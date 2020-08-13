package com.ylg.tc;

import java.util.Arrays;
import java.util.Random;

/**
 * @PROJECT_NAME: yeliguo
 * @DESCRIPTION:
 * @DATE: 2020/8/13 11:30
 */
public class tc {

    public static void main(String[] args) {
        Integer[] red = new Integer[5];
        Integer[] blur= new Integer[2];
        for (int i = 0;i<5;i++){
            red = creatNum(red, 34, i);
        }
        for (int i = 0;i<2;i++){
            blur = creatNum(blur, 14, i);
        }
        System.out.println(Arrays.toString(red) + "|" + Arrays.toString(blur));
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
