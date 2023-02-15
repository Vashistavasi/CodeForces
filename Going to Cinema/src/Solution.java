import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static FastReader f=new FastReader();
public static void main(String[] args) throws NumberFormatException, IOException {
	int n=f.nextInt();
	while(n-->0) {
		int s=f.nextInt();
		int a[]=new int[s];
		for(int i=0;i<s;i++) {
			a[i]=f.nextInt();
		}
		int ans=solve(s,a);
		f.write(ans+"\n");
	}
}
private static int solve(int s, int[] a) {
	// TODO Auto-generated method stub
	int cnt[]=new int[s+1];
	for(int i=0;i<s;i++) {
		cnt[a[i]]++;
	}
	int ans=0,sum=0;
	for(int i=0;i<=s;i++) {
		if(cnt[i]==0 && sum==i){
			ans++;
		}
		sum+=cnt[i];
	}
	return ans;
	
}
}
class FastReader {
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	StringTokenizer st=null;
	public String readLine() throws IOException {
		while(st==null || !st.hasMoreElements()) {
			st=new StringTokenizer(bf.readLine());
		}
		return st.nextToken();
	}
	public int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(readLine());
	}
	public void write(String s) throws IOException {
		bw.write(s);
		bw.flush();
	}
	public void write(Integer i) throws IOException {
		bw.write(i.toString());
		bw.flush();
	}
}
