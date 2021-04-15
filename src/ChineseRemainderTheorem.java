import java.math.BigInteger;
import java.util.List;

public class ChineseRemainderTheorem {

    public static BigInteger crt(List<BigInteger> c, List<BigInteger> m) {

        BigInteger M = m.stream().reduce(BigInteger.ONE, BigInteger::multiply);
        BigInteger x = BigInteger.ZERO;

        for (int i = 0; i < c.size(); i++) {
            BigInteger Mi = M.divide(m.get(i));
            BigInteger yi = Mod.modInverse(Mi, m.get(i));
            x = x.add(c.get(i).multiply(Mi).multiply(yi));
        }

        x = x.mod(M);

        return x;
    }
}
