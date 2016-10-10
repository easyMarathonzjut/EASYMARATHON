package com.EasyMarathon.other;   
  
import java.awt.AlphaComposite;   
import java.awt.Graphics2D;   
import java.awt.Image;   
import java.awt.RenderingHints;   
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;   
import java.awt.image.ColorConvertOp;
import java.io.File;   
import java.io.FileInputStream;   
import java.io.FileOutputStream;   
import java.io.InputStream;   
import java.io.OutputStream;   
  


import javax.imageio.ImageIO;   
import javax.swing.ImageIcon;

import org.apache.struts2.ServletActionContext;

import com.sun.image.codec.jpeg.JPEGCodec;   
import com.sun.image.codec.jpeg.JPEGImageDecoder;   
import com.sun.image.codec.jpeg.JPEGImageEncoder;   
  
/**  
 * ͼƬˮӡ  
 */  
public class ImageMarkLogoByIcon {   
	public static void main(String args[])
	{
		String srcImgPath="G:/��������/img04.jpg";
		String targerPath="G:/��������/img05.jpg";
		ImageMarkLogoByIcon.Original(srcImgPath, targerPath);
		
	}
	
	
    /**  
     * ��ͼƬ����ˮӡ��������ˮӡͼƬ��ת�Ƕ�  
     * @param iconPath ˮӡͼƬ·��  
     * @param srcImgPath ԴͼƬ·��  
     * @param targerPath Ŀ��ͼƬ·��  
     * @param degree ˮӡͼƬ��ת�Ƕ�  
     */  
    public static void markImageByIcon(String iconPath, String srcImgPath,   
            String targerPath) {   
        OutputStream os = null;   
        
        try {   
            Image srcImg = ImageIO.read(new File(srcImgPath));   
  
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),   
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB); 
            BufferedImage result=null;
         // ˮӡͼ���·�� ˮӡһ��Ϊgif����png�ģ�����������͸����   
            ImageIcon imgIcon = new ImageIcon(iconPath);
            double height=imgIcon.getIconHeight();
            double width=imgIcon.getIconWidth();
            double height1=buffImg.getHeight();
            double width1=buffImg.getWidth();
            if(height/width>height1/width1)
            {
            	height1=height1/width1*width;
            	width1=width;
            	
            }
            else
            {
            	width1=width1/height1*height;
            	height1=height;       	
            }
            result = new BufferedImage((int)width1, (int)height1,  
                    BufferedImage.TYPE_INT_RGB); 
            
           // �õ����ʶ���    
            Graphics2D g = result.createGraphics();   
  
            g.drawImage(srcImg, 0, 0,(int)width1,(int)height1, null);  
            
            // �õ�Image����   
            Image img = imgIcon.getImage();   
  
            // ��ʾˮӡͼƬ��λ��   
            g.drawImage(img, 0, 0, null);   
  
            g.dispose();   
  
            os = new FileOutputStream(targerPath);   
            // ����ͼƬ  
            srcImg.flush();
           
            ImageIO.write(result, "JPG", os);   
            os.flush();
            System.out.println("ͼƬ�������Iconӡ�¡�����������");   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            try {   
                if (null != os)   
                    os.close();   
            } catch (Exception e) {   
                e.printStackTrace();   
            }   
        }   
    }   
    public static void Original(String srcImgPath,   
            String targerPath) {   
        OutputStream os = null;   
        
        try {   
            Image srcImg = ImageIO.read(new File(srcImgPath));   
  
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),   
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB); 
            Graphics2D g = buffImg.createGraphics();   
            
            g.drawImage(srcImg, 0, 0,srcImg.getWidth(null),srcImg.getHeight(null), null);   
  
            g.dispose();   
            os = new FileOutputStream(targerPath);   
            // ����ͼƬ  
            srcImg.flush();
           
            ImageIO.write(buffImg, "JPG", os);   
            os.flush();
            System.out.println("ͼƬ�������Iconӡ�¡�����������");   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            try {   
                if (null != os)   
                    os.close();   
            } catch (Exception e) {   
                e.printStackTrace();   
            }   
        }   
    }   
}  