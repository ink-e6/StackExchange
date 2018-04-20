package com.example.StackExchange;

import com.example.StackExchange.model.Example;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@RestController
public class HelloWorld {

//  @RequestMapping("/index.html")
//  public String sayHello(@RequestParam(value = "title") String title) {
//    try {
//      String json = sendGet(title);
//
//      ObjectMapper mapper = new ObjectMapper();
//      Example user = mapper.readValue(json, Example.class);
//
//      System.out.print(user.getItems().size());
//
//      return json;
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      return "Get nothing.";
//    }
//  }

  public static Example getExample(String title) {
    try {
      String json = sendGet(title);

      ObjectMapper mapper = new ObjectMapper();
      Example user = mapper.readValue(json, Example.class);

      System.out.print(user.getItems().size());

      return user;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String sendGet(String title) throws Exception {

    String url = "http://api.stackexchange.com/2.2/search?order=desc&sort=activity&intitle=" + title + "&site=stackoverflow";
    String answer = "";


    try{
      URL obj = new URL(url);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      // optional default is GET
      con.setRequestMethod("GET");
      con.setRequestProperty("Accept-Encoding", "gzip");
      con.setRequestProperty("Content-Type", "application/Example; charset=utf-8");

      //add request header
      con.setRequestProperty("User-Agent", USER_AGENT);

      int responseCode = con.getResponseCode();
      System.out.println("\nSending 'GET' request to URL : " + url);
      System.out.println("Response Code : " + responseCode);

      BufferedReader in = new BufferedReader(
              new InputStreamReader(new GZIPInputStream( con.getInputStream())));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      //print result
      System.out.println(response.toString());
      answer = response.toString();
    }
    catch (Exception ex){System.out.print("111");}

    if (answer.isEmpty()){
      answer = "Answer is empty.";
    }

    return answer;

  }

}
