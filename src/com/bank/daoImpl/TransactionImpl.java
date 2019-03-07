package com.bank.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.bank.dao.Transaction;
import com.bank.utility.Database;


public class TransactionImpl implements Transaction{

	Scanner s=new Scanner(System.in);
	

	public void withdrawal(long accNo,int balance,int amount) {

		try {
			Database d=new Database();

			Connection connection=d.database();
			PreparedStatement preparedStatement=connection.prepareStatement("update users set balance=? where Acc_No=?");
			
			balance=balance-amount;
			
			preparedStatement.setInt(1, balance);
			preparedStatement.setLong(2, accNo);
			
			int i=preparedStatement.executeUpdate();
			
			if(i==1)
				System.out.println("Transaction Successfull");
			else
				System.out.println("ERROR");
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deposit(long accNo,int balance,int amount) {

		try {	
			Database d=new Database();

			Connection connection=d.database();

			PreparedStatement preparedStatement=connection.prepareStatement("update users set balance=? where Acc_No=?");

			balance=balance+amount;
			
			preparedStatement.setInt(1, balance);
			preparedStatement.setLong(2, accNo);
			
			int i=preparedStatement.executeUpdate();
			
			if(i==1)
				System.out.println("Transaction Successfull");
			else
				System.out.println("ERROR");
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}



}
