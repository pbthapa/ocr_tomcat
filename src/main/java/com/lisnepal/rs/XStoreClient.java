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

		// String url =
		// "https://gateway.poslynx.org:24599/thinclient/mobile/api.php";
		//
		// HttpClient httpclient = HttpClientBuilder.create().build();
		//
		// // RequestBody body = RequestBody.create(MediaType.TEXT_XML,
		// //
		// "<PLRequest>\n<Command>CCSALE</Command>\n<Amount>10.00</Amount>\n<Input>EXTERNAL</Input>\n<ClientDate>122515</ClientDate>\n<ClientTime>1350</ClientTime>\n<ClientMAC>FFFFFFFFFFFF</ClientMAC>\n<Lane>VRB_AUS_04</Lane>\n</PLRequest>");
		// // Request request = Req
		// //
		// .url("https://gateway.poslynx.org:24599/thinclient/mobile/api.php")
		// // .post(body)
		// // .addHeader("content-type", "text/xml")
		// // .addHeader("cache-control", "no-cache")
		// // .build();
		// //
		// // Response response = client.newCall(request).execute();
		//
		// HttpPost post = new HttpPost(url);
		// post.addHeader("content-type", "text/xml");
		// post.addHeader("cache-control", "no-cache");
		// post.addHeader("body",
		// "<PLRequest><Command>CCSALE</Command><Amount>10.00</Amount><Input>EXTERNAL</Input><ClientDate>122515</ClientDate><ClientTime>1350</ClientTime><ClientMAC>FFFFFFFFFFFF</ClientMAC><Lane>VRB_AUS_04</Lane></PLRequest>");

		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("https://gateway.poslynx.org:24599/thinclient/mobile/api.php");
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("content-type", "text/xml"));
			nameValuePairs.add(new BasicNameValuePair("cache-control", "no-cache"));
			nameValuePairs.add(new BasicNameValuePair("body", "<PLRequest><Command>CCSALE</Command><Amount>10.00</Amount><Input>EXTERNAL</Input><ClientDate>122515</ClientDate><ClientTime>1350</ClientTime><ClientMAC>FFFFFFFFFFFF</ClientMAC><Lane>VRB_AUS_04</Lane></PLRequest>"));

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
