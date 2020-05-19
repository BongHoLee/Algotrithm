package object;

import java.util.List;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
