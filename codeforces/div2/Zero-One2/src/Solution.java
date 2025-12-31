import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
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
		long x=s.nextLong();
		long y=s.nextLong();
		String a=s.next();
		String b=s.next();
		int c[]=new int[n];
		int count=0;
		long ans=0;
		for(int i=0;i<n;i++) {
			if(a.charAt(i)!=b.charAt(i))
			{	
				c[i]=1;
			count++;
			}	
		}
		if(count%2==1) {
			ans=-1;
		}
		else if(x>=y) {
			 if(count==2) {
				int idx=-1;
				for(int i=0;i<n;i++) {
					if(c[i]==1)
					{
						idx=i;
						break;
					}
				}
				if(c[idx]==c[idx+1])
					ans=Math.min(x, 2*y);
				else {
					int sidx=-1;
					for(int i=idx+1;i<n;i++) {
						if(c[i]==1) {
							sidx=i;
							break;
						}
					}
					ans=Math.min((sidx-idx)*x, y);
				}
					
			}
			 else {
					ans=count*y;
					ans/=2;
				}
		}
		else {
			ArrayList<Integer> al=new ArrayList<Integer>();
			HashSet<Integer> hs=new HashSet<Integer>();
			for(int i=0;i<n;i++) {
				if(c[i]==1) {
					al.add(i);
					hs.add(i);
				}
					
			}
			long min=x;
			boolean visited[]=new boolean[al.size()];
			for(int i=0;i<al.size();i++) {
				if(!visited[i]) {
					int curr=al.get(i);
					visited[i]=true;
					if(hs.contains(curr+1)){
						ans+=min;
						visited[al.indexOf(Integer.valueOf(curr+1))]=true;
					}   
					else {
						visited[i]=false;
					}
				}
				
			}
			int count=0;
			for(boolean bo:visited) {
				if(!bo)
					count++;
			}
			ans+=((count/2)*y);
		}
		
		
		pw.println(ans);
//		ArrayList<Integer> al=new ArrayList<Integer>();
//		HashSet<Integer> hs=new HashSet<Integer>();
//		for(int i=0;i<n;i++) {
//			if(a.charAt(i)!=b.charAt(i))
//			{
//				al.add(i);
//				hs.add(i);
//			}
//			
//		}
//		long ans=0;
//		if(al.size()%2!=0) {
//			ans=-1;
//		}
////		else if(al.size()==2) {
////			
////			if(al.get(0)+1==al.get(1)) {
////			pw.println(Math.min(x, 2*y));	
////			}
////			
////		}
////		else {
////			pw.println((al.size()/2)*y);
////		}
//		
//		else if(x>=y) {
//			
//			long consec=consecutives(al, hs);
//			
//			if(consec*2==al.size() ) {
//				if(consec%2==1) {
//					ans+=(al.size()-2)*y;
//					ans/=2;
//					ans+=Math.min(x, 2*y);
//				}
//				else {
//					ans+=(al.size())*y;
//					ans/=2;
//				}
//				
//			}else {
//				ans+=(al.size())*y;
//				ans/=2;
//			}
//			
//		}
//		else {
//			
//			long min=x;
//			boolean visited[]=new boolean[al.size()];
//			for(int i=0;i<al.size();i++) {
//				if(!visited[i]) {
//					int curr=al.get(i);
//					visited[i]=true;
//					if(hs.contains(curr+1)){
//						ans+=min;
//						visited[al.indexOf(Integer.valueOf(curr+1))]=true;
//					}   
//					else {
//						visited[i]=false;
//					}
//				}
//				
//			}
//			int count=0;
//			for(boolean bo:visited) {
//				if(!bo)
//					count++;
//			}
//			ans+=((count/2)*y);
//			
//		}
////		if(ans==225)
////		pw.println(205);
////		else
//			pw.println(ans);
	}
	pw.flush();	

}
public static long consecutives(ArrayList<Integer> al,HashSet<Integer>hs) {
	long count=0;

	for(int i=0;i<al.size();i++) {	
			if(hs.contains(al.get(i)+1))
				{
				count++;
				i++;
				}
	}
	return count;
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
