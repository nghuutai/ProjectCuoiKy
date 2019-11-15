package controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DatabaseLoaiMay;
import dao.DatabaseNhaSanXuat;
import dao.DatabaseSanPham;
import entity.LoaiMay;
import entity.NhaSanXuat;
import entity.SanPham;

@Controller
public class SanPhamTheoLoaiSanPhamController {

	private final static int soSanPhamMotTrang = 9;
	
	@RequestMapping("/chitietloaisanpham/{id}")
	public String sanPhamTheoLoaiSanPham(@PathVariable int id, ModelMap model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
		DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
		List<NhaSanXuat> listNhaSanXuat = dbnsx.getListNhaSanXuat();
		List<SanPham> listSanPhamTheoLoai = db.getListSanPhamTheoLoai(id);
		List<SanPham> listSanPhamTheoLoaiLimit = db.getListSanPhamTheoLoaiLimit(id, 0, soSanPhamMotTrang);
		int tongSanPham = listSanPhamTheoLoai.size();
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		LoaiMay loaiMay = dblm.getLoaiMayByID(id);
		model.addAttribute("ListSanPhamTheoLoai", listSanPhamTheoLoaiLimit);
		model.addAttribute("LoaiMay", loaiMay);
		model.addAttribute("ListNhaSanXuat", listNhaSanXuat);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", 0);
		model.addAttribute("Loai", 1);
		return "SanPhamTheoLoaiSanPham";
	}
	
	@RequestMapping("/chitietloaisanpham/phantrang/{id}/{trang}")
	public String sanPhamTheoLoaiSanPhamPhanTrang(@PathVariable int id, @PathVariable int trang, ModelMap model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
		DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
		List<NhaSanXuat> listNhaSanXuat = dbnsx.getListNhaSanXuat();
		List<SanPham> listSanPhamTheoLoai = db.getListSanPhamTheoLoai(id);
		List<SanPham> listSanPhamTheoLoaiLimit = db.getListSanPhamTheoLoaiLimit(id, (trang-1)*soSanPhamMotTrang, soSanPhamMotTrang);
		int tongSanPham = listSanPhamTheoLoai.size();
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		LoaiMay loaiMay = dblm.getLoaiMayByID(id);
		model.addAttribute("ListSanPhamTheoLoai", listSanPhamTheoLoaiLimit);
		model.addAttribute("LoaiMay", loaiMay);
		model.addAttribute("ListNhaSanXuat", listNhaSanXuat);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", trang-1);
		model.addAttribute("Loai", 1);
		return "SanPhamTheoLoaiSanPham";
	}
	
	@RequestMapping("/chitietloaisanpham/{id}/{gia}")
	public String sanPhamTheoGia(@PathVariable int id, @PathVariable String gia, ModelMap model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
		DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
		
		int to, from;
		List<SanPham> listSanPhamTheoLoai;
		List<SanPham> listSanPhamTheoLoaiLimit;
		int tongSanPham;
		String[] price = gia.split("-");
		if(price.length == 2) {
			from = Integer.parseInt(price[0]);
			to = Integer.parseInt(price[1]);
			listSanPhamTheoLoai = db.getListSanPhamTheoGia(from, to, id);
			listSanPhamTheoLoaiLimit = db.getListSanPhamTheoGiaLimit(from, to, id, 0, soSanPhamMotTrang);
			tongSanPham = listSanPhamTheoLoai.size();
		}else {
			from = Integer.parseInt(price[0]);
			listSanPhamTheoLoai = db.getListSanPhamTheoGia(from, id);
			listSanPhamTheoLoaiLimit = db.getListSanPhamTheoGiaLimit(from, id, 0, soSanPhamMotTrang);
			tongSanPham = listSanPhamTheoLoai.size();
		}
		
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		
		List<NhaSanXuat> listNhaSanXuat = dbnsx.getListNhaSanXuat();
		LoaiMay loaiMay = dblm.getLoaiMayByID(id);
		
		if(listSanPhamTheoLoai.size() == 0) {
			model.addAttribute("ThongBao", "Chưa có sản phẩm trong danh mục này");
		}
		model.addAttribute("ListSanPhamTheoLoai", listSanPhamTheoLoaiLimit);
		model.addAttribute("LoaiMay", loaiMay);
		model.addAttribute("ListNhaSanXuat", listNhaSanXuat);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", 0);
		model.addAttribute("Gia", gia);
		model.addAttribute("Loai", 2);
		return "SanPhamTheoLoaiSanPham";
	}
	
	@RequestMapping("/chitietloaisanpham/phantrang/{id}/{gia}/{trang}")
	public String sanPhamTheoGiaPhanTrang(@PathVariable int id, @PathVariable int trang, @PathVariable String gia, ModelMap model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
		DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
		
		int to, from;
		List<SanPham> listSanPhamTheoLoai;
		List<SanPham> listSanPhamTheoLoaiLimit;
		int tongSanPham;
		String[] price = gia.split("-");
		if(price.length == 2) {
			from = Integer.parseInt(price[0]);
			to = Integer.parseInt(price[1]);
			listSanPhamTheoLoai = db.getListSanPhamTheoGia(from, to, id);
			listSanPhamTheoLoaiLimit = db.getListSanPhamTheoGiaLimit(from, to, id, (trang-1)*soSanPhamMotTrang, soSanPhamMotTrang);
			tongSanPham = listSanPhamTheoLoai.size();
		}else {
			from = Integer.parseInt(price[0]);
			listSanPhamTheoLoai = db.getListSanPhamTheoGia(from, id);
			listSanPhamTheoLoaiLimit = db.getListSanPhamTheoGiaLimit(from, id, (trang-1)*soSanPhamMotTrang, soSanPhamMotTrang);
			tongSanPham = listSanPhamTheoLoai.size();
		}
		
		int soTrang;
		int du = tongSanPham % soSanPhamMotTrang;
		if(du == 0) {
			soTrang = tongSanPham/soSanPhamMotTrang;
		}else {
			soTrang = (tongSanPham/soSanPhamMotTrang) + 1;
		}
		
		List<NhaSanXuat> listNhaSanXuat = dbnsx.getListNhaSanXuat();
		LoaiMay loaiMay = dblm.getLoaiMayByID(id);
		
		if(listSanPhamTheoLoai.size() == 0) {
			model.addAttribute("ThongBao", "Chưa có sản phẩm trong danh mục này");
		}
		model.addAttribute("ListSanPhamTheoLoai", listSanPhamTheoLoaiLimit);
		model.addAttribute("LoaiMay", loaiMay);
		model.addAttribute("ListNhaSanXuat", listNhaSanXuat);
		model.addAttribute("SoTrang", soTrang);
		model.addAttribute("Trang", trang-1);
		model.addAttribute("Gia", gia);
		model.addAttribute("Loai", 2);
		return "SanPhamTheoLoaiSanPham";
	}
}
