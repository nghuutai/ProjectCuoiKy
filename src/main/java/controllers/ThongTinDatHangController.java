package controllers;

import java.sql.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Cart;
import entity.HoaDon;

@Controller
public class ThongTinDatHangController {

	@RequestMapping("/thongtin")
	public String thongTinDatHang() {
		return "ThongTinDatHang";
	}
	
	@PostMapping("/thongtin")
	public String taoDonHang(ModelMap model, @RequestParam String tenKhachHang, @RequestParam String email, @RequestParam String soDienThoai, @RequestParam String diaChi, HttpSession session) {
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<Integer, Cart>();
        }
        
        long millis=System.currentTimeMillis();  
        Date date=new Date(millis);  
        HoaDon hoaDon = new HoaDon();
        hoaDon.setTenKhachHang(tenKhachHang);
        hoaDon.setEmail(email);
        hoaDon.setSoDienThoai(soDienThoai);
        hoaDon.setDiaChi(diaChi);
        hoaDon.setNgayTao(date);
        hoaDon.setTinhTrangHoaDon(true);
        
		session.setAttribute("totalCart",session.getAttribute("totalCart"));
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("count", session.getAttribute("count"));
		session.setAttribute("hoaDon", hoaDon);
		return "ThongTinDonHang";
	}
}
