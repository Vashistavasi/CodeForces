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
		int m=s.nextInt();
		int a[][]=new int[n][m];
		int total=0;
		for(int i=0;i<n;i++) {
			String string=s.next();
			for(int j=0;j<m;++j) {
				a[i][j]=Integer.parseInt(string.substring(j, j+1));
				total+=a[i][j];
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m-1;j++) {
				int cnt=a[i][j]+a[i+1][j]+a[i][j+1]+a[i+1][j+1];
				if(cnt==0)
					continue;
				min=Math.min(min, Math.max(1, cnt-1));
			}
		}
		if(total==0)pw.println(0);
		else
			pw.println(1+total-min);
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
