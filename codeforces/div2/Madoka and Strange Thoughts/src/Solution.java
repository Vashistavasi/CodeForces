import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

//Java program to print pairs whose
//product is a perfect square
import java.util.*;

class GFG{

//Maximum number upto which sieve is performed
static final int MAXN = 100000001;

//Array to perform Sieve of Eratosthenes
//and store prime numbers
static int []spf = new int[MAXN];

//Function to perform sieve of
//eratosthenes on the array spf.
static void sieve()
{
 spf[1] = 1;
 for (int i = 2; i < MAXN; i++)
     spf[i] = i;

 for (int i = 4; i < MAXN; i += 2)
     spf[i] = 2;

 for (int i = 3; i * i < MAXN; i++) {
     if (spf[i] == i) {
         for (int j = i * i; j < MAXN; j += i)

             if (spf[j] == j)
                 spf[j] = i;
     }
 }
}

//Function to return the product of the
//odd occurring prime factors of a number
static int getProductOddOccuringPrimes(int x)
{
 // Product of 1 with perfect square gives
 // perfect square, 1 is returned for x = 1
 if (x == 1)
     return 1;

 // Temporary container of prime factors
 Vector<Integer> ret = new Vector<Integer>();
 while (x != 1) {
     ret.add(spf[x]);
     x = x / spf[x];
 }

 // ans contains the product of primes
 // which occurs odd number of times
 int count = 1, ans = 1;
 for (int i = 0, j = 1; j < ret.size(); ++j, ++i) {
     if (ret.get(i) != ret.get(j)) {
         if (count % 2 == 1)
             ans *= ret.get(i);
         count = 0;
     }
     count++;
 }

 // Checks if count is odd or not
 if (count %2 == 1)
     ans *= ret.get(ret.size() - 1);

 return ans;
}

//Function to print the pairs whose product is
//a perfect square
static void printPairs(int n, int m, int a[], int b[])
{
 int countPairs = 0;

 // For storing the indices with same
 // product of odd times occurring Primes as key
 Map<Integer, Vector<Integer>> productOfPrimes =
         new HashMap<Integer, Vector<Integer>>();

 // Every number from both the array is iterated
 // getProductOddOccuringPrimes function is called
 // and the product of odd occurring primes is
 // stored in the map productOfPrimes.
 // A pair is printed if the product is same
 for (int i = 0; i < n; ++i) {

     // Generating the product of odd times
     // occurring primes
     int productPrimesOfA
         = getProductOddOccuringPrimes(a[i]);

     // Pushing the indices to the to the
     // vector with the product of
     // odd times occurring Primes
     Vector<Integer> temp = new Vector<Integer>();
     if(productOfPrimes.containsKey(productPrimesOfA))
     for (Integer s:productOfPrimes.get(productPrimesOfA)){
         temp.add(s);
     }
     temp.add(i);
     productOfPrimes.put(productPrimesOfA, temp);
 }

 for (int i = 0; i < m; ++i)
 {
      
     // Generating the product of odd times
     // occurring Primes
     int productPrimesOfB
         = getProductOddOccuringPrimes(b[i]);

     // Checking if productPrimesOfB
     // lies in the productOfPrimes
     if (productOfPrimes.containsKey(productPrimesOfB)) {
         for (Integer itr : productOfPrimes.get(productPrimesOfB)) {
        	 BigInteger A=BigInteger.valueOf(a[itr]);
        	 BigInteger B=BigInteger.valueOf(b[i]);
        	 BigInteger gcd=BigInteger.valueOf(gcd(a[itr],b[i]));
        	 gcd=gcd.multiply(gcd);
        	 BigInteger product=A.multiply(B);
        	 product=product.divide(new BigInteger("3"));
        	 
             if(product.compareTo(gcd)<=0) {

                 countPairs++;
                 System.out.print(" (" + b[i]+ ", "
                     + a[itr]+ ") "); 
             }
         }
     }
 }
// if (countPairs <= 0)
//     System.out.print("No pairs Found!");
 System.out.println(countPairs);
}
public static long gcd(long a, long b)
{
    if (a == 0)
        return b;
    return gcd(b % a, a);
}
 
//Driver function
public static void main1(String[] args)
{
 sieve();

 // N, M are size of array a and b respectively
 int N = 5, M = 5;
 int a[] = { 4, 1, 6, 35, 120 };
 int b[] = { 24, 140, 4, 30, 1 };

 // Function that prints the pairs
 // whose product is a perfect square
 printPairs(N, M, a, b);
}
}
public class Solution {
static PrintWriter pw;
static FastScanner s;
public static long gcd(long a, long b)
{
    if (a == 0)
        return b;
    return gcd(b % a, a);
}
 

public static long lcm(long a,long b)
{
     long x= (a / gcd(a, b));
    return x*b;
}
public static long lcm(long a,long b,long gcd)
{
     long x= (a / gcd);
    return x*b;
}

public static void main(String[] args) throws Exception {
	pw=new PrintWriter(System.out);
	s=new FastScanner(System.in);
	long t=s.nextLong();
	 GFG helper =new GFG();
	while(t-->0) {
		int n=s.nextInt();
		int arr1[]=new int[n];
		int arr2[]=new int[n];
		for(int i=0;i<n;i++)
			arr1[i]=arr2[i]=i+1;
	
		
		
		}
		
	}


}
class FastScanner{
   	BufferedReader br;
   	StringTokenizer st;
	public FastScanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
	}

	public FastScanner(String s) throws Exception {
		br = new BufferedReader(new FileReader(new File(s)));
	}

	public String next() throws Exception {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	public long nextLong() throws Exception {
		return Long.parseLong(next());
	}
}
