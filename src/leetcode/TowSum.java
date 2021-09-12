package leetcode;

import java.util.Arrays;

public class TowSum {
	public static void main(String[] args) {
		int[] nums = {2, 11, 11, 7};
		int target = 9;
		int[] result = towSum(nums, target); 
		System.out.println(Arrays.toString(result));
		
	}
	
	public static int[] towSum(int[] nums, int target) {
		//given nums = {2, 7, 11, 15}, target = 9;
		//because nums[0] + nums[1] = 9;
		//return [0,1]
		
		
		int[] result = new int[2];
		
		for(int i = 0; i<nums.length - 1; i++) {
			for(int j = i+1; j<nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}
		
		return result;
	}

}
