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
    	int n=s.nextInt();
    	ArrayList<Friend>al=new ArrayList<Friend>();
    	for(int i=0;i<n;i++) {
    		al.add(new Friend(s.nextInt()));
    	}
    	for(int i=0;i<n;i++) {
    		Friend f=al.get(i);
    		f.y=s.nextInt();
    		al.set(i, f);
    	}
    	Collections.sort(al,(a,b)->(b.y-b.x)-(a.y-a.x));
    	int size=al.size();
    	int i=0;
    	int j=size-1;
    	int pairs=0;
    	while(i<j) {
    		Friend first=al.get(i);
    		Friend second=al.get(j);
    		int money=first.y+second.y;
    		int cost=first.x+second.x;
    		if(money>=cost) {
    			pairs++;
    			i++;
    			j--;
    		}
    		else {
    			j--;
    		}
    	}
    	pw.println(pairs);
    }
	
	pw.flush();
}
}
class Friend{
	int x;
	int y;
	public Friend(int x) {
	
		this.x = x;
		
	}
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y + "";
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
