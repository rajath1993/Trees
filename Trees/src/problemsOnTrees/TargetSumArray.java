package problemsOnTrees;

import java.util.HashMap;

public class TargetSumArray {

	public static void main(String[] args) {
		int[] arr = new int[] {3,4,1,6,1};
		int k = 7;
		
		int count = prefixSumMap(arr,k);
		System.out.println(count);
	}
	
	public static int prefixSumMap(int[] arr,int k) {
		HashMap<Integer,Integer> hmap = new HashMap<>();
		int curr_sum = 0;
		int count = 0;
		for(int x: arr) {
			curr_sum+=x;
			
			if(curr_sum==k) {
				count++;
			}
			
			count += hmap.getOrDefault(curr_sum-k, 0);
			hmap.put(curr_sum,hmap.getOrDefault(curr_sum, 0)+1);
		}
		
		return count;
	}
	
	public static int windowSliding(int[] arr,int k) {
		int windowStart = 0;
		int count = 0;
		int windowSum = 0;
		for(int windowEnd=0;windowEnd<arr.length;windowEnd++) {
			
			//System.out.println(windowSum);
			if(windowSum == k) {
				count++;
				windowSum -=arr[windowStart];
				windowStart+=1;
			}
			
			windowSum += arr[windowEnd];
			
			if(windowSum>k) {
				windowSum-=arr[windowStart];
				windowStart+=1;
			}
			
		}
		
		return count;
	}

}
