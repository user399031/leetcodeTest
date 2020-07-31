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
    //------------回答
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
    //------------答案
    /**
     * 关键属性
     *
     * 二分查找的最基础和最基本的形式。
     * 查找条件可以在不与元素的两侧进行比较的情况下确定（或使用它周围的特定元素）。
     * 不需要后处理，因为每一步中，你都在检查是否找到了元素。如果到达末尾，则知道未找到该元素。
     *
     *
     * 区分语法
     *
     * 初始条件：left = 0, right = length-1
     * 终止：left > right
     * 向左查找：right = mid-1
     * 向右查找：left = mid+1
     */
    int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while(left <= right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }

        // End Condition: left > right
        return -1;
    }

}
