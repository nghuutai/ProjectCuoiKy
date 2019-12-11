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

	public HashMap<String, String> getThanhPho(){
		HashMap<String, String> arrTinh = new HashMap<String, String>();
		arrTinh.put("TPHCM", "TP Hồ Chí Minh");
		arrTinh.put("HaNoi", "Hà Nội");
		arrTinh.put("DaNang", "Đà Nẵng");
		arrTinh.put("ThanhHoa", "Thanh Hoá");
		arrTinh.put("CanTho", "Cần Thơ");
		arrTinh.put("QuangNgai", "Quãng Ngãi");
		arrTinh.put("PhuYen", "Phú Yên");
		arrTinh.put("NhaTrang", "Nha Trang");
		arrTinh.put("DongNai", "Đồng Nai");
		arrTinh.put("LamDong", "Lâm Đồng");
		arrTinh.put("GiaLai", "Gia Lai");
		arrTinh.put("TayNinh", "Tây Ninh");
		return arrTinh;
	}
	
	
	@RequestMapping("/thongtin")
	public String thongTinDatHang(ModelMap model) {
		model.addAttribute("Tinh", getThanhPho());
		return "ThongTinDatHang";
	}
	
	@PostMapping("/thongtin")
	public String taoDonHang(ModelMap model, @RequestParam String tenKhachHang, @RequestParam String email, @RequestParam String soDienThoai, @RequestParam String diaChi, @RequestParam String thanhPho, HttpSession session) {
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
        hoaDon.setThanhPho(thanhPho);
        hoaDon.setNgayTao(date);
        hoaDon.setTinhTrangHoaDon(1);
        
		session.setAttribute("totalCart",session.getAttribute("totalCart"));
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("count", session.getAttribute("count"));
		session.setAttribute("hoaDon", hoaDon);
		return "ThongTinDonHang";
	}
}
