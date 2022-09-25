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
	int n=s.nextInt();
	int k=s.nextInt();
	int a[]=new int[n];
	int i;
	for( i=0;i<k;i++) {
		a[i]=s.nextInt();
	}
	
	for( i=k;i<n;i++) {
		a[i]=s.nextInt();
		if(a[i]<a[k-1])
			break;
	}
	int ans=0;
	if(a[k-1]==0) {
		for(int j=0;j<k;j++) {
			if(a[j]>0)
				ans++;
		}
		pw.print(ans);
	}
	else
		pw.print(i);
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
