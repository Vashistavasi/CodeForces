package org.practice.neetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(new int[]{1,2,1,0,4,2,6}, 3)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=0,r=0,len=nums.length,idx=0;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> (b[1] - a[1]));
        int[] ans = new int[nums.length-k+1];
       for(int i=0;i<k;i++)pq.offer(new Integer[]{i,nums[i]});
       for(int i=k;i<(len+1);i++){
          while(true) {
              Integer[] max = pq.peek();
              if (max!=null && max[0] >= l) {
                  ans[idx] = max[1];
                  idx++;
                  break;
              }
              else {
                  pq.poll();
              }
          }
           l++;
          if(i<len)
            pq.offer(new Integer[]{i,nums[i]});
       }

    return ans;
    }
}
