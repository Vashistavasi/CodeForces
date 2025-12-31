import java.util.*;
import java.io.*;

public class SubmissionIsAllYouNeed {

	public static void main(String args[]) throws IOException {
		solve();
	}

	static void solve() throws IOException {
		FastScanner fs = new FastScanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int arr[] = new int[n];
			int o = 0, z = 0, sum = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = fs.nextInt();
				if (arr[i] == 0)
					z++;
				if (arr[i] == 1)
					o++;
				sum += arr[i];
			}
			sum += z;
			pw.println(sum);
			pw.flush();

		}
	}

	static class FastScanner {

		BufferedReader bf;
		StringTokenizer st;

		FastScanner(InputStream is) {
			this.bf = new BufferedReader(new InputStreamReader(is));
		}

		String next() throws IOException {
			if (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(bf.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}
