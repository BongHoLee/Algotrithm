package Programmers.rePlay;

import java.util.*;

public class Leve2_RamenFactory {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {1, 2, 3, 5};
        int[] supplies = {10, 30, 20, 40};
        int k = 100;
//
//        입력값 〉 4, [4, 10, 15], [20, 5, 10], 30
//        기댓값 〉 2
//
//        입력값 〉 10, [5, 10], [1, 100], 110
//        기댓값 〉 1
//
//        입력값 〉 4, [1, 2, 3, 4], [10, 40, 20, 30], 100
//        기댓값 〉 4
//
//        입력값 〉 2, [1], [10], 10
//        기댓값 〉 1
        System.out.println(solution(stock, dates, supplies, k));
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        //List<SupplyInfo> prQueue = new ArrayList<>();
        PriorityQueue<SupplyInfo> prQueue = new PriorityQueue<>(new Comparator<SupplyInfo>() {
            @Override
            public int compare(SupplyInfo o1, SupplyInfo o2) {
                if (o1.getSupply() > o2.getSupply())
                    return -1;
                else if (o1.getSupply() < o2.getSupply())
                    return 1;
                else {
                    if (o1.getDate() > o2.getDate())
                        return -1;
                    else
                        return 0;
                }
            }
        });
        for (int i=0; i<dates.length; i++)
            prQueue.offer(new SupplyInfo(dates[i], supplies[i]));

        //Collections.sort(prQueue);
        System.out.println(prQueue);

        while (prQueue.size() > 0 && stock < k) {
            SupplyInfo prSupplyInfo = prQueue.poll();
            List<SupplyInfo> tmpList = new ArrayList<>();

            while (stock < prSupplyInfo.getDate()) {
                tmpList.add(prSupplyInfo);
                prSupplyInfo = prQueue.poll();
            }

            stock += prSupplyInfo.getSupply();
            System.out.println(prSupplyInfo);
            for (SupplyInfo tmp : tmpList) prQueue.offer(tmp);

            answer += 1;
        }

        return answer;
    }
}

class SupplyInfo  implements Comparable<SupplyInfo>{
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

    @Override
    public int compareTo(SupplyInfo o) {
        if (this.getSupply() > o.getSupply())
            return -1;
        else if (this.getSupply() < o.getSupply())
            return 1;
        else {
            if (this.getDate() > o.getDate())
                return -1;
            else
                return 0;
        }
    }
}
