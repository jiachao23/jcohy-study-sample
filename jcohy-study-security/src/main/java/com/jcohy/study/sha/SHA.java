package com.jcohy.study.sha;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.util.encoders.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author jiachao
 *
 */
public class SHA {

	public static String src ="my love";
	public static void main(String[] args) {
		jdkSHA1();
		bcSHA1();
	}
	public static void jdkSHA1(){
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(src.getBytes());
			System.out.println("jdkSHA1:"+org.apache.commons.codec.binary.Hex.encodeHexString(md.digest()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void bcSHA1(){
		try {
			Digest digest = new SHA1Digest();
			digest.update(src.getBytes(), 0, src.getBytes().length);
			byte[] sha1Bytes = new byte[digest.getDigestSize()];
			int a=digest.doFinal(sha1Bytes, 0);
			System.out.println("bcSHA1: "+Hex.toHexString(sha1Bytes));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
