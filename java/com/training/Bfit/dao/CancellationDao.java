package com.training.Bfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.training.Bfit.model.Members;
import com.training.Bfit.util.DBConnection;

public class CancellationDao {
	public static boolean insertCancellation(int memberId,int planId, Date cancellationDate, String reason) {
		boolean isSuccess=false;
        try {
        	 Connection connection=DBConnection.getConnection();
        	 String sqlQuery="insert into cancellation (member_Id,plan_id,cancellation_date,reason) values(?,?,?,?)";
     		PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
     		preparedStatement.setInt(1, memberId);
     		preparedStatement.setInt(2, planId);
     		preparedStatement.setDate(3,new java.sql.Date(cancellationDate.getTime()));
     		preparedStatement.setString(4,reason);
     		if(preparedStatement.executeUpdate()>0) {
    			isSuccess=true;
    		}
    		else {
             System.out.println("Failed to establish database connection.");
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return isSuccess;
	}
		
}