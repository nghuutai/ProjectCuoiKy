package controllers;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DatabaseSanPham;
import entity.Cart;
import entity.LoaiMay;
import entity.SanPham;

@Controller
public class IndexController {
	private final static int soSanPhamMotTrang = 9;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
	DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
	
	@RequestMapping("/")
	public String index(ModelMap model) {
		List<SanPham> listSanPhamMoi = db.getListSanPhamMoi();
		List<SanPham> listSanPhamBanChay = db.getListSanPhamBanChay();
		model.addAttribute("ListSanPhamMoi", listSanPhamMoi);
		model.addAttribute("ListSanPhamBanChay", listSanPhamBanChay);
		return "Index";
	}
	
	@RequestMapping("/quickdetail/{id}")
	public @ResponseBody String searchPerson(@PathVariable int id) {
		SanPham sanPham = db.getSanPhamByID(id);

		ObjectMapper mapper = new ObjectMapper();
		String ajaxResponse = "";
		try {
			ajaxResponse = mapper.writeValueAsString(sanPham);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(ajaxResponse);
		return ajaxResponse;
	}
	
	@RequestMapping("/timkiem")
	public String timKiemSanPham(ModelMap model, @RequestParam String timKiem) {
		List<SanPham> listTimKiem = db.timKiemSanPhamLimit(timKiem, 0, soSanPhamMotTrang);
		List<SanPham> listSPTK = db.timKiemSanPham(timKiem);
		int tongSanPham = listSPTK.size();
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		if(listSPTK.size() == 0) {
			model.addAttribute("ThongBao", "Không có kết quả tìm kiếm nào cho '" + timKiem +"'");
		}
		
		model.addAttribute("TimKiem", timKiem);
		model.addAttribute("KetQua", listTimKiem);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", 0);
		return "TimKiem";
	}
	
	@RequestMapping("/timkiem/{timKiem}/{trang}")
	public String timKiemSanPhamPhanTrang(ModelMap model, @PathVariable String timKiem, @PathVariable int trang) {
		List<SanPham> listTimKiem = db.timKiemSanPhamLimit(timKiem, (trang-1)*soSanPhamMotTrang, soSanPhamMotTrang);
		List<SanPham> listSPTK = db.timKiemSanPham(timKiem);
		int tongSanPham = listSPTK.size();
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		if(listSPTK.size() == 0) {
			model.addAttribute("ThongBao", "Không có kết quả tìm kiếm nào cho '" + timKiem +"'");
		}
		
		model.addAttribute("TimKiem", timKiem);
		model.addAttribute("KetQua", listTimKiem);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", trang - 1);
		return "TimKiem";
	}
	
	@PostMapping("/timkiem/addquickview/{id}/{timkiem}/{trang}")
	public String addQuickviewTimKiemSanPham(HttpSession session, @PathVariable int id, @RequestParam int soLuong,ModelMap model, @PathVariable String timkiem, @PathVariable int trang) {
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
		if (cartItems == null) {
            cartItems = new HashMap<Integer,Cart>();
        }
		
		SanPham sp = db.getSanPhamByID(id);
		Cart cart = new Cart();
		if(sp != null) {
			if(cartItems.containsKey(id)) {
				cart = cartItems.get(id);
				cart.setSanPham(sp);
				cart.setSoLuong(cart.getSoLuong() + soLuong);
				cartItems.put(id, cart);
			}else {
                cart.setSanPham(sp);
                cart.setSoLuong(soLuong);
                cartItems.put(id, cart);
			}
		}
		int total = 0;
		int totalSL = 0;
		for(Cart cart1:cartItems.values()) {
			int dg = cart1.getSanPham().getDonGia();
			int sl = cart1.getSoLuong();
			int tt = dg * sl;
			total = total + tt;
			totalSL = totalSL + sl;
		}
		List<SanPham> listSPTK = db.timKiemSanPham(timkiem);
		List<SanPham> listTimKiem = db.timKiemSanPhamLimit(timkiem, (trang-1)*soSanPhamMotTrang, soSanPhamMotTrang);
		int tongSanPham = listSPTK.size();
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		if(listSPTK.size() == 0) {
			model.addAttribute("ThongBao", "Không có kết quả tìm kiếm nào cho '" + timkiem +"'");
		}
		
		model.addAttribute("TimKiem", timkiem);
		model.addAttribute("KetQua", listTimKiem);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", trang - 1);
		session.setAttribute("totalCart", total);
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("count", totalSL);
		return "TimKiem";
	}
	
	@PostMapping("/addquickview/{id}")
	public String themVaoGioHangQuickView(HttpSession session, @PathVariable int id, @RequestParam int soLuong, ModelMap model) {
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
		if (cartItems == null) {
            cartItems = new HashMap<Integer,Cart>();
        }
		List<SanPham> listSanPhamMoi = db.getListSanPhamMoi();
		List<SanPham> listSanPhamBanChay = db.getListSanPhamBanChay();
		
		SanPham sp = db.getSanPhamByID(id);
		Cart cart = new Cart();
		if(sp != null) {
			if(cartItems.containsKey(id)) {
				cart = cartItems.get(id);
				cart.setSanPham(sp);
				cart.setSoLuong(cart.getSoLuong() + soLuong);
				cartItems.put(id, cart);
			}else {
                cart.setSanPham(sp);
                cart.setSoLuong(soLuong);
                cartItems.put(id, cart);
			}
		}
		int total = 0;
		int totalSL = 0;
		for(Cart cart1:cartItems.values()) {
			int dg = cart1.getSanPham().getDonGia();
			int sl = cart1.getSoLuong();
			int tt = dg * sl;
			total = total + tt;
			totalSL = totalSL + sl;
		}
		session.setAttribute("totalCart", total);
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("count", totalSL);
		model.addAttribute("ListSanPhamMoi", listSanPhamMoi);
		model.addAttribute("ListSanPhamBanChay", listSanPhamBanChay);
		return "Index";
	}
}
