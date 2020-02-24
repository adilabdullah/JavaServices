package com.java.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;





import sun.misc.BASE64Decoder;

import com.java.connection.DbConnection;
import com.java.model.Accounts;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Controls {
List<Accounts> arr=new ArrayList<Accounts>();
int i=0;	
public int AddAccount(String acct_no,String acct_title,double min_limit,double max_limit,int tran_limit,double balance,String acct_type,String status,double max)
	{
	try{
		Accounts ac=new Accounts(acct_no,acct_title,acct_type,status,tran_limit,max_limit,min_limit,balance,max);
	arr.add(ac);
	//	arr.add(i,ac);
	/*	String sql="INSERT INTO banking.`accounts`(account_no,account_title,min_limit,max_limit,tran_limit,balance,account_type,statuss,max_tran_limit,opening_date)"+
" VALUES ('123545','bilal ahmed',12.32,65.32,100,2541.36,'saving','active',3541.36,CURRENT_TIMESTAMP);";  */
		String sql="INSERT INTO banking.`accounts`(account_no,account_title,min_limit,max_limit,tran_limit,balance,account_type,statuss,max_tran_limit,opening_date)"+
				" VALUES ('"+acct_no+"','"+acct_title+"',"+max_limit+","+min_limit+","+tran_limit+
				","+balance+",'"+acct_type+"','"+status+"',"+max+",CURRENT_TIMESTAMP);";
		  Connection conn=(Connection) DbConnection.Conn();
	//	  PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
		Statement stm=(Statement) conn.createStatement();
stm.execute(sql);
		  /*		  pst.setString(1,acct_no);
		  pst.setString(2,acct_title);
		  pst.setFloat(3,(float) min_limit);
		  pst.setFloat(4,(float) max_limit);
		  pst.setInt(5,tran_limit);
		  pst.setFloat(6,(float) balance);
		  pst.setString(7,acct_type);
		  pst.setString(8,status);
		  pst.setFloat(9,(float) max);
		  pst.setFloat(10,CURRENT_TIMESTAMP);  */
	//	  pst.execute();
	
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		return 1;
	}
		return 0;
		
		
	}


public List<Accounts> getAll()
{
	List<Accounts> lis=new ArrayList<Accounts>();
	try{
	String sql="select * from banking.`accounts`";
	  Connection conn=(Connection) DbConnection.Conn();
	  Statement stm= (Statement) conn.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		
		while(rs.next())
		{
			Accounts acc;
			acc=new Accounts(rs.getString(2),rs.getString(3),rs.getString(8),rs.getString(9),
					rs.getInt(6),rs.getFloat(5),rs.getFloat(4),rs.getFloat(7),rs.getFloat(10));
		/*	acc.setAcct_no(rs.getString(1));
			acc.setAcct_title(rs.getString(2));
			acc.setMin_limit(rs.getFloat(3));
			acc.setMax_limit(rs.getFloat(4));
			acc.setMax_tran_limit(rs.getFloat(9));
			acc.setBalance(rs.getFloat(6));
			acc.setTran_limit(rs.getInt(5));
			acc.setAcct_status(rs.getString(8));
			acc.setAcct_type(rs.getString(7));
			acc.setDop(rs.getString(10)); */
			lis.add(acc);
		//	return acc;
		}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		return null;
	}
	return lis;
}
	
public boolean isUserAuthenticated(String authString){
    
    String decodedAuth = "";
    // Header is in the format "Basic 5tyc0uiDat4"
    // We need to extract data before decoding it back to original string
    String[] authParts = authString.split("\\s+");
    String authInfo = authParts[1];
    // Decode the data back to original string
    byte[] bytes = null;
    try {
        bytes = new BASE64Decoder().decodeBuffer(authInfo);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    decodedAuth = new String(bytes);
    
    if(decodedAuth.equalsIgnoreCase("adil:abdullah"))
    {
    	return true;
    }
    else
    {
    	return false;
    }
    
}
}
