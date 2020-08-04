package com.ylg.leetcode.search;

/**
 * @PROJECT_NAME: yeliguo
 * @DESCRIPTION:
 * @DATE: 2020/8/4 11:39
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int []nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            int tempRight = mid + 1;
            int tempLeft = mid - 1;
            if (tempRight >= nums.length){
                tempRight = nums.length - 1;
            }
            if (tempLeft < 0){
                tempLeft = 0;
            }
            if(nums[mid] >= nums[tempLeft] && nums[mid] >= nums[tempRight] ){ return mid; }
            else if(nums[mid] > nums[mid - 1]) { left = mid + 1 ; }
            else { right = mid  ; }
        }
        return -1;
    }
}
