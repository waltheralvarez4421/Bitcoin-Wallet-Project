package bitcoin;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONException;
import org.junit.Test;

@RunWith(PowerMockRunner.class)
@PrepareForTest(BitcoinInPriceService.class)
public class BitcoinWalletTester {
	
	@Before 
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetCurrentValue() throws IOException, JSONException {
		//Set up
		BitcoinWallet bWallet = new BitcoinWallet();
		double amountBitcoin = 10;
		double price = 5000;
		
		//Build
		PowerMockito.mockStatic(BitcoinInPriceService.class);
		when(BitcoinInPriceService.getCurrentBitcoinPriceUSD()).thenReturn(price);
		
		//Exercise
		assertEquals(bWallet.getCurrentValueUSD(amountBitcoin, BitcoinInPriceService.getCurrentBitcoinPriceUSD()), 50000, 0.00001);

	}
	
	@Test
	public void testVerifyValueBlank() {
		//Set up 
		String nbrBitcoin = " ";
		BitcoinWallet bWallet = new BitcoinWallet();
		
		//Build
		bWallet.verifyValue(nbrBitcoin);
		
		//Exercise
		assertFalse(bWallet.verifyValue(nbrBitcoin));
	}
	
	@Test
	public void testVerifyValueNegative() {
		//Set up 
		String nbrBitcoin = "-10";
		BitcoinWallet bWallet = new BitcoinWallet();
		
		//Build
		bWallet.verifyValue(nbrBitcoin);
		
		//Exercise
		assertFalse(bWallet.verifyValue(nbrBitcoin));
	}
	
	@Test
	public void testVerifyValuePositive() {
		//Set up 
		String nbrBitcoin = "10";
		BitcoinWallet bWallet = new BitcoinWallet();
		
		//Build
		bWallet.verifyValue(nbrBitcoin);
		
		//Exercise
		assertTrue(bWallet.verifyValue(nbrBitcoin));
	}

	@Test
	public void testVerifyEmptyString() {
		//Set up 
		String bitcAddress = " ";
		BitcoinWallet bWallet = new BitcoinWallet();
		
		//Build
		bWallet.verifyString(bitcAddress);
		
		//Exercise
		assertFalse(bWallet.verifyString(bitcAddress));
	}
	
	@Test
	public void testVerifyStringLengthShort() {
		//Set up 
		String bitcAddressShort = "3TRY7DEQ5";
		BitcoinWallet bWallet = new BitcoinWallet();
		
		//Build
		bWallet.verifyValue(bitcAddressShort);
		
		//Exercise
		assertFalse(bWallet.verifyString(bitcAddressShort));
	}
	
	@Test
	public void testVerifyStringLengthLong() {
		//Set up 
		String bitcAddressLong = "1BvBMSEYstWetqTFn5Au4m4GFg7xJaNVN237";
		BitcoinWallet bWallet = new BitcoinWallet();
		
		//Build
		bWallet.verifyValue(bitcAddressLong);
		
		//Exercise
		assertFalse(bWallet.verifyString(bitcAddressLong));
	}
	
	@Test
	public void testVerifyStringLengthValid() {
		//Set up 
		String bitcAddressValid = "3J98t1WpEZ73CNmQviecrnyiWrnqRhWNLy";
		BitcoinWallet bWallet = new BitcoinWallet();
		
		//Build
		bWallet.verifyValue(bitcAddressValid);
		
		//Exercise
		assertTrue(bWallet.verifyString(bitcAddressValid));
	}
	
	@Test
	public void testVerifyStringStartsWith() {
		//Set up 
		String bitcAddress = "bc18t1WpEZ73CNmQviecrnyiWrnqRhWNLy";
		BitcoinWallet bWallet = new BitcoinWallet();
		
		//Build
		bWallet.verifyValue(bitcAddress);
		
		//Exercise
		assertFalse(bWallet.verifyString(bitcAddress));
	}
}
