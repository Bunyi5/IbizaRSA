import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RSA rsa = new RSA();
//        RSA rsa = new RSA(new BigInteger("37"), new BigInteger("89"), new BigInteger("785"));
        while (true) {
            System.out.println("What do you want to do?(e = enc, d = dec, q = quit)");
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
            }
        }
    }
}
