package main.java.api;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
 * 
 */
public class RestApiInvoke {

    private void getApiInvoke(String url) throws IOException {

        URL url1=new URL(url);
        HttpURLConnection connection= (HttpURLConnection) url1.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestMethod("GET");

        connection.setConnectTimeout(1000);

        InputStream responseStream =connection.getInputStream();
        ObjectMapper objectMapper=new ObjectMapper();

        RestPojo val=objectMapper.readValue(responseStream,RestPojo.class);
        connection.disconnect();
        System.out.println(val);
        System.out.println("Date :"+val.getDate());
    }

    public static void main(String[] args) throws IOException {
        RestApiInvoke restApiInvoke=new RestApiInvoke();
        restApiInvoke.getApiInvoke("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
    }
}
