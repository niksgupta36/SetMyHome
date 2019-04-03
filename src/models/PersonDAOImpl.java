package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PersonDAOImpl implements PersonDAO {
	
	static Connection conn;
	static PreparedStatement ps;
	
	@Override
	public List<Person> getPerson(Person p) {
		// TODO Auto-generated method stub
		ArrayList<Person> persons = new ArrayList<>();
		conn = ConnectionProvider.getCon();
		try {
			ps=conn.prepareStatement("select * from Person");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Person l = new Person();
				l.setFname(rs.getString(1));
				l.setEmailid(rs.getString(2));
				persons.add(l);
		}
		
			
		} catch (SQLException e) {
			System.out.println(e);
		}
				
		return persons;
	}

	@Override
	public void setPerson(Person p) {
		// TODO Auto-generated method stub
		conn = ConnectionProvider.getCon();
		
		try {
			ps = conn.prepareStatement("insert into Person values(?,?,?,?)");
			ps.setString(1, p.getFname());
			ps.setString(2, p.getEmailid());
			ps.setString(3, p.getPassword());
			ps.setString(4, p.getType());
			ps.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletePerson(Person p) {
		// TODO Auto-generated method stub
		conn = ConnectionProvider.getCon();
		try {
			ps = conn.prepareStatement("delete from Person where emailId=?");
			ps.setString(1, p.getEmailid());
			ps.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	@Override
	public boolean loginPerson(Person p) {
		// TODO Auto-generated method stub
		conn = ConnectionProvider.getCon();
		boolean status=false;
		try {
			ps = conn.prepareStatement("select * from Person where emailId=? and Password=?");
			ps.setString(1, p.getEmailid());
			ps.setString(2, p.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				status=true;
			}else{
				status=false;
			}               
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return status;
		
	}

}
