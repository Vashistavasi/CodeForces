import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
public static void main(String[] args) throws Exception {
	
	FastScanner s=new FastScanner(System.in);
	PrintWriter pw=new PrintWriter(System.out);
	int n=s.nextInt();
	while(n-->0) {
		String str=s.next();
		if(str.length()>10) {
			pw.println(str.charAt(0)+""+(str.length()-2)+
					""+str.charAt(str.length()-1));
		}
		else {
			pw.println(str);
		}
	}
	pw.flush();
	
}


}
class FastScanner{
	BufferedReader br;
	StringTokenizer st;
	
	public FastScanner(InputStream s) {
		br=new BufferedReader(new InputStreamReader(s));
		
	}
	public FastScanner(String s) throws FileNotFoundException {
		br=new BufferedReader(new FileReader(new File(s)));
	}
	public String next() throws Exception{
		while(st==null||!st.hasMoreElements())
			st=new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	public int nextInt() throws Exception{
		return Integer.parseInt(next());
	}
	public long nextLong() throws Exception{
		return Long.parseLong(next());
	}
	
}
