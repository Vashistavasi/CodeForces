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
		int n=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=s.nextInt();
		}
//		long asum[]=new long[n];
//		asum[0]=a[0];
//		for(int i=1;i<n;i++) {
//			asum[i]+=asum[i-1]+a[i];
//		}
		
		boolean flag=true;
		long sum=0;
//		if(asum[n-1]!=0)
//		{
//			pw.println("No");
//			continue;
//		}
//		for(int i=0;i<n;i++) {
//			if(asum[i]<0) {
//			flag=false;
//			break;
//			}
//		}
//		boolean check=false;
//		if(flag)
//		for(int i=0;i<n;i++) {
//		if(asum[i]==0) {
//			check=true;
//		}
//		else if(check) {
//			flag=false;
//			break;
//		}
//		}
		
		for(int i=0;i<n;i++) {
			sum+=a[i];
			if(sum<0) {
				flag=false;
				break;
			}
			if(sum==0) {
				for(int j=i+1;j<n;j++) {
					if(a[j]!=0) {
						flag=false;
						break;
					}
				}
				if(!flag)
					break;
			}
		}
		if(flag && sum==0)
			pw.println("Yes");
		else
			pw.println("No");
		
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
