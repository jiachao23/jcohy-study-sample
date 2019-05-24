package com.jcohy.study.pbe;

import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * @author jiachao
 *
 */
public class PBETest {

	private static String src= "my love";
	public static void main(String[] args) {
		jdkPBE();
	}
	public static void jdkPBE(){
		try {
			//初始化盐
			SecureRandom random = new SecureRandom();
			byte[] salt = random.generateSeed(8);
			
			//口令与密钥
			String password = "mylove";
			PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
			Key key = factory.generateSecret(pbeKeySpec);
			
			//加密
			PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
			Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
			cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdkPBE encrypt :"+Hex.toHexString(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key, pbeParameterSpec);
			result = cipher.doFinal(result);
			System.out.println("jdkPBE encrypt :"+new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
