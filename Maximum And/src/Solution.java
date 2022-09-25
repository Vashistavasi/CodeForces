import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
static PrintWriter pw;
static FastScanner s;
public static boolean check(int ans,int []a, int b[]) {
	HashMap<Integer,Integer>hm=new HashMap<>();
	int n=a.length;
	for(int i=0;i<n;i++) {
		if(!hm.containsKey(a[i] & ans))
		hm.put(a[i] & ans,1 );
		else
			hm.put(a[i]&ans,hm.get(ans&a[i])+1);
	}
	for(int i=0;i<n;i++) {
		if(!hm.containsKey(~b[i] & ans))
		hm.put(~b[i] & ans,-1 );
		else
			hm.put(~b[i]&ans,hm.get(ans&(~b[i]))-1);
	}
	Set<Integer> key=hm.keySet();
	boolean ok=true;
	Iterator <Integer> it=key.iterator();
	while(it.hasNext()) {
		ok&=(hm.get(it.next())==0);
	}
	return ok;
	
	
}
public static void main(String[] args) throws Exception {
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
	int t=s.nextInt();
	while(t-->0) {
		int n=s.nextInt();
		int a[]=new int[n];
		int b[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();
		for(int i=0;i<n;i++)
			b[i]=s.nextInt();
		int ans=0;
		for(int bit=29;bit>=0;--bit)
			if(check(ans|(1<<bit),a,b)) {
				ans|=1<<bit;
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
