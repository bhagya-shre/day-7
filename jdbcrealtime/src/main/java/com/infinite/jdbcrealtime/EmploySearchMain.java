package com.infinite.jdbcrealtime;

import java.sql.SQLException;
import java.util.Scanner;

public class EmploySearchMain {
private static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int empno;
	System.out.println("Enter Employ Number ");
	empno = sc.nextInt();
	EmployDAO dao = new EmployDAO();
	try {
		Employ employ = dao.searchEmploy(empno);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
