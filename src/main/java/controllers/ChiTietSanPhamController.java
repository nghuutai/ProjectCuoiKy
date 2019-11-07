package controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DatabaseSanPham;
import entity.SanPham;

@Controller
public class ChiTietSanPhamController {

	@RequestMapping("/chitietsanpham/{id}")
	public String chiTietSanPham(@PathVariable int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		SanPham sanPham = db.getSanPhamByID(id);
		return "ChiTietSanPham";
	}
}
