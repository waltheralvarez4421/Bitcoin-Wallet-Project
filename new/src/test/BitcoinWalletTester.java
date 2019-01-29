package bitcoin;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestGetCurrentValue.class, TestVerifyEmptyString.class, TestVerifyStringLengthLong.class,
		TestVerifyStringLengthShort.class, TestVerifyStringLengthValid.class, TestVerifyStringStartsWith.class,
		TestVerifyValueBlank.class, TestVerifyValueNegative.class, TestVerifyValuePositive.class })
public class BitcoinWalletTester {

}
