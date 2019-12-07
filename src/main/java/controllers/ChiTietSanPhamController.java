package controllers;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Cart;

import dao.DatabaseCauHinhMay;
import dao.DatabaseSanPham;
import entity.CauHinhLaptop;
import entity.CauHinhPC;
import entity.SanPham;

@Controller
public class ChiTietSanPhamController {

	
	ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
	DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
	
	@RequestMapping("/chitietsanpham/{id}")
	public String chiTietSanPham(@PathVariable int id, ModelMap model, HttpSession session) {
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
		if (cartItems == null) {
            cartItems = new HashMap<Integer,Cart>();
        }
		
		DatabaseCauHinhMay dbchm = (DatabaseCauHinhMay) context.getBean("databasecauhinhmay");
		SanPham sp = db.getSanPhamByID(id);
		Cart cart = new Cart();
		if(sp != null) {
			if(cartItems.containsKey(id)) {
				cart = cartItems.get(id);
			}
		}
		
		List<SanPham> sanPhamLienQuan = db.getListSanPhamLienQuan(id, sp.getIdNhaSanXuat(), sp.getIdLoaiMay(), 6);
		
		
		CauHinhLaptop cauHinhLaptop;
		CauHinhPC cauHinhPC;
		if(sp.getIdLoaiMay() == 1) {
			cauHinhLaptop = dbchm.getCauHinhLaptopByID(id);
			model.addAttribute("CauHinhMay", cauHinhLaptop);
		}else {
			cauHinhPC = dbchm.getCauHinhPCByID(id);
			model.addAttribute("CauHinhMay", cauHinhPC);
		}
		
		model.addAttribute("SanPham", sp);
		model.addAttribute("SessionCart", cart);
		model.addAttribute("SanPhamLienQuan", sanPhamLienQuan);
		return "ChiTietSanPham";
	}
	
	@PostMapping("/chitietsanpham/add/{id}")
	public String themVaoGioHang(HttpSession session, @PathVariable int id, @RequestParam int soLuong, ModelMap model) {
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
		if (cartItems == null) {
            cartItems = new HashMap<Integer,Cart>();
        }
		
		DatabaseCauHinhMay dbchm = (DatabaseCauHinhMay) context.getBean("databasecauhinhmay");
		SanPham sp = db.getSanPhamByID(id);
		List<SanPham> sanPhamLienQuan = db.getListSanPhamLienQuan(id, sp.getIdNhaSanXuat(), sp.getIdLoaiMay(), 6);
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
		
		CauHinhLaptop cauHinhLaptop;
		CauHinhPC cauHinhPC;
		if(sp.getIdLoaiMay() == 1) {
			cauHinhLaptop = dbchm.getCauHinhLaptopByID(id);
			model.addAttribute("CauHinhMay", cauHinhLaptop);
		}else {
			cauHinhPC = dbchm.getCauHinhPCByID(id);
			model.addAttribute("CauHinhMay", cauHinhPC);
		}
		
		session.setAttribute("totalCart", total);
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("count", totalSL);
		model.addAttribute("SanPham", sp);
		model.addAttribute("SessionCart", cart);
		model.addAttribute("SanPhamLienQuan", sanPhamLienQuan);
		return "ChiTietSanPham";
	}
}
