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

import dao.DatabaseLoaiMay;
import dao.DatabaseNhaSanXuat;
import dao.DatabaseSanPham;
import entity.Cart;
import entity.LoaiMay;
import entity.NhaSanXuat;
import entity.SanPham;

@Controller
public class SanPhamTheoNhaSanXuatController {

	private final static int soSanPhamMotTrang = 9;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
	DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
	DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
	DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
	
	@RequestMapping("/sanphamtheonhasanxuat/{idnsx}/{idlm}")
	public String sanPhamTheoNhaSanXuat(@PathVariable int idnsx, @PathVariable int idlm, ModelMap model) {
		
		NhaSanXuat nhaSanXuat = dbnsx.getNhaSanXuatByID(idnsx);
		List<SanPham> listSanPhamTheoNhaSanXuat = db.getListSanPhamTheoNhaSanXuat(idnsx, idlm);
		List<SanPham> listSanPhamTheoNhaSanXuatLimit = db.getListSanPhamTheoNhaSanXuatLimit(idnsx, idlm, 0, soSanPhamMotTrang);
		LoaiMay loaiMay = dblm.getLoaiMayByID(idlm);
		
		int tongSanPham = listSanPhamTheoNhaSanXuat.size();
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		model.addAttribute("NhaSanXuat", nhaSanXuat);
		model.addAttribute("ListSanPhamTheoNhaSanXuat", listSanPhamTheoNhaSanXuatLimit);
		model.addAttribute("LoaiMay", loaiMay);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", 0);
		model.addAttribute("Loai", 1);
		return "SanPhamTheoNhaSanXuat";
	}
	
	@RequestMapping("/sanphamtheonhasanxuat/phantrang/{idnsx}/{idlm}/{trang}")
	public String sanPhamTheoNhaSanXuatPhanTrang(@PathVariable int idnsx, @PathVariable int idlm, @PathVariable int trang, ModelMap model) {
		
		NhaSanXuat nhaSanXuat = dbnsx.getNhaSanXuatByID(idnsx);
		List<SanPham> listSanPhamTheoNhaSanXuat = db.getListSanPhamTheoNhaSanXuat(idnsx, idlm);
		List<SanPham> listSanPhamTheoNhaSanXuatLimit = db.getListSanPhamTheoNhaSanXuatLimit(idnsx, idlm, (trang-1)*soSanPhamMotTrang, soSanPhamMotTrang);
		LoaiMay loaiMay = dblm.getLoaiMayByID(idlm);
		
		int tongSanPham = listSanPhamTheoNhaSanXuat.size();
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		model.addAttribute("NhaSanXuat", nhaSanXuat);
		model.addAttribute("ListSanPhamTheoNhaSanXuat", listSanPhamTheoNhaSanXuatLimit);
		model.addAttribute("LoaiMay", loaiMay);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", trang-1);
		model.addAttribute("Loai", 1);
		return "SanPhamTheoNhaSanXuat";
	}
	
	@PostMapping("/sanphamtheonhasanxuat/phantrang/{idnsx}/{idlm}/{trang}/addquickview/{idsp}")
	public String addQuickviewSanPhamTheoNhaSanXuatPhanTrang(@RequestParam int soLuong,HttpSession session,@PathVariable int idsp,@PathVariable int idnsx, @PathVariable int idlm, @PathVariable int trang, ModelMap model) {
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
		if (cartItems == null) {
            cartItems = new HashMap<Integer,Cart>();
        }
		
		SanPham sp = db.getSanPhamByID(idsp);
		Cart cart = new Cart();
		if(sp != null) {
			if(cartItems.containsKey(idsp)) {
				cart = cartItems.get(idsp);
				cart.setSanPham(sp);
				cart.setSoLuong(cart.getSoLuong() + soLuong);
				cartItems.put(idsp, cart);
			}else {
                cart.setSanPham(sp);
                cart.setSoLuong(soLuong);
                cartItems.put(idsp, cart);
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
		NhaSanXuat nhaSanXuat = dbnsx.getNhaSanXuatByID(idnsx);
		List<SanPham> listSanPhamTheoNhaSanXuat = db.getListSanPhamTheoNhaSanXuat(idnsx, idlm);
		List<SanPham> listSanPhamTheoNhaSanXuatLimit = db.getListSanPhamTheoNhaSanXuatLimit(idnsx, idlm, (trang-1)*soSanPhamMotTrang, soSanPhamMotTrang);
		LoaiMay loaiMay = dblm.getLoaiMayByID(idlm);
		
		int tongSanPham = listSanPhamTheoNhaSanXuat.size();
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		model.addAttribute("NhaSanXuat", nhaSanXuat);
		model.addAttribute("ListSanPhamTheoNhaSanXuat", listSanPhamTheoNhaSanXuatLimit);
		model.addAttribute("LoaiMay", loaiMay);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", trang-1);
		model.addAttribute("Loai", 1);
		session.setAttribute("totalCart", total);
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("count", totalSL);
		return "SanPhamTheoNhaSanXuat";
	}
	
	@RequestMapping("/sanphamtheonhasanxuat/{idnsx}/{idlm}/{gia}")
	public String sanPhamTheoGia(@PathVariable int idnsx, @PathVariable int idlm, @PathVariable String gia, ModelMap model) {
		
		int to, from;
		List<SanPham> listSanPhamTheoNhaSanXuat;
		List<SanPham> listSanPhamTheoNhaSanXuatLimit;
		int tongSanPham;
		String[] price = gia.split("-");
		if(price.length == 2) {
			from = Integer.parseInt(price[0]);
			to = Integer.parseInt(price[1]);
			listSanPhamTheoNhaSanXuat = db.getListSanPhamTheoGiaVaNhaSanXuat(from, to, idlm, idnsx);
			listSanPhamTheoNhaSanXuatLimit = db.getListSanPhamTheoGiaVaNhaSanXuatLimit(from, to, idlm, idnsx, 0, soSanPhamMotTrang);
			tongSanPham = listSanPhamTheoNhaSanXuat.size();
		}else {
			from = Integer.parseInt(price[0]);
			listSanPhamTheoNhaSanXuat = db.getListSanPhamTheoGiaVaNhaSanXuat(from, idlm, idnsx);
			listSanPhamTheoNhaSanXuatLimit = db.getListSanPhamTheoGiaVaNhaSanXuatLimit(from, idlm, idnsx, 0, soSanPhamMotTrang);
			tongSanPham = listSanPhamTheoNhaSanXuat.size();
		}
		
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		
		NhaSanXuat nhaSanXuat = dbnsx.getNhaSanXuatByID(idnsx);
		LoaiMay loaiMay = dblm.getLoaiMayByID(idlm);
		
		if(listSanPhamTheoNhaSanXuat.size() == 0) {
			model.addAttribute("ThongBao", "Chưa có sản phẩm trong danh mục này");
		}
		model.addAttribute("NhaSanXuat", nhaSanXuat);
		model.addAttribute("ListSanPhamTheoNhaSanXuat", listSanPhamTheoNhaSanXuatLimit);
		model.addAttribute("LoaiMay", loaiMay);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", 0);
		model.addAttribute("Gia", gia);
		model.addAttribute("Loai", 2);
		return "SanPhamTheoNhaSanXuat";
	}
	
	@RequestMapping("/sanphamtheonhasanxuat/phantrang/{idnsx}/{idlm}/{gia}/{trang}")
	public String sanPhamTheoGiaPhanTrang(@PathVariable int idnsx, @PathVariable int idlm, @PathVariable int trang, @PathVariable String gia, ModelMap model) {
		
		int to, from;
		List<SanPham> listSanPhamTheoNhaSanXuat;
		List<SanPham> listSanPhamTheoNhaSanXuatLimit;
		int tongSanPham;
		String[] price = gia.split("-");
		if(price.length == 2) {
			from = Integer.parseInt(price[0]);
			to = Integer.parseInt(price[1]);
			listSanPhamTheoNhaSanXuat = db.getListSanPhamTheoGiaVaNhaSanXuat(from, to, idlm, idnsx);
			listSanPhamTheoNhaSanXuatLimit = db.getListSanPhamTheoGiaVaNhaSanXuatLimit(from, to, idlm, idnsx, (trang-1)*soSanPhamMotTrang, soSanPhamMotTrang);
			tongSanPham = listSanPhamTheoNhaSanXuat.size();
		}else {
			from = Integer.parseInt(price[0]);
			listSanPhamTheoNhaSanXuat = db.getListSanPhamTheoGiaVaNhaSanXuat(from, idlm, idnsx);
			listSanPhamTheoNhaSanXuatLimit = db.getListSanPhamTheoGiaVaNhaSanXuatLimit(from, idlm, idnsx, (trang-1)*soSanPhamMotTrang, soSanPhamMotTrang);
			tongSanPham = listSanPhamTheoNhaSanXuat.size();
		}
		
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		
		NhaSanXuat nhaSanXuat = dbnsx.getNhaSanXuatByID(idnsx);
		LoaiMay loaiMay = dblm.getLoaiMayByID(idlm);
		
		if(listSanPhamTheoNhaSanXuat.size() == 0) {
			model.addAttribute("ThongBao", "Chưa có sản phẩm trong danh mục này");
		}
		model.addAttribute("NhaSanXuat", nhaSanXuat);
		model.addAttribute("ListSanPhamTheoNhaSanXuat", listSanPhamTheoNhaSanXuatLimit);
		model.addAttribute("LoaiMay", loaiMay);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", trang-1);
		model.addAttribute("Gia", gia);
		model.addAttribute("Loai", 2);
		return "SanPhamTheoNhaSanXuat";
	}
	
	@PostMapping("/sanphamtheonhasanxuat/phantrang/{idnsx}/{idlm}/{gia}/{trang}/addquickview/{idsp}")
	public String addQuickviewSanPhamTheoGiaPhanTrang(@RequestParam int soLuong,HttpSession session,@PathVariable int idsp,@PathVariable int idnsx, @PathVariable int idlm, @PathVariable int trang, @PathVariable String gia, ModelMap model) {
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
		if (cartItems == null) {
            cartItems = new HashMap<Integer,Cart>();
        }
		
		SanPham sp = db.getSanPhamByID(idsp);
		Cart cart = new Cart();
		if(sp != null) {
			if(cartItems.containsKey(idsp)) {
				cart = cartItems.get(idsp);
				cart.setSanPham(sp);
				cart.setSoLuong(cart.getSoLuong() + soLuong);
				cartItems.put(idsp, cart);
			}else {
                cart.setSanPham(sp);
                cart.setSoLuong(soLuong);
                cartItems.put(idsp, cart);
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
		int to, from;
		List<SanPham> listSanPhamTheoNhaSanXuat;
		List<SanPham> listSanPhamTheoNhaSanXuatLimit;
		int tongSanPham;
		String[] price = gia.split("-");
		if(price.length == 2) {
			from = Integer.parseInt(price[0]);
			to = Integer.parseInt(price[1]);
			listSanPhamTheoNhaSanXuat = db.getListSanPhamTheoGiaVaNhaSanXuat(from, to, idlm, idnsx);
			listSanPhamTheoNhaSanXuatLimit = db.getListSanPhamTheoGiaVaNhaSanXuatLimit(from, to, idlm, idnsx, (trang-1)*soSanPhamMotTrang, soSanPhamMotTrang);
			tongSanPham = listSanPhamTheoNhaSanXuat.size();
		}else {
			from = Integer.parseInt(price[0]);
			listSanPhamTheoNhaSanXuat = db.getListSanPhamTheoGiaVaNhaSanXuat(from, idlm, idnsx);
			listSanPhamTheoNhaSanXuatLimit = db.getListSanPhamTheoGiaVaNhaSanXuatLimit(from, idlm, idnsx, (trang-1)*soSanPhamMotTrang, soSanPhamMotTrang);
			tongSanPham = listSanPhamTheoNhaSanXuat.size();
		}
		
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		
		NhaSanXuat nhaSanXuat = dbnsx.getNhaSanXuatByID(idnsx);
		LoaiMay loaiMay = dblm.getLoaiMayByID(idlm);
		
		if(listSanPhamTheoNhaSanXuat.size() == 0) {
			model.addAttribute("ThongBao", "Chưa có sản phẩm trong danh mục này");
		}
		model.addAttribute("NhaSanXuat", nhaSanXuat);
		model.addAttribute("ListSanPhamTheoNhaSanXuat", listSanPhamTheoNhaSanXuatLimit);
		model.addAttribute("LoaiMay", loaiMay);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", trang-1);
		model.addAttribute("Gia", gia);
		model.addAttribute("Loai", 2);
		session.setAttribute("totalCart", total);
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("count", totalSL);
		return "SanPhamTheoNhaSanXuat";
	}
}
