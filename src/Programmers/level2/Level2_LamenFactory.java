package Programmers.level2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Level2_LamenFactory {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates =    {4,10,15};
        int[] supplies = {20,5,10};
        int k = 30;

        List<Integer> dateList = new ArrayList<>();
        List<Integer> suppleList = new ArrayList<>();

        for (int i=0; i<dates.length; i++) {
            dateList.add(dates[i]);
            suppleList.add(supplies[i]);
        }


        System.out.println(solution(stock, dates, supplies, k));
        //System.out.println(calcStock(stock, dateList, suppleList, k));

    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int suppleCnt = 0;
        List<Integer> dateList = new ArrayList<>();
        List<Integer> suppleList = new ArrayList<>();
        for (int i=0; i<dates.length; i++) {
            dateList.add(dates[i]);
            suppleList.add(supplies[i]);
        }

        // 1. stock < k 이면 stock 일째 이내 dates 중 가장 큰 supple을 가진 공급을 받는다
        while (k > stock) {
            stock = calcStock(stock, dateList, suppleList);
            suppleCnt += 1;
        }


        return suppleCnt;
    }

    private static int calcStock(int stock, List<Integer> dateList, List<Integer> suppleList) {

        int maxSupple = 0;
        int lastDateIdx = 0;
        for (int i=0; i<dateList.size(); i++) {
            int date = dateList.get(i);
            int supple = suppleList.get(i);

            if (stock  < date)
                break;

            if (maxSupple < supple) {
                maxSupple = supple;
                lastDateIdx = i;
            }
        }

       dateList.set(lastDateIdx, -1);
       suppleList.set(lastDateIdx, -1);

        return stock + maxSupple;
    }
}
