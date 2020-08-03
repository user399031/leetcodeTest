package com.ylg.leetcode.search;

/**
 * @PROJECT_NAME: yeliguo
 * @DESCRIPTION:
 * @DATE: 2020/8/3 16:16
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(1));
    }

    public static int firstBadVersion(int n) {
        int left = 0, right = n;
        boolean check_mid;
        boolean check_mid_befor;
        while(left < right){
            int mid = left + (right - left) / 2;
            check_mid = isBadVersion(mid);
            check_mid_befor = !isBadVersion(mid - 1);
            // Prevent (left + right) overflow
            if(check_mid && check_mid_befor){ return mid; }
            else if(check_mid){
                right = mid;
            } else { left = mid + 1; }
        }
        // Post-processing:
        // End Condition: left == right
        if(left == n && isBadVersion(left) && !isBadVersion(left - 1)) return left;
        return -1;
    }

    public static boolean isBadVersion(int version){
        if(version >= 1){
            return true;
        }else{
            return false;
        }
    }
}
