import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Solve {
	static FastScanner fs = new FastScanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

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

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

	public static void main(String[] args) throws IOException {
		makeitequal();
	}

	public static void theSecretNumber() throws IOException {
		int t = fs.nextInt();
		while (t-- > 0) {
			long val = fs.nextLong();
			long temp = val;
			long mul = 10;
			List<Long> al = new ArrayList();
			while (temp > 0) {
				long div = mul + 1;
				temp /= 10;
				if (val % div == 0)
					al.add(val / div);
				mul *= 10;
			}
			if (al.size() == 0)
				pw.println(0);
			else {
				Collections.sort(al);
				pw.println(al.size());
				for (long i : al)
					pw.print(i + " ");
				pw.println();
				pw.flush();
			}
			pw.flush();
		}
	}

	public static void homework() throws IOException {
		int t = fs.nextInt();
		while (t-- > 0) {
			int alen = fs.nextInt();
			String a = fs.next();
			int blen = fs.nextInt();
			String b = fs.next();
			int start = 0;
			StringBuilder prefix = new StringBuilder();
			StringBuilder suffix = new StringBuilder();
			char[] seq = fs.next().toCharArray();
			for (int i = 0; i < seq.length; i++) {
				if (seq[i] == 'V')
					prefix.append(b.charAt(start++));
				else
					suffix.append(b.charAt(start++));
			}
			pw.println(prefix.reverse().toString() + a + suffix.toString());
			pw.flush();
		}
	}

	public static void makeitequal() throws IOException {
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int k = fs.nextInt();
			Map<Integer, Integer> shm = new HashMap();
			Map<Integer, Integer> thm = new HashMap();

			boolean flag = true;
			for (int i = 0; i < n; i++) {
				int curr = fs.nextInt() % k;
				if (curr > k / 2)
					curr = k - curr;
				shm.put(curr, shm.getOrDefault(curr, 0) + 1);
			}

			for (int i = 0; i < n; i++) {
				int curr = fs.nextInt() % k;
				if (curr > k / 2)
					curr = k - curr;
				thm.put(curr, thm.getOrDefault(curr, 0) + 1);
			}
			if (!shm.equals(thm))
				flag = false;
			pw.println(flag ? "YES" : "NO");
			pw.flush();
		}
	}

	public static void binaryStringBattle() throws IOException {
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int k = fs.nextInt();
			int arr[] = new int[n];
			String st = fs.next();
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (st.charAt(i) == '1')
					arr[i] = 1;
				else
					arr[i] = 0;
				if (arr[i] == 1)
					count++;
			}
			// pw.println(Arrays.toString(arr));
			if (k >= count)
				pw.println("Alice");
			else {

				if (2 * k > n)
					pw.println("Alice");
				else
					pw.println("Bob");
			}
			pw.flush();
		}
	}

	public static void derangedDeletions() throws IOException {
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			List<Integer> al = new ArrayList<>();
			for (int i = 0; i < n; i++)
				al.add(fs.nextInt());
			List<Integer> bl = new ArrayList<>(al);
			Collections.sort(bl);
			boolean flag = false;
			if (al.size() == 1)
				flag = true;
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (al.get(i) == bl.get(i)) {
					count++;
				}
			}
			if (count == n) {
				pw.println("NO");
				pw.flush();
				continue;
			}

			// pw.println(al.toString());
			// pw.println(bl.toString());
			if (!flag) {
				for (int j = 1; j < n; j++) {
					if (al.get(j) < al.get(j - 1)) {
						pw.println("YES");
						pw.println("2");
						pw.println(al.get(j - 1) + " " + al.get(j));
						break;
					}
				}
			} else {
				pw.println("NO");
			}
			pw.flush();
		}

	}

	static void addK() throws IOException {
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			long k = fs.nextLong();
			long mod = k + 1;
			for (int i = 0; i < n; i++) {
				long a = fs.nextLong();
				long m = a % mod;
				long res = a + m * k;
				if (i > 0)
					pw.print(' ');
				pw.print(res);
			}
			pw.println();
		}
		pw.flush();
	}

	static void paintwithtwocolors() throws NumberFormatException, IOException {
		int t = fs.nextInt();
		while (t-- > 0) {
			long n = fs.nextLong();
			long a = fs.nextLong();
			long b = fs.nextLong();
			boolean blueCenterable = ((n - b) % 2 == 0);
			boolean redFitsOrBalances = (a <= b) || (Math.abs(a - b) % 2 == 0);
			boolean ok = blueCenterable && redFitsOrBalances;
			pw.println(ok ? "YES" : "NO");
		}
		pw.flush();
	}

	static void evenlarger() throws IOException {
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			long ans = 0L;
			long p = 0L;
			long mn = 0L;

			for (int i = 1; i <= n; i++) {
				long a = fs.nextLong();
				long np;
				if ((i & 1) == 1) {
					if (i == 1) {
						np = p - a;
					} else {
						long lim = p - mn;
						if (lim < 0)
							lim = 0;
						long keep = a;
						if (keep > lim) {
							ans += (keep - lim);
							keep = lim;
						}
						np = p - keep;
					}
				} else {
					np = p + a;
				}
				mn = Math.min(mn, p);
				p = np;
			}

			pw.println(ans);
		}
		pw.flush();
	}
}
