package controllers;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Cart;
import dao.DatabaseSanPham;
import entity.SanPham;

@Controller
public class GioHangChiTietController {

	@RequestMapping("/giohangchitiet")
	public String gioHangChiTiet(HttpSession session) {
		System.out.println("hello");
		session.setAttribute("SoLuongCon", 1);
		return "GioHangChiTiet";
	}
	
	@RequestMapping("/giohangchitiet/them/{id}")
	public String themGioHang(HttpSession session, @PathVariable int id, ModelMap modelMap) {
		System.out.println(1);
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
        SanPham sp = db.getSanPhamByID(id);
        int soLuongCon = db.getSoLuong(id);
        if (sp != null) {
            Cart cart = cartItems.get(id);
            cart.setSanPham(sp);
            cart.setSoLuong(cart.getSoLuong() + 1);
            cart.setSoLuongCon(soLuongCon);
            cartItems.put(id, cart);
        }
        int total = 0;
		int totalSL = 0;
		for(Cart cart:cartItems.values()) {
			int dg = cart.getSanPham().getDonGia();
			int sl = cart.getSoLuong();
			int tt = dg * sl;
			total = total + tt;
			totalSL = totalSL + sl;
		}
		session.setAttribute("totalCart", total);
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("count", totalSL);
		return "GioHangChiTiet";
	}
	
	@RequestMapping("/giohangchitiet/giam/{id}")
	public String giamSoLuong(HttpSession session, @PathVariable int id, ModelMap modelMap) {
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
        SanPham sp = db.getSanPhamByID(id);
        if (sp != null) {
            Cart cart = cartItems.get(id);
            cart.setSanPham(sp);
            cart.setSoLuong(cart.getSoLuong() - 1);
            cartItems.put(id, cart);
        }
        int total = 0;
		int totalSL = 0;
		for(Cart cart:cartItems.values()) {
			int dg = cart.getSanPham().getDonGia();
			int sl = cart.getSoLuong();
			int tt = dg * sl;
			total = total + tt;
			totalSL = totalSL + sl;
		}
		session.setAttribute("totalCart", total);
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("count", totalSL);
		
		return "GioHangChiTiet";
	}
	
	@RequestMapping("/giohangchitiet/xoa/{id}")
	public String xoaSanPham(HttpSession session, @PathVariable int id, ModelMap modelMap){
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<Integer,Cart>();
        }
        if (cartItems.containsKey(id)) {
            cartItems.remove(id);
        }
        int total = 0;
		int totalSL = 0;
		for(Cart cart:cartItems.values()) {
			int dg = cart.getSanPham().getDonGia();
			int sl = cart.getSoLuong();
			int tt = dg * sl;
			total = total + tt;
			totalSL = totalSL + sl;
		}
		session.setAttribute("totalCart", total);
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("count", totalSL);
        return "GioHangChiTiet";
	}
}
