package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DatabaseHoaDon;
import entity.ThongKe;

@Controller
public class ThongKeDoanhThuController {

	ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
	DatabaseHoaDon dbhd = (DatabaseHoaDon) context.getBean("databasehoadon");
	
	public ArrayList<Integer> thang(){
		ArrayList<Integer> arrThang = new ArrayList<Integer>();
		arrThang.add(1);
		arrThang.add(2);
		arrThang.add(3);
		arrThang.add(4);
		arrThang.add(5);
		arrThang.add(6);
		arrThang.add(7);
		arrThang.add(8);
		arrThang.add(9);
		arrThang.add(10);
		arrThang.add(11);
		arrThang.add(12);
		return arrThang;
	}
	
	public ArrayList<Integer> nam(){
		ArrayList<Integer> arrNam = new ArrayList<Integer>();
		arrNam.add(2009);
		arrNam.add(2010);
		arrNam.add(2011);
		arrNam.add(2012);
		arrNam.add(2013);
		arrNam.add(2014);
		arrNam.add(2015);
		arrNam.add(2016);
		arrNam.add(2017);
		arrNam.add(2018);
		arrNam.add(2019);
		arrNam.add(2020);
		return arrNam;
	}
	
	@RequestMapping("/thongke")
	public String thong(ModelMap model) {
		model.addAttribute("Size", -1);
		model.addAttribute("Thang", thang());
		model.addAttribute("Nam", nam());
		model.addAttribute("ThangChon", 1);
		model.addAttribute("NamChon", 2009);
		model.addAttribute("TrangChon", 3);
		return "ThongKeDoanhThu";
	}
	
	@PostMapping("/thongkedoanhthu")
	public String thongKeDoanhThu(ModelMap model, @RequestParam int thang, @RequestParam int nam) {
		List<ThongKe> listThongKe = dbhd.thongKe(thang, nam);
		if(listThongKe.size() == 0) {
			model.addAttribute("ThongBao", "Không có kết quả cần tìm kiếm!!!");
		}
		
		model.addAttribute("ListThongKe", listThongKe);
		model.addAttribute("Size", listThongKe.size());
		model.addAttribute("Thang", thang());
		model.addAttribute("Nam", nam());
		model.addAttribute("ThangChon", thang);
		model.addAttribute("NamChon", nam);
		model.addAttribute("TrangChon", 3);
		return "ThongKeDoanhThu";
	}
}
