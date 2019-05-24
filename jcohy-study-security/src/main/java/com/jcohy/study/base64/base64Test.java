package com.jcohy.study.base64;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @author jiachao
 *
 */
public class base64Test {

	/**
	 * @param args
	 */
	public static String src="my love";
	public static void main(String[] args) {
		jdkbase64();
		ccbase64();
		BCbase64();
	}
	public static void jdkbase64(){
		try {
			BASE64Encoder encoder =new BASE64Encoder();
			String encode = encoder.encode(src.getBytes());
			System.out.println("JDKencoder："+encode);
			
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decode = decoder.decodeBuffer(encode);
			System.out.println("JDKdecoder:"+new String(decode));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void ccbase64(){
		try {
			Base64 base64 = new Base64();
			byte[] encoderBytes = base64.encode(src.getBytes());
			System.out.println("CCencoder:"+new String(encoderBytes));
			
			byte[] decoderByte = base64.decode(encoderBytes);
			System.out.println("CCdecoder:"+new String(decoderByte));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void BCbase64(){
		try {
			byte[] encoderBytes =org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
			System.out.println("BCencoder:"+new String(encoderBytes));
			byte[] decoderByte =org.bouncycastle.util.encoders.Base64.decode(encoderBytes);
			System.out.println("BCdecoder:"+new String(decoderByte));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
