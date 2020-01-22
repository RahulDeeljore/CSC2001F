/**
*The Dam Class shows the 3 instance variables of a Dam object.
*/

public class Dam implements Comparable<Dam>

{
private String name;
private String FSC;
private String percentFull;


//Constructor
public Dam(String name,String FSC,String percentFull)
{
this.name = name;
this.FSC = FSC;
this.percentFull = percentFull;
}
/**
*@return Dam name
*/
//toString method
public String toString()
{
return ("Name: "+ this.name+", " +"FSC: " +this.FSC +", Percentage: " + this.percentFull);
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
