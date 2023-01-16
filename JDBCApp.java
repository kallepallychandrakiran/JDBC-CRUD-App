import java.util.*;
import java.sql.*;

public class JDBCApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		/*
		 * 1)load and register the driver 2)establish the connection with database
		 * 3)create the statement object and execute the query 4)process the result set
		 * 5)Handle the SQL exception if it gets generated 6)close the connection
		 * 
		 * 
		 * 
		 */

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;

		Scanner scan = new Scanner(System.in);
		System.out.println("1. Press 1 for Insert operation\n" + "2. Press 2 for select operation\n"
				+ "3. Press 3 for Update operation\n" + "4. Press 4 for Delete operation\n" + "5. Press 5 for exit");
		int selection = scan.nextInt();
		
		if(selection!=1||selection!=2||selection!=3||selection!=4||selection!=5)
			System.out.println("Can you please provide a accurate response");

		if (selection == 1) {
			System.out.println("You have choose to insert data");
			System.out.println("Please Enter ID of student");
			int id = scan.nextInt();
			System.out.println("Please enter firstname of student");
			String firstname = scan.next();
			System.out.println("Please enter lastname of student");
			String lastname = scan.next();
			System.out.println("Please Enter age of student");
			int age = scan.nextInt();

			String sqlQuery = String.format(
					"Insert into studentdata(`id`,`first_name`,`lastname`,`age`) values('%d','%s','%s','%d')", id,
					firstname, lastname, age);

			System.out.println(sqlQuery);

			// 1)load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class loaded sucessfully");

			// 2)establish the connection with database
			String url = "jdbc:mysql:///Students";
			String uname = "root";
			String pass = "root";
			connection = DriverManager.getConnection(url, uname, pass);
			System.out.println("Connection established sucessfully");

			// 3)create the statement object and send the query

			pstmt = connection.prepareStatement(sqlQuery);

			int rowcount = pstmt.executeUpdate();
			System.out.println("the no of rows affected =  " + rowcount);
			System.out.println("record inserted sucessfully");

			// Step6 : close the connection

			connection.close();
			pstmt.close();
			System.out.println("Closed the resources...");

		}

		if (selection == 2) {
			System.out.println("You have choose to Select data");
			System.out.println("Please Enter ID of student");
			int id = scan.nextInt();

			Statement statement = null;

			String sqlQuery = String.format("Select first_name, lastname from studentdata where id= " + id);

			System.out.println(sqlQuery);

			// 1)load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class loaded sucessfully");

			// 2)establish the connection with database
			String url = "jdbc:mysql:///Students";
			String uname = "root";
			String pass = "root";
			connection = DriverManager.getConnection(url, uname, pass);
			System.out.println("Connection established sucessfully");

			// 3)create the statement object and send the query

			statement = connection.createStatement();

			resultset = statement.executeQuery(sqlQuery);

			System.out.println("record fetched sucessfully");

			resultset.next();
			System.out.println(resultset.getString(1) + " " + resultset.getString(2));

			// Step6 : close the connection

			connection.close();
			statement.close();
			System.out.println("Closed the resources...");
		}

		// 3. Press 3 for Update operation

		if (selection == 3) {
			System.out.println("You have choose to update data");
			System.out.println("Please Enter ID of student which you want to update");
			int id = scan.nextInt();
			System.out.println("Please enter new firstname of student");
			String firstname = scan.next();
			System.out.println("Please enter new lastname of student");
			String lastname = scan.next();
			System.out.println("Please Enter new age of student");
			int age = scan.nextInt();

			String sqlQuery = "UPDATE studentdata SET first_name = " + "'" + firstname + "'" + ", lastname = " + "'"
					+ lastname + "'" + ", age = " + age + " WHERE id = " + id + ";";

			System.out.println(sqlQuery);

			// 1)load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class loaded sucessfully");

			// 2)establish the connection with database
			String url = "jdbc:mysql:///Students";
			String uname = "root";
			String pass = "root";
			connection = DriverManager.getConnection(url, uname, pass);
			System.out.println("Connection established sucessfully");

			// 3)create the statement object and send the query

			pstmt = connection.prepareStatement(sqlQuery);

			int rowcount = pstmt.executeUpdate();
			System.out.println("the no of rows affected =  " + rowcount);
			System.out.println("record updated sucessfully");

			// Step6 : close the connection

			connection.close();
			pstmt.close();
			System.out.println("Closed the resources...");

		}

		// 4. Press 4 for Delete operation
		if (selection == 4) {
			System.out.println("You have choose to delete data");
			System.out.println("Please Enter ID of student which you want to delete");
			int id = scan.nextInt();

			String sqlQuery = "DELETE FROM studentdata WHERE id = " + id + ";";

			System.out.println(sqlQuery);

			// 1)load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class loaded sucessfully");

			// 2)establish the connection with database
			String url = "jdbc:mysql:///Students";
			String uname = "root";
			String pass = "root";
			connection = DriverManager.getConnection(url, uname, pass);
			System.out.println("Connection established sucessfully");

			// 3)create the statement object and send the query

			pstmt = connection.prepareStatement(sqlQuery);

			int rowcount = pstmt.executeUpdate();
			System.out.println("the no of rows affected =  " + rowcount);
			System.out.println("record Deleted sucessfully");

			// Step6 : close the connection

			connection.close();
			pstmt.close();
			System.out.println("Closed the resources...");

		}

		if (selection == 5) {
			System.out.println("Secure exit from command line interface");
		}
		
		
	}

}
