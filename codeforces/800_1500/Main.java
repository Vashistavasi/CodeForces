
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    static FastScanner fs = new FastScanner(System.in);

    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
//		maxDisToPort();
//        honeyCake2();
//kefafirstsetps();
        fillingShapes();
    }

    public static void fillingShapes() throws Exception {
        int in= fs.nextInt();
        if(in%2!=0)pw.println(0);
        else pw.println((int)Math.pow(2,in/2));
        pw.flush();
    }

    public static void kefafirstsetps()throws Exception{

        int n = fs.nextInt();
        int []arr= new int[n];
        for(int i=0;i<n;i++)arr[i]=fs.nextInt();
        /*
        dp[i] if arr[i]>arr[i-1] dp[i]+1
        find the smallest number before and +1
         2 2 1 3 4 1
         1 1 1 2 3 1
         */
        int [] dp = new int[n];
        int ans=1;
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
          if(arr[i]>arr[i-1])dp[i]=1+dp[i-1];
          else dp[i]=1;
          ans=Math.max(ans,dp[i]);
        }

        pw.println(ans);
        pw.flush();
    }

    public static void medicalParity() throws Exception{

        /*
        x and y
        flip x and flip y. So minimum flips done and x's parity is y.
         */

    }
    
    static void honeyCake2() throws Exception{
       
        int l = fs.nextInt();
        int w = fs.nextInt();
        int h = fs.nextInt();
        
        int units = fs.nextInt();
        
       int l_div = gcd(l,units);
       int w_div = gcd(w,units/l_div);
       int div = units/l_div;
       div = div/w_div;
       int h_div = gcd(h, div);
       div = div/h_div;
       if(div!=1)pw.println(-1);
       else {
           pw.println((l_div-1)+ " " +( w_div-1 )+ " "+ (h_div-1));
       }
       pw.flush();

    }
    static int getGcd(int dim, int uni){
        if(uni==1)return 1;
        int currGcd = gcd(dim,uni);
        int c_div=currGcd;
        while(uni!=1 && currGcd!=1){
            dim=dim/currGcd;
            uni=uni/currGcd;
            currGcd=gcd(dim,uni);
            c_div*=currGcd;
        }
        return c_div;
    }
    static int gcd(int a, int b){
        while(b!=0){
            int t = a%b;
            a=b;
            b=t;
        }
        return a;
    }

    static void honeyCake() throws IOException {
        /*
		calculate for the volume: 10,20,6 
		1200
		40
		30 5*2*3 
		30 - xyz 
		x - 10,5,2,1
		y - 20,10,5,4,2,1
		z - 6,3,1
		
		xyz = 30
		10%x=0 20%y=0 6%h=0
		x=1 y=1 z=1
		
		find gcd 
		 given l,h,w and units
		 gcd(l,u) -> k 
		 if(k!=1) l/k u/k
		 gcd(l/k,u/k) 
		

         */
        long w = fs.nextLong();
        long h = fs.nextLong();
        long d = fs.nextLong();
        int units = fs.nextInt();
        long volume = w * h * d;
        long perUnitVol = (volume / units);
        if (volume % units != 0) {
            pw.println("-1");
        } else {
            List<Integer> wFact = getFactors((int) w);
            List<Integer> hFact = getFactors((int) h);
            List<Integer> dFact = getFactors((int) d);
            for (int i : wFact) {
                for (int j : hFact) {
                    for (int k : dFact) {
                        long curVol = (long) i * j * k;
                        if (curVol == perUnitVol) {
                            pw.println((i - 1) + " " +( j - 1) + " " + (k - 1));
                            pw.flush();
                            return;
                        }
                    }
                }
            }
        }
        pw.flush();

    }

    public static List<Integer> getFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);

                if (i != n / i) { // avoid duplicate when n is a perfect square
                    factors.add(n / i);
                }
            }
        }

        return factors;
    }

    static void clusterComputing() {
        /*
		ith server - pi th protocol
		u and v -
		cost of connection between u and v
		gcd(pu, pu+1, pu+2 ... pv	)
		min cost to connect all n servers so that every server is reachale from every other server.

		for intput
		1 2 3
		4 2 6

	1,2 -> gcd(1,2) -> gcd(4,2) -> 2
	1,3 -> gcd(1,2,3) -> gcd(4,2,6) -> 2
	2,3 -> gcd(2,3) -> gcd(2,6) -> 2
	sum = 4
	connection can be direct or indirect

         */
    }

    static void maxDisToPort() throws IOException {
        int n, m, k;
        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();

        int[] produce = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            produce[i] = fs.nextInt();
        }
        List<ArrayList<Integer>> gr = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n + 1; i++) {
            gr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            gr.get(u).add(v);
            gr.get(v).add(u);
        }

        int[] distances = dfs(n, gr);

        int[] ans = new int[k + 1];

        for (int i = 1; i < produce.length; i++) {
            ans[produce[i]] = Math.max(ans[produce[i]], distances[i]);
        }

        for (int i = 1; i < ans.length; i++) {
            pw.print(ans[i] + " ");
        }
        pw.println("");
        pw.flush();
    }

    static int[] dfs(int n, List<ArrayList<Integer>> gr) {
        int[] distances = new int[n + 1];
        distances[1] = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(1);
        Set<Integer> visited = new HashSet<Integer>();
        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            visited.add(currNode);
            List<Integer> adjNodes = gr.get(currNode);
            for (int i = 0; i < adjNodes.size(); i++) {
                int adjNode = adjNodes.get(i);
                if (!visited.contains(adjNode)) {
                    distances[adjNode] = distances[currNode] + 1;
                    stack.push(adjNode);
                }
            }

        }

        return distances;
    }

    static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}
