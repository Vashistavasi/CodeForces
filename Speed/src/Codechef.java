/* package codechef; // don't place package name! */

import java.math.BigDecimal;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0){
//			BigDecimal a=new BigDecimal(s.next());
//			BigDecimal b=new BigDecimal(s.next());
//			BigDecimal x=new BigDecimal(s.next());
//			BigDecimal y=new BigDecimal(s.next());
//			a=a.divide(x);
//			b=b.divide(y);
//			if(a.equals(b))
//				System.out.println("Equal");
//			else if(a.compareTo(b)<0)
//				System.out.println("Bob");
//			else
//				System.out.println("Alice");
		    double a=s.nextDouble();
		    double b=s.nextDouble();
		    double x=s.nextDouble();
		    double y=s.nextDouble();
		    a=a/x;
		    b=b/y;
		    if(a==b)
		    System.out.println("Equal");
		    else if(a>b)
		    System.out.println("Alice");
		    else
		    System.out.println("Bob");
		}
	}
}
