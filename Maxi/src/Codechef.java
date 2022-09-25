/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s=new Scanner(System.in);
		long t=s.nextLong();
		while(t-->0){
		    long n=s.nextLong();
		    long max=Long.MIN_VALUE;
		    long min=Long.MAX_VALUE;
		    long negMax=Long.MIN_VALUE;
		    long negMin=Long.MAX_VALUE;
		    for(int i=0;i<n;i++){
		        long num=s.nextLong();
		        min=Math.min(min,num);
		        if(num>=0)
		        max=Math.max(max,num);
		        else {
		        	negMax=Math.max(negMax,Math.abs(num));
		        	negMin=Math.min(negMin,Math.abs(num));
		        }
		        
		    }
		    long ansMax=0;
		    long ansMin=0;
		        if(max>negMax)
		        ansMax=max*max;
		        else
		        ansMax=negMax*negMax;
		        
		    if(min>=0)
		    {
		        ansMin=min*min;
		    }
		    else if(max>=0)
		    {
		        ansMin=min*max;
		    }
		    else {
		    	ansMin=negMin*negMin;
		    }
		    
		    System.out.println(ansMin+" "+ ansMax);
		}
	}
}
