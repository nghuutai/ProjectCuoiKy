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
	
	ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
	DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
	
	@RequestMapping("/")
	public String index(ModelMap model) {
		List<SanPham> listSanPhamMoi = db.getListSanPhamMoi();
		model.addAttribute("ListSanPhamMoi", listSanPhamMoi);
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
		List<SanPham> listSPTK = db.timKiemSanPham(timKiem);
		
		if(listSPTK.size() == 0) {
			model.addAttribute("ThongBao", "Không có kết quả tìm kiếm nào cho '" + timKiem +"'");
		}
		
		model.addAttribute("TimKiem", timKiem);
		model.addAttribute("KetQua", listSPTK);
		return "TimKiem";
	}
	
	@PostMapping("/timkiem/addquickview/{id}/{timkiem}")
	public String addQuickviewTimKiemSanPham(HttpSession session, @PathVariable int id, @RequestParam int soLuong,ModelMap model, @PathVariable String timkiem) {
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
		
		if(listSPTK.size() == 0) {
			model.addAttribute("ThongBao", "Không có kết quả tìm kiếm nào cho '" + timkiem +"'");
		}
		
		model.addAttribute("TimKiem", timkiem);
		model.addAttribute("KetQua", listSPTK);
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
		return "Index";
	}
}
