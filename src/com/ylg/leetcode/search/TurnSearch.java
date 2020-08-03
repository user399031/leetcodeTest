package com.ylg.leetcode.search;

/**
 * @PROJECT_NAME: yeliguo
 * @DESCRIPTION:
 * @DATE: 2020/7/31 16:47
 */
public class TurnSearch {


    public static void main(String[] args) {
        int []nums = {4,5,6,7,8,9,0,1,2};
        int []nums2 = {1,3};
        int []nums3 = {5,1,2,3,4};
       // System.out.println(nums[4] == 1);
        System.out.println(binarySearch(nums2, 3));
    }
    /**
     * 输入: nums = [4,5,6,7,8,9,0,1,2], target = 5
     * 输出: 4
     */
    static int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(target > nums[mid] ) {
                if(nums[mid] > nums[right]){
                    left = mid + 1;
                }else if(nums[right] >= target){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            else{
                if(nums[mid] < nums[left]){
                    right = mid - 1;
                } else if(target < nums[left]){
                   left = mid + 1;
                }else {
                   right = mid - 1;
                }
            }
        }
        // End Condition: left > right
        return -1;
    }
    /**
     * 缺少思考,误打误撞通过 o(*￣▽￣*)ブ
     */



}
