public class Subsets {
    static int[] primes = {2, 3, 5, 7};

    public static void main(String[] args) {
        // loop from 1 to 15 (all non-empty subsets of 4 primes)
        for (int mask = 1; mask < (1 << 4); mask++) {
            StringBuilder subset = new StringBuilder("{ ");
            for (int i = 0; i < 4; i++) {
                if ((mask >> i & 1) == 1) {
                    subset.append(primes[i]).append(" ");
                }
            }
            subset.append("}");
            System.out.println("mask=" + mask + " (" + Integer.toBinaryString(mask) + ") → " + subset);
        }
    }
}

