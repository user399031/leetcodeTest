package com.ylg.tc;

import java.util.Arrays;
import java.util.Random;

/**
 * @PROJECT_NAME: yeliguo
 * @DESCRIPTION:
 * @DATE: 2020/8/13 11:32
 */
public class tc1 {
    public static void main(String[] args) {
        //大: 35 12 双 33, 16
        for(int i = 0; i < 9; i++){
            kaiji(5,2, 35,12);
        }
    }

    private static void kaiji(int redMaxCount, int blueMaxCount, int redMaxNum, int blueMaxNum){
        Integer[] red;
        Integer[] blue;
        if(redMaxCount != 0){
            red = new Integer[redMaxCount];
            for (int i = 0;i< redMaxCount;i++){
                red = creatNum(red, redMaxNum - 1, i);
            }
            Arrays.sort(red);
            System.out.print(Arrays.toString(red));
        }
        System.out.print("--");
        if(blueMaxCount != 0){
            blue= new Integer[blueMaxCount];
            for (int i = 0;i< blueMaxCount;i++){
                blue = creatNum(blue, blueMaxNum - 1, i);
            }
            Arrays.sort(blue);
            System.out.print(Arrays.toString(blue));
        }
        System.out.println();

    }
    private static Integer[] creatNum(Integer[] obj, Integer count, Integer index){
        Random random = new Random();
        Integer a = random.nextInt(count) + 1;
        boolean need = false;
        for (int i = 0; i< obj.length; i++){
            if (a == obj[i]){
                need = true;
            }
        }
        if (need){
            return creatNum(obj, count, index);
        }else{
            obj[index] = a;
            return  obj;
        }

    }
}
