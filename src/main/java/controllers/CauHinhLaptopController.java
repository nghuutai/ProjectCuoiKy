package controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DatabaseCauHinhMay;
import dao.DatabaseSanPham;
import entity.CauHinhLaptop;
import entity.SanPham;

@Controller
public class CauHinhLaptopController {
	ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
	DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
	DatabaseCauHinhMay dbchm = (DatabaseCauHinhMay) context.getBean("databasecauhinhmay");
	@RequestMapping("/cauhinhlaptop/{id}")
	public String cauHinhLaptop(@PathVariable int id, ModelMap model) {
		SanPham sanPham = db.getSanPhamByID(id);
		model.addAttribute("SanPham", sanPham);
		return "CauHinhLaptop";
	}
	
	@PostMapping("/cauhinhlaptop/{id}")
	public String themCauHinhLapTop(ModelMap model, @ModelAttribute CauHinhLaptop chlt) {
		System.out.println(chlt.getIdSanPham());
		System.out.println(chlt.getCpu());
		dbchm.addCauHinhLaptop(chlt);
		SanPham sanPham = db.getSanPhamByID(chlt.getIdSanPham());
		model.addAttribute("SanPham", sanPham);
		return "CauHinhLaptop";
	}
}
