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
    	int points=s.nextInt();
    	int pX=0,nX=0,pY=0,nY=0;
    	for(int i=0;i<points;i++) {
    		int x=s.nextInt();
    		int y=s.nextInt();
    		if(x==0) {
    			if(y>0) {
    				pY=Math.max(pY,y);
    			}
    			else
    				nY=Math.max(Math.abs(y), nY);
    		}
    		else {
    	if(x>0)
    				pX=Math.max(pX, x);
    		else
    			nX=Math.max(Math.abs(x), nX);
    	}
    	
    }
	pw.println(2*(nX+nY+pX+pY));
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
