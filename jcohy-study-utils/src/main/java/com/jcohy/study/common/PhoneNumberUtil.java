package com.jcohy.study.common;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.Phonenumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhoneNumberUtil {
    private static Logger logger = LoggerFactory.getLogger(PhoneNumberUtil.class);

    /**
     * 格式化手机号
     * @param countryCode       手机号国家码,如中国为 86
     * @param nationalNumber     手机号本地号码, 如 13811112222
     * @return
     */
    public static String formatPhoneNumber(Integer countryCode, String nationalNumber){
        if(StringUtils.isBlank(nationalNumber)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        com.google.i18n.phonenumbers.PhoneNumberUtil phoneUtil = com.google.i18n.phonenumbers.PhoneNumberUtil.getInstance();
        try {
            String region = phoneUtil.getRegionCodeForCountryCode(countryCode);

            Phonenumber.PhoneNumber swissNumberProto = phoneUtil.parse(nationalNumber, region);

            sb.append(swissNumberProto.getCountryCode()).append(swissNumberProto.getNationalNumber());
            return sb.toString();
        } catch (NumberParseException e) {
            logger.error("NumberParseException was thrown: ", e);

            if(nationalNumber.startsWith("0")) {
                nationalNumber = nationalNumber.substring(1);
            }
            nationalNumber = nationalNumber.replaceAll("\\s*", "");
            if(countryCode != null) {
                sb.append(countryCode);
            }
            sb.append(nationalNumber);
        }
        return sb.toString();
    }

    /**
     * 格式化手机号
     * @param region            国家,如中国为 CN
     * @param nationalNumber     手机号本地号码, 如 13811112222
     * @return
     */
    public static String formatPhoneNumber(String region, String nationalNumber){
        if(StringUtils.isBlank(nationalNumber)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        com.google.i18n.phonenumbers.PhoneNumberUtil phoneUtil = com.google.i18n.phonenumbers.PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber swissNumberProto = phoneUtil.parse(nationalNumber, region);
            sb.append(swissNumberProto.getCountryCode()).append(swissNumberProto.getNationalNumber());
            return sb.toString();
        } catch (NumberParseException e) {
            logger.error("NumberParseException was thrown: ", e);

            if(nationalNumber.startsWith("0")) {
                nationalNumber = nationalNumber.substring(1);
            }
            nationalNumber = nationalNumber.replaceAll("\\s*", "");
            sb.append(nationalNumber);
        }
        return sb.toString();
    }

    /**
     * 判断手机号是否为某个国家的手机号
     * @param region            国家,如中国为 CN
     * @param countryCode       手机号国家码,如中国为 86
     * @param nationalNumber    手机号本地号码, 如 13811112222
     * @return                  所输入的手机号（countryCode+nationalNumbe）是否为region所示的国家的手机号
     */
    public static boolean isValidNumberForRegion(String region, Integer countryCode, String nationalNumber) {
        com.google.i18n.phonenumbers.PhoneNumberUtil phoneUtil = com.google.i18n.phonenumbers.PhoneNumberUtil.getInstance();
        boolean result = false;
        try {
            String defaultRegion = phoneUtil.getRegionCodeForCountryCode(countryCode);

            Phonenumber.PhoneNumber swissNumberProto = phoneUtil.parse(nationalNumber, defaultRegion);

            result = phoneUtil.isValidNumberForRegion(swissNumberProto, region);

        } catch (NumberParseException e) {
            logger.error("NumberParseException was thrown: ", e);
        }
        return result;
    }

    public static boolean isValidNumber(Integer countryCode, String nationalNumber) {
        com.google.i18n.phonenumbers.PhoneNumberUtil phoneUtil = com.google.i18n.phonenumbers.PhoneNumberUtil.getInstance();
        boolean result = false;
        try {
            String defaultRegion = phoneUtil.getRegionCodeForCountryCode(countryCode);
            Phonenumber.PhoneNumber numberProto = phoneUtil.parse(nationalNumber, defaultRegion);
            result = phoneUtil.isValidNumberForRegion(numberProto, defaultRegion);
        } catch (NumberParseException e) {
            logger.error("NumberParseException was thrown: ", e);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(formatPhoneNumber(86, "0138 1111 000"));   //output 8613811110000
        System.out.println(formatPhoneNumber(99, "0138 1111 0000"));   //output 8613811110000
        System.out.println(formatPhoneNumber("CN", "0138 1111 0000"));      //output 8613811110000
        System.out.println(isValidNumberForRegion("CN", 86,"1381111000"));   //output false
        System.out.println(isValidNumber(86, "0138 111 00000"));    //output true
        System.out.println(isValidNumber(86, "0138 111 0000"));    //output false
    }
}
