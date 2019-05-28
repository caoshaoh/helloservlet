package test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
			String str="李白";
			/*
			 * encode方法:按照指定的字符集进行编码,然后将
			 * 编码之后生成的字节,转换成对应的十六进制形式
			 */
			String str1=URLEncoder.encode(str,"utf-8");
			System.out.println("str1:"+str1);
			/*
			 * decode方法:按照指定的字符集进行解码
			 */
			String str2=URLDecoder.decode(str1,"utf-8");
			System.out.println("str2:"+str2);
	}
}
