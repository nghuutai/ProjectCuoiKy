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
public class QLSanPhamController {

	@Autowired
	ServletContext context;
	@GetMapping("/admin")
	public String trangQuanLySanPham(ModelMap modelMap) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
		DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
		List<LoaiMay> listLoaiMay = dblm.getListLoaiMay();
		List<NhaSanXuat> listNhaSanXuat = dbnsx.getListNhaSanXuat();
		List<SanPham> listSP = db.getListSanPham();
		modelMap.addAttribute("listSP", listSP);
		modelMap.addAttribute("ListLoaiMay", listLoaiMay);
		modelMap.addAttribute("ListNhaSanXuat", listNhaSanXuat);
		return "QuanLySanPham";
	}
	
	@PostMapping("/admin")
	public String themSanPham(@RequestParam String tenSanPham,@RequestParam int donGia,@RequestParam int soLuong,@RequestParam String moTa,@RequestParam int idNhaSanXuat,@RequestParam int idLoaiMay,@RequestParam("hinhAnh") MultipartFile image, ModelMap modelMap) {
		if(image.isEmpty()) {
			modelMap.addAttribute("message", "Vui long chon file");
		}else {
			try {
				String path1 = "/Users/nguyenhuutai/Documents/ProjectSpring/project2/src/main/webapp/recources/imagess/" + image.getOriginalFilename();
				String path =  context.getRealPath("/images/" + image.getOriginalFilename());
				System.out.println(path1);
				File fileDir = new File(path1);
				System.out.println(fileDir.exists());
				if(!fileDir.exists()){
					fileDir.mkdirs();
				}
				image.transferTo(new File(path1));
				String hinhAnh = image.getOriginalFilename();
				ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
				DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
				DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
				DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
				SanPham sp = new SanPham();
				sp.setTenSanPham(tenSanPham);
				sp.setDonGia(donGia);
				sp.setSoLuong(soLuong);
				sp.setHinhAnh(hinhAnh);
				sp.setMoTa(moTa);
				sp.setIdNhaSanXuat(idNhaSanXuat);
				sp.setIdLoaiMay(idLoaiMay);
				db.addSanPham(sp);
				List<SanPham> listSP = db.getListSanPham();
				List<NhaSanXuat> listNhaSanXuat = dbnsx.getListNhaSanXuat();
				List<LoaiMay> listLoaiMay = dblm.getListLoaiMay();
				modelMap.addAttribute("listSP", listSP);
				modelMap.addAttribute("ListLoaiMay", listLoaiMay);
				modelMap.addAttribute("ListNhaSanXuat", listNhaSanXuat);
			}catch(Exception ex) {
				modelMap.addAttribute("message", "Loi luu file!");
			}
		}
		return "QuanLySanPham";
	}
	
	@GetMapping("/admin/{id}")
	public String xoaSanPham(@PathVariable int id, ModelMap modelMap) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseSanPham db = (DatabaseSanPham) context.getBean("databasesanpham");
		DatabaseLoaiMay dblm = (DatabaseLoaiMay) context.getBean("databaseloaimay");
		DatabaseNhaSanXuat dbnsx = (DatabaseNhaSanXuat) context.getBean("databasenhasanxuat");
		db.xoaSanPham(id);
		List<SanPham> listSP = db.getListSanPham();
		List<NhaSanXuat> listNhaSanXuat = dbnsx.getListNhaSanXuat();
		List<LoaiMay> listLoaiMay = dblm.getListLoaiMay();
		modelMap.addAttribute("listSP", listSP);
		modelMap.addAttribute("ListLoaiMay", listLoaiMay);
		modelMap.addAttribute("ListNhaSanXuat", listNhaSanXuat);
		return "QuanLySanPham";
	}
}
