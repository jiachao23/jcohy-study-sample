package com.jcohy.study.md5;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @author jiachao
 *
 */
public class MD5Test {
	public static String src="my love";
	public static void main(String[] args) {
		jdkMD5();
		System.out.println("encode:"+encode(src));
		jdkMD2();
		jdkMD4();//添加提供者
		BCMD4();
		BCMD2();
		BCMD5();
		ccMd5();
	}
	public static void jdkMD5(){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5bytes = md.digest(src.getBytes());
			System.out.println("jdkmd5: "+Hex.toHexString(md5bytes));
//			md.update("ni".getBytes());
//			byte[] md5bytes2 = md.digest();
//			System.out.println("更新后jdkmd5: "+Hex.toHexString(md5bytes2));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void jdkMD2(){
		try {
			MessageDigest md = MessageDigest.getInstance("MD2");
			byte[] md5bytes = md.digest(src.getBytes());
			System.out.println("jdkmd2: "+Hex.toHexString(md5bytes));
//			md.update("ni".getBytes());
//			byte[] md5bytes2 = md.digest();
//			System.out.println("更新后jdkmd2:"+Hex.toHexString(md5bytes2));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void jdkMD4(){
		Security.addProvider(new BouncyCastleProvider());
		try {
			MessageDigest md = MessageDigest.getInstance("MD4");
			System.out.println(md.getProvider());
			byte[] md5bytes = md.digest(src.getBytes());
			System.out.println("jdkmd4: "+Hex.toHexString(md5bytes));
//			md.update("ni".getBytes());
//			byte[] md5bytes2 = md.digest();
//			System.out.println("更新后jdkmd2:"+Hex.toHexString(md5bytes2));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void BCMD4(){
		try {
			Digest digest = new MD4Digest();
			digest.update(src.getBytes(), 0, src.getBytes().length);
			byte[] md4bytes = new byte[digest.getDigestSize()];
			digest.doFinal(md4bytes, 0);
			System.out.println("BCmd4: "+Hex.toHexString(md4bytes));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void BCMD5(){
		try {
			Digest digest = new MD5Digest();
			digest.update(src.getBytes(), 0, src.getBytes().length);
			byte[] md5bytes = new byte[digest.getDigestSize()];
			digest.doFinal(md5bytes, 0);
			System.out.println("BCmd5: "+Hex.toHexString(md5bytes));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void BCMD2(){
		try {
			Digest digest = new MD2Digest();
			digest.update(src.getBytes(), 0, src.getBytes().length);
			byte[] md2bytes = new byte[digest.getDigestSize()];
			digest.doFinal(md2bytes, 0);
			System.out.println("BCmd2: "+Hex.toHexString(md2bytes));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String encode(String password) {
		try {
			MessageDigest instance = MessageDigest.getInstance("MD5");// 获取MD5算法对象
			byte[] digest = instance.digest(password.getBytes());// 对字符串加密,返回字节数组

			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				int i = b & 0xff;// 获取字节的低八位有效值
				String hexString = Integer.toHexString(i);// 将整数转为16进制

				if (hexString.length() < 2) {
					hexString = "0" + hexString;// 如果是1位的话,补0
				}

				sb.append(hexString);
			}

			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			// 没有该算法时,抛出异常, 不会走到这里
		}

		return "";
	}
	public static void ccMd5(){
		String md5 = DigestUtils.md5Hex(src.getBytes());
		System.out.println("ccmd5:" +md5);
		
	}
}
