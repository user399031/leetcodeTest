package com.ylg.leetcode;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @PROJECT_NAME: yeliguo
 * @DESCRIPTION:
 * @DATE: 2020/8/1 14:15
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(nicknameTranscoding("5bmz6Z2Z5LiK54+t5peP"));;
    }

    public static String nicknameTranscoding(String name){
        byte[] list = Base64.getDecoder().decode(name);
        String nickname = new String(list, Charset.forName("UTF-8"));
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < nickname.length(); i++) {
            char current = nickname.charAt(i);
            if (!("\\u" + Integer.toHexString(current)).equals("\\ufffd")) {
                out.append(current);
            }
        }
        nickname = out.toString() + "推荐给你好物";
        return nickname;
    }
}
