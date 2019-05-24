package com.jcohy.study.aes;

import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * @author jiachao
 *
 */
public class AESTest {
	private static String src ="my love";
	public static void main(String[] args) {
		jdkAES();
	}
	public static void jdkAES(){
		try {
			//生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(new SecureRandom());
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();
			
			//key转换
			Key key = new SecretKeySpec(keyBytes, "AES");
			//加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk AES encrpyt: "+Hex.toHexString(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			 result = cipher.doFinal(result);
			 System.out.println("jdk AES decrpyt: "+new String(result));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
