import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		FastScanner s=new FastScanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int n=s.nextInt();
		int ans=0;
		while(n-->0) {
			int count=3;
			int freq=0;
			while(count-->0) {
				if(s.nextInt()==1)
					freq++;
			}
			if(freq>=2)
				ans++;
		}
		pw.print(ans);
		pw.flush();
		
	}
	
	
	
	
}
class FastScanner{
	BufferedReader br;
	StringTokenizer st;
	
	FastScanner(InputStream s){
		br=new BufferedReader(new InputStreamReader(s));
	}
	FastScanner(String s) throws FileNotFoundException{
		br=new BufferedReader(new FileReader(new File(s)));
		
	}
	public String next() throws IOException {
		while(st==null|| !st.hasMoreElements())
			st=new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	
	public int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	public long nextLong() throws Exception {
		return Long.parseLong(next());
	}
	
	
	
	
	
}