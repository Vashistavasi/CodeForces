import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
     public static int score (ArrayList<HashSet<String>> al,String game[][],int p) {
    	 HashSet<String> hs1=null;
    	 HashSet<String> hs2=null;
    	 for(int i=0;i<3;i++) {
    		 if(i!=p && hs1==null) {
    			 hs1=al.get(i);
    		 }
    		 else if(i!=p&& hs1!=null)
    			 hs2=al.get(i);
    	 }
        int count=0;
        for(int i=0;i<game[p].length;i++) {
        	String num=game[p][i];
        	if(hs1.contains(num)&&hs2.contains(num)) {
        		
        	}
        	else if(hs1.contains(num)&&!hs2.contains(num)) {
        		count++;
        	}
        	else if(!hs1.contains(num)&&hs2.contains(num)) {
        		count++;
        	}
        	else {
        		count=count+3;
        	}
        }
        return count;
     }
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
			ArrayList<HashSet<String>> al=new ArrayList<HashSet<String>>();
			int words=s.nextInt();
		 String [][] game=new String[3][words];
			for(int i=0;i<3;i++) {
				HashSet<String> hs=new HashSet<String> ();
				for(int j=0;j<words;j++) {
					game[i][j]=s.next();
					hs.add(game[i][j]);
				}
				al.add(hs);
			}
			for(int i=0;i<3;i++) {
				System.out.print(score(al,game,i)+" ");
			}
			System.out.println();
		   
			
			
		}
	}
	
	
	
}
