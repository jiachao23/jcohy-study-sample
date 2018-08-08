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
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");//��ʼ��
			SecretKey secretkey = keyGenerator.generateKey();//������Կ
//			byte[] key = secretkey.getEncoded();//�����Կ
			byte[] key = org.apache.commons.codec.binary.Hex.decodeHex(new char[]{'a',
					'a','a','a','a','a','a','a','a','a'});
			SecretKey restoreKey = new SecretKeySpec(key, "HmacMD5");//��ԭ��Կ
			Mac mac = Mac.getInstance(restoreKey.getAlgorithm());//ʵ����mac
			mac.init(restoreKey);//��ʼ��mac
			byte[] HmacMD5Bytes = mac.doFinal(src.getBytes());//ִ��ժҪ
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
