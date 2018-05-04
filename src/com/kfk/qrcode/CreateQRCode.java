package com.kfk.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;
//使用QRCode生成二维码
public class CreateQRCode {

	public static void main(String[] args) throws Exception {
		int versioncode = 7;//版本(1-40)
		int width = 67 + 12*(versioncode -1);
		int height = 67 + 12*(versioncode -1);
		
		Qrcode x = new Qrcode();
		x.setQrcodeErrorCorrect('M');//纠错等级
		x.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其他字符
		x.setQrcodeVersion(versioncode);
		String qrData = "水牛，欢迎来到动物世界";
		
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D gs = bufferedImage.createGraphics();
		
		gs.setBackground(Color.white);
		gs.setColor(Color.black);
		gs.clearRect(0, 0, width, height);
		
		int pixoff = 2;//偏移量
		
		byte[] d = qrData.getBytes("gb2312");
		if(d.length > 0 && d.length < 120) {
			boolean[][] s = x.calQrcode(d);
			
			for(int i = 0; i < s.length; i++) {
				for(int j = 0; j < s.length; j++) {
					if(s[j][i]) {
						gs.fillRect(j*3 + pixoff,i*3 + pixoff, 3, 3);
					}
				}
			}
		}
		
		gs.dispose();
		bufferedImage.flush();
		
		ImageIO.write(bufferedImage, "png", new File("D:/eclipse/qrcode.png"));
	}

}
