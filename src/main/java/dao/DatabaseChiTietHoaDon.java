package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.SanPham;

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
	
	public List<ChiTietHoaDon> getChiTietHoaDonByID(int id) {
		String sql = "select * from shopmaytinh.ChiTietHoaDon where IdHoaDon = ?";
		List<ChiTietHoaDon> listChiTietHoaDon = jdbcTemplate.query(sql, new RowMapper<ChiTietHoaDon>() {

			public ChiTietHoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
				HoaDon hoaDon = new HoaDon();
				SanPham sanPham = new SanPham();
				hoaDon.setMaHoaDon(rs.getInt("IdHoaDon"));
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				chiTietHoaDon.setId(rs.getInt("IdChiTietHoaDon"));
				chiTietHoaDon.setHoaDon(hoaDon);
				chiTietHoaDon.setSanPham(sanPham);
				chiTietHoaDon.setSoLuongMua(rs.getInt("SoLuongMua"));
				return chiTietHoaDon;
			}
		}, id);
		return listChiTietHoaDon;
	}
}
