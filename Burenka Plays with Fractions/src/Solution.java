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
    	long a=s.nextLong();
    	long b=s.nextLong();
    	long c=s.nextLong();
    	long d=s.nextLong();
    	long prod1=a*d;
    	long prod2=b*c;
    
    	if(prod1==prod2)
    		pw.println(0);
    	else if(prod1==0||prod2==0)
    	{
    		if(prod1==prod2)
    			pw.println(0);
    		else 
    			pw.println(1);
    	}
    	else if(prod1%prod2==0 || prod2%prod1==0)
    		pw.println(1);
    	else
    		pw.println(2);
    	
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
