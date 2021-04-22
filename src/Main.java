import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RSA rsa = new RSA();
//        RSA rsa = new RSA(new BigInteger("463"), new BigInteger("547"), new BigInteger("47"));
//        RSA rsa = new RSA(new BigInteger("17"), new BigInteger("23"));
        while (true) {
            System.out.println("What do you want to do?(e = enc, d = dec, k = keys, q = quit)");
            String nextStep = scanner.nextLine();
            if (nextStep.equalsIgnoreCase("q")) {
                break;
            } else if (nextStep.equals("e")) {
                System.out.print("Message to encrypt: ");
                String messageToEncrypt = scanner.nextLine();
                System.out.printf("Result: %d\n", rsa.encrypt(new BigInteger(messageToEncrypt)));
            } else if (nextStep.equals("d")) {
                System.out.print("Message to decrypt: ");
                String messageToDecrypt = scanner.nextLine();
                System.out.printf("Result: %d\n", rsa.decryptCRT(new BigInteger(messageToDecrypt)));
            } else if (nextStep.equals("k")) {
                System.out.println(rsa.toString());
            }
        }
    }
}
