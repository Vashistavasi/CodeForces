import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
static PrintWriter pw;
static FastScanner s;
static int ans;
static ArrayList<ArrayList<Integer>> graph;
static int l[],r[];
public static long DFS(int v) {
	long sum=0;
	for(int u:graph.get(v-1)) {
		sum+=DFS(u-1);
	}
	if(sum<l[v-1]) {
		++ans;
		return r[v-1];
	}
	return Math.min(r[v-1], sum);
}
public static void main(String[] args) throws Exception {
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
	
	int t=s.nextInt();
	while(t-->0) {
		int n=s.nextInt();
		graph= new ArrayList<ArrayList<Integer>>();
		for(int i=1;i<n;i++)
			graph.add(new ArrayList<>());
		for(int i=0;i<n;i++) {
			int node=s.nextInt();
			graph.get(node-1).add(i);
			graph.get(i).add(node-1);
		}
		 l=new int[n];r=new int[n];
		for(int i=0;i<n;i++) {
			l[i]=s.nextInt();
			r[i]=s.nextInt();
		}
		ans=0;
		DFS(1);
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
