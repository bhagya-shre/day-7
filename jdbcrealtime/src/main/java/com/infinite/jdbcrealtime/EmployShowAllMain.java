package com.infinite.jdbcrealtime;

import java.sql.SQLException;
import java.util.List;

public class EmployShowAllMain {
	public static void main(String[] args) {
		EmployDAO dao = new EmployDAO();
		try {
			List<Employ>employList=dao.showEmploy();
			for (Employ employ : employList) {
				System.out.println(employ);
			}
		} catch (ClassNotFoundException  | SQLException e) {
			
			e.printStackTrace();
		} 
	}

}

