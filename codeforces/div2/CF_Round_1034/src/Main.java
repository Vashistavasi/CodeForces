import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static FastScanner fs = new FastScanner(System.in);
   static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) {
        blackBoardGame();
    }
    static void blackBoardGame(){
        int n = fs.nextInt();
        while(n-->0){
            int m = fs.nextInt();
            if(m%4 == 0){
                pw.println("BOB");
            }
            else pw.println("ALICE");
            pw.flush();
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream is){
            br = new BufferedReader(new InputStreamReader(is));
        }
         String next(){
           if(st == null || !st.hasMoreTokens()){
               try {
                   st = new StringTokenizer(br.readLine());
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
           return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}