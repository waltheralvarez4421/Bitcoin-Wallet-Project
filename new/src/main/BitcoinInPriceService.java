package bitcoin;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;


public class BitcoinInPriceService {

	

	private static String readAll(Reader rd) throws IOException {
	    StringBuilder stringBuild = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      stringBuild.append((char) cp);
	    }
	    return stringBuild.toString();
	  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }
  
  
  public static Double getCurrentBitcoinPriceUSD() throws IOException, JSONException {
	String address = "https://www.bitstamp.net/api/ticker/";
    JSONObject json = readJsonFromUrl(address);
    double gcbpd = json.getDouble("last");
	return gcbpd;
  }
}