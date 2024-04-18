package com.training.Bfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.training.Bfit.model.Transactions;
import com.training.Bfit.util.DBConnection;

public class TransactionDao {
    public static boolean sucessfullPayment(int planId,int memberId) {
    	boolean isSuccess=false;
    	try {
			//Connection connection=DBConnection.getConnection();
		   Connection connection=DBConnection.getConnection();
			String sqlQuery="insert into transactions (plan_id,member_id, payment_method) values(?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, planId);
			preparedStatement.setInt(2, memberId);	
			preparedStatement.setString(3, "card-payment");	
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
