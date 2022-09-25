
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
		int col=s.nextInt();
		String first=s.next();
		String second=s.next();
		boolean flag=true;
		for(int i=0;i<col;i++) {
			if(first.charAt(i)==second.charAt(i))
				continue;
			else if(first.charAt(i)=='G' && second.charAt(i)=='B')
				continue;
			else if(first.charAt(i)=='B' && second.charAt(i)=='G')
				continue;
			else {
				flag=false;
				break;
			}
		}
		if(flag)
			pw.print("YES");
		else
			pw.print("NO");
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
