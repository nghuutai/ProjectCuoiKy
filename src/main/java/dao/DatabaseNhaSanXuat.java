package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import entity.NhaSanXuat;

public class DatabaseNhaSanXuat {

	JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dbShopMayTinh) {
		this.jdbcTemplate = new JdbcTemplate(dbShopMayTinh);
	}
	
	public List<NhaSanXuat> getListNhaSanXuat() {
		String sql = "SELECT * FROM NhaSanXuat;";
		List<NhaSanXuat> listNhaSanXuat = jdbcTemplate.query(sql, new RowMapper<NhaSanXuat>() {
			public NhaSanXuat mapRow(ResultSet rs, int rowNum) throws SQLException {
				NhaSanXuat nhaSanXuat = new NhaSanXuat();
				nhaSanXuat.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
				nhaSanXuat.setTenNhaSanXuat(rs.getString("TenNhaSanXuat"));
				return nhaSanXuat;
			}
		});
		return listNhaSanXuat;
	}
	
	public String getTenNhaSanXuat(int id) {
		String sql = "SELECT TenNhaSanXuat FROM NhaSanXuat where IdNhaSanXuat = ?;";
		String result =jdbcTemplate.queryForObject(sql, new Object[]{id} , String.class);
		return result;
	}
	
	public NhaSanXuat getNhaSanXuatByID(int id) {
		String sql = "SELECT * FROM NhaSanXuat where IdNhaSanXuat = ?;";
		NhaSanXuat nsx = jdbcTemplate.queryForObject(sql, new RowMapper<NhaSanXuat>() {
			public NhaSanXuat mapRow(ResultSet rs, int rowNum) throws SQLException {
                NhaSanXuat nhaSanXuat = new NhaSanXuat();
                nhaSanXuat.setIdNhaSanXuat(rs.getInt("IdNhaSanXuat"));
                nhaSanXuat.setTenNhaSanXuat(rs.getString("TenNhaSanXuat"));
                return nhaSanXuat;
            }
		}, id);
		return nsx;
	}
}
