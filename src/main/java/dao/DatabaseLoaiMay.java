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



public class DatabaseLoaiMay {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dbShopMayTinh) {
		this.jdbcTemplate = new JdbcTemplate(dbShopMayTinh);
	}
	
	public void addLoaiMay(final String tenLoaiMay) {
		String sql = "INSERT INTO `shopmaytinh`.`LoaiMay` (`TenLoaiMay`) VALUES (?);";
		int results = jdbcTemplate.update(sql, tenLoaiMay);
	}
	
	public List<LoaiMay> getListLoaiMay() {
		String sql = "select * from LoaiMay";
		List<LoaiMay> listLoaiMay = jdbcTemplate.query(sql, new RowMapper<LoaiMay>() {

			public LoaiMay mapRow(ResultSet rs, int rowNum) throws SQLException {
				LoaiMay loaiMay = new LoaiMay();
				loaiMay.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				loaiMay.setTenLoaiMay(rs.getString("TenLoaiMay"));
				return loaiMay;
			}
		});
		return listLoaiMay;
	}
	
	public String getTenLoaiMay(int id) {
		String sql = "SELECT TenLoaiMay FROM LoaiMay where IdLoaiMay = ?;";
		String result =jdbcTemplate.queryForObject(sql, new Object[]{id} , String.class);
		return result;
	}
	
	public LoaiMay getLoaiMayByID(int id) {
		String sql = "SELECT * FROM LoaiMay where idLoaiMay = ?;";
		LoaiMay lm = jdbcTemplate.queryForObject(sql, new RowMapper<LoaiMay>() {
			public LoaiMay mapRow(ResultSet rs, int rowNum) throws SQLException {
                LoaiMay loaiMay = new LoaiMay();
                loaiMay.setIdLoaiMay(rs.getInt("IdLoaiMay"));
				loaiMay.setTenLoaiMay(rs.getString("TenLoaiMay"));
                return loaiMay;
            }
		}, id);
		return lm;
	}
}
