import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

    private final static BigInteger one= new BigInteger("1");
    private final static SecureRandom random=new SecureRandom();

    private BigInteger p;
    private BigInteger q;
    private BigInteger fi;
    private BigInteger e;
    private BigInteger d;
    private BigInteger mod;

    public RSA(){

        do {
            this.p = BigInteger.probablePrime(25, random);
            this.q = BigInteger.probablePrime(25, random);
            this.fi = (p.subtract(one).multiply(q.subtract(one)));
            this.mod = p.multiply(q);
            this.e = new BigInteger("67335");
            try {
                this.d = e.modInverse(fi);
            } catch (ArithmeticException e){
                System.out.println("Rossz modulus. Új generálása.");
            }
        } while(this.d==null);

    }

    public BigInteger titkosit(BigInteger üzenet){
        return üzenet.modPow(e,mod);
    }

    public BigInteger visszafejt(BigInteger titkosÜzenet){
        return titkosÜzenet.modPow(d, mod);
    }

    public static void main(String[] args) {
        RSA rsa=new RSA();

        for(int i=0; i<10; i++) {

            BigInteger üzenet = new BigInteger(25, random);
            BigInteger titkosÜzenet = rsa.titkosit(üzenet);
            BigInteger visszaFejtett = rsa.visszafejt(titkosÜzenet);

            System.out.println("Üzenet: " + üzenet);
            System.out.println("Titkositott: " + titkosÜzenet);
            System.out.println("Visszafejtett: " + visszaFejtett);

            System.out.println("-------------------------------------------------");
        }
    }

}
