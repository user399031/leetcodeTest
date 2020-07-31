package com.ylg.leetcode.search;

import java.util.Random;

/**
 * 猜数字
 * @PROJECT_NAME: yeliguo
 * @DESCRIPTION:
 * @DATE: 2020/7/31 11:01
 */
public class GuessNumber {

    public static void main(String[] args) {
        guessNumber(8645982);
    }

    public static int guessNumber(int n) {
        Random r = new Random(1);
        int pick = r.nextInt(n + 1);
        int left = 0, right = n;
        while (right > left){
            int mid = (right - left) / 2 + left;
            if(mid == pick){
                return mid;
            }else if(mid > pick){
                right = mid;
            }else{
                left = mid;
            }
        }
        return left;
    }
}
