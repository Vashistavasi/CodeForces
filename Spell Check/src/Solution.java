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
	HashSet<Character> o=new HashSet<Character>();
	String name="Timur";
	for(int i=0;i<5;i++) {
	o.add(name.charAt(i));	
	}
	int t=s.nextInt();
	
	while(t-->0) {
		int n=s.nextInt();
		String str=s.next();
		
		if(n!=5)
		{
			pw.println("NO");
			continue;
		}
		else {
			boolean flag=true;
			HashSet<Character> temp=new HashSet<Character> (o);
			for(int i=0;i<5;i++) {
				if(temp.contains(str.charAt(i)))
					temp.remove(str.charAt(i));
				else {
					flag=false;
					break;
				}
			}
			if(flag)
				pw.println("YES");
			else
				pw.println("NO");
			}
		
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
