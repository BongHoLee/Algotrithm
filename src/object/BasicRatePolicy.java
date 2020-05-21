package object;

import java.util.List;

public abstract class BasicRatePolicy implements RatePolicy{
    @Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;

        for (Call call : phone.getCalls()) {
             // result.plus(calculateCallFee(call));        // 기존 코드
            result = result.plus(calculateCallFee(call));   // 수정 코드
        }

        return result;
    }


    protected abstract Money calculateCallFee(Call call);
}
