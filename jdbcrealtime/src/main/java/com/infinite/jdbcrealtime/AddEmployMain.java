package com.infinite.jdbcrealtime;

import java.sql.SQLException;
import java.util.Scanner;

public class AddEmployMain {

	public static void main(String[] args) {
		Employ employ = new Employ();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ Name");
		employ.setName(sc.next());
		System.out.println("Enter Department");
		employ.setDept(sc.next());
		System.out.println("Enter Designation");
		employ.setDesig(sc.next());
		System.out.println("Enter Basic");
		employ.setBasic(sc.nextInt());
		EmployDAO dao = new EmployDAO();
		try {
			System.out.println(dao.addEmploy(employ));
		} catch(ClassNotFoundException | SQLException e){
			
			e.printStackTrace();
			
		} 
		}
	}


