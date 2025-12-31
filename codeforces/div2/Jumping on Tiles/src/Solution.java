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
	
	int t=s.nextInt();
	while(t-->0) {
	String line=s.next();
	char start=line.charAt(0);
	char end=line.charAt(line.length()-1);
	int min=Math.abs(start-end);
	int upper=end;
	int lower=start;
	if(upper<lower) {
		int temp=lower;
		lower=upper;
		upper=temp;
	}
	ArrayList<Pair>al=new ArrayList<>();
	for(int i=1;i<line.length()-1;i++) {
		int c=line.charAt(i);
		if(c<=upper && c>=lower)
		{
			al.add(new Pair(i,c));
			
		}
	}
	if(line.charAt(0)>line.charAt(line.length()-1)) {
		Collections.sort(al,(p1,p2)->p2.value-p1.value);
	
	}
	else {
		Collections.sort(al,(p1,p2)->p1.value-p2.value);
	}
	pw.println(min+" "+(al.size()+2));
	pw.print(1+" ");
	for(int i=0;i<al.size();i++) {
		pw.print(al.get(i).pos+1+" ");
	}
	pw.print(line.length());
	pw.println();
	}
	pw.flush();
	
	
}
}
class Pair{
	int pos;
	int value;
	public Pair(int pos, int value) {
		super();
		this.pos = pos;
		this.value = value;
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
