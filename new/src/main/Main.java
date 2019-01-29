package bitcoin;

import java.io.IOException;

import org.json.JSONException;

public class Main {
	
	public static void main(String[] args) throws IOException, JSONException {
		BitcoinWallet wallet = new BitcoinWallet();
		BitcoinInPriceService priceService = new BitcoinInPriceService();
		
		String walletAddress = wallet.getAddress();
		double bitcoinValue = priceService.getCurrentBitcoinPriceUSD();
		double walletCoins = wallet.getNumberOfBitcoins();
		double walletValue = wallet.getCurrentValueUSD(walletCoins, bitcoinValue);
		System.out.println("Here is how much your Wallet is worth: "+ walletValue);
	  }


}
