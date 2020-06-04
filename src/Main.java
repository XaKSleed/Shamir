import java.math.BigInteger;
import java.security.SecureRandom;

public class Main {

    public static void main(String[] args) {
        final BigInteger secret = new BigInteger("256");
        final int CERTAINTY = 256;
        final SecureRandom random = new SecureRandom();
        final BigInteger prime = new BigInteger(secret.bitLength() + 1, CERTAINTY, random);


        final SecretShare[] shares = ShamirScheme.split(secret, 2, 6, prime, random);

        SecretShare[] sharesToViewSecret = new SecretShare[] {shares[2], shares[3]};
        BigInteger result = ShamirScheme.combine(sharesToViewSecret, prime);
    }
}
