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
    	int a[]=new int[26];
    	StringBuffer sb=new StringBuffer();
    	sb.append(s.next());
    	sb.append(s.next());
    	for(int i=0;i<4;i++) {
    		a[sb.charAt(i)-97]+=1;
    	}
    	int count=0;
    	for(int i=0;i<26;i++) {
    		if(a[i]>0)
    			count++;
    	}
    	 
    	switch(count) {
    	case 4: pw.println(3);
    	break;
    	case 3: pw.println(2);
    	break;
    	case 2: pw.println(1);
    	break;
    	case 1: pw.println(0);
    	break;
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
