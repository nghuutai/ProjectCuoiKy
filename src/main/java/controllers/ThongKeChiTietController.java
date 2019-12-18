package controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DatabaseHoaDon;
import entity.ThongKeChiTiet;

@Controller
public class ThongKeChiTietController {

	ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
	DatabaseHoaDon dbhd = (DatabaseHoaDon) context.getBean("databasehoadon");
	
	@RequestMapping("/thongkechitiet/{ngaytao}")
	public String thongKeChiTiet(ModelMap model, @PathVariable Date ngaytao ) {
		List<ThongKeChiTiet> listThongKeChiTiet =  dbhd.thongKeChiTiet(ngaytao);
		model.addAttribute("ListThongKeChiTiet", listThongKeChiTiet);
		model.addAttribute("TrangChon", 3);
		model.addAttribute("Ngay", ngaytao);
		return "ThongKeChiTiet";
	}
}
