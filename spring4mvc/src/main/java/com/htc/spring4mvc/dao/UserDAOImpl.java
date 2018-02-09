package com.htc.spring4mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.htc.spring4mvc.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean registerUser(User user) {
		String sql = "insert into TRNG_USERS values (?,?,?,?,?,?,?,?,?,?)";
		int insertCnt = jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getPassword(), user.getDetail(), user.getBirthdate(),user.getGender(), user.getCountry(), user.getHobbies(), user.getPhoneno(), user.getEmail());
		if(insertCnt>0)
			return true;
		return false;
	}

	@Override
	public boolean validateUser(String email, String password) {
		String sql = "select count(*) from TRNG_USERS where EMAIL=? and PASSWORD=?";
		Integer userCnt = jdbcTemplate.queryForObject(sql, Integer.class, email, password);
		if(userCnt==null || userCnt == 0)
			return false;
		else
			return true;
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "select firstName, lastName, password, detail, birthdate, gender, country, hobbies, phoneno, email from TRNG_USERS";
		List<User> userList = jdbcTemplate.query(sql,new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
				return user;
			}
			
		});
		return userList;
	}

	@Override
	public boolean deleteUser(String email) {
		String sql = "delete from TRNG_USERS where email=?";
		int dletCnt = jdbcTemplate.update(sql, email);
		if(dletCnt>0)
			return true;
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "update TRNG_USERS set detail=:detail, email=:email, password=:password where phoneno=:phoneno";
		
		NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("detail", user.getDetail());
		paramSource.addValue("email", user.getEmail());
		paramSource.addValue("password", user.getPassword());
		paramSource.addValue("phoneno", user.getPhoneno());
		
		int updtCnt = namedJdbcTemplate.update(sql, paramSource);
		if(updtCnt>0)
			return true;
		return false;

	}

	@Override
	public User findUser(String phoneno) {
		System.out.println("received:" + phoneno);
		String sql = "select firstName, lastName, password, detail, birthdate, gender, country, hobbies, email  from TRNG_USERS where phoneno=?";
		User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),phoneno,rs.getString(9));
				return user;
			}
			
		}, phoneno);
		return user;
		
	}
}
