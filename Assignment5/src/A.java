import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class A
{
public static void main(String[] args)
{

try
{
String DRIVER = "com.mysql.jdbc.Driver";

Connection myConn = DriverManager.getConnection("jdbc:mysql://137.158.160.145:3306/rhldee001","rhldee001","iejobafo");

Statement myStmt = myConn.createStatement();
ResultSet myRs = myStmt.executeQuery("select Course,Symbol from University");
System.out.println("Printing out Grades of every student:");
while(myRs.next())
{
System.out.println(myRs.getString("Course") + "  " + myRs.getString("Symbol"));
}

myRs.close();
myStmt.close();
myConn.close();

}


catch(Exception exc)
{ 
exc.printStackTrace();
}


}
}
