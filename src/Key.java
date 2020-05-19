import java.math.BigInteger;

public class Key {

    BigInteger exp;
    BigInteger mod;


    public Key(BigInteger exp, BigInteger mod) {
        this.exp = exp;
        this.mod=mod;
    }

    public BigInteger getExp() {
        return exp;
    }

    public BigInteger getMod() {
        return mod;
    }
}
