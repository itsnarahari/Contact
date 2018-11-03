package com.agilecrm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agilecrm.dao.Dao;
import com.agilecrm.dto.Contact;
import com.agilecrm.util.JdbcConnection;

public class DaoImpl implements Dao {

	static Connection con;
	static int status;		
	Contact contact = new Contact();


	public int saveContact(Contact contact) throws SQLException {
		con = JdbcConnection.getConnection();
		try {
			String sql = "insert into contact(fname,lname,email,mobile) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, contact.getLname());
			ps.setString(2, contact.getFname());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getMobile());
			status = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return status;

	}

	public Contact updateContact(Contact contact) {

		String sql = "update contact set fname='" + contact.getFname() + "', lname='" + contact.getLname()
				+ "', email='" + contact.getEmail() + "'," + "'" + contact.getMobile() + "' where id=" + contact.getId()
				+ "";
		System.out.println(sql);

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contact;
	}

	public List<Contact> listContacts() throws SQLException {
		

		String sql="select *from contact";
		List<Contact> list=new ArrayList<>();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			contact.setId(rs.getInt("id"));
			contact.setFname(rs.getString("fname"));
			contact.setLname(rs.getString("lname"));
			contact.setMobile(rs.getString("mobile"));
			list.add(contact);
		}
		return (List<Contact>) contact;
	}
	public Contact getContactById(int id) throws SQLException {
		
		String sql="select *from contact where id="+id+"";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			contact.setId(rs.getInt("id"));
			contact.setFname(rs.getString("fname"));
			contact.setLname(rs.getString("lname"));
			contact.setMobile(rs.getString("mobile"));
		}
		return contact;
	}

	public void deleteContact(int id) {
		
		String sql="delete from contact where id="+id+"";
		
		try {
			
			Statement stmt=con.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();

		}


	}

}
