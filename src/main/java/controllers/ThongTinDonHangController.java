package controllers;

import java.util.HashMap;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import entity.Cart;
import entity.ChiTietHoaDon;
import dao.DatabaseChiTietHoaDon;
import dao.DatabaseHoaDon;
import dao.DatabaseSanPham;
import entity.HoaDon;

@Controller
public class ThongTinDonHangController {
	
	@Autowired
	JavaMailSender mailer;
	

	
	@RequestMapping("/donhang")
	public String thongTinDonHang() {
		return "ThongTinDonHang";
	}
	
	@RequestMapping("/dathang")
	public String datHang(ModelMap model, HttpSession session) throws MessagingException {
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<Integer, Cart>();
        }
        HoaDon hoaDon = (HoaDon)session.getAttribute("hoaDon");
        ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseHoaDon db = (DatabaseHoaDon) context.getBean("databasehoadon");
		DatabaseChiTietHoaDon db1 = (DatabaseChiTietHoaDon) context.getBean("databasechitiethoadon");
		DatabaseSanPham db2 = (DatabaseSanPham) context.getBean("databasesanpham");
		int kq = db.addHoaDon(hoaDon);
		if(kq == 1) {
			hoaDon.setMaHoaDon(db.getMaHoaDon());
			for(Cart cart:cartItems.values()) {
				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
				chiTietHoaDon.setHoaDon(hoaDon);
				chiTietHoaDon.setSanPham(cart.getSanPham());
				chiTietHoaDon.setSoLuongMua(cart.getSoLuong());
				db1.addChiTietHoaDon(chiTietHoaDon);
				db2.suaSoLuong(cart.getSoLuong(),cart.getSanPham().getIdSanPham());
			}
		}

		
//		mailService.send("nhtai124356@gmail.com", "nhtai12435@gmail.com", hoaDon, cartItems, "Don dat hang");
		send("nhtai124356@gmail.com", "nhtai12435@gmail.com", hoaDon, cartItems, "Don dat hang");
		
		cartItems = new HashMap<Integer, Cart>();
		hoaDon = new HoaDon();
		session.setAttribute("totalCart",0);
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("count", 0);
		session.setAttribute("hoaDon", hoaDon);
		
		
		return "ThongBao";
	}
	
	public void send(String from, String to, HoaDon hoaDon, HashMap<Integer, Cart> cartItems, String tieuDe) {
		try {
			//Tao mail
			MimeMessage mail = mailer.createMimeMessage();
			//Su dung lop tro giup
			MimeMessageHelper helper = new MimeMessageHelper(mail, "utf-8");
			helper.setFrom(from);
			helper.setTo(to);
			helper.setReplyTo(from);
			helper.setSubject(tieuDe);
			
			
		    String htmlMsg = "<html>" + 
		    		"<head>" + 
		    		"<meta charset=\"UTF-8\">" +
		    		"</head>\n" +
		    		"<body>"
		    		+"<h3>Xin chào " +hoaDon.getTenKhachHang() + "</h3>"
	                +"<h3>Địa chỉ :  " +hoaDon.getDiaChi() + "</h3>"
	                +"<h3>Số điện thoại :  " +hoaDon.getSoDienThoai() + "</h3>"
	                +"</body>"
	                +"</html>";
	         
	        mail.setContent(mail(hoaDon, cartItems), "text/html;charset=utf-8");
		    
			mailer.send(mail);
		}catch(Exception ex) {
			System.out.println("Gui mail that bai");
		}
	}
	
	public String mail(HoaDon hoaDon, HashMap<Integer, Cart> cartItems) {
		String table = "";
		int tongTien = 0;
		for(Cart cart:cartItems.values()) {
			table = table + "			  		<tr>\n" + 
					"				  		<td>" + cart.getSanPham().getTenSanPham() + "</td>\n" + 
					"				  		<td>" + cart.getSoLuong() + "</td>\n" + 
					"				  		<td>" + cart.tongTien() + "</td>\n" + 
					"			  		</tr>\n";
			tongTien = tongTien + cart.tongTien();
		}
		
		String content = "<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<title>Insert title here</title>\n" + 
				"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +  
				"</head>\n" + 
				"<body>\n" + 
				"	<div class=\"container\">"+
				"<div style=\"margin:20px;\">\n" + 
				"		<h2>THÔNG TIN ĐƠN HÀNG</h2>\n" + 
				"	</div>\n" + 
				"	<div class=\"row\" style=\"margin-left:20px;margin-right:20px;\">\n" + 
				"		<div class=\"col-6\">\n" + 
				"			<div class=\"row\">\n" + 
				"				<div class=\"col-12\">\n" + 
				"					<h3>Địa chỉ giao hàng</h3>\n" + 
				"				</div>\n" + 
				"			</div>\n" + 
				"			<div class=\"dropdown-divider\"></div>\n" + 
				"			<div style=\"margin-bottom:20px;\">Họ tên: " + hoaDon.getTenKhachHang() + "</div>\n" + 
				"			<div style=\"margin-bottom:20px;\">Email: " + hoaDon.getEmail() + "</div>\n" + 
				"			<div style=\"margin-bottom:20px;\">Số điện thoại: " + hoaDon.getSoDienThoai() + "</div>\n" + 
				"			<div style=\"margin-bottom:20px;\">Địa chỉ: " + hoaDon.getDiaChi() + "</div>\n" + 
				"		</div>\n" + 
				"		<div class=\"col-6\">\n" + 
				"			<div class=\"row\">\n" + 
				"				<div class=\"col-12\">\n" + 
				"					<h3>Đơn hàng</h3>\n" + 
				"				</div>\n" + 
				"			</div>\n" + 
				"			<div class=\"dropdown-divider\"></div>\n" + 
				"			<table class=\"table\" >\n" + 
				"			  <thead>\n" + 
				"			    <tr>\n" + 
				"			      <th scope=\"col\">Sản phẩm</th>\n" + 
				"			      <th scope=\"col\">Số lượng</th>\n" + 
				"			      <th scope=\"col\">Thành tiền</th>\n" + 
				"			    </tr>\n" + 
				"			  </thead>\n" + 
				"			  <tbody>\n" + 	  	
				table +
				"			  	<tr>\n" + 
				"			  		<td colspan=\"3\" style=\"text-align:right;\">Tổng tiền: "+ tongTien + "đ</td>\n" + 
				"			  	</tr>\n" + 
				"			  </tbody>\n" + 
				"			</table>\n" + 
				"		</div>\n" + 
				"	</div>" +
				"	</div>" +
				"</div>\n" + 
				"	<!-- Optional JavaScript -->\n" + 
				"    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n" + 
				"    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
				"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
				"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" + 
				"</body>\n" + 
				"</html>";
		
		return content;
	}
}
