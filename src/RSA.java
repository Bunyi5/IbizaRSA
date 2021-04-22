import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RSA {

    private final BigInteger p, q, n, phiN, e, d;

    public RSA() {
        this.p = generateRandomPrime();
        this.q = generateRandomPrime();
        this.n = p.multiply(q);
        this.phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        this.e = chooseE();
        this.d = Mod.modInverse(e, phiN);
    }

    public RSA(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
        this.n = p.multiply(q);
        this.phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        this.e = chooseSmallestE();
        this.d = Mod.modInverse(e, phiN);
    }

    public RSA(BigInteger p, BigInteger q, BigInteger e) {
        this.p = p;
        this.q = q;
        this.n = p.multiply(q);
        this.phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        this.e = e;
        this.d = Mod.modInverse(e, phiN);
    }

    private BigInteger chooseSmallestE() {
        BigInteger maybeE = BigInteger.TWO;

        for (BigInteger i = new BigInteger("2"); i.compareTo(phiN) < 0; i = i.add(BigInteger.ONE)) {
            if (Euclidean.euclidean(i, phiN).equals(BigInteger.ONE)) {
                maybeE = i;
                break;
            }
        }

        return maybeE;
    }

    private BigInteger chooseE() {
        BigInteger maybeE = BigInteger.TWO;

        while (!Euclidean.euclidean(maybeE, phiN).equals(BigInteger.ONE)) {
            maybeE = RandomBigInteger.generateRandomBigInteger(BigInteger.TWO, phiN);
        }

        return maybeE;
    }

    private BigInteger generateRandomPrime() {
        BigInteger maybePrime;
        BigInteger min = BigInteger.valueOf(1000000000L);
        BigInteger max = BigInteger.valueOf(100000000000000L);

        while (true) {
            maybePrime = RandomBigInteger.generateRandomBigInteger(min, max);
            if (MillerRabin.isPrime(maybePrime, 3)) {
                return maybePrime;
            }
        }
    }

    public BigInteger encrypt(BigInteger message) {
        return Mod.modPow(message, e, n);
    }

    public BigInteger decrypt(BigInteger cipher) {
        return Mod.modPow(cipher, d, n);
    }

    public BigInteger decryptCRT(BigInteger cipher) {
        List<BigInteger> c = createReducedCList(cipher);
        List<BigInteger> m = createReducedMList();

        return ChineseRemainderTheorem.crt(c, m);
    }

    private List<BigInteger> createReducedCList(BigInteger cipher) {

        BigInteger reducedC1 = cipher.mod(p);
        BigInteger reducedC2 = cipher.mod(q);

        BigInteger reducedD1 = d.mod(p.subtract(BigInteger.ONE));
        BigInteger reducedD2 = d.mod(q.subtract(BigInteger.ONE));

        List<BigInteger> c = new ArrayList<>();
        c.add(Mod.modPow(reducedC1, reducedD1, p));
        c.add(Mod.modPow(reducedC2, reducedD2, q));

        return c;
    }

    private List<BigInteger> createReducedMList() {
        List<BigInteger> m = new ArrayList<>();
        m.add(p);
        m.add(q);

        return m;
    }

    @Override
    public String toString() {
        return "RSA: \n" +
                "p = " + p +
                "\nq = " + q +
                "\nn = " + n +
                "\nphiN = " + phiN +
                "\ne = " + e +
                "\nd = " + d;
    }
}