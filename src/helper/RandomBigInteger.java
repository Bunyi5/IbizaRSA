package helper;

import java.math.BigInteger;
import java.util.Random;

public class RandomBigInteger {

    public static BigInteger generateRandomBigInteger(BigInteger min, BigInteger max) {

        BigInteger result = new BigInteger(max.bitLength(), new Random());

        if (result.compareTo(min) < 0) {
            result = result.add(min);
        } else {
            result = result.mod(max.subtract(min)).add(min);
        }

        return result;
    }
}
