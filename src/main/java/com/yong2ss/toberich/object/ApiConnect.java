package com.yong2ss.toberich.object;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import com.yong2ss.toberich.util.Pathinfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class ApiConnect {

    //==* 지난 회차 당첨번호 가져오기
    public String lotto_select(int round) {
        //https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=861
        String apiURL = "https://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=" + round;
        String json = "";
        BufferedReader br;
        try{
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // &#xC815;&#xC0C1; &#xD638;&#xCD9C;
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // &#xC5D0;&#xB7EC; &#xBC1C;&#xC0DD;
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            json = br.readLine();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return json;
    }

    public int [] lotto_json (int round) {
        String json = lotto_select(round);

        int [] lottoNum = new int[7];
        try {
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject)parser.parse(json);
            //System.out.println(obj);

            for(int i = 0; i < 6; i++) {
                lottoNum[i] = ((Long)obj.get("drwtNo" + (i+1))).intValue();
            }
            lottoNum[6] = ((Long)obj.get("bnusNo")).intValue();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lottoNum;
    }

    //==* 구글 스프레드시트 데이터 가져오기
    public String lotto_google_data() {
        String key= Pathinfo.getKey();

        String apiURL = "https://docs.google.com/spreadsheets/d/" + key + "/gviz/tq?";
        String json = "";
        BufferedReader br;
        try{
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // &#xC815;&#xC0C1; &#xD638;&#xCD9C;
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // &#xC5D0;&#xB7EC; &#xBC1C;&#xC0DD;
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            json = br.readLine();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return json;
    }

    //https://docs.google.com/spreadsheets/d/1LnATd9r2V_5tU3uPJs9LL8Ii93ZhsWTJflO2l0k0abw/gviz/tq?
}

