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

			int t=s.nextInt();
			while(t-->0){
			  int n=s.nextInt();
			  ArrayList<Long> a=new ArrayList<>();
			  for(int i=0;i<n;i++){
			  	a.add(s.nextLong());
			  }
			  Collections.sort(a);
			  pw.println(a.get(n-1)+a.get(n-2)-a.get(0)-a.get(1));
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
