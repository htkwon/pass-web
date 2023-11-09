package com.example.passweb.kakao;

import com.example.passweb.entity.user.UserEntity;
import com.example.passweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class KakaoService {

    private final UserRepository userRepository;

    public String getToken(String code) throws IOException {
        String host = "https://kauth.kakao.com/oauth/token";
        URL url = new URL(host);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        String token = "";

        try{
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=c5ea7bc8ad89501f0ac8eb68827665b3");
            sb.append("&redirect_uri=http://localhost:8081/kakao/oauth");
            sb.append("&code="+code);


            bw.write(sb.toString());
            bw.flush();

            int responseCode = urlConnection.getResponseCode();
            System.out.println("responseCode = " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            String result = "";
            while((line = br.readLine())!=null){
                result += line;
            }
            System.out.println("result = " + result);

            JSONParser parser = new JSONParser();
            JSONObject elem = (JSONObject) parser.parse(result);

            String access_token = elem.get("access_token").toString();
            String refresh_token = elem.get("refresh_token").toString();

            token = access_token;

            br.close();
            bw.close();

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return token;
    }


    public Map<String,Object> getUserInfo(String access_token) throws IOException {
        String host = "https://kapi.kakao.com/v2/user/me";
        Map<String,Object> result = new HashMap<>();

        try{
            URL url = new URL(host);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization","Bearer "+access_token);
            urlConnection.setRequestMethod("GET");

            int responseCode = urlConnection.getResponseCode();
            System.out.println("responseCode = " +responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            String res = "";
            while ((line=br.readLine())!=null){
                res += line;
            }

            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(res);

            String id = obj.get("id").toString();
            result.put("id",id);

            br.close();

        } catch (IOException | ParseException e) {
            e.getStackTrace();
        }
        return result;
    }

    public String getAgreementInfo(String access_token){
        String result = "";
        String host = "https://kapi.kakao.com/v2/user/scopes";

        try{
            URL url = new URL(host);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Authorization","Bearer "+access_token);

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            while ((line=br.readLine())!=null){
                result +=line;
            }
            int responseCode = urlConnection.getResponseCode();
            System.out.println("responseCode = " + responseCode);

            br.close();

        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void saveUuid(Map<String, Object> userInfo) {
        String user = (String) userInfo.get("id");
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(user);
        String uuid = "";
        if (matcher.find()) {
            uuid = matcher.group();
        }
        List<UserEntity> userEntityList = userRepository.findAll();
        for (UserEntity entity : userEntityList) {
            entity.setUuid(uuid);
        }
        userRepository.saveAll(userEntityList);
    }
}
