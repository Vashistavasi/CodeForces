import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
static PrintWriter pw;
static FastScanner s;
public static void main(String[] args) throws Exception {
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
    long t=s.nextLong();
    while(t-->0) {
    	long n=s.nextLong();
    	String str=s.next();
    	long tot=0;
    	ArrayList<Long> al=new ArrayList<Long>();
    	for( int i=0;i<n;i++) {
    		if(str.charAt(i)=='L') {
    			al.add((n-1-i)-i);
    			tot+=i;
    		}else
    		{
    			al.add(i-(n-1-i));
    			tot+=n-1-i;
    		}
    	}
    		Collections.sort(al,Collections.reverseOrder());
    		
    		for(int i=0;i<n; i++) {
    			if(al.get(i)>0)
    				tot+=al.get(i);
    			pw.print(tot+" ");
    		}
    		
    		pw.println();
    		
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
