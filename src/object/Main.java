package object;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 구간 별 규칙을 정의를 담을 List
        List<DurationDiscountRule> rules = new ArrayList<>();

        // 첫 번째 구간 별 규칙 : [통화 0분 ~ 30분] 까지 [단위 시간 10분] 당 [단위 요금 10원]을 부과
        DurationDiscountRule rule1 = new DurationDiscountRule(Duration.ofMinutes(0), Duration.ofMinutes(30), Money.wons(10), Duration.ofSeconds(10));

        // 두 번째 구간 별 규칙 : [통화 30분 ~ 90분] 까지 [단위 시간 10분] 당 [단위 요금 15원]을 부과
        DurationDiscountRule rule2 = new DurationDiscountRule(Duration.ofMinutes(30), Duration.ofMinutes(90), Money.wons(15), Duration.ofSeconds(10));
        rules.add(rule1);
        rules.add(rule2);

        // 구간 별 요금 부과 인스턴스 초기화
        DurationDiscountPolicy policy = new DurationDiscountPolicy(rules);

        // 현재 시간부터 1시간 (총 60분)의 통화 인스턴스 초기화
        Call call = new Call(LocalDateTime.now(), LocalDateTime.now().plusMinutes(60));


        // 기대값 : 현재 시간부터 60분 이후까지 구간 별 통화 요금 계산
        // 0분 ~ 30분 까지 단위 요금 10원으로 총 30원
        // 30분 ~ 60분 까지 단위 요금 15원으로 총 20원
        // 최종 결과 50원
        Money result = policy.calculateCallFee(call);

        // But 결과는 0원
        System.out.println(result.toString());

    }
}
