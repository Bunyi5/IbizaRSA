import java.math.BigInteger;

public class Euclidean {

    public static BigInteger euclidean(BigInteger a, BigInteger b) {
        while (!b.equals(BigInteger.ZERO)) {
            BigInteger r = a.mod(b);
            a = b;
            b = r;
        }
        return a;
    }
}
