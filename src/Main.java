import java.math.BigInteger;
import java.security.SecureRandom;


public class Main {

    public static BigInteger titkosit(BigInteger üzenet, BigInteger e, BigInteger mod) {
        return üzenet.modPow(e, mod);
    }

    public static void main(String[] args) {

        SecureRandom random=new SecureRandom();
        RSA rsa=new RSA();
        BigInteger üzenet, titkosÜzenet;
        Key publicKey=rsa.getPublicKey();


        for(int i=0; i<10; i++) {

            üzenet = new BigInteger(50, random);
            titkosÜzenet = titkosit(üzenet, publicKey.getExp(), publicKey.getMod());
            System.out.println("Üzenet: " + üzenet);
            System.out.println("Titkositott: " + titkosÜzenet);
            rsa.visszafejt(titkosÜzenet);

            System.out.println("-------------------------------------------------");
        }
    }
}
