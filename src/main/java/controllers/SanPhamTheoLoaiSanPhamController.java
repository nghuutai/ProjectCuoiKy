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

	@RequestMapping("/chitietloaisanpham/{id}")
	public String sanPhamTheoLoaiSanPham(@PathVariable int id, ModelMap model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
		DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
		List<NhaSanXuat> listNhaSanXuat = dbnsx.getListNhaSanXuat();
		List<SanPham> listSanPhamTheoLoai = db.getListSanPhamTheoLoai(id);
		LoaiMay loaiMay = dblm.getLoaiMayByID(id);
		model.addAttribute("ListSanPhamTheoLoai", listSanPhamTheoLoai);
		model.addAttribute("LoaiMay", loaiMay);
		model.addAttribute("ListNhaSanXuat", listNhaSanXuat);
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
		String[] price = gia.split("-");
		if(price.length == 2) {
			from = Integer.parseInt(price[0]);
			to = Integer.parseInt(price[1]);
			listSanPhamTheoLoai = db.getListSanPhamTheoGia(from, to, id);
		}else {
			from = Integer.parseInt(price[0]);
			listSanPhamTheoLoai = db.getListSanPhamTheoGia(from, id);
		}

		List<NhaSanXuat> listNhaSanXuat = dbnsx.getListNhaSanXuat();
		LoaiMay loaiMay = dblm.getLoaiMayByID(id);
		
		if(listSanPhamTheoLoai.size() == 0) {
			model.addAttribute("ThongBao", "Chưa có sản phẩm trong danh mục này");
		}
		model.addAttribute("ListSanPhamTheoLoai", listSanPhamTheoLoai);
		model.addAttribute("LoaiMay", loaiMay);
		model.addAttribute("ListNhaSanXuat", listNhaSanXuat);
		
		return "SanPhamTheoLoaiSanPham";
	}
}
