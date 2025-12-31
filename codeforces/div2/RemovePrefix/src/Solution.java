import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
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
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=s.nextInt();
		}
		HashSet<Integer> hs = new HashSet<Integer>();
		int count=0;
		for(int i=n-1;i>-1;i--) {
			if(!hs.contains(a[i])) {
				count++;
				hs.add(a[i]);
			}
			else
				break;
		}
		pw.println(n-count);
		
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
