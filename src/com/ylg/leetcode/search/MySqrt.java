package com.ylg.leetcode.search;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @PROJECT_NAME: yeliguo
 * @DESCRIPTION:
 * @DATE: 2020/7/30 16:11
 */
public class MySqrt {

    public static void main(String[] args) {
        System.out.println(binarySearch(4));
    }


    static int binarySearch(int x){
        int left = 0, right = x;
        while(left < right){
            // Prevent (left + right) overflow
            int mid = (right - left) / 2 + left;
            int befor = mid * mid;
            boolean flag = true;
            if(befor < x){
                flag = true;
            }
            long temp = Long.valueOf(mid ) *  Long.valueOf(mid );
            if(temp > Long.valueOf(x) ){
                //如果负数说明越界肯定大了
                flag = false;
            }
            if(befor == x || left + 1 == right){ return mid; }
            else if(flag) { left = mid; }
            else { right = mid; }
        }
        // End Condition: left > right
        return right;
    }
}
