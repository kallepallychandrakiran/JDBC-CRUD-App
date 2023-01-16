# JDBC-CRUD-App
CRUD operations with a JDBC MYSQL


JDBC Project Requirement
=====================
	1. Develop a console based application in the following manner
		a. Create a menu for the user to perform CRUD operation as shown below
				1. Press 1 for Insert operation
				2. Press 2 for select operation
				3. Press 3 for Update operation
				4. Press 4 for Delete operation
				5. Press 5 for exit
				 	Note: anything above 5 tell invalid operation

		b. If user presses 1
			a. Take inputs from the user to accept the data like
					1. sid(pk)  2. sname 3. sage 4. saddress
			b. perform insertion operation		
			c. display suitable message as 
					a. record inserted succesfully
					b. record insertion failed

		c. If user presses 2
			a. Take inputs from the user to accept the data like
					1. sid(pk) 
			b. perform select operation		
			c. display suitable message as 
					a. display the details in table format.
					b. record not available for the given id.

		d. b. If user presses 3
			a. Take inputs from the user to accept the data like
					1. sid(pk)  
			b. for the entered id display the details first
						sid        : XXXXX (no change becoz it is pk)
						sname : XXXXX   enter new sname :: XXXXX
						sage     : XXXXX   enter new sage     :: YYYYY
						saddr   : XXXXX	 enter new saddr   :: YYYYY
			c. display suitable message as 
					a. record updated succesfully
					b. record updation failed

		e. If user presses 4
			a. Take inputs from the user to accept the data like
					1. sid(pk) 
			b. perform delete operation		
			c. display suitable message as 
					a. record deleted succesfully.
					b. record not available for the given id.
