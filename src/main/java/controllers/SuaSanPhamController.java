package controllers;

import java.io.File;
import java.util.List;

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

import dao.DatabaseLoaiMay;
import dao.DatabaseNhaSanXuat;
import dao.DatabaseSanPham;
import entity.LoaiMay;
import entity.NhaSanXuat;
import entity.SanPham;

@Controller
public class SuaSanPhamController {

	@Autowired
	ServletContext servletContext;
	ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
	DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
	DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
	DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
	@GetMapping("suasanpham/{id}")
	public String trangSuaSanPham(@PathVariable int id, ModelMap modelMap) {
		
		SanPham sp = db.getSanPhamByID(id);
		List<NhaSanXuat> listNhaSanXuat = dbnsx.getListNhaSanXuat();
		List<LoaiMay> listLoaiMay = dblm.getListLoaiMay();
		modelMap.addAttribute("sanPham",sp);
		modelMap.addAttribute("result", 0);
		modelMap.addAttribute("ListLoaiMay", listLoaiMay);
		modelMap.addAttribute("ListNhaSanXuat", listNhaSanXuat);
		return "SuaSanPham";
	}
	
	@PostMapping("suasanpham/{id}")
	public String suaSanPham(@RequestParam int idSanPham, @RequestParam String tenSanPham, @RequestParam int donGia,@RequestParam String moTa,@RequestParam int idNhaSanXuat,@RequestParam int idLoaiMay, @RequestParam int soLuong, @RequestParam("hinhAnh") MultipartFile image, ModelMap modelMap) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
//		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
//		DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
//		DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
		if(image.isEmpty()) {
			SanPham sp = new SanPham();
			sp.setIdSanPham(idSanPham);
			sp.setTenSanPham(tenSanPham);
			sp.setDonGia(donGia);
			sp.setSoLuong(soLuong);
			sp.setMoTa(moTa);
			sp.setIdNhaSanXuat(idNhaSanXuat);
			sp.setIdLoaiMay(idLoaiMay);
			int kq = db.suaSanPhamNoImg(sp);
			List<NhaSanXuat> listNhaSanXuat = dbnsx.getListNhaSanXuat();
			List<LoaiMay> listLoaiMay = dblm.getListLoaiMay();
			modelMap.addAttribute("sanPham",sp);
			modelMap.addAttribute("result", kq);
			modelMap.addAttribute("ListLoaiMay", listLoaiMay);
			modelMap.addAttribute("ListNhaSanXuat", listNhaSanXuat);
		}else {
			try {
				String path1 = "/Users/nguyenhuutai/Documents/ProjectSpring/project2/src/main/webapp/recources/imagess/" + image.getOriginalFilename();
				File fileDir = new File(path1);
//				System.out.println(fileDir.exists());
				if(!fileDir.exists()){
					fileDir.mkdirs();
				}
				image.transferTo(new File(path1));
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
				List<NhaSanXuat> listNhaSanXuat = dbnsx.getListNhaSanXuat();
				List<LoaiMay> listLoaiMay = dblm.getListLoaiMay();
				int kq = db.suaSanPham(sp);	
				modelMap.addAttribute("sanPham",sp);
				modelMap.addAttribute("result", kq);
				modelMap.addAttribute("ListLoaiMay", listLoaiMay);
				modelMap.addAttribute("ListNhaSanXuat", listNhaSanXuat);
			}catch(Exception ex) {
				modelMap.addAttribute("message", "Loi luu file!");
			}
		}
		return "SuaSanPham";
	}
}
