import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Next {
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
        againstTheDifference();
    }

    static void inTheDream() throws NumberFormatException, IOException {
        int t = fs.nextInt();
        while (t-- > 0) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            int c = fs.nextInt() - a;
            int d = fs.nextInt() - b;
            if (isPossible(a, b) && isPossible(c, d))
                pw.println("YES");
            else
                pw.println("NO");
            pw.flush();
        }
    }

    static boolean isPossible(int a, int b) {
        int c = Math.max(a, b);
        int d = Math.min(a, b);
        if (2 * d >= c - 2)
            return true;
        else
            return false;
    }

    public static void likeTheBitSet() throws IOException {
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            String s = fs.next();

            int curr = 0, consec = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    curr++;
                    consec = Math.max(consec, curr);
                } else
                    curr = 0;
            }
            if (consec >= k) {
                pw.println("NO");
                pw.flush();
                continue;
            }

            int[] p = new int[n];
            int cur = n;
            for (int i = 0; i < n; i++)
                if (s.charAt(i) == '0')
                    p[i] = cur--;
            for (int i = 0; i < n; i++)
                if (s.charAt(i) == '1')
                    p[i] = cur--;

            pw.println("YES");
            for (int i = 0; i < n; i++) {
                if (i > 0)
                    pw.print(' ');
                pw.print(p[i]);
            }
            pw.println();
            pw.flush();
        }
    }

    public static void againstTheDifference() throws IOException {
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            List<List<Integer>> pos = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++)
                pos.add(new ArrayList<>());
            for (int i = 1; i <= n; i++) {
                int v = fs.nextInt();
                if (v <= n)
                    pos.get(v).add(i);
            }

            int total = 0;
            for (int v = 1; v <= n; v++) {
                int c = pos.get(v).size();
                if (c >= v)
                    total += (c - v + 1);
            }

            if (total == 0) {
                pw.println(0);
                pw.flush();
                continue;
            }

            int[] starts = new int[total];
            int[] ends = new int[total];
            int[] weights = new int[total];
            int idx = 0;
            for (int v = 1; v <= n; v++) {
                List<Integer> p = pos.get(v);
                int c = p.size();
                if (c < v)
                    continue;
                for (int j = 0; j + v - 1 < c; j++) {
                    starts[idx] = p.get(j);
                    ends[idx] = p.get(j + v - 1);
                    weights[idx] = v;
                    idx++;
                }
            }

            Integer[] order = new Integer[total];
            for (int i = 0; i < total; i++)
                order[i] = i;
            Arrays.sort(order, (i, j) -> Integer.compare(ends[i], ends[j]));

            int[] sortedEnds = new int[total];
            for (int i = 0; i < total; i++)
                sortedEnds[i] = ends[order[i]];

            int[] dp = new int[total];
            for (int i = 0; i < total; i++) {
                int st = starts[order[i]];
                int w = weights[order[i]];
                int prev = upperBound(sortedEnds, st - 1) - 1;
                int take = (prev >= 0 ? dp[prev] : 0) + w;
                int skip = (i > 0 ? dp[i - 1] : 0);
                dp[i] = Math.max(skip, take);
            }

            pw.println(dp[total - 1]);
            pw.flush();
        }
    }

    static int upperBound(int[] a, int x) {
        int l = 0, r = a.length; // first index > x
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= x)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}