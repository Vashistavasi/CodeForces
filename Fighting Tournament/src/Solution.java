import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
static PrintWriter pw;
static FastScanner s;



public static int[][] stepsForSaturations(LinkedList<Integer>ll) {
	

	int size=ll.size();
	int[][] a=new int[size+1][size+1];
	for(int k=1;k<=size;k++) {
	
				
		int first=ll.get(0);
		int second=ll.get(1);
		if(first>second) {
			
			a[k][first]+=1+a[k-1][first];
			ll.remove();
			ll.remove();
			ll.addFirst(first);
			ll.add(second);
		}
		else {
			a[k][second]+=1+a[k-1][second];
			ll.remove();
			ll.remove();
			ll.addFirst(second);
			ll.add(first);
		}
		
	}
	
	return a;
}
public static void main(String[] args) throws Exception {
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
	int t=s.nextInt();
	while(t-->0) {
		int n=s.nextInt();
		long queries=s.nextLong();
	
		
		int arr[]=new int[n];
		LinkedList<Integer> ll=new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
			int num=s.nextInt();
			ll.add(num);
			arr[i]=num;
			
		}
	
		int a[][]=stepsForSaturations(ll);
		

		while(queries-->0) {
			int index=s.nextInt();
			long rounds=s.nextLong();
			
			int strength=arr[index-1];
			  if(rounds>=n) {
				  rounds=rounds-n;
				  if(strength==n)
				  pw.println(rounds+a[n][n]);
				  else {
					  int max=0;
					  for(int i=1;i<=n;i++)
						  max=Math.max(a[i][strength],max);
					  pw.println(max);
				  }
					  
			  }
			  else {
				  int max=00;
				  for(int i=1;i<=rounds;i++)
					  max=Math.max(a[i][strength],max);
				  pw.println(max);
			  }
		}
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
