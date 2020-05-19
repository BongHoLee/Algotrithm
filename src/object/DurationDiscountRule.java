package object;

import java.time.Duration;

public class DurationDiscountRule extends FixedFeePolicy {

    private Duration from;
    private Duration to;

    public DurationDiscountRule(Duration from, Duration to, Money amount, Duration seconds) {
        super(amount, seconds);
        this.from = from;       // 0, 30
        this.to = to;           // 30, 90
    }

    // 구간 별 요금 부과를 위한 계산 규칙
    public Money calculate(Call call) {

        Duration tmpTo = call.getDuration();

        // 실제 통화 기간(60) 보다 규칙 최종 시간이 더 적다면 (ex : to == 30) 0원을 반환
        if (call.getDuration().compareTo(to) > 0) {
            return Money.ZERO;
        }

        // 실제 통화 기간(60) 보다 규칙 시작 시간이 더 크다면 (ex : from == 70) 0원을 반환
        if (call.getDuration().compareTo(from) < 0) {
            return Money.ZERO;
        }

        Phone phone = new Phone(null);
        phone.call(new Call(call.getFrom().plus(from),
                       call.getDuration().compareTo(to) > 0 ? call.getFrom().plus(to) : call.getTo()));

        return super.calculateFee(phone);
    }
}
