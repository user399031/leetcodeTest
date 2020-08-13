package com.ylg.tc;

import java.util.*;

/**
 * @PROJECT_NAME: yeliguo
 * @DESCRIPTION:
 * @DATE: 2020/8/13 11:33
 */
public class tc2 {

    public static void main(String[] args) {
        //01 15 22 28 32 03 11
        //大: 35 12 双 33, 16
        //kaiji(6,2, 33,16);
        System.out.print(Arrays.toString(coldHotRed(2)));
        System.out.print("--");
        System.out.print(Arrays.toString(coldHotBlueBigHappy()));
        System.out.println();

    }

    private static Integer[] coldHotRed(int hotCount){
        //上期号码
        Integer[] openRedNum = {1,15,22,28,32};
        Set<Integer> coldRedSet = new HashSet();
        Set<Integer> hotRedSet = new HashSet();
        //全部数据填充
        for(int i = 1; i <= 35; i++){
            coldRedSet.add(i);
        }
        //生成热数组
        for(int i = 0; i < openRedNum.length; i++){
            hotRedSet.add(openRedNum[i]);
            coldRedSet.remove(openRedNum[i]);
            if(openRedNum[i] != 35){
                int temp = openRedNum[i] + 1;
                hotRedSet.add(temp);
                coldRedSet.remove(temp);
            }
            if(openRedNum[i] != 1){
                int temp = openRedNum[i] - 1;
                hotRedSet.add(openRedNum[i] - 1);
                coldRedSet.remove(temp);
            }
        }
        //set转list
        List<Integer> coldRedList = new ArrayList(coldRedSet);
        List<Integer> hotRedList = new ArrayList(hotRedSet);

        //==============================
        Integer[] redCold = new Integer[5 - hotCount];
        Integer[] redHot = new Integer[hotCount];
        if(coldRedList.size() != 0){
            for (int i = 0;i< 5 - hotCount;i++){
                redCold = creatNum(redCold, coldRedList.size(), i);
            }
            for (int i = 0;i< hotCount;i++){
                redHot = creatNum(redHot, hotRedList.size(), i);
            }
        }
        Integer[] redReal = new Integer[5];
        int redRealIndex = 0;
        for (int i = 0; i < redCold.length; i++){
            redReal[redRealIndex] = coldRedList.get(redCold[i] - 1);
            redRealIndex++;
        }
        for (int i = 0; i < redHot.length; i++){
            redReal[redRealIndex] = hotRedList.get(redHot[i] - 1);
            redRealIndex++;
        }
        Arrays.sort(redReal);
        return redReal;
    }

    private static Integer[] coldHotBlueBigHappy(){
        Integer[] blue;
        blue= new Integer[2];
        //天意
        Long startTs = System.currentTimeMillis();
        if(startTs % 3 == 0){
            blue = creatNum(blue, 12, 0);
            blue = creatNum(blue, 12, 1);
            System.out.print("天意->");
        }else{
            blue = creatNum(blue, 6, 0);
            Random random = new Random();
            blue[1] = random.nextInt(6) + 7;
        }
        Arrays.sort(blue);
        return blue;
    }

    private static Integer[] coldHotBlueDouble(){
        Integer[] blue;
        blue= new Integer[1];
        blue = creatNum(blue, 15, 0);
        return blue;
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
