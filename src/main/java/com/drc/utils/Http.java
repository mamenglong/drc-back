/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/10/26
  Time: 17:52
  To change this template use File | Settings | File Templates.
*/
package com.drc.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http {
    public static Logger LOGGER = LogManager.getLogger();
    public static String init(String url, Object jsonObject) {
        String result = "";
        LOGGER.info("url:"+url);
        LOGGER.info("jsonOB:"+jsonObject.toString());
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            // 设置是否向connection输出，因为这个是post请求，参数要放在 http正文内，因此需要设为true
            connection.setDoOutput(true);
            // Read from the connection. Default is true.
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            //设置长连接
            connection.setRequestProperty("Connection", "keep-Alive");
            //设置字符集
            connection.setRequestProperty("Charset", "utf-8");
            //转换为字节数组
            byte[] data = (jsonObject.toString()).getBytes();
            // 设置文件长度
            connection.setRequestProperty("Content-Length", String.valueOf(data.length));
            // 设置文件类型:
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            OutputStream out = connection.getOutputStream();
            // 写入请求的字符串
            out.write(data);
            out.flush();
            out.close();
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            LOGGER.info("result:" + result);
//            System.out.println("result:" + result);
        } catch (Exception e) {
            LOGGER.error(e.toString());
            result+="{\"error\":\""+e.toString()+"\"";
            e.printStackTrace();
        }
        return result.equals("")?"{}":result;
    }

}
