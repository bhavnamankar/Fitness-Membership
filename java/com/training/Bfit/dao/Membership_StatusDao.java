package com.training.Bfit.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.training.Bfit.util.DBConnection;

public class Membership_StatusDao {
    public static boolean membershipStatus(int planId,int memberId,Date currentDate,Date endDate) {
    	boolean isSuccess=false;
    	try {
			//Connection connection=DBConnection.getConnection();
		   Connection connection=DBConnection.getConnection();
			String sqlQuery="insert into membership_status (plan_id,member_id, membership_status,start_Date,end_date) values(?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, planId);
			preparedStatement.setInt(2, memberId);	
			preparedStatement.setString(3, "Active");
			preparedStatement.setDate(4, new java.sql.Date(currentDate.getTime()));
			preparedStatement.setDate(5, new java.sql.Date(endDate.getTime()));
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
    public static String getStatus(int memberId,int planId) {
    	String status=null;
    	try {
    	Connection connection=DBConnection.getConnection();
    	String sqlQuery="select  membership_status from membership_status where member_id=? and plan_Id=?";
    	PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, memberId);
		preparedStatement.setInt(2, planId);
		ResultSet rs=preparedStatement.executeQuery();
		if(rs.next()){
			status=rs.getString("membership_status");
		}
    	}
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return status;
    }
    public static Date getLastDate(int mid,int pid) {
    	
    	Date lastday=new Date();
    	try {
        	Connection connection=DBConnection.getConnection();
        	String sqlQuery="select  end_date from membership_status where member_id=? and plan_id=?" ;
        	PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
    		preparedStatement.setInt(1, mid);
    		preparedStatement.setInt(2, pid);
    		ResultSet rs=preparedStatement.executeQuery();
    		if(rs.next()){
    			lastday=rs.getDate("end_date");
    		}
        	}
        	catch (SQLException e) {
    			e.printStackTrace();
    		}
    	
        	return lastday;
    }
 public static Date getStartDate(int mid,int pid) {
    	
    	Date lastday=new Date();
    	try {
        	Connection connection=DBConnection.getConnection();
        	String sqlQuery="select  start_date from membership_status where member_id=? and plan_id=?" ;
        	PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
    		preparedStatement.setInt(1, mid);
    		preparedStatement.setInt(2, pid);
    		ResultSet rs=preparedStatement.executeQuery();
    		if(rs.next()){
    			lastday=rs.getDate("start_date");
    		}
        	}
        	catch (SQLException e) {
    			e.printStackTrace();
    		}
    	
        	return lastday;
    }
 public static List<Integer> findAllPlanByMemberIDAndStatus(int memberId){
	   List<Integer> planIds = new ArrayList<>();
	   
	   try {
		   Connection conn=DBConnection.getConnection();
		    PreparedStatement ps=conn.prepareStatement("select plan_id from membership_status  where member_id=? and membership_status='Active'");
		    ps.setInt(1,memberId);
		    ResultSet resultSet=ps.executeQuery();
		    while(resultSet.next()){
		    	int planId=resultSet.getInt(1);
              planIds.add(planId);
      	  
      	}
        
     } catch (SQLException e) {
         e.printStackTrace();
     }
	  
 return planIds;
	   
 }


}
