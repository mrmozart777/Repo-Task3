package main.java;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class CTranslate {

    private String Str_out;

    public CTranslate(String Str_in, String input){
        String https_key = "https://translate.yandex.net/api/v1.5/tr.json/translate?" +
                "key=trnsl.1.1.20170823T233047Z.1b009f1801529872.081f83dc09c4297572bd31291da6a1e7a6a9ff09";
        try {
            URL https_url = new URL(https_key);
            HttpsURLConnection connection = (HttpsURLConnection)https_url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            DataOutputStream answer = new DataOutputStream(connection.getOutputStream());
            answer.writeBytes("text=" + URLEncoder.encode(input, "UTF-8") + "&lang=" + Str_in);

            InputStream resp = connection.getInputStream();
            Str_out = new java.util.Scanner(resp).nextLine();
            int start = Str_out.indexOf("[");
            int end = Str_out.lastIndexOf("]");
            Str_out = Str_out.substring(start + 2, end - 1);
        }
        catch(MalformedURLException e){
            Str_out = "### Fail! ###";
        }
        catch (Exception e){
            Str_out = "### Fail! ###";
        }
    }

    public String getRes(){
        return Str_out;
    }
}