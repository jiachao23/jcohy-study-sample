package com.jcohy.study.common;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiac on 2018/8/14.
 * ClassName  : com.star.uums.utils
 * Description  :
 */
public class Validator {

    private static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)"
                    + "+[\\w](?:[\\w-]*[\\w])?");

    // 6 -- 18 位字母数字组合
    private static final Pattern USERNAME_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._-]{6,18}$");

    /**
     *
     * 要求字母、数字、字符任意两种组合即可
     * ^(?![0-9]+$)(?![a-zA-Z]+$)[A-Za-z0-9\\W]{6,18}$
     * 6 -- 18 位字母数字组合密码
     */
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9]{6,18}$");

    private Validator() {
    }

    /**
     * Returns <code>true</code> if the string is a valid email address.
     *
     * @param  email the string to check
     * @return <code>true</code> if the string is a valid email address;
     *         <code>false</code> otherwise
     */
    public static boolean isEmail(String email) {
        if (Objects.isNull(email)) {
            return false;
        }


        Matcher matcher = EMAIL_ADDRESS_PATTERN.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidateUsername(String username) {
        if (Objects.isNull(username)) {
            return false;
        }

        Matcher matcher = USERNAME_PATTERN.matcher(username);
        return matcher.matches();
    }

    public static boolean isValidatePassword(String password) {
        if (Objects.isNull(password)) {
            return false;
        }

        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isEmail("jiac@163"));
        System.out.println(isEmail("jiac@163.com"));
        System.out.println(isEmail("jiac@163.com.cn"));
        System.out.println(isValidatePassword("123456") + ", expect true");
        System.out.println(isValidatePassword("54321") + ", expect false");
        System.out.println(isValidatePassword("1231231231231231231") + ", expect false");
        System.out.println(isValidatePassword("abc def") + ", expect false");
        System.out.println(isValidatePassword("abcde ") + ", expect false");
        System.out.println(isValidatePassword("abcdefghijklmnopqrstuvwxyz") + ", expect false");
        System.out.println(isValidatePassword("Ae123hj") + ", expect true");
    }
}
