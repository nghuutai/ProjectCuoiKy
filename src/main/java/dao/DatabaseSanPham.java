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
}
