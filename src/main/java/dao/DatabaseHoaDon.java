package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
	
	
	public List<HoaDon> getDanhSachHoaDonTheoTrangThai(int tinhTrangHoaDon) {
		String sql = "SELECT * FROM HoaDon where TinhTrangHoaDon = ?;";
		List<HoaDon> hd = jdbcTemplate.query(sql, new RowMapper<HoaDon>() {
			public HoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
				HoaDon hoaDon= new HoaDon();
				hoaDon.setMaHoaDon(rs.getInt("IdHoaDon"));
				hoaDon.setTenKhachHang(rs.getString("TenKhachHang"));
				hoaDon.setEmail(rs.getString("Email"));
				hoaDon.setSoDienThoai(rs.getString("SoDienThoai"));
				hoaDon.setDiaChi(rs.getNString("DiaChi"));
				hoaDon.setThanhPho(rs.getString("ThanhPho"));
				hoaDon.setNgayTao(rs.getDate("NgayTao"));
				hoaDon.setTinhTrangHoaDon(rs.getInt("TinhTrangHoaDon"));
				return hoaDon;
            }
		}, tinhTrangHoaDon);
		return hd;
	}
	
	public List<HoaDon> timKiemHoaDon(String info) {
		String sql = "SELECT * FROM shopmaytinh.HoaDon where TenKhachHang like '%" + info + "%' or SoDienThoai like '%" + info + "%';";
		List<HoaDon> hd = jdbcTemplate.query(sql, new RowMapper<HoaDon>() {
			public HoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
				HoaDon hoaDon= new HoaDon();
				hoaDon.setMaHoaDon(rs.getInt("IdHoaDon"));
				hoaDon.setTenKhachHang(rs.getString("TenKhachHang"));
				hoaDon.setEmail(rs.getString("Email"));
				hoaDon.setSoDienThoai(rs.getString("SoDienThoai"));
				hoaDon.setDiaChi(rs.getNString("DiaChi"));
				hoaDon.setThanhPho(rs.getString("ThanhPho"));
				hoaDon.setNgayTao(rs.getDate("NgayTao"));
				hoaDon.setTinhTrangHoaDon(rs.getInt("TinhTrangHoaDon"));
				return hoaDon;
            }
		});
		return hd;
	}
	
	public HoaDon getHoaDonById(int id) {
		String sql = "SELECT * FROM HoaDon where IdHoaDon = ?;";
		HoaDon hd = jdbcTemplate.queryForObject(sql, new RowMapper<HoaDon>() {
			public HoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
				HoaDon hoaDon= new HoaDon();
				hoaDon.setMaHoaDon(rs.getInt("IdHoaDon"));
				hoaDon.setTenKhachHang(rs.getString("TenKhachHang"));
				hoaDon.setEmail(rs.getString("Email"));
				hoaDon.setSoDienThoai(rs.getString("SoDienThoai"));
				hoaDon.setDiaChi(rs.getNString("DiaChi"));
				hoaDon.setThanhPho(rs.getString("ThanhPho"));
				hoaDon.setNgayTao(rs.getDate("NgayTao"));
				hoaDon.setTinhTrangHoaDon(rs.getInt("TinhTrangHoaDon"));
				return hoaDon;
            }
		}, id);
		return hd;
	}
	
	public int suaTinhTrang(int tinhTrang, int id) {
		String sql = "UPDATE `shopmaytinh`.`HoaDon` SET `TinhTrangHoaDon` = ? WHERE (`IdHoaDon` = ?);";
		int result = jdbcTemplate.update(sql, tinhTrang, id);
		return result;
	}
}
