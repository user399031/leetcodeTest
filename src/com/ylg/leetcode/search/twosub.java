package com.ylg.leetcode.search;

import java.util.Arrays;

/**
 * 二分法练习
 * @PROJECT_NAME: yeliguo
 * @DESCRIPTION:
 * @DATE: 2020/7/30 15:51
 */
public class twosub {
    public static void main(String[] args) {
        int []nums = {2,3, 5};
        System.out.println(search(nums, 5));
    }

    public static int search(int[] nums, int target) {
        return search2(nums,target, 0);
    }

    public static int search2(int[] nums, int target, int indexSum) {
        int index = nums.length/2;
        if(nums.length == 2 && target != nums[0] && target != nums[1]){
            return -1;
        }
        if(nums.length == 1 && target != nums[0]){
            return -1;
        }
        if(nums[index] > target){
            int[] newData = Arrays.copyOfRange(nums,0,index);
            return search2(newData, target, indexSum);
        }else if(nums[index] == target){
            return indexSum + index;
        }else{
            int[] newData = Arrays.copyOfRange(nums,index, nums.length);
            indexSum = indexSum + index;
            return search2(newData, target, indexSum);
        }
    }
}
