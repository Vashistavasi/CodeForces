import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
static PrintWriter pw;
static FastScanner s;
public static void main(String[] args) throws Exception {
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
	
   long t=s.nextLong();
   while(t-->0) {
	   int n=s.nextInt();
	   int k=s.nextInt();
	   if(k%4==0)
		   pw.println("NO");
	   else if(k%4==1 || k%4==3) {
		   
		   pw.println("YES");
		   for(int i=1;i<=n;i++) {
			   
			   pw.println(i+" "+ (i+1));
			   i++;
		   }
	   }
	   else {
		   pw.println("YES");
	   
		   for(int i=1;i<=n;i++) {
			   if((i+1)%4!=0) {
				   pw.println(i+1+" "+(i));
			   i++;
		   }
		   else
		   {
			   pw.println(i+" "+ (i+1));  
			   i++;
		   }
	   }
	   
   }
	pw.flush();

}

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
