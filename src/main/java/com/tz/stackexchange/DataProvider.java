package com.tz.stackexchange;

import com.tz.stackexchange.model.StackExchange;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@RestController
public class DataProvider {

  public static StackExchange getStackExchange(String title) {
    try {
      String json = sendGet(title);

      ObjectMapper mapper = new ObjectMapper();
      StackExchange stackExchange = mapper.readValue(json, StackExchange.class);

      System.out.print(stackExchange.getItems().size());

      return stackExchange;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private static String sendGet(String title) throws Exception {
    String url = "http://api.stackexchange.com/2.2/search?order=desc&sort=activity&site=stackoverflow&intitle=";
    String answer = "";
    String fullUrl = "";

    if ((title == null) || (title.isEmpty())) {
      return answer;
    }

    fullUrl = url + title;

    try {
      URL obj = new URL(fullUrl);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      con.setRequestMethod("GET");
      con.setRequestProperty("Accept-Encoding", "gzip");
      con.setRequestProperty("Content-Type", "application/StackExchange; charset=utf-8");

      con.setRequestProperty("User-Agent", USER_AGENT);

      int responseCode = con.getResponseCode();
      System.out.println("\nSending 'GET' request to URL : " + fullUrl);
      System.out.println("Response Code : " + responseCode);

      BufferedReader in = new BufferedReader(
              new InputStreamReader(new GZIPInputStream(con.getInputStream())));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      System.out.println(response.toString());
      answer = response.toString();
    } catch (Exception ex) {
    }

    return answer;

  }

}
