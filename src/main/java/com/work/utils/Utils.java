package com.work.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.alibaba.druid.support.http.util.IPAddress;

public class Utils {

	public static String getWather(){
		HttpClient httpClient = new DefaultHttpClient();
		String url = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js&ip=219.242.98.111";
		InetAddress in = null;
		try {
			in = InetAddress.getLocalHost();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ip = in.getHostAddress();
		String uri = url.replaceAll("219.242.98.111", ip);
		HttpGet get = new HttpGet(uri);
		try {
			HttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			InputStream input = entity.getContent();
			byte[] b = new byte[input.available()];
			input.read(b, 0, b.length);
			return new String(b,0,b.length,"utf-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static void main(String[] args) {
		System.out.println(getWather());
	}
	
	public static String getAddressByIP(String strIP)
	{ 
	  try
	  {
	    URL url = new URL( "http://ip.qq.com/cgi-bin/searchip?searchip1=" + strIP); 
	    URLConnection conn = url.openConnection(); 
	    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK")); 
	    String line = null; 
	    StringBuffer result = new StringBuffer(); 
	    while((line = reader.readLine()) != null)
	    { 
	      result.append(line); 
	    } 
	    reader.close(); 
	    strIP = result.substring(result.indexOf( "该IP所在地为：" ));
	    strIP = strIP.substring(strIP.indexOf( "：") + 1);
	    String province = strIP.substring(6, strIP.indexOf("省"));
	    String city = strIP.substring(strIP.indexOf("省") + 1, strIP.indexOf("市"));
	    return city;
	  }
	  catch( IOException e)
	  { 
	    return "读取失败"; 
	  }
	}
}
