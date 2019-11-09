package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entity.CauHinhLaptop;
import entity.CauHinhPC;
import entity.SanPham;

public class DatabaseCauHinhMay {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dbShopMayTinh) {
		this.jdbcTemplate = new JdbcTemplate(dbShopMayTinh);
	}

	public CauHinhLaptop getCauHinhLaptopByID(int id) {
		String sql = "SELECT * FROM shopmaytinh.CauHinhLaptop where IdSanPham = ?;";
		CauHinhLaptop chlt = jdbcTemplate.queryForObject(sql, new RowMapper<CauHinhLaptop>() {
			public CauHinhLaptop mapRow(ResultSet rs, int rowNum) throws SQLException {
				CauHinhLaptop cauHinhLapTop = new CauHinhLaptop();
				cauHinhLapTop.setIdSanPham(rs.getInt("IdSanPham"));
				cauHinhLapTop.setCpu(rs.getString("CPU"));
				cauHinhLapTop.setRam(rs.getString("RAM"));
				cauHinhLapTop.setHardDisk(rs.getString("HardDisk"));
				cauHinhLapTop.setVga(rs.getString("VGA"));
				cauHinhLapTop.setKichThuocManHinh(rs.getString("KichThuocManHinh"));
				cauHinhLapTop.setDoPhanGiaiManHinh(rs.getString("DoPhanGiaiManHinh"));
				cauHinhLapTop.setLoaiManHinh(rs.getString("LoaiManHinh"));
				cauHinhLapTop.setTrongLuong(rs.getString("TrongLuong"));
				cauHinhLapTop.setKichThuoc(rs.getString("KichThuoc"));
				cauHinhLapTop.setOs(rs.getString("OS"));
				cauHinhLapTop.setPin(rs.getString("Pin"));		
				return cauHinhLapTop;
            }
		}, id);
		return chlt;
	}
	
	public CauHinhPC getCauHinhPCByID(int id) {
		String sql = "SELECT * FROM CauHinhPC where IdSanPham = ?;";
		CauHinhPC chpc = jdbcTemplate.queryForObject(sql, new RowMapper<CauHinhPC>() {
			public CauHinhPC mapRow(ResultSet rs, int rowNum) throws SQLException {
				CauHinhPC cauHinhPC = new CauHinhPC();
				cauHinhPC.setIdSanPham(rs.getInt("IdSanPham"));
				cauHinhPC.setCpu(rs.getString("CPU"));
				cauHinhPC.setMainboard(rs.getString("MainBoard"));
				cauHinhPC.setRam(rs.getString("RAM"));
				cauHinhPC.setHardDisk(rs.getString("HardDisk"));
				cauHinhPC.setVga(rs.getString("VGA"));
				cauHinhPC.setNguon(rs.getString("Nguon"));
				cauHinhPC.setmCase(rs.getString("Case"));
				return cauHinhPC;
            }
		}, id);
		return chpc;
	}
}
