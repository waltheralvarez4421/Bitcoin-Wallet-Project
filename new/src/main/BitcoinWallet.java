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

import bitcoin.BitcoinInPriceService;

public class BitcoinWallet {
//-------------------------------------------------------------------------------------------------------------------------------------------
	public static boolean tryParseDouble(String value) {  
		try {
	       
	        double x = Double.parseDouble(value);
	       
	        if (x == (double) x) {

	            return true;
	        }
	        else {
	        return false;
	        }
	    }
	    catch(NumberFormatException e) {
	        return false;
	    }
	}
//-------------------------------------------------------------------------------------------------------------------------------------------  
	public static boolean isNumeric(String strNum) {
	    return strNum.matches("-?\\d+(\\.\\d+)?");
	}
	
//-------------------------------------------------------------------------------------------------------------------------------------------
	public static boolean verifyValue(String nbrValue) {
		  
		  boolean validValue = false;
		  if (tryParseDouble(nbrValue) == false) {
			  validValue = false;
		  }
		  else {
			  double value = Double.parseDouble(nbrValue);
		  
			  if (nbrValue == null){
				  validValue = false;
			  }
			  else if (isNumeric(nbrValue) == false){
				  validValue = false;
			  }
			  else {
				  if (value >= 0) {
					  validValue = true;
				  }
				  else {
					  validValue = false;
				  }
			  }
		  }
		  return validValue;
	  }
//-------------------------------------------------------------------------------------------------------------------------------------------

	public static boolean verifyString(String strValue) {
		  
		  boolean validString = false;
		  if (strValue == null || strValue.isEmpty()) {
			  validString = false;
		  }
		  else {
			  if (strValue.length() > 35 || strValue.length() < 26) {
				  validString = false;
			  }
			  else {
				  if (strValue.startsWith("1") || strValue.startsWith("3")) {
					  validString = true;
				  }
				  else {
					  validString = false;
				  }
			  }
		  }
		 
		  return validString;
	  }
//-------------------------------------------------------------------------------------------------------------------------------------------	
	private static Scanner scanner;
	
	public static String getAddress() {
	System.out.println("Walther Alvarez's Bitcoin Wallet Service");
    System.out.println ("Enter Bitcoin Address: ");
    scanner = new Scanner(System.in);
    String address = scanner.nextLine();
    while (verifyString(address) == false) {
    	System.out.println("The Address you have entered is invalid");
    	System.out.print("Please enter your address again:");
    	address = scanner.nextLine();  	
    }
    return address;
	}
//-------------------------------------------------------------------------------------------------------------------------------------------
	  private static Scanner scanner2;
	  
	  static double getNumberOfBitcoins() {
		    System.out.println ("Enter your Number of Bitcoins:");
		    scanner2 = new Scanner(System.in);
		    String stringValBitcoin = scanner2.nextLine();
		    while (verifyValue(stringValBitcoin) == false) {
		    	System.out.println("The Bitcoin Quantity you have entered is invalid");
		    	System.out.print("Please enter number of Bitcoins again:");
		    	stringValBitcoin = scanner2.nextLine();  	
		    }
		    double amountBitcoin = Double.parseDouble(stringValBitcoin);
		    System.out.println();
		    return amountBitcoin;
		}
//-------------------------------------------------------------------------------------------------------------------------------------------
	  public static double getCurrentValueUSD(double amountBitcoin, double bitcoinPrice) throws IOException, JSONException {
		  System.out.println("This is the going rate for Bitcoin: "+bitcoinPrice);
		  double bitcoinTotal = bitcoinPrice * amountBitcoin;
		  return bitcoinTotal;
	  }
 
}
