/**
*DamArrayApp class creates a dam array and prints the dam objects.
*Contains a method that will return the number of comparisons when using the printDam() method.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;


public class DamArrayApp
{
//Integer[] opcounts = new Integer[];
public static String filename = "thedam.csv";
public static int num =0; //used to count comparisons 

/**
* The main method will invoke the printAllDams() Dams if no argument is given
* If an argument is given, the printDam() method will be invokes
* The method will also print out the number of comparisons
*/
public static void main(String args[])
{
//for (int ass =0;ass<211;ass++)
//{
//System.out.println("printdams(\""+makearray()[ass].getName()+"\");");
//}
if (args.length >0)
{
printDam(args[0]);
System.out.println(getnum());
}
else
printAllDams();
}

/**
* This method reads the csv file and splits it 
* The columns that contain the required data are retained 
* The data in the columns are used to make a Dam object
* Every Dam object created is stored in a Dam array
*/
public static Dam[] makearray()
{
File file = new File(filename);
try
{
Scanner read = new Scanner(file);
read.nextLine();//Skips first line that contains labels
int count =-1;
Dam[] allDams = new Dam[211];

while (read.hasNext())
{
count = count + 1;
String data = read.nextLine();
String[] arr = data.split(",");

if (arr.length > 42)
{
String[] arra = new String[3];
arra[0] = arr[2].toString().trim();
arra[1] = arr[10].toString();
arra[2] = arr[42].toString();
allDams[count] = new Dam(arra[0],arra[1],arra[2]);

String arraOutput = Arrays.toString(arra);
}

else if(arr.length > 10)
{
String arrOutput = Arrays.toString(arr);
allDams[count] = new Dam(arr[2].toString().trim(),arr[10].toString()," ");
}
}
read.close();
return (allDams);
}
catch (FileNotFoundException e)
{
e.printStackTrace();
}
return (null);
}

public static String[] DamNames()
{
String[] Names = new String[makearray().length];
for (int i =0;i < makearray().length;i++)
{
Names[i] = makearray()[i].getName();
}
return Names;
}
// printAllDams method to print all Dam objects
public static void printAllDams()
{
Dam[] a = makearray();
for (Dam i: a)
{
System.out.println(i);
}
}
/**
* This method prints a Dam object from the Dam array whose name matches the argument "damName".
* If no Dam name matches the argument, the user is told so.
*/
public static void printDam(String damName)
{
int counter = 0;// used to see if argument "damName" matches any Dam name in array
Dam[] b = makearray();
for (Dam j: b)
{
if (j.getName().equals(damName))
{
System.out.println(j);
counter += 1;// if argument "damName" matches a Dam name in array, counter is increased
break;
}
else
num += 1; //if the Dam has not been found yet, increase the comparison count by 1.
}

if (counter == 0)// if no Dam name matches argument "damName" counter remains 0
{
System.out.println("Dam not found");
}
}


/**
*@return the number of comparisons made before finding Dam object
*/
public static int getnum()
{return(num);}
}


