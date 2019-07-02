//package com.jcohy.study.core;
//
//
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
///**
// * 制作图片缩略图
// *
// *
// *
// */
//public class PicUtils {
//	private String srcFile;
//	private String destFile;
//	private int width;
//	private int height;
//	private Image img;
//
//	/**
//	 * 构造函数
//
//	 *
//	 * @param fileName
//	 *            String
//	 * @throws IOException
//	 */
//	public PicUtils(String fileName) throws IOException {
//		File _file = new File(fileName); // 读入文件
//		this.srcFile = fileName;
//		// 查找最后一个.
//		int index = this.srcFile.lastIndexOf(".");
//		String ext = this.srcFile.substring(index);
//		this.destFile = this.srcFile.substring(0, index) + "_s" + ext;
//		img = javax.imageio.ImageIO.read(_file); // 构造Image对象
//		width = img.getWidth(null); // 得到源图宽
//		height = img.getHeight(null); // 得到源图长
//	}
//
//	/**
//	 * 强制压缩/放大图片到固定的大小
//	 *
//	 * @param w
//	 *            int 新宽度
//	 * @param h
//	 *            int 新高度
//	 * @throws IOException
//	 */
//	public void resize(int w, int h) throws IOException {
//		BufferedImage _image = new BufferedImage(w, h,
//				BufferedImage.TYPE_INT_RGB);
//		_image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
//		FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//		encoder.encode(_image); // 近JPEG编码
//		out.close();
//	}
//
//	/**
//	 * 按照固定的比例缩放图片
//	 *
//	 * @param t
//	 *            double 比例
//	 * @throws IOException
//	 */
//	public void resize(double t) throws IOException {
//		int w = (int) (width * t);
//		int h = (int) (height * t);
//		resize(w, h);
//	}
//
//	/**
//	 * 以宽度为基准，等比例放缩图片
//	 *
//	 * @param w
//	 *            int 新宽度
//	 * @throws IOException
//	 */
//	public void resizeByWidth(int w) throws IOException {
//		int h = (int) (height * w / width);
//		resize(w, h);
//	}
//
//	/**
//	 * 以高度为基准，等比例缩放图片
//	 *
//	 * @param h
//	 *            int 新高度
//	 * @throws IOException
//	 */
//	public void resizeByHeight(int h) throws IOException {
//		int w = (int) (width * h / height);
//		resize(w, h);
//	}
//
//	/**
//	 * 按照最大高度限制，生成最大的等比例缩略图
//	 *
//	 * @param w
//	 *            int 最大宽度
//	 * @param h
//	 *            int 最大高度
//	 * @throws IOException
//	 */
//	public void resizeFix(int w, int h) throws IOException {
//		if (width / height > w / h) {
//			resizeByWidth(w);
//		} else {
//			resizeByHeight(h);
//		}
//	}
//
//	/**
//	 * 设置目标文件名 setDestFile
//	 *
//	 * @param fileName
//	 *            String 文件名字符串
//	 */
//	public void setDestFile(String fileName) throws Exception {
//		if (!fileName.endsWith(".jpg")) {
//			throw new Exception("Dest File Must end with \".jpg\".");
//		}
//		destFile = fileName;
//	}
//
//	/**
//	 * 获取目标文件名 getDestFile
//	 */
//	public String getDestFile() {
//		return destFile;
//	}
//
//	/**
//	 * 获取图片原始宽度 getSrcWidth
//	 */
//	public int getSrcWidth() {
//		return width;
//	}
//
//	/**
//	 * 获取图片原始高度 getSrcHeight
//	 */
//	public int getSrcHeight() {
//		return height;
//	}
//
//
//}
