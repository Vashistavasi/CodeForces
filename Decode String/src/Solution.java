import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
static PrintWriter pw;
static FastScanner s;
public static void main(String[] args) throws Exception {
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
	int t=s.nextInt();
	while(t-->0) {
		int n=s.nextInt();
		String code=s.next();
		StringBuilder sb=new StringBuilder();
		int i=0;
	   for(i=n-1;i>=0;i--) {
		   if(code.charAt(i)=='0') {
			   int num=Integer.parseInt(code.substring(i-2,i));
			   num=num+96;
			   char c=(char)num;
			   sb.append(c);
			   i=i-2;
		   }
		  
		   else {
			   int num=Integer.parseInt(code.substring(i, i+1));
				   num=num+96;
				   char c=(char)num;
				   sb.append(c);
				
			   
		   }
	   }
	
	   pw.println(sb.reverse());
	}
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
