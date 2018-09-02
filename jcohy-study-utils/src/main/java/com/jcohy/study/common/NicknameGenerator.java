package com.jcohy.study.common;

import java.util.Random;

/**
 * Created by jiac on 2018/8/14.
 * ClassName  : com.star.uums.utils
 * Description  :
 */
public class NicknameGenerator {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";
    public static String nickname(int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }

        return sb.toString();
    }
}
