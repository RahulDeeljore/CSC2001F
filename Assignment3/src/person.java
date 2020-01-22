/** This is a person class
* Each person has a name and a 13 digit ID number
*/

public class person
{
private String name;
private long ID;

/** Constructor
*/
public person(String name,long ID)
{
this.name = name;
this.ID = ID;
}
/** No argument constructor
*/
public person()
{
name = "";
ID = 0;
}

/** Accessor method that returns the ID
*/
public long getID()
{
return ID;
}

/** Accessor method that returns the name
*/
public String getName()
{
return name;
}

/** toString method for a person object
*/
public String toString()
{
return ("Name:" + name + ", ID:" + ID);
}

/** equals method that uses only the ID number as comparison
*/
public boolean equals(person b)
{
if(this.getID() == b.getID())
{
return true;
}
else
return false;
}

/** Main method with some test values for the methods
*/
public static void main(String[] args)
{
person a = new person("Rahul",12);
person b = new person("GAA",12);
System.out.println(a.getID());
System.out.println(a.equals(b));
}
}
