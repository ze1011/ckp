package com.vg.ckp.utils;

import android.content.Context;
import android.content.res.Resources.NotFoundException;

import com.vg.ckp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Properties;

public class MessageHelper {

	private HashMap<String , String> urls = new HashMap<String, String>();
	public static final String POST_URL_MENU = "POST_URL_MENU";
	public static final String LOGIN_URL = "LOGIN_URL";
	public static final String BASE_URL = "BASE_URL";
	public static final String BASE_HOST = "BASE_HOST";
	public static final String FORGOT_PWD_URL = "FORGOT_PWD_URL";
	public static final String REG_URL = "REG_URL";
	public static final String CART_URL = "CART_URL";
	private static final String APK_VERSION_URL = "APK_VERSION_URL";
	public static final String POST_URL_COUNTRISAPI = "POST_URL_COUNTRISAPI";
	public static final String URL_LINE_SERVICES = "URL_LINE_SERVICES";
	public static final String URL_TERMS = "URL_TERMS";
	private static final String APK_WELCOME_IMG_URL = "APK_WELCOME_IMG_URL";
	

	public MessageHelper (Context context) {
//		try {
//			Properties p = new Properties();
//			p.load(context.getResources().openRawResource(R.raw.system));
//			urls.put(POST_URL_MENU, p.getProperty(POST_URL_MENU));
//			urls.put(LOGIN_URL, p.getProperty(LOGIN_URL));
//			urls.put(BASE_URL, p.getProperty(BASE_URL));
//			urls.put(BASE_HOST, p.getProperty(BASE_HOST));
//			urls.put(REG_URL, p.getProperty(REG_URL));
//			urls.put(FORGOT_PWD_URL, p.getProperty(FORGOT_PWD_URL));
//			urls.put(CART_URL, p.getProperty(CART_URL));
//			urls.put(APK_VERSION_URL, p.getProperty(APK_VERSION_URL));
//			urls.put(POST_URL_COUNTRISAPI, p.getProperty(POST_URL_COUNTRISAPI));
//			urls.put(URL_LINE_SERVICES, p.getProperty(URL_LINE_SERVICES));
//			urls.put(URL_TERMS, p.getProperty(URL_TERMS));
//			urls.put(APK_WELCOME_IMG_URL, p.getProperty(APK_WELCOME_IMG_URL));
//		} catch (NotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}


	/**
	 * Http方式请求接口
	 * 
	 * @param key
	 * @return
	 */
	public String sendPost(String key) {
		try {
			HttpURLConnection httpcon = (HttpURLConnection) ((new URL(urls.get(key)).openConnection()));
			httpcon.setDoOutput(true);
			httpcon.setRequestProperty("Content-Type", "application/json");
			httpcon.setRequestProperty("Accept", "application/json");
			httpcon.setRequestProperty("contentType", "utf-8");  
			httpcon.setRequestMethod("POST");
			httpcon.connect();

			int status = httpcon.getResponseCode();
			if (status != 200) {
				throw new IOException("Post failed with error code " + status);
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					httpcon.getInputStream() ,"utf-8"));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			
			System.out.println(sb.toString());
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *
	 * @return
	 */
	public String sendPostGetWelComeImg() {
		try {
			URL url = new URL(urls.get(APK_WELCOME_IMG_URL));
			if (url == null) {
				return null;
			}
			URLConnection urlConnection = url.openConnection();
			if (urlConnection == null) {
				return null;
			}
			HttpURLConnection httpcon = (HttpURLConnection) (urlConnection);
			httpcon.setDoOutput(true);
			httpcon.setRequestProperty("Content-Type", "application/json");
			httpcon.setRequestProperty("Accept", "application/json");
			httpcon.setRequestProperty("contentType", "utf-8");
			httpcon.setConnectTimeout(3 * 1000);
			httpcon.setRequestMethod("GET");
			httpcon.connect();
			
			int status = httpcon.getResponseCode();
			if (status == 302) {
				String location = httpcon.getHeaderField("Location");
				url = new URL(location);
				urlConnection = url.openConnection();
				if (urlConnection == null) {
					return null;
				}
				httpcon = (HttpURLConnection) (urlConnection);
				httpcon.setDoOutput(true);
				httpcon.setInstanceFollowRedirects(false);
				httpcon.setRequestProperty("Content-Type", "application/json");
				httpcon.setRequestProperty("Accept", "application/json");
				httpcon.setRequestProperty("contentType", "utf-8");
				httpcon.setConnectTimeout(3 * 1000);
				httpcon.setRequestMethod("GET");
				httpcon.connect();
			} else if (status != 200) {
				throw new IOException("Get failed with error code " + status);
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					httpcon.getInputStream() ,"utf-8"));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *
	 * @return
	 */
	public String sendPostGetVersion() {
		try {
			URL url = new URL(urls.get(APK_VERSION_URL));
			if (url == null) {
				return null;
			}
			URLConnection urlConnection = url.openConnection();
			if (urlConnection == null) {
				return null;
			}
			HttpURLConnection httpcon = (HttpURLConnection) (urlConnection);
			httpcon.setDoOutput(true);
			httpcon.setInstanceFollowRedirects(false);
			httpcon.setRequestProperty("Content-Type", "application/json");
			httpcon.setRequestProperty("Accept", "application/json");
			httpcon.setRequestProperty("contentType", "utf-8");
			httpcon.setConnectTimeout(3 * 1000);
			httpcon.setRequestMethod("GET");
			httpcon.connect();

			int status = httpcon.getResponseCode();
			if (status == 302) {
				String location = httpcon.getHeaderField("Location");
				url = new URL(location);
				urlConnection = url.openConnection();
				if (urlConnection == null) {
					return null;
				}
				httpcon = (HttpURLConnection) (urlConnection);
				httpcon.setDoOutput(true);
				httpcon.setInstanceFollowRedirects(false);
				httpcon.setRequestProperty("Content-Type", "application/json");
				httpcon.setRequestProperty("Accept", "application/json");
				httpcon.setRequestProperty("contentType", "utf-8");
				httpcon.setConnectTimeout(3 * 1000);
				httpcon.setRequestMethod("GET");
				httpcon.connect();
				
				
			} else if (status != 200) {
				throw new IOException("Post failed with error code " + status);
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					httpcon.getInputStream() ,"utf-8"));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * @return the urls
	 */
	public HashMap<String, String> getUrls() {
		return urls;
	}

	
	
//	/**
//	 * 调用webservice
//	 * 
//	 * @param json
//	 * @return
//	 */
//	public String sendMsg(String json) {
//		try {
//			SoapObject rpc = new SoapObject(NAMESPACE, METHOD_NAME);
//			rpc.addProperty("arg0", json);
//
//			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//					SoapEnvelope.VER11);
//			envelope.dotNet = false;
//			envelope.encodingStyle = "UTF-8";
//			envelope.setOutputSoapObject(rpc);
//			new MarshalBase64().register(envelope);
//			HttpTransportSE aht = new HttpTransportSE(URL, 60 * 1000);
//
//			aht.call(SOAP_ACTION, envelope);
//			Object result = (Object) envelope.getResponse();
//			Log.d(TAG, result.toString());
//			return String.valueOf(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
