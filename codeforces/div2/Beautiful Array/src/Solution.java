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
public static void main(String[] args) throws Exception {
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
	
	int t=s.nextInt();
	while(t-->0) {
		long n=s.nextLong();
		long k=s.nextLong();
		long b=s.nextLong();
		long sum=s.nextLong();
		long minSum=k*b;
		long maxSum=k*b+(n)*(k-1);
		if(sum<minSum || sum>maxSum) {
			pw.println(-1);
		}
		else {
			
			sum=sum-k*b-k+1;
			int count=0;
			while(sum>0) {
				count++;
				sum-=(k-1);
			}
			long a[]=new long[(int) n];
			if(count==0) {
				
				sum=sum+k*b+k-1;
				a[0]=sum;
			}
			else {
				sum+=k-1;
				int i=0;
				a[0]=k*b+k-1;
				for( i=1;i<count;i++) {
					a[i]=k-1;
				}
				if(i<n)
				a[i++]=sum;	
			}
			
		
			for(long v:a)
				pw.print(v+" ");
			pw.println();
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
