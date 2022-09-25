/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class Pairs{
	int id;
	long strength;
	public Pairs(int id, long strength) {
		super();
		this.id = id;
		this.strength = strength;
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

class Codechef
{
	static PrintWriter pw;
	static FastScanner s;
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		pw=new PrintWriter(System.out);
		s=new FastScanner(System.in);
		long t=s.nextLong();
		while(t-->0){
			int n=s.nextInt();
			
			ArrayList<Pairs>al=new ArrayList<Pairs>();
			for(int i=0;i<n;i++) {
				long strength=s.nextLong();
				al.add(new Pairs(i,strength));
				
			}
		
			ArrayList<Pairs>bl=new ArrayList<Pairs>();
			for(int i=0;i<n;i++) {
				long strength=s.nextLong();
				
				bl.add(new Pairs(i,strength));
			}
		Collections.sort(al,(p1,p2)->(int)(p2.strength-p1.strength));
		Collections.sort(bl,(p1,p2)->(int)(p2.strength-p1.strength));
		if(al.get(0).id==bl.get(0).id){
		    pw.println(1);
		    continue;
		}
		ArrayList<HashSet<Integer>> pokemon=new ArrayList<HashSet<Integer>>();
		LinkedList<Integer> visit=new LinkedList<Integer>();
		LinkedList<Integer>vis=new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
			pokemon.add(new HashSet<Integer>());
			visit.add(i);
			vis.add(i);
		}
			
       
        for(int i=0;i<n;i++) {
        	HashSet<Integer> hs=new HashSet<Integer>();
        	visit.remove(Integer.valueOf(al.get(i).id));
        	for(int j=0;j<visit.size();j++)
        	{
        			hs.add(visit.get(j));
        	}
        	pokemon.set(al.get(i).id,hs);
        }
       
        
     	
        int ans=0;
        for(int i=0;i<n;i++) {
        	int num=bl.get(i).id;
        	HashSet<Integer> hs=pokemon.get(num);
        	vis.remove(Integer.valueOf(num));
        	for(int j=0;j<vis.size();j++) {
        		
        			hs.add(vis.get(j));
        	}
        	if(hs.size()==n-1)
        		ans++;
        	
        }

		pw.println(ans);
 	   
		}
		pw.flush();
	}
}















///* package codechef; // don't place package name! */
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
///* Name of the class has to be "Main" only if the class is public. */
//class Pairs{
//	int id;
//	long strength;
//	public Pairs(int id, long strength) {
//		super();
//		this.id = id;
//		this.strength = strength;
//	}
//
//}
//class FastScanner{
//   	BufferedReader br;
//   	StringTokenizer st;
//	public FastScanner(InputStream s) {
//		br = new BufferedReader(new InputStreamReader(s));
//	}
//
//	public FastScanner(String s) throws Exception {
//		br = new BufferedReader(new FileReader(new File(s)));
//	}
//
//	public String next() throws Exception {
//		while (st == null || !st.hasMoreTokens())
//			st = new StringTokenizer(br.readLine());
//		return st.nextToken();
//	}
//
//	public int nextInt() throws Exception {
//		return Integer.parseInt(next());
//	}
//
//	public long nextLong() throws Exception {
//		return Long.parseLong(next());
//	}
//}

//class Codechef
//{
//	static PrintWriter pw;
//	static FastScanner s;
//	public static void main (String[] args) throws java.lang.Exception
//	{
//		// your code goes here
//		pw=new PrintWriter(System.out);
//		s=new FastScanner(System.in);
//		long t=s.nextLong();
//		while(t-->0){
//			int n=s.nextInt();
//			
//			ArrayList<Pairs>al=new ArrayList<Pairs>();
//			for(int i=0;i<n;i++) {
//				long strength=s.nextLong();
//				al.add(new Pairs(i,strength));
//				
//			}
//		
//			ArrayList<Pairs>bl=new ArrayList<Pairs>();
//			for(int i=0;i<n;i++) {
//				long strength=s.nextLong();
//				
//				bl.add(new Pairs(i,strength));
//			}
//		Collections.sort(al,(p1,p2)->(int)(p2.strength-p1.strength));
//		Collections.sort(bl,(p1,p2)->(int)(p2.strength-p1.strength));
//		if(al.get(0).id==bl.get(0).id){
//		    pw.println(1);
//		    continue;
//		}
//		ArrayList<HashSet<Integer>> pokemon=new ArrayList<HashSet<Integer>>();
//		LinkedList<Integer> visit=new LinkedList<Integer>();
//		for(int i=0;i<n;i++) {
//			pokemon.add(new HashSet<Integer>());
//			visit.add(i);
//		}
//			
//       
//        for(int i=0;i<n;i++) {
//        	HashSet<Integer> hs=new HashSet<Integer>();
//        	visit.remove(Integer.valueOf(al.get(i).id));
//        	for(int j=0;j<visit.size();j++)
//        	{
//        			hs.add(visit.get(j));
//        	}
//        	pokemon.set(al.get(i).id,hs);
//        }
//        ArrayList<HashSet<Integer>> finalPokemon=new ArrayList<HashSet<Integer>>();
//        LinkedList<Integer>vis=new LinkedList<Integer>();
//        for(int i=0;i<n;i++) {
//        	finalPokemon.add(new HashSet<Integer>());
//        	vis.add(i);
//        }
//			
//       
//        for(int i=0;i<n;i++) {
//        	int num=bl.get(i).id;
//        	HashSet<Integer> hs=pokemon.get(num);
//        	vis.remove(Integer.valueOf(num));
//        	for(int j=0;j<vis.size();j++) {
//        		
//        			hs.add(vis.get(j));
//        	}
//        	finalPokemon.set(num,hs);
//        }
//		
//		int ans=0;
//		int max=0;
//		for(int i=0;i<n;i++) {
//			max=Math.max(max, finalPokemon.get(i).size());
//		}
//		for(int i=0;i<n;i++)
//		{
//			if(max==finalPokemon.get(i).size())
//				ans++;
//		}
//		pw.println(ans);
// 	   
//		}
//		pw.flush();
//	}
//}
