/**
*The Dam Class shows the 3 instance variables of a Dam object.
*/

public class Dam implements Comparable<Dam>

{
private String name;
private String FSC;
private String percentFull;
public int insertcount;

//Constructor
public Dam(String name,String FSC,String percentFull,int insertcount)
{


this.name = name;
this.FSC = FSC;
this.percentFull = percentFull;
this.insertcount = insertcount;
}

public Dam(String name,String FSC,String percentFull)
{

this.name = name;
this.FSC = FSC;
this.percentFull = percentFull;
}

public Dam()
{
name ="";
FSC = "";
percentFull ="";
insertcount =0;
}

public int getinsert()
{
return insertcount;
}

/**
*@return Dam name
*/
//toString method
public String toString()
{
return ("Name: "+ this.name+", " +"FSC: " +this.FSC +", Percentage: " + this.percentFull+"\n"+"insert counts:" +this.insertcount);
}
public String getName()
{
return name;
}

/**
*@return the name which is higher in alphabetical order
*/
//compareTo method
public int compareTo(Dam d)
{
return (this.getName().compareTo(d.getName()));
}

}
