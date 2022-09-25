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
		if(n%2==0) {
			for(int i=1;i<=n-2;i++) {
				pw.print(i+1+" ");
				pw.print(i+" ");
				i++;
			}
			pw.print(n-1+" ");
			pw.print(n+" ");
		}
		else {
			pw.print(1+" ");
			for(int i=2;i<=n-2;i++) {
				pw.print(i+1+" ");
				pw.print(i+" ");
				i++;
			}
			pw.print(n-1+" ");
			pw.print(n+" ");
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
