import java.util.Optional;

/**
 * Created by alex on 5/7/2017.
 */
public class Rate {
    String ccy;
    Double rate;
    Optional<Double> multiplier;

    public Rate(String ccy, Double rate, Optional<Double> multiplier) {
        this.ccy = ccy;
        this.rate = rate;
        this.multiplier = multiplier;
    }

    public String getCcy() {
        return ccy;
    }

    public Double getRate() {
        return rate;
    }

    public Double getMultiplier() {
        if(multiplier.isPresent())
            return  multiplier.get();
        else
            return 1.0;
    }
}
