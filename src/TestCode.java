import java.util.*;

public class TestCode {
    public static void main(String[] args) {
        //([4, 8], [4, 9], [8, 9]) ([1], [2], [3]), ([3,5], [3,6], [5,6])
        List<List<Integer>> set1 = new ArrayList<>();
        set1.add(new ArrayList<>(Arrays.asList(4, 8)));
        set1.add(new ArrayList<>(Arrays.asList(4, 9)));
        set1.add(new ArrayList<>(Arrays.asList(8, 9)));

        List<List<Integer>> set2 = new ArrayList<>();
        set2.add(new ArrayList<>(Arrays.asList(1)));
        set2.add(new ArrayList<>(Arrays.asList(2)));
        set2.add(new ArrayList<>(Arrays.asList(3)));

        List<List<Integer>> set3 = new ArrayList<>();
        set3.add(new ArrayList<>(Arrays.asList(3, 5)));
        set3.add(new ArrayList<>(Arrays.asList(3, 6)));
        set3.add(new ArrayList<>(Arrays.asList(5, 6)));

        List<List<List<Integer>>> setList = new ArrayList<>(Arrays.asList(set1, set2, set3));

        List<List<Integer>> combination = new ArrayList<>();
        getCombination(0,new ArrayList<>(), combination, setList);

        for (List<Integer> each : combination)
            System.out.println(each);

    }

    static void getCombination(int curSetIdx, List<Integer> curList, List<List<Integer>> combination, List<List<List<Integer>>> setList) {
        if (curSetIdx >= setList.size()) {
            combination.add(new ArrayList<>(curList));
        } else {
            List<List<Integer>> curSet = setList.get(curSetIdx);

            for (List<Integer> eachListFromSet : curSet) {
                curList.addAll(eachListFromSet);
                getCombination(curSetIdx+1, curList, combination, setList);

                for (int i=0; i<eachListFromSet.size(); i++)
                    curList.remove(curList.size()-1);
            }

        }
    }


}


