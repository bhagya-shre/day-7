package com.infinite.JsfJdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployDAO {
Connection connection;
PreparedStatement pst;

public int validate(String user,String pwd) throws ClassNotFoundException, SQLException{
	connection = ConnectionHelper.getConnection();
	String cmd = "select count(*) cnt from Login where userName=? and PassCode=?";
	pst=connection.prepareStatement(cmd);
	pst.setString(1, user);
	pst.setString(2, pwd);
	ResultSet rs = pst.executeQuery();
	rs.next();
	int count = rs.getInt("cnt");
	return count;
	
}
public String updateEmploy(Employ employNew) throws ClassNotFoundException, SQLException{
	Employ  employ = searchEmploy(employNew.getEmpno());
	if(employ!=null){
		String cmd = "update Employ set name=?,dept=?,desig=?,basic=?+"
				+ "Basic=? where empno=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, employ.getName());
		pst.setString(2, employ.getDept());
		pst.setString(3,employ.getDesig());
		pst.setInt(4, employ.getBasic());
		pst.setInt(5, employ.getEmpno());
		
		pst.executeUpdate();
		return "Employ record Inserted..";
		
	}
	return "record not found";

}

public String deleteEmploy(int empno)throws ClassNotFoundException,SQLException{
Employ employ=searchEmploy(empno);
if(employ!=null){
	connection = ConnectionHelper.getConnection();
	String cmd = "delete from  Employ where empno=?";
	pst = connection.prepareStatement(cmd);
	pst.setInt(1, empno);
	pst.executeUpdate();
	return "Record delete";
}
return "record not found";
}
	
	
	
public String addEmploy(Employ employ)
throws ClassNotFoundException,SQLException{
	connection = ConnectionHelper.getConnection();
	String cmd = "insert into Employ(name,dept,desig,basic)"+"values(?,?,?,?)";
	pst = connection.prepareStatement(cmd);
	pst.setString(1, employ.getName());
	pst.setString(2, employ.getDept());
	pst.setString(3,employ.getDesig());
	pst.setInt(4, employ.getBasic());
	pst.executeUpdate();
	return "Record Inserted...";
}

public Employ searchEmploy(int empno) throws ClassNotFoundException, SQLException {
	connection = ConnectionHelper.getConnection();
	String cmd = "Select * from Employ where empno=?";
	pst=connection.prepareStatement(cmd);
	pst.setInt(1, empno);
	ResultSet rs = pst.executeQuery();
	Employ employ = null;
	if(rs.next()){
		employ = new Employ();
		employ.setEmpno(rs.getInt("empno"));
		employ.setName(rs.getString("name"));
		employ.setDept(rs.getString("dept"));
		employ.setDesig(rs.getString("desig"));
		employ.setBasic(rs.getInt("basic"));
	}
	return employ;
	
}
public List<Employ> showEmploy() throws SQLException, ClassNotFoundException{
List<Employ> employList = new ArrayList<Employ>();
connection = ConnectionHelper.getConnection();
String cmd = "Select * from Employ";
pst = connection.prepareStatement(cmd);
ResultSet rs = pst.executeQuery();
 
Employ employ = null;
while(rs.next()){
	employ = new Employ();
	employ.setEmpno(rs.getInt("empno"));
	employ.setName(rs.getString("name"));
	employ.setDept(rs.getString("dept"));
	employ.setDesig(rs.getString("desig"));
	employ.setBasic(rs.getInt("basic"));
	employList.add(employ);
}
return employList;
}
}
