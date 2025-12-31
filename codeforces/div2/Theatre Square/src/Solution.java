import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {
	static PrintWriter pw;
	static FastScanner s;
	public static void calc(int m,int n,int a) {
		int h=m/a ;
		if(m%a>0)
			h++;
		n=n-a;
		
		if(n>0)
		{
			int w=n/a;
			if(n%a>0)
				w++;
			w++;
			pw.print(h*w);
		}
		else {
		pw.print(h);	
		}
	}
	public static void calc() throws Exception {
		BigInteger m=new BigInteger(s.next());
		BigInteger n=new BigInteger(s.next());
		BigInteger a=new BigInteger(s.next());
		//calc(m.intValue(),n.intValue(),a.intValue());
		//pw.print(" ");
		if(m.mod(a).longValue()>0) {
			m=m.divide(a);
			m=m.add(BigInteger.ONE);
		}
		else
			m=m.divide(a);
		n=n.subtract(a);
		if(n.longValue()>0) {
			if(n.mod(a).longValue()>0) {
				n=n.divide(a);
				n=n.add(BigInteger.ONE);
				n=n.add(BigInteger.ONE);
				
			}
			else {
				n=n.divide(a);
				n=n.add(BigInteger.ONE);
			}
			pw.print(m.multiply(n));
		}
		else
		pw.print(m);
		
		
	}
	public static void calc1(int m,int n,int a) {
		if(m*n<=a*a && m<=a &&n<=a) {
			pw.print(1);
			return;
		}
			
		int M=m+m%a;
		int N=n+n%a;
	    BigInteger area=BigInteger.valueOf(M).multiply(BigInteger.valueOf(N));
	    area=area.divide(BigInteger.valueOf(a));
	    area=area.divide(BigInteger.valueOf(a));
	    pw.print(area);
	}
	public static int rand(int n) {
		Random r=new Random();
		return r.nextInt(n)+1;
	}
public static void main(String[] args) throws Exception {
	 pw=new PrintWriter(System.out);
	 s=new FastScanner(System.in);
//	int m=s.nextInt();
//	int n=s.nextInt();
//	int a=s.nextInt();
//	int k=10;
//	int range=10;
	calc();
	pw.println();
//	while(k-->0) {
//		int m=rand(range);
//		int n=rand(range);
//		int a=rand(range);
//		pw.println(m+" "+n+" "+a);
//		calc();
//		pw.print(" ");
//		calc(m,n,a);
//		pw.println();
//	}
	

	pw.flush();
}
}
	

class FastScanner{
   	BufferedReader br;
   	StringTokenizer st;
	public FastScanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
	}

	public FastScanner(String s) throws Exception {
		br = new BufferedReader(new FileReader(new File(s)));
	}

	public String next() throws Exception {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	public long nextLong() throws Exception {
		return Long.parseLong(next());
	}
}