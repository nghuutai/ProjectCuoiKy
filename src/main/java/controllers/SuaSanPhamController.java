package controllers;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dao.DatabaseSanPham;
import entity.SanPham;

@Controller
public class SuaSanPhamController {

	@Autowired
	ServletContext context;

	@GetMapping("suasanpham/{id}")
	public String trangSuaSanPham(@PathVariable int id, ModelMap modelMap) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		SanPham sp = db.getSanPhamByID(id);
		modelMap.addAttribute("sanPham",sp);
		modelMap.addAttribute("result", 0);
		return "SuaSanPham";
	}
	
	@PostMapping("suasanpham/{id}")
	public String suaSanPham(@RequestParam int idSanPham, @RequestParam String tenSanPham, @RequestParam int donGia,@RequestParam String moTa,@RequestParam int idNhaSanXuat,@RequestParam int idLoaiMay, @RequestParam int soLuong, @RequestParam("hinhAnh") MultipartFile image, ModelMap modelMap) {
		
		if(image.isEmpty()) {
			ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
			DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
			SanPham sp = new SanPham();
			sp.setIdSanPham(idSanPham);
			sp.setTenSanPham(tenSanPham);
			sp.setDonGia(donGia);
			sp.setSoLuong(soLuong);
			sp.setMoTa(moTa);
			sp.setIdNhaSanXuat(idNhaSanXuat);
			sp.setIdLoaiMay(idLoaiMay);
			int kq = db.suaSanPhamNoImg(sp);
			System.out.println(idNhaSanXuat);
			System.out.println(idLoaiMay);
			modelMap.addAttribute("sanPham",sp);
			modelMap.addAttribute("result", kq);
		}else {
			try {
				String path1 = "/Users/nguyenhuutai/Documents/ProjectSpring/project2/src/main/webapp/recources/imagess/" + image.getOriginalFilename();
				System.out.println(path1);
				File fileDir = new File(path1);
				System.out.println(fileDir.exists());
				if(!fileDir.exists()){
					fileDir.mkdirs();
				}
				image.transferTo(new File(path1));
				
				ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
				DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
				String hinhAnh = image.getOriginalFilename();
				SanPham sp = new SanPham();
				sp.setIdSanPham(idSanPham);
				sp.setTenSanPham(tenSanPham);
				sp.setDonGia(donGia);
				sp.setSoLuong(soLuong);
				sp.setHinhAnh(hinhAnh);
				sp.setMoTa(moTa);
				sp.setIdNhaSanXuat(idNhaSanXuat);
				sp.setIdLoaiMay(idLoaiMay);
				System.out.println(idNhaSanXuat);
				System.out.println(idLoaiMay);
				int kq = db.suaSanPham(sp);	
				modelMap.addAttribute("sanPham",sp);
				modelMap.addAttribute("result", kq);
			}catch(Exception ex) {
				modelMap.addAttribute("message", "Loi luu file!");
			}
		}
		return "SuaSanPham";
	}
}
