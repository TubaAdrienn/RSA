import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {


    private BigInteger p;
    private BigInteger q;
    private BigInteger fi;
    private BigInteger e;
    private BigInteger d;
    private BigInteger mod;
    private final BigInteger one= new BigInteger("1");
    private final SecureRandom random=new SecureRandom();


    public RSA(){

        this.p = BigInteger.probablePrime(25, random);
        this.q = BigInteger.probablePrime(25, random);
        this.fi = (p.subtract(one).multiply(q.subtract(one)));
        this.mod = p.multiply(q);
        do {
            this.e = new BigInteger(String.valueOf(Math.abs(random.nextInt())));
            try {
                this.d = e.modInverse(fi);
            } catch (ArithmeticException e){
                System.out.println("Rossz e. Új generálása.");
            }
        } while(this.d==null);
        System.out.println("A nyilvános e: "+e);
        System.out.println("A titkos d: "+d);

    }

    public BigInteger getE(){
        return e;
    }

    public BigInteger getMod(){
        return mod;
    }

    public void visszafejt(BigInteger titkosÜzenet){
        System.out.println("Visszafejtett: " + titkosÜzenet.modPow(d, mod));
    }

}
