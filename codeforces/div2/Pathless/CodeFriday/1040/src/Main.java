import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // pathless();
        runPathlessScriptInline();
    }

    static void test() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String line = br.readLine();
        pw.println(line);
        pw.flush();;

        // datatypes
        int ai = 1;
        double d = 0.001;
        float f = 0.1f;
        String st = "What";
        Character ch = 'c';

        // loops
        int n = 10;
        for (int i = 0; i < n; i++) {

        }
        int a = 0;
        while (a < n)
            a++;
        do {
            a++;
        } while (a < n);

        // if else
        if (a == 0) {

        } else if (a == 1) {

        } else {

        }

        switch (a) {

            case 0: {

            }
                break;
            case 1: {

            }
                break;
            case 2: {

            }
                break;
            default: {

            }
                break;

        }

        List<Integer> al = new ArrayList();
        Collections.sort(al);

    }

    static void pathless() throws IOException {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = fs.nextInt();
        while (t-- > 0) {
            int sum = 0;
            int s = 0;
            int[] arr = new int[1];
            int n = fs.nextInt();
            s = fs.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
                sum += arr[i];
            }
            if (s < sum) {
                for (int i : arr)
                    pw.print(i + " ");
                pw.println();
            } else if (s - sum == 1) {
                int[] ans = shuffleArray(arr);
                for (int an : ans) {
                    pw.print(an + " ");
                }
                pw.println();
            } else
                pw.println(-1);
            pw.flush();
        }

    }

    static void runPathlessScriptInline() throws IOException, InterruptedException {
        String script = """
                #!/bin/bash
                read t
                for ((tc=0; tc<t; tc++)); do
                    read n s
                    read -a arr
                    sum=0
                    for i in "${arr[@]}"; do
                        ((sum+=i))
                    done
                    if (( s < sum )); then
                        echo "${arr[@]}"
                    elif (( s - sum == 1 )); then
                        z=0; o=0; t2=0
                        for i in "${arr[@]}"; do
                            case $i in
                                0) ((z++));;
                                1) ((o++));;
                                2) ((t2++));;
                            esac
                        done
                        ans=()
                        for ((i=0; i<z; i++)); do ans+=(0); done
                        for ((i=0; i<t2; i++)); do ans+=(2); done
                        for ((i=0; i<o; i++)); do ans+=(1); done
                        echo "${ans[@]}"
                    else
                        echo -1
                    fi
                done
                """;

        ProcessBuilder pb = new ProcessBuilder("bash", "-c", script);
        pb.redirectErrorStream(true);
        pb.inheritIO();
        Process process = pb.start();
        int exitCode = process.waitFor();
        System.out.println("Script exited with code: " + exitCode);
    }

    static int[] shuffleArray(int[] array) {
        int[] ans = new int[array.length];
        int z = 0, o = 0, t = 0;
        for (int i : array) {
            switch (i) {
                case 0:
                    z++;
                    break;
                case 1:
                    o++;
                    break;
                case 2:
                    t++;
            }
        }
        int k = 0;
        while (k < z)
            ans[k++] = 0;
        while (k < z + t)
            ans[k++] = 2;
        while (k < t + o + z)
            ans[k++] = 1;
        return ans;
    }

    void helloWorld() {
        // TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the
        // highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            // TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have
            // set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut
            // actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            this.br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

    }

}