public class RandomNumber {

/** Create 150 Numbers
*/
public static void main(String[] args){

int num = 150;
for (int i = 0;i<num;i++)
{
generateMyNumber();
}


/** This method is used to create a 13 integer number using the Math.random method
*/ 
}
public static void generateMyNumber()
{
long aNumber = 0; 
aNumber = (long)((Math.random() * 900000000000l)+1000000000000l); 

System.out.println((aNumber));


}
 
}