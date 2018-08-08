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
		jdkMD4();//����ṩ��
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
//			System.out.println("���º�jdkmd5: "+Hex.toHexString(md5bytes2));
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
//			System.out.println("���º�jdkmd2:"+Hex.toHexString(md5bytes2));
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
//			System.out.println("���º�jdkmd2:"+Hex.toHexString(md5bytes2));
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
			MessageDigest instance = MessageDigest.getInstance("MD5");// ��ȡMD5�㷨����
			byte[] digest = instance.digest(password.getBytes());// ���ַ�������,�����ֽ�����

			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				int i = b & 0xff;// ��ȡ�ֽڵĵͰ�λ��Чֵ
				String hexString = Integer.toHexString(i);// ������תΪ16����

				if (hexString.length() < 2) {
					hexString = "0" + hexString;// �����1λ�Ļ�,��0
				}

				sb.append(hexString);
			}

			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			// û�и��㷨ʱ,�׳��쳣, �����ߵ�����
		}

		return "";
	}
	public static void ccMd5(){
		String md5 = DigestUtils.md5Hex(src.getBytes());
		System.out.println("ccmd5:" +md5);
		
	}
}
