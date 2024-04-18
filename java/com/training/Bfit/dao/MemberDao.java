package com.training.Bfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.Bfit.model.Members;
import com.training.Bfit.model.Membership_Plans;
import com.training.Bfit.util.DBConnection;

public class MemberDao {
	//private DBConnection dbConnection;
   public static boolean registerMember(Members member) {
	   boolean isSuccess=false;
	   try {
			//Connection connection=DBConnection.getConnection();
		   Connection connection=DBConnection.getConnection();
			String sqlQuery="insert into member (UserName,Password,full_name,email,address,Age,phone_number,gender) values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, member.getUserName());
			preparedStatement.setString(2, member.getPassword());	
			preparedStatement.setString(3, member.getFullName());	
			preparedStatement.setString(4, member.getEmail());	
			preparedStatement.setString(5, member.getAddress());	
			preparedStatement.setInt(6,member.getAge());	
		
			preparedStatement.setString(7, member.getPhone_Number());
			preparedStatement.setString(8, member.getGender());
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
  /* public static Members isMember(String username,String password) {
	   Members member=new Members();
	   try {
		   Connection connection=DBConnection.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select  member_id,full_name,address,age,gender,email,phone_number from member where username=? and password=?");
			preparedStatement.setString(1,username);
			preparedStatement.setString(2, password);
			
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()){
	            member.setMember_Id(rs.getInt("member_id"));
	            member.setAddress(rs.getString("address"));
	            member.setAge(rs.getInt("age"));
	            member.setEmail(rs.getString("email"));
	            member.setFullName(rs.getString("full_name"));
	            member.setGender(rs.getString("gender"));
	            member.setPhone_Number(rs.getString("phone_number"));
	           
	         }
	         
			else
				System.out.println("Invalid username or password");
	   }
	   catch (SQLException e) {
			e.printStackTrace();
		}
	   return member;
   }*/
  
   public static Members isMember(String username, String password) {
       Members member = new Members();
       try {
           Connection connection = DBConnection.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("SELECT member_id,full_name, address,age,gender,email,phone_number FROM member  WHERE username=? AND password=?");
           preparedStatement.setString(1, username);
           preparedStatement.setString(2, password);

           ResultSet rs = preparedStatement.executeQuery();
           if (rs.next()) {
               // Set member details
               member.setMember_Id(rs.getInt("member_id"));
               member.setAddress(rs.getString("address"));
               member.setAge(rs.getInt("age"));
               member.setEmail(rs.getString("email"));
               member.setFullName(rs.getString("full_name"));
               member.setGender(rs.getString("gender"));
               member.setPhone_Number(rs.getString("phone_number"));
               List<Membership_Plans> list = new ArrayList<>();
               list = Membership_plansDao.findAllPlanByMemberID(rs.getInt("member_id"));
               member.setPlans(list);
           } else {
               System.out.println("Invalid username or password");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return member;
   }
}
