import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
static PrintWriter pw;
static FastScanner s;
//public static int findMin(int a[],int b[],int idx) {
//	int n=a.length;
//	int start=0;
//	int end=n-1;
//	while(start<end) {
//		int mid=start+(end-start)/2;
//		if(b[mid]>a[idx])
//			end=mid-1;
//		else
//			start=mid+1;
//	}
//// if(start>n-1)
////	 return -1;
//	return start;
//}
public static int findMin(int a[],int b[],int idx) {
	int n=a.length;
	int start=0;
	int end=n-1;
	while(start<=end) {
		int mid=start+(end-start)/2;
		if(a[idx]>b[mid])
			start=mid+1;
		else
			end=mid-1;
	}
	return start;
}
//public static int findMin(int a[],int b[],int idx) {
//	int n=a.length;
//	boolean flag=false;
//	int min=0;
//	while(!flag) {
//		if(min>n-1)
//			return -1;
//		boolean check=true;
//		int j=0;
//		for(int i=0;i<n;i++) {
//			if(i==idx) {
//				
//			}
//			else if(j==min)
//				j++;
//			else {
//				if(a[i]>b[j++]) {
//					check=false;
//					break;
//				}
//			}
//		}
//		if(check)
//			flag=true;
//		else
//			min=min+1;
//	}
//    
//	return min;
//}
public static int findMax(int a[],int b[],int idx) {
	int n=a.length;
	boolean flag=false;
	int max=n-1;
	while(!flag) {
		if(max<0)
			return -1;
		boolean check=true;
		int j=0;
		for(int i=0;i<n;i++) {
			if(i==idx) {
				
			}
			else if(j==max)
				j++;
			else {
				if(a[i]>b[j++]) {
					check=false;
					break;
				}
			}
		}
		if(check)
			flag=true;
		else
			max=max-1;
	}
    
	return max;
	
}
public static void main(String[] args) throws Exception {
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
    int t=s.nextInt();
    while(t-->0) {
    	int n=s.nextInt();
    	int a[]=new int[n],b[]=new int[n],indices[]=new int[n],
    			mn[]=new int[n],mx[]=new int[n];
    	for(int i=0;i<n;i++) {
    		a[i]=s.nextInt();
    		indices[i]=a[i];
    	}
    		
    	for(int i=0;i<n;i++)
    		b[i]=s.nextInt();
  
  int max=n-1;
  for(int i=n-1;i>=0;i--) {
	 int cnt=findMin(a,b,i);
	 if(cnt==i) {
		 mn[i]=b[i]-a[i];
		 mx[i]=b[max]-a[i];
		 max=i-1;
	 }
	 else {
		 mn[i]=b[cnt]-a[i];
		 mx[i]=b[max]-a[i];
	 }
  }
  for(int i=0;i<n;i++)
	  pw.print(mn[i]+" ");
  pw.println();
  for(int i=0;i<n;i++)
	  pw.print(mx[i]+" ");
  pw.println();
  
  
//    int lst=n;
//    for(int i=n-1;i>-1;i--) {
//    	
//    }
    	
//    	ArrayList<Integer> al=new ArrayList<Integer>();
//    
//        boolean flag=true;
//    	for(int i=0;i<n;i++) {
//    		
//    		int min=findMin(a,b,i);
//    		if(min==-1) {
//    			flag=false;
//    			break;
//    		}else {
//    			al.add(b[min]-a[i]);
//    		}
//    	}
//    	if(flag) {
//    		for(int k=0;k<al.size();k++) {
//    			pw.print(al.get(k)+" ");
//    		}
//    		
//    	}
//    	else {
//    		for(int k=0;k<n;k++) {
//    			pw.print(0+" ");
//    		}
//    	}
//    	
//    	pw.println();
//    	for(int i=0;i<n;i++)
//    	{
//    		int max=findMax(a,b,i);
//    		if(max!=-1)
//    		pw.print(b[max]-a[i]+" ");
//    		else 
//    			pw.print(0+" ");
//    	}
//    	pw.println();
//    }
	pw.flush();
	
	
}
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
