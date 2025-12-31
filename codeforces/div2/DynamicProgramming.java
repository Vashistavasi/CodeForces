import java.util.*;
import java.io.*;

public class DynamicProgramming {

	static FastScanner fs = new FastScanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String args[]) throws IOException {
		solveOptimized();
	}

	static void solve() throws IOException {
		int n = fs.nextInt();
		int b = fs.nextInt();
		int input[] = new int[n];
		for (int i = 0; i < n; i++)
			input[i] = fs.nextInt();
		List<Integer> costs = calCosts(input);
		List<Integer> sums = new ArrayList(allSums(costs));
		Collections.sort(sums);
		int idx = Collections.binarySearch(sums, b);
		// pw.println(idx + "is the idx");
		// pw.println(sums.toString());
		if (idx < 0) {
			int curr = -1 * (idx + 1);
			curr -= 1;
			// pw.println("is the curr " + curr);
			// pw.println(sums.get(curr));
			pw.println(curr);
		} else
			pw.println(idx);
		// pw.println(sums.get(idx));
		pw.flush();

	}

	static void solveOptimized() throws IOException {
		int n = FastScanner.nextInt();
		int b = FastScanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = FastScanner.nextInt();
		List<Integer> cutCosts = calCosts(a);
		int ans = maxCutsWithinBudget(cutCosts, b);
		pw.println(ans);
		pw.flush();
	}

	public static int maxCutsWithinBudget(List<Integer> costs, int budget) {
		Collections.sort(costs);
		int used = 0, cnt = 0;
		for (int c : costs) {
			if (used + c > budget)
				break;
			used += c;
			cnt++;
		}
		return cnt;
	}

	public static List<Integer> calCosts(int[] input) {
		int even = 0;
		int odd = 0;
		List<Integer> costs = new ArrayList<Integer>();
		if (input[0] % 2 == 0)
			even++;
		else
			odd++;

		for (int i = 1; i < input.length; i++) {
			if (input[i] % 2 == 0)
				even++;
			else
				odd++;
			if (even - odd == 0 && i + 1 < input.length) {
				costs.add(Math.abs(input[i + 1] - input[i]));
			}
		}
		return costs;
	}

	public static Set<Integer> allSums(List<Integer> nums) {
		Set<Integer> sums = new HashSet<>();
		sums.add(0); // start with empty subset
		for (int x : nums) {
			// for current x, add x to every existing sum (snapshot first!)
			Set<Integer> next = new HashSet<>();
			for (int s : sums) {
				next.add(s + x);
			}
			sums.addAll(next);
		}
		return sums; // contains 0 .. all achievable sums
	}

	static class FastScanner {
		static BufferedReader bf;
		static StringTokenizer st;

		FastScanner(InputStream is) {
			this.bf = new BufferedReader(new InputStreamReader(is));
		}

		static String next() throws IOException {
			if (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(bf.readLine());
			}
			return st.nextToken();
		}

		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

}