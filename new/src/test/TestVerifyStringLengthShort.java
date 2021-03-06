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
public class TestVerifyStringLengthShort {

	@Test
	public void testVerifyStringLengthShort() {
		// Set up
		String bitcAddressShort = "3TRY7DEQ5";
		BitcoinWallet bWallet = new BitcoinWallet();

		// Build
		bWallet.verifyValue(bitcAddressShort);

		// Exercise
		assertFalse(bWallet.verifyString(bitcAddressShort));
	}

}
