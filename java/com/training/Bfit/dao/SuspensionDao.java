package com.training.Bfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.training.Bfit.util.DBConnection;

public class SuspensionDao {
     public static boolean createSuspension(int memberId,int planId,LocalDate startDate,long daysDifference) {
    	 boolean isSuccess=false;
    	 try {
 			//Connection connection=DBConnection.getConnection();
 		   Connection connection=DBConnection.getConnection();
 			String sqlQuery="insert into suspension (member_id,plan_id,no_of_days,suspension_approval_status,suspension_start_date) values(?,?,?,?,?)";
 			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
 			preparedStatement.setInt(1, memberId);
 			preparedStatement.setInt(2, planId);
 			preparedStatement.setLong(3,daysDifference);	
 			preparedStatement.setString(4, "Approved");
 			preparedStatement.setDate(5, java.sql.Date.valueOf(startDate));
 			if(preparedStatement.executeUpdate()>0) {
 				isSuccess=true;
 			}
 			else {
                 System.out.println("wrong member id");
 			}
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
    	 return isSuccess;
     }
}
