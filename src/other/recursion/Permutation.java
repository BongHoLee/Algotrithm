package other.recursion;

/**
 *  순서를 갖는 모든 경우의 수를 구하는 순열을 재귀로 구현
 *  주어진 numbers = "0195"일 때 모든 순열을 출력한다.
 */


// 자신의 문제만 풀고 나머지는 재귀에 위임한다는 점을 명심
// 수학적 귀납법 ( f(n) + f(n + 1) )
public class Permutation {
    static int count = 0;
    public static void main(String[] args) {
        String numbers = "12340";
        Permutation permutation = new Permutation();
        permutation.stringPermutation("", numbers);
        System.out.println(count);
    }

    // 각 재귀는 자신의 자릿수에 대해서만 계산하고 나머지 문자열은 재귀에 위임한다!
    public void stringPermutation(String madeNumbers, String remainNumbers) {
        if (remainNumbers.length() == 0) {
            count++;
            System.out.println(madeNumbers);
        } else {
            // remainNumbers 있는 숫자들 중 하나를 뽑아서 madeNumbers 붙여나간다.
            // 뽑은 숫자를 제외한 remainNumbers 중 뽑은 숫자를 붙인 madeNumbers를 다음 재귀에 전달한다.
            for(int i=0; i<remainNumbers.length(); i++) {
                String pre = remainNumbers.substring(0, i);
                String suf = remainNumbers.substring(i+1);
                String cur = Character.toString(remainNumbers.charAt(i));
                stringPermutation(cur + madeNumbers, pre + suf);
            }
        }
    }
}
