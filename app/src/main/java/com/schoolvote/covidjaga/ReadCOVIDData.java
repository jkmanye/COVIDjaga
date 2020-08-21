package com.schoolvote.covidjaga;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadCOVIDData {
    public String getData() throws IOException {
        Date today = new Date();
        SimpleDateFormat pm = new SimpleDateFormat("yyyyMMdd");
        String urlBuilder = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=hNK48kADYhSYcKyAcUZvihx1aoltSehHgPR3k2VeiR4qAtL1qcxMqZBeRBEG%2FQZWaJFYY1WWBoh84uijMg173A%3D%3D&pageNo=1&numOfRows=1&startCreateDt=" + pm.format(today) + "&endCreateDt=" + pm.format(today) +"&";
        URL url = new URL(urlBuilder);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        BufferedReader rd;
        rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    }
}
