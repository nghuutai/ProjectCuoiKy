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
import entity.CauHinhPC;
import entity.SanPham;

@Controller
public class CauHinhPCController {
	ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
	DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
	DatabaseCauHinhMay dbchm = (DatabaseCauHinhMay) context.getBean("databasecauhinhmay");
	@RequestMapping("/cauhinhpc/{id}")
	public String cauHinhPC(@PathVariable int id, ModelMap model) {
		SanPham sanPham = db.getSanPhamByID(id);
		model.addAttribute("SanPham", sanPham);
		return "CauHinhPC";
	}
	
	@PostMapping("/cauhinhpc/{id}")
	public String themCauHinhPC(ModelMap model, @ModelAttribute CauHinhPC chpc) {
		dbchm.addCauHinhPC(chpc);
		SanPham sanPham = db.getSanPhamByID(chpc.getIdSanPham());
		model.addAttribute("SanPham", sanPham);
		return "CauHinhPC";
	}
}
