import java.math.BigInteger;

public class ModPow {

    public static BigInteger modPow(BigInteger a, BigInteger e, BigInteger m) {
        BigInteger result = BigInteger.ONE;
        BigInteger apow = a;

        while (!e.equals(BigInteger.ZERO)) {
            if (e.testBit(0)) {
                result = result.multiply(apow).mod(m);
            }
            e = e.shiftRight(1);
            apow = apow.multiply(apow).mod(m);
        }

        return result;
    }
}
