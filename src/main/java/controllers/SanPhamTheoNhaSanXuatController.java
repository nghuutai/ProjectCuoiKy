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
public class SanPhamTheoNhaSanXuatController {

	@RequestMapping("/sanphamtheonhasanxuat/{idnsx}/{idlm}")
	public String sanPhamTheoNhaSanXuat(@PathVariable int idnsx, @PathVariable int idlm, ModelMap model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
		DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
		
		NhaSanXuat nhaSanXuat = dbnsx.getNhaSanXuatByID(idnsx);
		List<SanPham> listSanPhamTheoNhaSanXuat = db.getListSanPhamTheoNhaSanXuat(idnsx, idlm);
		LoaiMay loaiMay = dblm.getLoaiMayByID(idlm);
		
		model.addAttribute("NhaSanXuat", nhaSanXuat);
		model.addAttribute("ListSanPhamTheoNhaSanXuat", listSanPhamTheoNhaSanXuat);
		model.addAttribute("LoaiMay", loaiMay);
		return "SanPhamTheoNhaSanXuat";
	}
	
	@RequestMapping("/sanphamtheonhasanxuat/{idnsx}/{idlm}/{gia}")
	public String sanPhamTheoGia(@PathVariable int idnsx, @PathVariable int idlm, @PathVariable String gia, ModelMap model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
		DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
		
		int to, from;
		List<SanPham> listSanPhamTheoNhaSanXuat;
		String[] price = gia.split("-");
		if(price.length == 2) {
			from = Integer.parseInt(price[0]);
			to = Integer.parseInt(price[1]);
			listSanPhamTheoNhaSanXuat = db.getListSanPhamTheoGiaVaNhaSanXuat(from, to, idlm, idnsx);
		}else {
			from = Integer.parseInt(price[0]);
			listSanPhamTheoNhaSanXuat = db.getListSanPhamTheoGiaVaNhaSanXuat(from, idlm, idnsx);
		}
		
		NhaSanXuat nhaSanXuat = dbnsx.getNhaSanXuatByID(idnsx);
		LoaiMay loaiMay = dblm.getLoaiMayByID(idlm);
		
		if(listSanPhamTheoNhaSanXuat.size() == 0) {
			model.addAttribute("ThongBao", "Chưa có sản phẩm trong danh mục này");
		}
		model.addAttribute("NhaSanXuat", nhaSanXuat);
		model.addAttribute("ListSanPhamTheoNhaSanXuat", listSanPhamTheoNhaSanXuat);
		model.addAttribute("LoaiMay", loaiMay);
		return "SanPhamTheoNhaSanXuat";
	}
}
