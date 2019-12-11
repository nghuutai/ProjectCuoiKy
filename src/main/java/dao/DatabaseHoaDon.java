package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import entity.HoaDon;

public class DatabaseHoaDon {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dbShopBanHang) {
		this.jdbcTemplate = new JdbcTemplate(dbShopBanHang);
	}
	
	public int addHoaDon(HoaDon hoaDon) {
		String sql = "INSERT INTO `shopmaytinh`.`HoaDon` (`TenKhachHang`, `Email`, `SoDienThoai`, `DiaChi`, `ThanhPho`, `NgayTao`, `TinhTrangHoaDon`) VALUES (?, ?, ?, ?, ?, ?, ?);";
		int result = jdbcTemplate.update(sql, hoaDon.getTenKhachHang(), hoaDon.getEmail(), hoaDon.getSoDienThoai(), hoaDon.getDiaChi(), hoaDon.getThanhPho(), hoaDon.getNgayTao(), hoaDon.getTinhTrangHoaDon());
		return result;
	}
	
	public int getMaHoaDon() {
		String sql = "SELECT max(IdHoaDon) FROM shopmaytinh.HoaDon;";
		int result =jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}
}
