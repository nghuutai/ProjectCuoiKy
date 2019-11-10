package controllers;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DatabaseSanPham;
import entity.Cart;
import entity.LoaiMay;
import entity.SanPham;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index(ModelMap model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		List<SanPham> listSanPhamMoi = db.getListSanPhamMoi();
		model.addAttribute("ListSanPhamMoi", listSanPhamMoi);
		return "Index";
	}
	
	@RequestMapping("/quickdetail/{id}")
	public @ResponseBody String searchPerson(@PathVariable int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		SanPham sanPham = db.getSanPhamByID(id);

		ObjectMapper mapper = new ObjectMapper();
		String ajaxResponse = "";
		try {
			ajaxResponse = mapper.writeValueAsString(sanPham);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(ajaxResponse);
		return ajaxResponse;
	}

	
}
