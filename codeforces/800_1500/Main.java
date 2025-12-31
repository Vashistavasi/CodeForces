import java.io.*;
import java.util.*;

public class Main {

	static FastScanner fs = new FastScanner(System.in);

	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
//		maxDisToPort();

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
	}
}
