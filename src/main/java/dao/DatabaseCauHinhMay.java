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
	
	public int checkCauHinhLaptop(int id, int idlm) {
		String sql = "";
		if(idlm == 1) {
			sql = "SELECT count(*) FROM shopmaytinh.CauHinhLaptop where IdSanPham=?;";
		}else if(idlm == 2) {
			sql = "SELECT count(*) FROM shopmaytinh.CauHinhPC where IdSanPham=?;";
		}
		return jdbcTemplate.queryForObject(
                sql, new Object[]{id}, Integer.class);
	}
	
	public void addCauHinhLaptop(final CauHinhLaptop cauHinhLaptop) {
		String sql = "INSERT INTO `shopmaytinh`.`CauHinhLaptop` (`IdSanPham`, `CPU`, `RAM`, `HardDisk`, `VGA`, `KichThuocManHinh`, `DoPhanGiaiManHinh`, `LoaiManHinh`, `TrongLuong`, `KichThuoc`, `OS`, `Pin`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		int results = jdbcTemplate.update(sql, cauHinhLaptop.getIdSanPham(), cauHinhLaptop.getCpu(), cauHinhLaptop.getRam(), cauHinhLaptop.getHardDisk(), cauHinhLaptop.getVga(), cauHinhLaptop.getKichThuocManHinh(), cauHinhLaptop.getDoPhanGiaiManHinh(), cauHinhLaptop.getLoaiManHinh(), cauHinhLaptop.getTrongLuong(), cauHinhLaptop.getKichThuoc(), cauHinhLaptop.getOs(), cauHinhLaptop.getPin());
	}
	
	public void addCauHinhPC(final CauHinhPC cauHinhPC) {
		String sql = "INSERT INTO `shopmaytinh`.`CauHinhPC` (`IdSanPham`, `CPU`, `Mainboard`, `RAM`, `HardDisk`, `VGA`, `Nguon`, `Case`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		int results = jdbcTemplate.update(sql, cauHinhPC.getIdSanPham(), cauHinhPC.getCpu(), cauHinhPC.getMainboard(), cauHinhPC.getRam(), cauHinhPC.getHardDisk(), cauHinhPC.getVga(), cauHinhPC.getNguon(), cauHinhPC.getmCase());
	}
	
	public int xoaCauHinhPC(int id) {
		String sql = "DELETE FROM `shopmaytinh`.`CauHinhPC` WHERE (`IdSanPham` = ?);";
		int result = jdbcTemplate.update(sql, id);
		return result;
	}
	
	public int xoaCauHinhLaptop(int id) {
		String sql = "DELETE FROM `shopmaytinh`.`CauHinhLaptop` WHERE (`IdSanPham` = ?);";
		int result = jdbcTemplate.update(sql, id);
		return result;
	}
}
