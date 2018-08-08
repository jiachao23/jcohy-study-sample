package com.jcohy.study.security.AsymmetricAlgorithm;



import com.jcohy.study.security.constans.AsymmetricEnum;
import com.jcohy.study.security.constans.KeyType;
import com.jcohy.study.security.exception.EncryptException;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.interfaces.RSAKey;

/**
 * RSA加密算法
 *
 * @author Looly
 */
public class RSA extends AsymmetricEncryption {

    private static final AsymmetricEnum ALGORITHM_RSA = AsymmetricEnum.RSA;

    // ------------------------------------------------------------------ Constructor start

    /**
     * 构造，创建新的私钥公钥对
     */
    public RSA() {
        super(ALGORITHM_RSA);
    }

    /**
     * 构造 私钥和公钥同时为空时生成一对新的私钥和公钥<br>
     * 私钥和公钥可以单独传入一个，如此则只能使用此钥匙来做加密或者解密
     *
     * @param privateKey 私钥
     * @param publicKey  公钥
     */
    public RSA(byte[] privateKey, byte[] publicKey) {
        super(ALGORITHM_RSA, privateKey, publicKey);
    }
    // ------------------------------------------------------------------ Constructor end

    /**
     * 分组加密
     *
     * @param data    数据
     * @param keyType 密钥类型
     * @return 加密后的密文
     */
    public String encryptStr(String data, KeyType keyType) {
        Key key = getKeyByType(keyType);
        // 模长
        int keyLength = ((RSAKey) key).getModulus().bitLength() / 8;
        StringBuilder sb = new StringBuilder();
        lock.lock();
        try {
            clipher.init(Cipher.ENCRYPT_MODE, key);
            // 加密数据长度 <= 模长-11
            String[] dataArray = split(data, keyLength - 11);
            // 如果明文长度大于模长-11则要分组加密
            for (String s : dataArray) {
                sb.append(BCD.bcdToStr(clipher.doFinal(s.getBytes())));
            }
        } catch (Exception e) {
            throw new EncryptException(e);
        } finally {
            lock.unlock();
        }
        return sb.toString();
    }

    /**
     * 分组解密
     *
     * @param data    数据
     * @param keyType 密钥类型
     * @return 加密后的密文
     */
    public String decryptStr(String data, KeyType keyType) {
        Key key = getKeyByType(keyType);
        // 模长
        int keyLength = ((RSAKey) key).getModulus().bitLength() / 8;
        StringBuilder sb = new StringBuilder();
        lock.lock();
        try {
            clipher.init(Cipher.DECRYPT_MODE, key);
            // 加密数据长度 <= 模长-11
            byte[] bcd = BCD.ascToBcd(data == null ? null : data.getBytes(StandardCharsets.UTF_8));
            // 如果密文长度大于模长则要分组解密
            byte[][] arrays = this.split(bcd, keyLength);
            for (byte[] arr : arrays) {
                byte[] cipherBytes = clipher.doFinal(arr);
                sb.append(new String(cipherBytes, StandardCharsets.UTF_8));
            }
        } catch (Exception e) {
            throw new EncryptException(e);
        } finally {
            lock.unlock();
        }
        return sb.toString();
    }


    /**
     * 拆分字符串
     */
    /**
     * 根据给定长度，将给定字符串截取为多个部分
     *
     * @param str 字符串
     * @param len 每一个小节的长度
     * @return 截取后的字符串数组
     */
    private static String[] split(String str, int len) {
        int partCount = str.length() / len;
        int lastPartCount = str.length() % len;
        int fixPart = 0;
        if (lastPartCount != 0) {
            fixPart = 1;
        }
        final String[] strs = new String[partCount + fixPart];
        for (int i = 0; i < partCount + fixPart; i++) {
            if (i == partCount + fixPart - 1 && lastPartCount != 0) {
                strs[i] = str.substring(i * len, i * len + lastPartCount);
            } else {
                strs[i] = str.substring(i * len, i * len + len);
            }
        }
        return strs;
    }

    /**
     * 拆分byte数组
     *
     * @param array 数组
     * @param len   每个小节的长度
     * @return 拆分后的数组
     */
    private static byte[][] split(byte[] array, int len) {
        int x = array.length / len;
        int y = array.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        byte[][] arrays = new byte[x + z][];
        byte[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new byte[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(array, i * len, arr, 0, y);
            } else {
                System.arraycopy(array, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }
}
