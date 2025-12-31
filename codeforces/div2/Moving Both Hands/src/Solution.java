import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
static PrintWriter pw;
static FastScanner s;
public static void main(String[] args) throws Exception {
	ArrayList<ArrayList<ArrayList<Long>>>graph=new ArrayList<ArrayList<ArrayList<Long>>>();
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
	int n=s.nextInt();
	int m=s.nextInt();
	for(int i=0;i<n;i++)
		graph.add(new ArrayList<ArrayList<Long>>());
	for(int i=0;i<m;i++) {
		int parent=s.nextInt()-1;
		int child=s.nextInt()-1;
		long dist=s.nextLong();
	   ArrayList<Long> al=new ArrayList<Long>();
		al.add((long) child);
		al.add(dist);
		graph.get(parent).add(al);
	}
	
	long []dist=dijkstra(n, graph, 0);
	for(int i=2; i<=n; i++) {
		long []distI=dijkstra(n, graph, i-1);
		long min=Math.min(dist[i-1], distI[0]);
		System.out.print(min + " ");
	}
        
    System.out.println();
	
}
static long[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Long>>> adj, int S)
{
    // Write your code here
	
	return shortestPath(V, adj, S);
}
public static int minDistance(long dist[],boolean shortestPathSet[]) {
	Long min=Long.MAX_VALUE;
	int minIndex=-1;
	for(int node=0;node<dist.length;node++) {
		if(!shortestPathSet[node]&&dist[node]<=min) {
			min=dist[node];
			minIndex=node;
		}
	}
	return minIndex;
	
}
public static long[] shortestPath(int V/*size*/, ArrayList<ArrayList<ArrayList<Long>>> adj, int S/*start*/) {
	long dist[]=new long[V];
	boolean shortestPathSet[]=new boolean[V];
	for(int i=0;i<V;i++) {
		dist[i]=Long.MAX_VALUE;	
	}
		
	dist[S]=0;
	for(int count=0;count<V-1; count++) {
		int cnode=minDistance(dist,shortestPathSet);
		shortestPathSet[cnode]=true;
		Iterator<ArrayList<Long>> it=adj.get(cnode).listIterator();
		while(it.hasNext()) {
		 ArrayList<Long> adjNode=it.next();
		 long vertx=adjNode.get(0);
		 int vertex=(int) vertx;
		 long weight=adjNode.get(1);
			if(!shortestPathSet[vertex] 
					&& dist[cnode]!=Long.MAX_VALUE && dist[cnode]+weight<dist[vertex] ) {
				dist[vertex]=dist[cnode]+weight;
			}
		}
		
	}
	
	
	return dist;
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
