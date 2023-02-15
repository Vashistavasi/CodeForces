import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static FastReader f=new FastReader();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n=f.nextInt();
		while(n-->0) {
			int size=f.nextInt();
            int [][] a=new int[size][size-1];
            for(int i=0;i<size;i++) {
    			for(int j=0;j<size-1;j++) {
    				a[i][j]=f.nextInt();
    			}
            }
            Map<Integer,Integer> hs=new HashMap<>();
            for(int i=0;i<size;i++) {
            	hs.put(a[i][size-2],hs.getOrDefault(a[i][size-2], 0)+1);
            }
            Set<Integer> keys=hs.keySet();
            Iterator<Integer> it=keys.iterator();
            int lastValue=-1,notLast=-1;
            while(it.hasNext()) {
            	int key=it.next();
            	if(hs.get(key)>1)
            		lastValue=key;
            	else
            		notLast=key;     	
            }
            int row=-1;
            for(int i=0;i<size;i++) {
            	if(a[i][size-2]==notLast) {
            		row=i;
            		break;
            	}
            }
            for(int i=0;i<size-1;i++) {
            	f.write(a[row][i]+" ");
            }
            f.write(lastValue+ "\n");
		}
	}

	
}
class FastReader{
	 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	 BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	StringTokenizer st=null;
	 
	public  String readLine() throws IOException {
		while(st==null||!st.hasMoreElements()) {
			st=new StringTokenizer(bf.readLine());
		}
		return st.nextToken();
	}
	public int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(readLine());
	}
	public Double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(readLine());
	}
	public Long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(readLine());
	}
	public void write(String str) throws IOException {
		bw.write(str);
		bw.flush();
	}
	public void write (Integer i) throws IOException {
		bw.write(i.toString());
		bw.flush();
	}
}