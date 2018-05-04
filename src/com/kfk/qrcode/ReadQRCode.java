package com.kfk.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

//使用QRCode解析二维码
public class ReadQRCode {
	public static void main(String[] args) throws Exception {
		File file = new File("D:/eclipse/qrcode.png");
		
		BufferedImage bufferedImage = ImageIO.read(file);
		
		QRCodeDecoder qrCodeDecoder = new QRCodeDecoder();
		
		String result = new String(qrCodeDecoder.decode(new MyQRCodeImage(bufferedImage)),"gb2312");
		System.out.println(result);
	}
	

}
