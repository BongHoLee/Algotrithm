package object;

import java.time.Duration;

public class FixedFeePolicy extends BasicRatePolicy{
    private Money amount;
    private Duration seconds;

    public FixedFeePolicy(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        long totalDuration = call.getDuration().getSeconds();
        long seoncdTimes = seconds.getSeconds();
        long result = totalDuration/seoncdTimes;

        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
