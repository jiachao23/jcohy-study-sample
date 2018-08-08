package com.jcohy.study.core;

import java.util.Locale;

/**
 * Created by jiac on 2018/3/21.
 * ClassName  : com.jcohy.lang
 * Description  :
 */
public class EncodeConvertUtils {

    /**
     * 将字节数据转为十六进制编码的数据
     * @param data data to hex encode.
     * @return hex-encoded string.
     */
    public static String toHex(byte[] data) {
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (int i = 0; i < data.length; i++) {
            String hex = Integer.toHexString(data[i]);
            if (hex.length() == 1) {
                // Append leading zero.
                sb.append("0");
            } else if (hex.length() == 8) {
                // Remove ff prefix from negative numbers.
                hex = hex.substring(6);
            }
            sb.append(hex);

        }
        return sb.toString().toLowerCase(Locale.getDefault());
    }

    /**
     * 将一个十六进制编码的数据装换成字节数据
     *
     * @param hexData       hex-encoded data to decode.
     * @return decoded data from the hex string.
     */
    public static byte[] fromHex(String hexData) {
        byte[] result = new byte[(hexData.length() + 1) / 2];
        String hexNumber = null;
        int stringOffset = 0;
        int byteOffset = 0;
        while (stringOffset < hexData.length()) {
            hexNumber = hexData.substring(stringOffset, stringOffset + 2);
            stringOffset += 2;
            result[byteOffset++] = (byte) Integer.parseInt(hexNumber, 16);
        }
        return result;
    }
}
