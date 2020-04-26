package Programmers.rePlay;

import java.util.*;

public class Leve2_RamenFactory {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {4, 10, 30};
        int[] supplies = {20, 5, 10};
        int k = 30;
        System.out.println(solution(stock, dates, supplies, k));
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int lastDate = 0;
        List<SupplyInfo> prQueue = new ArrayList<>();


        for (int i=0; i<dates.length; i++)
            prQueue.add(new SupplyInfo(dates[i], supplies[i]));

        Collections.sort(prQueue);
        System.out.println(prQueue);

        while (prQueue.size() > 0 && stock < k) {
            SupplyInfo prSupplyInfo = prQueue.remove(0);
            List<SupplyInfo> tmpList = new ArrayList<>();

            while (stock < prSupplyInfo.getDate()) {
                tmpList.add(prSupplyInfo);
                prSupplyInfo = prQueue.remove(0);
            }

            stock += prSupplyInfo.getSupply();
            prQueue.addAll(tmpList);

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
