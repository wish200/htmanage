package com.huiting.manage.action.common;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class requestclient {
	private static final String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成
	private static final String PREFIX = "--";
	private static final String LINE_END = "\r\n";
	private static final String CONTENT_TYPE = "multipart/form-data"; // 内容类型
	private static int requestTime = 0;
	private int readTimeOut = 10 * 1000; // 读取超时
	private int connectTimeout = 10 * 1000; // 超时时间
	private static final String CHARSET = "utf-8"; // 设置编码
	
	
	public static void main(String[] a){
		String result="{\"filepathURL\":\"http://120.132.70.11:8080/huitingimg/f/other/201508/e575d7ad38114dc49eff956e0d479246.mp3\",\"duration\":\"1\",\"type\":\"audio\",\"isorigin\":\"1\"}";
		Gson gson=new Gson();
		Map<String,String> rtn = gson.fromJson(result, new TypeToken<Map<String,String>>(){}.getType());
		String path = rtn.get("filepathURL");
		String duration = rtn.get("duration");
		System.out.println(path+"--"+duration);
	}
	
	public String toUploadSingleFile(File file,String fieldname,String filename, String RequestURL,Map<String, String> param) {
		String result = null;
		requestTime= 0;

		long requestTime = System.currentTimeMillis();
		long responseTime = 0;

		try {
		URL url = new URL(RequestURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setReadTimeout(readTimeOut);
		conn.setConnectTimeout(connectTimeout);
		conn.setDoInput(true); // 允许输入流
		conn.setDoOutput(true); // 允许输出流
		conn.setUseCaches(false); // 不允许使用缓存
		conn.setRequestMethod("POST"); // 请求方式
		conn.setRequestProperty("Charset", CHARSET); // 设置编码
		conn.setRequestProperty("Accept-Charset", CHARSET);
		conn.setRequestProperty("connection", "keep-alive");
		conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
		conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
		// conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		/**
		* 当文件不为空，把文件包装并且上传
		*/
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		StringBuffer sb = null;
		String params = "";

		/***
		* 以下是用于上传参数
		*/
		if (param != null && param.size() > 0) {
			Iterator<String> it = param.keySet().iterator();
				while (it.hasNext()) {
				sb = null;
				sb = new StringBuffer();
				String key = it.next();
				String value = param.get(key);
				sb.append(PREFIX).append(BOUNDARY).append(LINE_END);
				sb.append("Content-Disposition: form-data; name=\"").append(key).append("\"").append(LINE_END).append(LINE_END);
				sb.append(value).append(LINE_END);
				params = sb.toString();
				//Log.i(TAG, key+"="+params+"##");
				System.out.println(params);
				dos.write(params.getBytes());
				// dos.flush();
				}
		}

		sb = null;
		params = null;
		
		/**
		* 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
		* filename是文件的名字，包含后缀名的 比如:abc.png
		*/
		
		//Iterator iter = filemHashMap.entrySet().iterator();
		/*Map.Entry entry = null;
		File file = null;
		String fileKey = "";
		while (iter.hasNext()) {
			sb = new StringBuffer();
			 entry = (Map.Entry) iter.next();
			//Object key = entry.getKey();
			//Object val = entry.getValue();
			 fileKey = entry.getKey().toString();
			 file = new File(entry.getValue().toString());*/
		sb = new StringBuffer();
			 if (file == null || (!file.exists())) {
					System.out.println("文件不存在3");
				    return "file is not exists";
			 }
			 
			 sb.append(PREFIX).append(BOUNDARY).append(LINE_END);
				sb.append("Content-Disposition:form-data; name=\"" + fieldname
				+ "\"; filename=\"" + filename + "\"" + LINE_END);
				//sb.append("Content-Type:image/pjpeg" + LINE_END); // 这里配置的Content-type很重要的 ，用于服务器端辨别文件的类型的
				sb.append("Content-Type:application/octet-stream" + LINE_END); 
				sb.append(LINE_END);
				params = sb.toString();
				sb = null;

				//Log.i(TAG, file.getName()+"=" + params+"##");
				dos.write(params.getBytes());
				/**上传文件*/
				InputStream is = new FileInputStream(file); 
				byte[] bytes = new byte[1024];
				int len = 0;
				int curLen = 0;
				while ((len = is.read(bytes)) != -1) {
				curLen += len;
				dos.write(bytes, 0, len); 
				}
				is.close();

				dos.write(LINE_END.getBytes());
		//}
		
		
		
		byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
		dos.write(end_data);
		dos.flush();
		// 
		// dos.write(tempOutputStream.toByteArray());
		/**
		* 获取响应码 200=成功 当响应成功，获取响应的流
		*/
		int res = conn.getResponseCode();
		responseTime = System.currentTimeMillis();
		this.requestTime = (int) ((responseTime-requestTime)/1000);
		//Log.e(TAG, "response code:" + res);
		if (res == 200) {
			//Log.e(TAG, "request success");
			InputStream input = conn.getInputStream();
			
			/*InputStreamReader isInputStreamReader  = new InputStreamReader(input, "utf-8");
			 BufferedReader reader =  new BufferedReader(isInputStreamReader);
			 String strMessage="";
			 StringBuffer buffer = new StringBuffer();
			 while ((strMessage = reader.readLine()) != null) {
	             buffer.append(strMessage);
	         }
			 System.out.println(UPLOAD_SUCCESS_CODE+ "上传结果："+buffer.toString());
			 */
			StringBuffer sb1 = new StringBuffer();
			int ss;
			while ((ss = input.read()) != -1) {
			sb1.append((char) ss);
			}
			result = sb1.toString();
			//Log.e(TAG, "result : " + result);
			//System.out.println(UPLOAD_SUCCESS_CODE+ "上传结果："+ result);
			return result;
		} else {
			return "upload error";
		}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "upload exception";
		} catch (IOException e) {
			e.printStackTrace();
			return "upload exception";
		}
		}
	
	public String toUploadFile(HashMap<String, String> filemHashMap, String RequestURL,Map<String, String> param) {
			String result = null;
			requestTime= 0;

			long requestTime = System.currentTimeMillis();
			long responseTime = 0;

			try {
			URL url = new URL(RequestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(readTimeOut);
			conn.setConnectTimeout(connectTimeout);
			conn.setDoInput(true); // 允许输入流
			conn.setDoOutput(true); // 允许输出流
			conn.setUseCaches(false); // 不允许使用缓存
			conn.setRequestMethod("POST"); // 请求方式
			conn.setRequestProperty("Charset", CHARSET); // 设置编码
			conn.setRequestProperty("Accept-Charset", CHARSET);
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
			// conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			/**
			* 当文件不为空，把文件包装并且上传
			*/
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			StringBuffer sb = null;
			String params = "";

			/***
			* 以下是用于上传参数
			*/
			if (param != null && param.size() > 0) {
				Iterator<String> it = param.keySet().iterator();
					while (it.hasNext()) {
					sb = null;
					sb = new StringBuffer();
					String key = it.next();
					String value = param.get(key);
					sb.append(PREFIX).append(BOUNDARY).append(LINE_END);
					sb.append("Content-Disposition: form-data; name=\"").append(key).append("\"").append(LINE_END).append(LINE_END);
					sb.append(value).append(LINE_END);
					params = sb.toString();
					//Log.i(TAG, key+"="+params+"##");
					System.out.println(params);
					dos.write(params.getBytes());
					// dos.flush();
					}
			}

			sb = null;
			params = null;
			
			/**
			* 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
			* filename是文件的名字，包含后缀名的 比如:abc.png
			*/
			
			Iterator iter = filemHashMap.entrySet().iterator();
			Map.Entry entry = null;
			File file = null;
			String fileKey = "";
			while (iter.hasNext()) {
				sb = new StringBuffer();
				 entry = (Map.Entry) iter.next();
				//Object key = entry.getKey();
				//Object val = entry.getValue();
				 fileKey = entry.getKey().toString();
				 file = new File(entry.getValue().toString());
				 if (file == null || (!file.exists())) {
						System.out.println("文件不存在3");
					    return "file is not exists";
				 }
				 
				 sb.append(PREFIX).append(BOUNDARY).append(LINE_END);
					sb.append("Content-Disposition:form-data; name=\"" + fileKey
					+ "\"; filename=\"" + file.getName() + "\"" + LINE_END);
					//sb.append("Content-Type:image/pjpeg" + LINE_END); // 这里配置的Content-type很重要的 ，用于服务器端辨别文件的类型的
					sb.append("Content-Type:application/octet-stream" + LINE_END); 
					sb.append(LINE_END);
					params = sb.toString();
					sb = null;

					//Log.i(TAG, file.getName()+"=" + params+"##");
					dos.write(params.getBytes());
					/**上传文件*/
					InputStream is = new FileInputStream(file); 
					byte[] bytes = new byte[1024];
					int len = 0;
					int curLen = 0;
					while ((len = is.read(bytes)) != -1) {
					curLen += len;
					dos.write(bytes, 0, len); 
					}
					is.close();

					dos.write(LINE_END.getBytes());
			}
			
			
			
			byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
			dos.write(end_data);
			dos.flush();
			// 
			// dos.write(tempOutputStream.toByteArray());
			/**
			* 获取响应码 200=成功 当响应成功，获取响应的流
			*/
			int res = conn.getResponseCode();
			responseTime = System.currentTimeMillis();
			this.requestTime = (int) ((responseTime-requestTime)/1000);
			//Log.e(TAG, "response code:" + res);
			if (res == 200) {
				//Log.e(TAG, "request success");
				InputStream input = conn.getInputStream();
				
				/*InputStreamReader isInputStreamReader  = new InputStreamReader(input, "utf-8");
				 BufferedReader reader =  new BufferedReader(isInputStreamReader);
				 String strMessage="";
				 StringBuffer buffer = new StringBuffer();
				 while ((strMessage = reader.readLine()) != null) {
		             buffer.append(strMessage);
		         }
				 System.out.println(UPLOAD_SUCCESS_CODE+ "上传结果："+buffer.toString());
				 */
				StringBuffer sb1 = new StringBuffer();
				int ss;
				while ((ss = input.read()) != -1) {
				sb1.append((char) ss);
				}
				result = sb1.toString();
				//Log.e(TAG, "result : " + result);
				//System.out.println(UPLOAD_SUCCESS_CODE+ "上传结果："+ result);
				return result;
			} else {
				return "upload error";
			}
			} catch (MalformedURLException e) {
				e.printStackTrace();
				return "upload exception";
			} catch (IOException e) {
				e.printStackTrace();
				return "upload exception";
			}
			}
}
