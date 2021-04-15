import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {

        System.out.println("ModPow");
        System.out.println(Mod.modPow(new BigInteger("4"), new BigInteger("73"), new BigInteger("42")).toString()); // 4
        System.out.println(Mod.modPow(new BigInteger("7"), new BigInteger("618"), new BigInteger("60")).toString()); // 49

        System.out.println("ModInverse");
        System.out.println(Mod.modInverse(new BigInteger("27"), new BigInteger("392")).toString()); // 363
        System.out.println(Mod.modInverse(new BigInteger("785"), new BigInteger("3168")).toString()); // 113

        System.out.println("Miller-Rabin");
        System.out.println(MillerRabin.isPrime(new BigInteger("87"), 7)); //false
        System.out.println(MillerRabin.isPrime(new BigInteger("69"), 4)); //false
        System.out.println(MillerRabin.isPrime(new BigInteger("1109"), 2)); //true
    }
}
