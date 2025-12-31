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


public static void main(String[] args) throws Exception {
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
	long t=s.nextLong();
	while(t-->0) {
		long rect=s.nextLong();
		long queries=s.nextLong();
		long area[][]=new long[1001][1001];
		
	
		while(rect-->0) {
	    int h=s.nextInt();
	    int w=s.nextInt();
	    area[h][w]+=(long)h*(long)w;	
		}
		long prefix[][]=new long[1001][1001];
		for(int i=1;i<1001;i++)
			for(int j=1;j<1001;j++)
				prefix[i][j]=prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+area[i][j];
		while(queries-->0) {
			int a=s.nextInt();
			int b=s.nextInt();
			int A=s.nextInt();
			int B=s.nextInt();
			pw.println(prefix[A-1][B-1]-prefix[A-1][b]-prefix[a][B-1]+prefix[a][b]);
		}
		
	}
	
pw.flush();
}

//public static void main(String[] args) throws Exception {
//	pw=new PrintWriter(System.out);
//	s=new FastScanner(System.in);
//	long t=s.nextLong();
//	while(t-->0) {
//		long rect=s.nextLong();
//		long queries=s.nextLong();
//		ArrayList<Rectangle> rectangles=new ArrayList<Rectangle>();
//		while(rect-->0) {
//			rectangles.add(new Rectangle(s.nextLong(), s.nextLong()));
//		}
//		while(queries-->0) {
//			Rectangle small=new Rectangle(s.nextLong(),s.nextLong());
//			Rectangle large=new Rectangle(s.nextLong(),s.nextLong());
//			long area=0;
//			for(int i=0;i<rectangles.size();i++) {
//				Rectangle curr=rectangles.get(i);
//				boolean flag=(curr.len<large.len)&&
//						(curr.wid<large.wid && curr.len>small.len
//								&& curr.wid>small.wid);
//				if(flag)
//					area+=curr.len*curr.wid;
//			}
//			pw.print(area);
//			pw.println();
//			
//		}
//		
//	}
//	
//pw.flush();
//	
//	
//}
}
class Rectangle{
	long len;
	long wid;
	
	public Rectangle(long len, long wid) {
		super();
		this.len = len;
		this.wid = wid;
		
	}
	@Override
	public String toString() {
		return "[ " + len + "," + wid + "]";
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
