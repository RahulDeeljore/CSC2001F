import java.util.Scanner;

public class VerifyVoter
{
public static void main(String[] args)
{
verify();
}

/** This is the driver class
* This contains the user interface
* The user will be prompted to write the 13 digit ID 
* The ID number will then be searched in the list
* The user must press 0 to exit
*/
public static void verify()
{
HashTable thehash = new HashTable();
thehash.makedata();
thehash.insertP();
Scanner keyboard = new Scanner(System.in);
System.out.println("Welcome to the voter verifier.");
System.out.println("Please enter the 13 digit ID of the person you wish to check.");
System.out.println("Press 0 to exit.");
long ID = keyboard.nextLong(); 
while(ID != 0)
{
if (ID == 0)
{
System.exit(0);
}
else if (Long.toString(ID).length() != 13)
{
System.out.println("You have entered an incorrect amount. Please try again.");
ID = keyboard.nextLong();
}
else
{
thehash.find(ID);
System.out.println("Please enter the 13 digit ID of the person you wish to check.");
ID = keyboard.nextLong();
}
}
}
}
