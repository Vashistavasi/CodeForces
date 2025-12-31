import java.util.*;

public class DivisibleCount {
    static int[] primes = {2, 3, 5, 7};

    // Function f(x) → count numbers <= x divisible by 2,3,5,7
    static long f(long x) {
        if (x <= 0) return 0;
        long res = 0;
        // Loop over all subsets of {2,3,5,7}
        for (int mask = 0; mask < (1 << 4); mask++) {
            long m = 1;
            int sg = 1;
            for (int i = 0; i < 4; i++) {
                if (((mask >> i) & 1) == 1) {
                    m *= primes[i];
                    sg = -sg;  // flip sign
                }
            }
            res += sg * (x / m);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases
        while (t-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            System.out.println(f(r) - f(l - 1));
        }
        sc.close();
    }
}

