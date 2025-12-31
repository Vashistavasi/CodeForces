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
	long count=0;
	while(t-->0) {
		count=0;
		int n=s.nextInt();
		
		count+=n;
		count+=n/2+n/2;
		count+=n/3+n/3;
		pw.println(count);
		
	}
	pw.flush();	
	

}
static long gcd(long a, long b)
{
	if (a == 0)
		return b;
	return gcd(b % a, a);
}


static long lcm(long a, long b)
{
	return (a / gcd(a, b)) * b;
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
