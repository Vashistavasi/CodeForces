import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static FastScanner fs = new FastScanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        ascii_art_contest();
    }

    static void ascii_art_contest() throws IOException {
        int g, c, l;
        g = fs.nextInt();
        c = fs.nextInt();
        l = fs.nextInt();
        int arr[] = { g, c, l };
        Arrays.sort(arr);
        if (arr[2] - arr[0] >= 10)
            pw.println("check again");
        else
            pw.println("final " + arr[1]);
        pw.flush();
    }
}

class FastScanner {

    BufferedReader bf;
    StringTokenizer st;

    FastScanner(InputStream is) {
        bf = new BufferedReader(new InputStreamReader(is));
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