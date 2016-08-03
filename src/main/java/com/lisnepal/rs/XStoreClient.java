package com.lisnepal.rs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair; 

public class XStoreClient {

	public static void main(String[] args) {

	HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://gateway.poslynx.org:24599/thinclient/mobile/api.php");
        try {
            //Implementation 1
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("Command", "CCSALE"));
            nameValuePairs.add(new BasicNameValuePair("Amount", "10.00"));
            nameValuePairs.add(new BasicNameValuePair("Input", "EXTERNAL"));
            nameValuePairs.add(new BasicNameValuePair("ClientDate", "122515"));
            nameValuePairs.add(new BasicNameValuePair("ClientTime", "1350"));
            nameValuePairs.add(new BasicNameValuePair("ClientMAC", "FFFFFFFFFFFF"));
            nameValuePairs.add(new BasicNameValuePair("Lane", "VRB_AUS_04"));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));



            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


	}

}
