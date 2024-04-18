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

public class Membership_plansDao {
       public static int getPlanId(String planName,int duration) {
    	   int planId=0;
           try {
        	   
               Connection connection = DBConnection.getConnection();
               PreparedStatement preparedStatement = connection.prepareStatement("select plan_id from membership_plan where plan_name=? and duration_month=?");
               preparedStatement.setString(1, planName);
               preparedStatement.setInt(2, duration);
               ResultSet resultSet = preparedStatement.executeQuery();
               if (resultSet.next()) {
            	   planId=resultSet.getInt("plan_id"); 
               }else {
                   System.out.println("Invalid plan details");
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       return planId;    
       }
       
       public static List<Membership_Plans> findAllPlanByMemberID(int memberId){
    	   List<Membership_Plans> plans = new ArrayList<>();
    	   
    	   try {
    		   Connection conn=DBConnection.getConnection();
    		    PreparedStatement ps=conn.prepareStatement("select p.plan_id,p.plan_name,p.duration_month,p.price from membership_plan p inner join membership_status ms on ms.plan_id=p.plan_id where ms.member_id=?");
    		    ps.setInt(1,memberId);
    		    ResultSet resultSet=ps.executeQuery();
    		    while(resultSet.next()){
    		    	Membership_Plans plan=new Membership_Plans(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),resultSet.getInt(4));
                    plans.add(plan);
            	  
            	}
              
           } catch (SQLException e) {
               e.printStackTrace();
           }
    	   System.out.println(plans);
       return plans;
    	   
       }
       }
