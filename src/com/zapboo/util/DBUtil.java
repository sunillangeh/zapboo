package com.zapboo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;


@Repository
public class DBUtil {

	private static final Logger logger = Logger.getLogger(DBUtil.class.getName());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean isExists(final String tableName, final String whereClause){
		
		boolean flag = false;
		String query = "select * from " + tableName + " where " + whereClause;
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
		if(rowSet.next()){
			flag = true;
		}
		
		return flag;
	}
	
	public String getSingleColumn(final String tableName, final String whereClause, String columnName){
		String query = "select "+columnName+" from " + tableName ;
		if(whereClause != null && !whereClause.trim().equals("")){
			query = query + " where " + whereClause;
		}
		
		String value = jdbcTemplate.queryForObject(query, String.class);
		
		return value;
	}
	
	public static void closeConnection(Connection connection) {

		try{
			if(connection != null){
				connection.close();
			}
		}
		catch (Exception e) {
			logger.error("Exception occured while closing connection : "+e);
		}
	}

	public static void closeStatement(Statement statement) {
		try{
			if(statement != null){
				statement.close();
			}
		}
		catch (Exception e) {
			logger.error("Exception occured while closing Statement : "+e);
		}
	}

	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		try{
			if(preparedStatement != null){
				preparedStatement.close();
			}
		}
		catch (Exception e) {
			logger.error("Exception occured while closing PreparedStatement : "+e);
		}
	}

	public static void closeResultSet(ResultSet rs) {
		try{
			if(rs != null){
				rs.close();
			}
		}
		catch (Exception e) {
			logger.error("Exception occured while closing ResultSet : "+e);
		}
	}

	
}
