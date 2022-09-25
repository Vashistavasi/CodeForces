import java.util.*;
import java.io.*;
 
public class Solution{
	static Scanner sc;
	static PrintWriter pw;
	public static void solve(int n) {
		
		long xor1=0;
		long xor2=0;
		for(int i=0;i<n-2;i++) {
			xor1^=i;
			xor2^=i+1;
		}
		if(xor1!=0) {
			for(int i=0;i<n-2;i++)
				pw.print(i+" ");
		
		long l=1<<31-1;
		xor1^=l;
		pw.print(l+" "+xor1);
		}
		else {
			for(int i=1;i<=n-2;i++)
				pw.print(i+" ");
		
		long l=1<<31-1;
		xor2^=l;
		pw.print(l+" "+xor2);	
		}
		pw.println();
		}
 
	public static void main(String[] args) throws Exception {
		pw = new PrintWriter(System.out);
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			solve(sc.nextInt());
		}
		pw.flush();
	}
 
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;
 
		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}
 
		public Scanner(String s) throws Exception {
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
}