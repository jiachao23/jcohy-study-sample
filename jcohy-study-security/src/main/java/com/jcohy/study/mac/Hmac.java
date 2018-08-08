package com.jcohy.study.mac;

import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author jiachao
 *
 */
public class Hmac {

	public static String src="my love";
	public static void main(String[] args) {
		jdkHmacMD5();
		bcHmacMD5();
	}
	public static void jdkHmacMD5(){
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");//初始化
			SecretKey secretkey = keyGenerator.generateKey();//产生密钥
//			byte[] key = secretkey.getEncoded();//获得密钥
			byte[] key = org.apache.commons.codec.binary.Hex.decodeHex(new char[]{'a',
					'a','a','a','a','a','a','a','a','a'});
			SecretKey restoreKey = new SecretKeySpec(key, "HmacMD5");//还原密钥
			Mac mac = Mac.getInstance(restoreKey.getAlgorithm());//实例化mac
			mac.init(restoreKey);//初始化mac
			byte[] HmacMD5Bytes = mac.doFinal(src.getBytes());//执行摘要
			System.out.println("HmacMD5:"+Hex.toHexString(HmacMD5Bytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void bcHmacMD5(){
		HMac hmac =new HMac(new MD5Digest());
		hmac.init(new KeyParameter(Hex.decode("aaaaaaaaaa")));
		hmac.update(src.getBytes(),0,src.getBytes().length);
		
		byte[] HmacMD5Bytes =  new byte[hmac.getMacSize()];
		hmac.doFinal(HmacMD5Bytes, 0);
		System.out.println("bcHmacMd5:"+Hex.toHexString(HmacMD5Bytes));
	}
}
