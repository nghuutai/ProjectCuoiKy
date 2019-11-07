package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseCauHinhMay {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dbShopMayTinh) {
		this.jdbcTemplate = new JdbcTemplate(dbShopMayTinh);
	}
	
}
