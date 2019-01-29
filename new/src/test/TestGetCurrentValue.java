package bitcoin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(BitcoinInPriceService.class)
public class TestGetCurrentValue {

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetCurrentValue() throws IOException, JSONException {
		// Set up
		BitcoinWallet bWallet = new BitcoinWallet();
		double amountBitcoin = 10;
		double price = 5000;

		// Build
		PowerMockito.mockStatic(BitcoinInPriceService.class);
		when(BitcoinInPriceService.getCurrentBitcoinPriceUSD()).thenReturn(price);

		// Exercise
		assertEquals(bWallet.getCurrentValueUSD(amountBitcoin, BitcoinInPriceService.getCurrentBitcoinPriceUSD()),
				60000, 0.00001);

	}

}
