package com.jcohy.study.DES;

import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author jiachao
 *
 */
public class DESTest {

	private static String src ="my love";
	public static void main(String[] args) {
		jdkDES();
	}
	public static void jdkDES(){
		try {
			//生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");//3DES为DESede
			keyGenerator.init(56);//3DES为112或168
			SecretKey secreKey = keyGenerator.generateKey();
			byte[] key = secreKey.getEncoded();
			
			//转换key
			DESKeySpec desKeySpec = new DESKeySpec(key);
			SecretKeyFactory factory= SecretKeyFactory.getInstance("DES");
			SecretKey convertsecretKey = factory.generateSecret(desKeySpec);
			
			//加密
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertsecretKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdkDES: encrypt"+Hex.toHexString(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertsecretKey);
			result = cipher.doFinal(result);
			System.out.println("jdkDES decrypt:"+new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
