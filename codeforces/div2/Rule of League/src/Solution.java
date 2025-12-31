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
	   int x=s.nextInt();
	   int y=s.nextInt();
	   if((x==0&&y==0)||(x!=0&&y!=0)) {
		   pw.println(-1);
		   continue;
	   }
	   if(x<y)
	   {
		   int temp=x;
		   x=y;
		   y=temp;
	   }
	   if((n-1)%x==0) {
		   int q=1;
		   y=0;
		   for(int i=0;i<n-1;i++) {
			   if(x==y) {
				   y=0;
				   q=i+2;
			   }
			   y++;
			   pw.print(q+" ");
		   }
		   pw.println();
	   }
	   else {
		   pw.println(-1);
	   }
	  
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
