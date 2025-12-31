import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.*;

public class Deque {
    static FastScanner fs = new FastScanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String args[]) throws NumberFormatException, IOException, Exception {

        countgoodnumbersNaive();
    }

    public static void countgoodnumbers2() throws Exception {
        int f = fs.nextInt();
        while (f-- > 0) {
            long l = fs.nextLong();
            long r = fs.nextLong();
            pw.println(countHelper(r + 1) - countHelper(l));
            pw.flush();
        }
    }

    static long countHelper(long in) {
        if (in <= 0)
            return 0;
        int[] primes = { 2, 3, 5, 7 };
        long count = 0;

        for (int mask = 0; mask < (1 << 4); mask++) {
            long product = 1;
            int bits = 0;
            for (int i = 0; i < 4; i++) {
                if (((mask >> i) & 1) == 1) {
                    product *= primes[i];
                    bits++;
                }
            }
            int sign = (bits % 2 == 1) ? -1 : 1; // odd size subset → +
            count += sign * (in / product);
            pw.println("for mask " + mask + " the value count is " + count);
            pw.flush();
        }

        return count;
    }

    public static void countgoodnumbersNaive() throws Exception {
        int t = fs.nextInt();
        while (t-- > 0) {
            long l = fs.nextLong();
            long r = fs.nextLong();
            pw.println(get(r + 1) - get(l));
            pw.flush();
        }
    }

    public static long get(long in) {
        return (in / 210) * (naiveHelper(210)) + naiveHelper(in % 210);
    }

    public static long naiveHelper(long in) {
        long count = 0;

        for (long i = 0; i < in; i++) {
            if (divRule(i))
                count++;
        }

        return count;
    }

    public static boolean divRule(long num) {
        return num % 2 > 0 && num % 3 > 0 && num % 5 > 0 && num % 7 > 0;
    }

    public static void countgoodnumbers() throws Exception {
        int t = fs.nextInt();
        int primes[] = { 2, 3, 5, 7 };
        while (t-- > 0) {
            long l = fs.nextLong();
            long r = fs.nextLong();
            int ans = 0;
            for (long i = l; i < r + 1; i++) {
                pw.println("current num : " + i);
                pw.flush();
                for (int p : primes) {
                    if (i % p == 0) {
                        ans++;
                        break;
                    }
                }
            }
            pw.println(r - l + 1 - ans);
            pw.flush();
        }
    }

    public static void onlyonedigit() throws Exception {
        int t = fs.nextInt();
        while (t-- > 0) {
            int in = fs.nextInt();
            int min = Integer.MAX_VALUE;
            int len = 0;
            while (in > 0) {
                min = Math.min(min, in % 10);
                in = in / 10;
                len++;
            }
            pw.println(min);
            pw.flush();
        }
    }

    public static void nocasiosinmountains() throws Exception {
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int count = 0;
            int ans = 0;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (count == k) {
                    ans++;
                    count = 0;
                    continue;
                } else if (arr[i] == 1) {
                    count = 0;
                } else {
                    count++;
                }
            }
            if (count == k)
                ans++;
            pw.println(ans);
            pw.flush();

        }

    }

    public static void iwilldefinatelymakeit3() throws NumberFormatException, IOException {
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int currpos = fs.nextInt();
            ArrayList<Integer> al = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                al.add(fs.nextInt());
                max = Math.max(max, al.get(i));
            }
            int curr = al.get(currpos - 1);
            int pos = curr;
            Collections.sort(al);
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (max == curr)
                    break;
                if (al.get(i) > curr) {
                    if (al.get(i) - curr > pos) {
                        flag = false;
                        break;
                    } else {
                        curr = al.get(i);
                    }
                }

            }
            if (flag)
                pw.println("Yes");
            else
                pw.println("No");
            pw.flush();
        }

    }

    static void iwilldefinatelymakeit4() throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int p = fs.nextInt(); // 1-based
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = fs.nextInt();

            int cur = arr[p - 1];
            int dist = cur;

            int[] sorted = arr.clone();
            Arrays.sort(sorted);

            boolean ans = true;
            for (int x : sorted) {
                if (x < cur)
                    continue;
                if (x - cur > dist) {
                    ans = false;
                }
                cur = x;
            }
            if (ans)
                pw.println("Yes");
            else
                pw.println("No");
            pw.flush();
        }
    }

    static void iwilldefinatelymakeit2() throws NumberFormatException, IOException {
        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int currpos = fs.nextInt();
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                al.add(fs.nextInt());
            }
            ArrayList<Integer> bl = new ArrayList<>();
            for (int i : al) {
                if (i > al.get(currpos - 1))
                    bl.add(i);
            }
            Collections.sort(bl);
            int max = bl.get(bl.size() - 1);
            int waterH = 1;
            int curr = al.get(currpos - 1);
            for (int i = 0; i < bl.size(); i++) {
                if (max == curr)
                    break;
                if (jumpPossible(curr, bl.get(i), waterH)) {
                    waterH += bl.get(i) - curr;
                    curr = bl.get(i);
                } else {
                    break;
                }
            }
            if (curr == max)
                pw.println("Yes");
            else
                pw.println("No");
            pw.flush();
        }
    }

    static void iwilldefinatelymakeit() throws NumberFormatException, IOException {
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int currpos = fs.nextInt();
            int max = Integer.MIN_VALUE;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
                max = Math.max(max, arr[i]);
            }
            if (recursiveMakeit(arr[currpos - 1], arr, max, 1)) {
                pw.println("Yes");
            } else
                pw.println("No");
            pw.flush();
        }

    }

    static boolean recursiveMakeit(int currH, int[] arr, int max, int waterH) {
        boolean flag = false;
        if (currH == max && waterH <= currH)
            return true;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (currH != arr[i] && currH < arr[i] && jumpPossible(currH, arr[i], waterH)) {
                flag |= recursiveMakeit(arr[i], arr, max, waterH + arr[i] - currH);
            }
        }
        return flag;
    }

    static boolean jumpPossible(int currH, int nextH, int waterH) {
        if (currH - waterH + 1 >= nextH - currH)
            return true;
        return false;
    }

    static void thisisthelasttime2() throws NumberFormatException, IOException {
        int t = fs.nextInt();
        while (t-- > 0) {

            int casinos = fs.nextInt();
            int coins = fs.nextInt();
            ArrayList<Integer[]> al = new ArrayList<>();
            for (int i = 0; i < casinos; i++) {
                Integer[] a = new Integer[3];
                a[0] = fs.nextInt();
                a[1] = fs.nextInt();
                a[2] = fs.nextInt();
                al.add(a);
            }
            Collections.sort(al, (a, b) -> a[0] - b[0]);
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            int i = 0;
            while (true) {
                while (i < casinos && coins >= al.get(i)[0]) {
                    pq.offer(al.get(i)[2]);
                    i++;
                }
                if (pq.isEmpty() || pq.peek() < coins)
                    break;

                coins = pq.poll();
            }
            pw.println(coins);
            pw.flush();
        }
    }

    static void thisIsTheLastTime() throws NumberFormatException, IOException {
        int t = fs.nextInt();
        while (t-- > 0) {
            int casinos = fs.nextInt();
            int coins = fs.nextInt();
            boolean visited[] = new boolean[casinos];
            ArrayList<Integer[]> al = new ArrayList<Integer[]>();
            int count = 0;
            for (int i = 0; i < casinos; i++) {
                Integer a[] = new Integer[3];
                a[0] = fs.nextInt();
                a[1] = fs.nextInt();
                a[2] = fs.nextInt();
                al.add(a);
            }
            int loop = (int) Math.pow(casinos, 2);
            int prevHops = 0, currHops = 0;
            while (done(visited) && count < loop) {
                count++;
                for (int i = 0; i < casinos; i++) {
                    if (visited[i])
                        continue;
                    Integer curr[] = al.get(i);
                    currHops++;
                    if ((coins <= curr[1] && coins >= curr[0]) || (curr[2] <= coins)) {
                        visited[i] = true;
                        if (curr[2] > coins)
                            coins = curr[2];
                    }

                }
                if (prevHops == currHops)
                    break;
                prevHops = currHops;
                currHops = 0;
            }
            pw.println(coins);
            pw.flush();

        }
    }

    static boolean done(boolean[] visited) {
        for (boolean b : visited)
            if (!b)
                return true;
        return false;
    }

    static void mixmexmax() throws NumberFormatException, IOException {
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            boolean zOrDiff = false;
            Set<Integer> hs = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int curr = fs.nextInt();
                if (curr == -1)
                    continue;
                if (!zOrDiff) {
                    hs.add(curr);
                    if (curr == 0 || hs.size() > 1) {
                        zOrDiff = true;
                    }
                }
            }
            if (zOrDiff)
                pw.println("No");
            else
                pw.println("Yes");
            pw.flush();
        }

    }

    static void leftmostbelow() throws NumberFormatException, IOException {
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = fs.nextInt();
            int min = arr[0];
            boolean ans = true;
            for (int i = 1; i < n; i++) {
                if (arr[i] >= 2 * min) {
                    ans = false;
                    break;
                }
                min = Math.min(min, arr[i]);
            }
            if (ans)
                pw.println("Yes");
            else
                pw.println("No");
            pw.flush();
        }
    }

    static void recyclingCenter() throws NumberFormatException, IOException {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int c = fs.nextInt();
            Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++)
                hm.put(i, fs.nextInt());
            int sum = 0;
            int min = Integer.MIN_VALUE;
            int idx = -1;
            int power = 0;
            while (isParse(hm)) {
                for (int i : hm.keySet()) {
                    if (hm.get(i) == -1)
                        continue;
                    int val = hm.get(i) << power;

                    if (val > c) {
                        sum++;
                        hm.put(i, -1);
                    } else {
                        if (val <= c && val > min) {
                            idx = i;
                            min = val;
                        }
                    }
                }
                if (idx != Integer.MIN_VALUE)
                    hm.put(idx, -1);
                min = Integer.MIN_VALUE;
                power++;
            }
            pw.println(sum);
            pw.flush();

        }
    }

    static boolean isParse(Map<Integer, Integer> hm) {
        for (int i : hm.keySet()) {
            if (hm.get(i) != -1)
                return true;
        }
        return false;
    }

    void solve() throws NumberFormatException, IOException {

        FastScanner fs = new FastScanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < n; i++)
                queue.add(fs.nextInt());
            ArrayDeque<Integer> ans = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            int prev = 0;
            for (int i = 0; i < n; i++) {
                int left = queue.peekFirst();
                int right = queue.peekLast();
                int max = Math.max(left, right);
                int min = Math.min(left, right);
                if (prev > left && prev > right) {
                    if (min == left) {
                        sb.append("L");
                        prev = queue.pollFirst();
                    } else {
                        sb.append("R");
                        prev = queue.pollLast();
                    }
                    ans.add(prev);
                    if (!queue.isEmpty()) {
                        i++;
                        if (max == left) {
                            sb.append("R");
                            prev = queue.pollLast();
                        } else {
                            sb.append("L");
                            prev = queue.pollFirst();
                        }
                        ans.add(prev);
                    }
                } else {
                    if (max == left) {
                        sb.append("L");
                        prev = queue.pollFirst();
                    } else {
                        sb.append("R");
                        prev = queue.pollLast();
                    }
                    ans.add(prev);
                    if (!queue.isEmpty()) {
                        i++;
                        if (min == left) {
                            sb.append("L");
                            prev = queue.pollFirst();
                        } else {
                            sb.append("R");
                            prev = queue.pollLast();
                        }
                        ans.add(prev);
                    }
                }

            }
            pw.println(sb);
            pw.flush();

            // for (int i = 0; i < n; i++) {
            // pw.print(ans.poll() + " ");
            // }
            // pw.println();
            // pw.flush();

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

        int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }
    }
}
