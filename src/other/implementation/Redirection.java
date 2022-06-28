package other.implementation;
/**
 * 다음과 같이  "EEESEEEEEENNNN" 방향이 주어집니다. ( E: 동 N: 북, S: 남, W: 서 )
 *
 * 방향 하나당 100M이며 1의 시간이 걸립니다.
 *
 * 해당 예시로 들면 E방향으로 300M 후에 S로 움직이니 오른쪽으로 움직이는 겁니다
 *
 * 동일한 방향으로 네비게이션은 최대 500M까지만 안내합니다. (만일 "SSEEEEEEE"와 같이 E 방향 6번이면 최초 1 번은 건너 뜁니다.)
 *
 *
 * 결론적으로 출력 결과는
 *
 * 'Time 0:Go straight 300m and turn right', ("EEE")
 *
 * 'Time 3:Go straight 100m and turn left',  ("S")
 *
 * 'Time 5:Go straight 500m and turn left'  ("EEEEEE")
 * Time이 5인 이유 -> 6칸 직진하기 때문에 같은 방향으로 이동하는 한 칸은 내비게이션이 언급하지 않아도 되기 때문
 *
 * 이렇게 나옵니다.
 *
 *
 *
 * 다른 예제 입력 2 )
 *
 * SSSSSSWWWNNNNNN
 * 답 2 )
 *
 * ["Time 1: Go straight 500m and turn right","Time 6: Go straight 300m and turn right"]
 */
public class Redirection {

    public static void main(String[] args) {
        String direction = "SSSSSSWWWNNNNNN";
        Redirection redirection = new Redirection();
        redirection.solution(direction);
    }

    public void solution(String direction) {
        char[] directions = direction.toCharArray();
        char lastDirection = directions[0];
        int sameDirectionCount = 0;
        int navigateTime = 0;


        for (int i=0; i<directions.length; i++) {
            char curDirection = directions[i];

            if (curDirection == lastDirection) {
                if (sameDirectionCount >= 5) {
                    navigateTime++;
                } else {
                    sameDirectionCount++;
                }


            } else {
                print(navigateTime, sameDirectionCount * 100, lastDirection, curDirection);
                navigateTime = i;
                lastDirection = curDirection;
                sameDirectionCount = 1;
            }
        }
    }

    public String nextDirection(char lastDirection, char curDirection) {
        if (lastDirection == 'E') {
            if (curDirection == 'S') return "right";
            if (curDirection == 'N') return "left";
        }

        if (lastDirection == 'W') {
            if (curDirection == 'S') return "left";
            if (curDirection == 'N') return "right";
        }

        if (lastDirection == 'S') {
            if (curDirection == 'E') return "left";
            if (curDirection == 'W') return "right";
        }

        if (lastDirection == 'N') {
            if (curDirection == 'W') return "left";
            if (curDirection == 'E') return "right";
        }

        throw new RuntimeException("IT'S NOT VALID DIRECTION");
    }

    public void print(int navigateTime, int distance, char lastDirection, char curDirection) {
        String sb = "["
                + "Time " + navigateTime + ": "
                + "Go straight " + distance + "m "
                + "and turn " + nextDirection(lastDirection, curDirection)
                + "]";

        System.out.println(sb);
    }
}
