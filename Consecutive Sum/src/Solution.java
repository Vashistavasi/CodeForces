import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
static PrintWriter pw;
static FastScanner s;
public static int[] a;
public static int findmax(int idx,int k,int n) {
	int maxIndex=idx;
	int max=a[maxIndex];
	for(int i=idx;i<n;i+=k) {
		if(max<=a[i]) {
			max=a[maxIndex];
			maxIndex=i;
		}
	}
	return maxIndex;
}
public static void main(String[] args) throws Exception {
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
	
	int t=s.nextInt();
	while(t-->0) {
		int n=s.nextInt();
		int k=s.nextInt();
		a=new int[n];
		long sum=0;
		for(int i=0;i<n;i++) {
			a[i]=s.nextInt();
		}
//		for(int i=0;i<k;i++) {
//			int maxIndex=findmax(i, k, n);
//			sum+=a[maxIndex];
//			int temp=a[i];
//			a[i]=a[maxIndex];
//			a[maxIndex]=temp;
//			
//		}
		int maxi[]=new int[k];
		for(int i=0;i<n;i++) {
			maxi[i%k]=Math.max(a[i], maxi[i%k]);
		}
		for(int i=0;i<k;i++) {
			sum+=maxi[i];
		}
		pw.println(sum);
		
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
