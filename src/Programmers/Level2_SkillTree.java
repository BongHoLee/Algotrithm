package Programmers;

// Skill Tree 문제

/*
*   무난하게 쉬운 문제였음.
*   풀이 과정
*   1. skill_tree에 있는 요소들을 하나씩 가져옴(sk)
*   2. sk의 요소들을 loop
*   3. sk의 요소들 중 skill에 해당하는 요소가 있으면 
*       3-1. lastIndex + 1 == 현재 요소의 위치라면 skill의 순서와 맞는거니까 lastIndex + 1을 해줌
*       3-2. lastIndex + 1 != 현재 요소의 위치라면 skill의 순서가 맞지 않는거니까 틀린놈
* */
public class Level2_SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_tree = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skill_tree));

    }

    public static int solution(String skill, String[] skill_tree) {
        int answer = skill_tree.length;


        for (String sk : skill_tree) {
            int lastIndex = -1;

            for(int i=0; i<sk.length(); i++) {
                String T = Character.toString(sk.charAt(i));

                if (skill.contains(T)) {
                    if (skill.indexOf(T) == lastIndex + 1) {
                        lastIndex = skill.indexOf(T);
                    } else {
                        answer -= 1;
                        break;
                    }

                }
            }

        }

        return answer;
    }

}
