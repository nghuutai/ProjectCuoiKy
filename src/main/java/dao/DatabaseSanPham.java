package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entity.LoaiMay;
import entity.NhaSanXuat;
import entity.SanPham;

public class DatabaseSanPham {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dbShopMayTinh) {
		this.jdbcTemplate = new JdbcTemplate(dbShopMayTinh);
	}
	
	public List<SanPham> getListSanPham() {
		String sql = "select * from shopmaytinh.SanPham";
		List<SanPham> listSanPham = jdbcTemplate.query(sql, new RowMapper<SanPham>() {

			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("idSanPham"));
				sanPham.setTenSanPham(rs.getString("tenSanPham"));
				sanPham.setDonGia(rs.getInt("donGia"));
				sanPham.setSoLuong(rs.getInt("soLuong"));
				sanPham.setHinhAnh(rs.getString("hinhAnh"));
				sanPham.setMoTa(rs.getString("moTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("idNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("idLoaiMay"));
				return sanPham;
			}
		});
		return listSanPham;
	}
	
	public List<SanPham> getListSanPhamMoi() {
		String sql = "SELECT * FROM shopmaytinh.SanPham order by IdSanPham desc limit 6;";
		List<SanPham> listSanPhamMoi = jdbcTemplate.query(sql, new RowMapper<SanPham>() {

			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPhamMoi;
	}
	
	public List<SanPham> getListSanPhamBanChay() {
		String sql = "SELECT ChiTietHoaDon.IdSanPham,TenSanPham,DonGia,SoLuong,HinhAnh,MoTa,IdNhaSanXuat,IdLoaiMay,sum(SoLuongMua)  FROM shopmaytinh.ChiTietHoaDon,shopmaytinh.SanPham where ChiTietHoaDon.IdSanPham = SanPham.IdSanPham group by IdSanPham order by sum(SoLuongMua) desc limit 0,6;";
		List<SanPham> listSanPhamMoi = jdbcTemplate.query(sql, new RowMapper<SanPham>() {

			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPhamMoi;
	}
	
	public List<SanPham> getListSanPhamTheoLoai(int id) {
		String sql = "SELECT * FROM shopmaytinh.SanPham where IdLoaiMay=?;";
		List<SanPham> listSanPhamMoi = jdbcTemplate.query(sql, new Object[]{id}, new RowMapper<SanPham>() {

			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPhamMoi;
	}
	
	public List<SanPham> getListSanPhamTheoLoaiLimit(int id, int trang, int soPhanTu) {
		String sql = "SELECT * FROM shopmaytinh.SanPham where IdLoaiMay=? limit ?,?;";
		List<SanPham> listSanPhamMoi = jdbcTemplate.query(sql, new Object[]{id, trang, soPhanTu}, new RowMapper<SanPham>() {

			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPhamMoi;
	}
	
	public List<SanPham> getListSanPhamTheoNhaSanXuat(int idnsx, int idlm) {
		String sql = "SELECT * FROM shopmaytinh.SanPham where IdNhaSanXuat=? and IdLoaiMay=?;";
		List<SanPham> listSanPhamMoi = jdbcTemplate.query(sql, new Object[]{idnsx, idlm}, new RowMapper<SanPham>() {

			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPhamMoi;
	}
	
	public List<SanPham> getListSanPhamTheoNhaSanXuatLimit(int idnsx, int idlm, int trang, int soPhanTu) {
		String sql = "SELECT * FROM shopmaytinh.SanPham where IdNhaSanXuat=? and IdLoaiMay=? limit ?,?;";
		List<SanPham> listSanPhamMoi = jdbcTemplate.query(sql, new Object[]{idnsx, idlm, trang, soPhanTu}, new RowMapper<SanPham>() {

			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPhamMoi;
	}
	
	public List<SanPham> getListSanPhamTheoGia(int from, int to, int loaiMay){
		String sql = "SELECT * FROM shopmaytinh.SanPham where DonGia >= ? and DonGia < ? and IdLoaiMay = ?;";
		List<SanPham> listSanPham = jdbcTemplate.query(sql, new Object[] {from, to, loaiMay}, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPham;
	}
	
	public List<SanPham> getListSanPhamTheoGiaLimit(int from, int to, int loaiMay, int trang, int soPhanTu){
		String sql = "SELECT * FROM shopmaytinh.SanPham where DonGia >= ? and DonGia < ? and IdLoaiMay = ? limit ?,?;";
		List<SanPham> listSanPham = jdbcTemplate.query(sql, new Object[] {from, to, loaiMay, trang, soPhanTu}, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPham;
	}
	
	public List<SanPham> getListSanPhamTheoGia(int from, int loaiMay){
		String sql = "SELECT * FROM shopmaytinh.SanPham where DonGia >= ? and IdLoaiMay = ?;";
		List<SanPham> listSanPham = jdbcTemplate.query(sql, new Object[] {from, loaiMay}, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPham;
	}
	
	public List<SanPham> getListSanPhamTheoGiaLimit(int from, int loaiMay, int trang, int soPhanTu){
		String sql = "SELECT * FROM shopmaytinh.SanPham where DonGia >= ? and IdLoaiMay = ? limit ?,?;";
		List<SanPham> listSanPham = jdbcTemplate.query(sql, new Object[] {from, loaiMay, trang, soPhanTu}, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPham;
	}
	
	public List<SanPham> getListSanPhamTheoGiaVaNhaSanXuat(int from, int to, int loaiMay, int nhaSanXuat){
		String sql = "SELECT * FROM shopmaytinh.SanPham where DonGia >= ? and DonGia < ? and IdLoaiMay = ? and IdNhaSanXuat = ?;";
		List<SanPham> listSanPham = jdbcTemplate.query(sql, new Object[] {from, to, loaiMay, nhaSanXuat}, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPham;
	}
	
	public List<SanPham> getListSanPhamTheoGiaVaNhaSanXuatLimit(int from, int to, int loaiMay, int nhaSanXuat,int trang, int soPhanTu){
		String sql = "SELECT * FROM shopmaytinh.SanPham where DonGia >= ? and DonGia < ? and IdLoaiMay = ? and IdNhaSanXuat = ? limit ?,?;";
		List<SanPham> listSanPham = jdbcTemplate.query(sql, new Object[] {from, to, loaiMay, nhaSanXuat, trang, soPhanTu}, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPham;
	}
	
	public List<SanPham> getListSanPhamTheoGiaVaNhaSanXuat(int from, int loaiMay, int nhaSanXuat){
		String sql = "SELECT * FROM shopmaytinh.SanPham where DonGia >= ? and IdLoaiMay = ? and IdNhaSanXuat = ?;";
		List<SanPham> listSanPham = jdbcTemplate.query(sql, new Object[] {from, loaiMay, nhaSanXuat}, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPham;
	}
	
	public List<SanPham> getListSanPhamTheoGiaVaNhaSanXuatLimit(int from, int loaiMay, int nhaSanXuat,int trang, int soPhanTu){
		String sql = "SELECT * FROM shopmaytinh.SanPham where DonGia >= ? and IdLoaiMay = ? and IdNhaSanXuat = ? limit ?,?;";
		List<SanPham> listSanPham = jdbcTemplate.query(sql, new Object[] {from, loaiMay, nhaSanXuat, trang, soPhanTu}, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPham;
	}
	
	public List<SanPham> getListSanPhamLienQuan(int id, int idnsx, int idloaimay, int limit){
		String sql = "SELECT * FROM shopmaytinh.SanPham where IdNhaSanXuat=? and IdLoaiMay=? and IdSanPham<>? limit ?;";
		List<SanPham> listSanPham = jdbcTemplate.query(sql, new Object[] {idnsx, idloaimay, id, limit}, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPham;
	}
	
	public List<SanPham> timKiemSanPham(String info) {
		String sql = "SELECT * FROM shopmaytinh.SanPham where TenSanPham like '%" + info + "%';";
		List<SanPham> listSanPham = jdbcTemplate.query(sql, new RowMapper<SanPham>() {

			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPham;
	}
	
	public List<SanPham> timKiemSanPhamLimit(String info, int trang, int soPhanTu) {
		String sql = "SELECT * FROM shopmaytinh.SanPham where TenSanPham like '%" + info + "%' Limit ?,?;";
		List<SanPham> listSanPham = jdbcTemplate.query(sql, new Object[] {trang, soPhanTu}, new RowMapper<SanPham>() {

			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
			}
		});
		return listSanPham;
	}
	
	public SanPham getSanPhamByID(int id) {
		String sql = "SELECT * FROM SanPham where IdSanPham = ?;";
		SanPham sp = jdbcTemplate.queryForObject(sql, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham();
				sanPham.setIdSanPham(rs.getInt("IdSanPham"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				sanPham.setDonGia(rs.getInt("DonGia"));
				sanPham.setSoLuong(rs.getInt("SoLuong"));
				sanPham.setHinhAnh(rs.getString("HinhAnh"));
				sanPham.setMoTa(rs.getString("MoTa"));
				sanPham.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				sanPham.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				return sanPham;
            }
		}, id);
		return sp;
	}
	
	public int getSoLuong(int id) {
		String sql = "SELECT soLuong FROM shopmaytinh.SanPham where IdSanPham=?;";
		int result =jdbcTemplate.queryForObject(sql, new Object[]{id}, Integer.class);
		return result;
	}
	
	public int suaSoLuong(int sl, int id) {
		String sql = "UPDATE `shopmaytinh`.`SanPham` SET `SoLuong` = `SoLuong` - ? WHERE (`idSanPham` = ?);";
		int result = jdbcTemplate.update(sql, sl, id);
		return result;
	}
	
	public void addSanPham(final SanPham sp) {
		String sql = "INSERT INTO `shopmaytinh`.`SanPham` (`TenSanPham`, `DonGia`, `SoLuong`, `HinhAnh`, `MoTa`, `IdNhaSanXuat`, `IdLoaiMay`) VALUES (?, ?, ?,?,?,?,?);";
		int results = jdbcTemplate.update(sql, sp.getTenSanPham(), sp.getDonGia(), sp.getSoLuong(), sp.getHinhAnh(), sp.getMoTa(), sp.getIdNhaSanXuat(), sp.getIdLoaiMay());
	}
	
	public int suaSanPham(final SanPham sp) {
		String sql = "UPDATE `shopmaytinh`.`SanPham` SET `TenSanPham` = ?, `DonGia` = ?, `SoLuong` = ?, `HinhAnh` = ?, `MoTa` = ?, `IdNhaSanXuat`= ?, `IdLoaiMay` = ? WHERE (`IdSanPham` = ?);";
		int result = jdbcTemplate.update(sql, sp.getTenSanPham(), sp.getDonGia(), sp.getSoLuong(), sp.getHinhAnh(), sp.getMoTa(), sp.getIdNhaSanXuat(), sp.getIdLoaiMay(), sp.getIdSanPham());
		return result;
	}
	
	public int suaSanPhamNoImg(final SanPham sp) {
		String sql = "UPDATE `shopmaytinh`.`SanPham` SET `TenSanPham` = ?, `DonGia` = ?, `SoLuong` = ?, `MoTa` = ?, `IdNhaSanXuat`= ?, `IdLoaiMay` = ? WHERE (`IdSanPham` = ?);";
		int result = jdbcTemplate.update(sql, sp.getTenSanPham(), sp.getDonGia(), sp.getSoLuong(), sp.getMoTa(), sp.getIdNhaSanXuat(), sp.getIdLoaiMay(), sp.getIdSanPham());
		return result;
	}
	
	
	public int xoaSanPham(int id) {
		String sql = "DELETE FROM `shopmaytinh`.`SanPham` WHERE (`IdSanPham` = ?);";
		int result = jdbcTemplate.update(sql, id);
		return result;
	}
}
