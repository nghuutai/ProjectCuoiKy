package controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DatabaseChiTietHoaDon;
import dao.DatabaseHoaDon;
import dao.DatabaseSanPham;
import entity.ChiTietHoaDon;
import entity.HoaDon;

@Controller
public class QuanLyDonHangController {

	ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
	DatabaseHoaDon db = (DatabaseHoaDon) context.getBean("databasehoadon");
	DatabaseChiTietHoaDon dbcthd = (DatabaseChiTietHoaDon) context.getBean("databasechitiethoadon");
	DatabaseSanPham dbsp = (DatabaseSanPham) context.getBean("databasesanpham");
	public HashMap<Integer, String> getTinhTrang(){
		HashMap<Integer, String> arrTinhTrang = new HashMap<Integer, String>();
		arrTinhTrang.put(1, "Chưa xác nhận");
		arrTinhTrang.put(2, "Không liên lạc được");
		arrTinhTrang.put(3, "Huỷ đơn hàng");
		arrTinhTrang.put(4, "Đã xác nhận");
		return arrTinhTrang;
	}
	
	@RequestMapping("/quanlydonhang")
	public String quanLyDonHang(ModelMap model) {
		List<HoaDon> listHoaDon = db.getDanhSachHoaDonTheoTrangThai(1);
		if(listHoaDon.size() == 0) {
			model.addAttribute("ThongBao", "Không có kết quả cần tìm kiếm!!!");
		}
		model.addAttribute("HoaDon", listHoaDon);
		model.addAttribute("TinhTrang", getTinhTrang());
		model.addAttribute("TinhTrangChon", 0);
		model.addAttribute("TrangChon", 2);
		return "QuanLyDonHang";
	}
	
	@RequestMapping("/quanlydonhang/timkiem")
	public String timKiemDonHang(ModelMap model, @RequestParam String timKiem) {
		List<HoaDon> listHoaDon;
		if(timKiem.isEmpty()) {
			listHoaDon = db.getDanhSachHoaDonTheoTrangThai(1);
		}else {
			listHoaDon = db.timKiemHoaDon(timKiem);
		}
		if(listHoaDon.size() == 0) {
			model.addAttribute("ThongBao", "Không có kết quả cần tìm kiếm!!!");
		}
		model.addAttribute("HoaDon", listHoaDon);
		model.addAttribute("TinhTrang", getTinhTrang());
		model.addAttribute("TinhTrangChon", 0);
		model.addAttribute("TrangChon", 2);
		return "QuanLyDonHang";
	}
	
	@PostMapping("/quanlydonhang/tinhtrang")
	public String quanLyDonHangTheoTrangThai(ModelMap model, @RequestParam int tinhTrang1) {
		List<HoaDon> listHoaDon = db.getDanhSachHoaDonTheoTrangThai(tinhTrang1);
		if(listHoaDon.size() == 0) {
			model.addAttribute("ThongBao", "Không có kết quả cần tìm kiếm!!!");
		}
		model.addAttribute("HoaDon", listHoaDon);
		model.addAttribute("TinhTrang", getTinhTrang());
		model.addAttribute("TinhTrangChon", tinhTrang1);
		model.addAttribute("TrangChon", 2);
		return "QuanLyDonHang";
	}
	
	@PostMapping("/quanlydonhang/thaydoitrangthai/{id}")
	public String suaTrangThai(ModelMap model, @RequestParam int tinhTrang, @PathVariable int id){
		if(tinhTrang == 3) {
			List<ChiTietHoaDon> listCTHD = dbcthd.getChiTietHoaDonByID(id);
			for(ChiTietHoaDon cthd : listCTHD) {
				dbsp.tangSoLuong(cthd.getSoLuongMua(), cthd.getSanPham().getIdSanPham());
			}
			db.suaTinhTrang(tinhTrang, id);
		}else {
			db.suaTinhTrang(tinhTrang, id);
		}
		List<HoaDon> listHoaDon = db.getDanhSachHoaDonTheoTrangThai(1);
		model.addAttribute("HoaDon", listHoaDon);
		model.addAttribute("TinhTrang", getTinhTrang());
		model.addAttribute("TinhTrangChon", 0);
		model.addAttribute("TrangChon", 2);
		return "QuanLyDonHang";
	}
}
