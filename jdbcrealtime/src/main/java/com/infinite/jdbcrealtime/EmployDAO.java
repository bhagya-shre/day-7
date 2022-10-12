package com.infinite.jdbcrealtime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployDAO {
Connection connection;
PreparedStatement pst;
public String updateEmploy(Employ employNew) throws ClassNotFoundException, SQLException{
	Employ  employ = searchEmploy(employNew.getEmpno());
	connection =  ConnectionHelper.getConnection();
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
