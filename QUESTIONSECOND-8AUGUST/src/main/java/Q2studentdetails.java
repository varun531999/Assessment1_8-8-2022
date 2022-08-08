import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2studentdetails {

	public static void main(String[] args) throws Exception{
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gl", "root", "root");
		 
		 Scanner sc = new Scanner(System.in);
		 
		 while(true) {
		
			 System.out.println("Press 1 to insert row...");
			 System.out.println("Press any other key to exit..");
			 int ch = sc.nextInt();
			 
			 switch(ch) {
		
				case 1:
					
				 int rollno = 0;
				 String roll;
				 boolean checkRoll;
				 
					 do {
						 System.out.print("Enter the Roll No. : ");
						 rollno = sc.nextInt();
					 
						 roll = String.valueOf(rollno);
					     checkRoll = false;
					     
						  if(roll.length()==4) {
							  rollno = Integer.parseInt(roll);
							  checkRoll = true;
						  }
						  else {
							  System.out.println("Not a 4 digit RollNo.");
							  checkRoll = false;
						  	}
					 }while(!checkRoll);
		  
				 String sName="";
				 boolean nameFlag;
				 sc.nextLine();		//buffer because string is taken user input after integer.
				 
				  	do {
						  
						  System.out.print("Enter the Name : ");
						  sName = sc.nextLine();
						  
						  nameFlag = false;
						  String name = sName.toUpperCase();
						  if(sName.equals(name) && sName.length()<=20) {
							  nameFlag = true;
						  }
						  else {
							  System.out.println("Please enter the name in upper case or length of name should be less than 20!!");
							  System.out.println();
							  nameFlag = false;
						  }
				  	}while(!nameFlag);

					  String std = "";
					  List<String> list = new ArrayList<String>();
					  
					  list.add("I");
					  list.add("II");
					  list.add("III");
					  list.add("IV");
					  list.add("V");
					  list.add("VI");
					  list.add("VII");
					  list.add("VIII");
					  list.add("IX");
					  list.add("X");
		  
					  boolean standard;
					  
					  do {
							System.out.print("Enter Standard of the Student : ");
							std = sc.nextLine();
							
							standard = false;
							if(list.contains(std)) {
								standard = true;
							}
							else {
								System.out.println("Standard Not exists in the List...Try Again!!");
								System.out.println();
								standard = false;
							}
						} while (!standard);
		   
					  System.out.print("Enter Date of Birth : ");
					  String dob = sc.nextLine();
		  
					  System.out.print("Enter fees of the student : ");
					  double fees = sc.nextDouble();
						
					String query = "insert into student values(?, ?, ?, ?, ?)";
					PreparedStatement ps=con.prepareStatement(query);
			
						ps.setInt(1, rollno);
						ps.setString(2, sName);
						ps.setString(3, std);
						ps.setString(4, dob);
						ps.setDouble(5, fees);
						
					ps.executeUpdate();
					System.out.println("Student registered successfully...");
					System.out.println();
					break;
			
				default:
				 System.out.println("Exited Successfully");
				 System.exit(0);
			 }	
		 }
	}
	
}