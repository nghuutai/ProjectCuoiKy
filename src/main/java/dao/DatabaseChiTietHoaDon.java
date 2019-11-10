package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import entity.ChiTietHoaDon;

public class DatabaseChiTietHoaDon {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dbShopBanHang) {
		this.jdbcTemplate = new JdbcTemplate(dbShopBanHang);
	}
	
	public int addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		String sql = "INSERT INTO `shopmaytinh`.`ChiTietHoaDon` (`IdHoaDon`, `IdSanPham`, `SoLuongMua`) VALUES (?, ?, ?);";
		int result = jdbcTemplate.update(sql, chiTietHoaDon.getHoaDon().getMaHoaDon(), chiTietHoaDon.getSanPham().getIdSanPham(), chiTietHoaDon.getSoLuongMua());
		return 1;
	}
}
