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
	
	int n=s.nextInt();
	long d=s.nextLong();
	ArrayList<Long>al=new ArrayList<Long>();
	for(int i=0;i<n;i++)
		al.add(s.nextLong());
	Collections.sort(al, Collections.reverseOrder());
	int i=0;
	int j=n-1;
	int count=0;
	while(i<=j) {
		long sum=al.get(i);
		
		while(sum<=d && i<=j) {
			sum+=al.get(i);
			j--;
		}
		if(sum>d && i<=j)
			count++;
		i++;
	}
	pw.println(count);
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
