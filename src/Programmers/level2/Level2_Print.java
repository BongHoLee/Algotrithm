package Programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
*   패턴을 찾은줄 알았는데 패턴이 아니었따.
*   실제 패턴이 있는지는 아직 모르겠음 (패턴식으로 이용하면 만약 있다고 해도 상당히 복잡할듯, if 난무?)
*
*   우선순위 큐를 사용하지 말자 (같은 priority에 대해 우선순위가 다를 수 있으니까)
*    ex [2, 3, 2] 순으로 들어오면 뒤에 들어온 2가 우선순위가 더 높다.
*    ex [2, 2, 3] 순으로 들어오면 앞에 들어온 2가 우선순위가 더 높다.
* */
public class Level2_Print {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        System.out.println(solution(priorities, 0));

    }

    public static int solution(int[] priorities, int location) {
        int order = 0;
        Node targetNode = null;
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<priorities.length; i++) {
            Node node = new Node(i);
            if (i == location)
                targetNode = node;
            q.add(node);
        }





        return order;
    }
}

class Node{
    int priority;

    public Node(int priority) {
        this.priority = priority;
    }
}
