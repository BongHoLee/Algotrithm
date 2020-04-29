package Programmers.rePlay;

import java.util.*;

public class Leve2_RamenFactory {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;
        System.out.println(solution(stock, dates, supplies, k));
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<SupplyInfo> prQueue = new PriorityQueue<>(new Comparator<SupplyInfo>() {
            @Override
            public int compare(SupplyInfo o1, SupplyInfo o2) {
                return o2.getSupply() - o1.getSupply();
            }
        });

        for (int i=0; i<dates.length; i++)
            prQueue.offer(new SupplyInfo(dates[i], supplies[i]));

        System.out.println(prQueue);

        while (! prQueue.isEmpty() && stock < k) {
                SupplyInfo prSupplyInfo = prQueue.poll();
                List<SupplyInfo> tmpList = new ArrayList<>();

                while (stock < prSupplyInfo.getDate()) {
                    tmpList.add(prSupplyInfo);
                    prSupplyInfo = prQueue.poll();
                }

                stock += prSupplyInfo.getSupply();
                prQueue.addAll(tmpList);

            answer += 1;
        }

        return answer;
    }
}

class SupplyInfo {
    private int date;
    private int supply;

    public SupplyInfo(int date, int supply) {
        this.date = date;
        this.supply = supply;
    }

    public int getDate() { return date; }
    public int getSupply() {return supply;}

    public String toString() {

        return "[" + date + ", " + supply + "]";
    }

}
