package com.example.jv_an.filmes;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Connection {

    private final String USER_AGENT = "Mozilla/5.0";

    public String encodeString(String palavra) {
        char one;
        StringBuffer n = new StringBuffer(palavra.length());
        for (int i = 0; i < palavra.length(); i++) {
            one = palavra.charAt(i);
            switch (one) {
                case ' ':
                    n.append('%');
                    n.append('2');
                    n.append('0');
                    break;
                default:
                    n.append(one);
            }
        }
        return n.toString();
    }


    public Filme sendGetFilme(String name, String diretor) throws Exception {


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String nome = encodeString(name);

        String url = "https://api.myjson.com/bins/gkelf";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");


        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer res = new StringBuffer();
        String resultado = "";
        while ((inputLine = in.readLine()) != null) {
            res.append(inputLine);
            resultado = res.toString();
        }
        in.close();

        JSONObject response = new JSONObject(resultado);

        Filme fil = new Filme(response.getString("lancamento"), response.getString("name"),
                response.getString("diretor"), response.getString("genero"),
                response.getString("distribuicao"));

        return fil;
    }

}
