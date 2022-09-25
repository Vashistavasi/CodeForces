import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
static PrintWriter pw;
static FastScanner s;
public static int count(long n) {
	
	
		int ans=0;
		while(n!=0)
		{
			ans++;
			n=n/10;
		}
		return ans;
	
}
public static void main(String[] args) throws Exception {
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
	int t=s.nextInt();
	while(t-->0) {
	int n=s.nextInt();
	PriorityQueue<Integer> pq=new PriorityQueue<>((p1,p2)->p2-p1);
	for(int i=0;i<n;i++)
		pq.add(s.nextInt());
	PriorityQueue<Integer> p=new PriorityQueue<>((p1,p2)->p2-p1);
	for(int i=0;i<n; i++)
	p.add(s.nextInt());
	int ans=0;
	while(!pq.isEmpty() ) {
		
		int first=pq.peek();
		int second=p.peek();
		if(first==second)
		{
			pq.poll();
			p.poll();
		}
		else if(first>second) {
			int replace=count(first);
			pq.poll();
			pq.add(replace);
			ans++;
		}
		else {
		  int replace=count(second);
		  p.poll();
		  p.add(replace);
		  ans++;
		}
	}
	
	pw.println(ans);
     
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
