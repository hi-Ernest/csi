package edu.team.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**   
 * @ClassName: MD5Util   
 * @Description: MD5加密工具类
 * @author: lgaoyi
 * @date: 2017年11月10日 上午12:46:16   
 *     
 */  
public class MD5Util {
	
	protected static final Logger logger = LoggerFactory.getLogger(MD5Util.class);
	
	public static String getMD5_16(String plainText) {
		String md5_16bit = null;
		try {
			md5_16bit = getMD5_32(plainText).substring(8, 24);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return md5_16bit;
	}
	
	public static String getMD5_32(String plainText) {
		String md5_32bit = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			md5_32bit = buf.toString();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return md5_32bit;
	}
	
	public static void main(String[] args) {
		System.out.println(MD5Util.getMD5_16("e10adc3949ba59abbe56e057f20f883e"));
		System.out.println(MD5Util.getMD5_32("123456"));
	}
	
}
