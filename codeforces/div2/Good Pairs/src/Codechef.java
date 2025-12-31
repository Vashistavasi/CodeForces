/* package codechef; // don't place package name! */

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	
	public static Long combinations(long n) {
		return (n*(n-1))/2;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s=new Scanner(System.in);
		//int t=s.nextInt();
		int t=1;
		while(t-->0) {
			//long n=s.nextLong();
			HashMap<Long,Long> hm=new HashMap<Long,Long>();
			
			
			for(int i=0;i<100000;i++) {
				long num=100000;
			//	long num=s.nextLong();
				if(!hm.containsKey(num)) {
					hm.put(num,1l);
				}
				else {
					hm.put(num, hm.get(num)+1);
				}
			}
			Set<Long>keySet=hm.keySet();
            long ans=0;
			Iterator<Long> it=keySet.iterator();
			while(it.hasNext())
			{
				Long key=it.next();
				if(hm.get(key)>1)
					ans+=combinations(hm.get(key));
			}
			System.out.println(ans);
			double a=Math.pow(10, 18);
			double b=Math.pow(2, 63);
			if(a>b)
				System.out.println("Treue");
			else
				System.out.println("false");
		}
	}
}
