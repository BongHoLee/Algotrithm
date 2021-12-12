package leetcode.hard.graph.leet_1591

import java.util.*


/**
*
* leetCode 1591 Hard graph 문제 풀이
 * 위상정렬 이용 문제 풀이
 * 직사각형 범위 구하는 방법을 눈여겨 볼것
 * '순서'가 있음에 주목 - 위상 정렬문제를 의심
 * 진입 차수, 진출 차수 대상이 되는 노드를 어떻게 파악하는지 고민
 * 진입 차수, 진출 차수를 어떻게 구하는지 고민
 *
*
 * 1. 행렬에서 사용중인 모든 노드(색) 구하기
 * 2. 사용된 색들의 사각형 범위 구하기
 * 3. 사각형 범위에서 덮어써진 다른 색들 구하기
 *  3-1. 덮어써진 색들과는 그래프 형성
 *  3-2. 덮여써진 다른 색들보다 현재 색이 먼저 칠해져야 한다.
 * 4. 사이클이 있으면 false, 없으면 true
*
* @author
* @version 1.0.0
* 작성일 2021-11-29
**/


class Solve2_JustUseQueue_Mine {
    fun isPrintable(targetGrid: Array<IntArray>): Boolean {
        val pos = posOf(targetGrid)
        val eraseQueue = LinkedList(pos.keys)

        while(eraseQueue.isNotEmpty()) {
            val lastSize = eraseQueue.size

            for (qSize in 0 until eraseQueue.size) {
                val curColor = eraseQueue.poll()
                if (!canErase(targetGrid, curColor, pos[curColor]!!)) {
                    eraseQueue.offer(curColor)
                }
            }

            if (lastSize == eraseQueue.size) {
                return false
            }

        }

        return true
    }

    private fun canErase(targetGrid: Array<IntArray>, color: Int, colorRange: IntArray) : Boolean {
        val minY = colorRange[0]
        val minX = colorRange[1]
        val maxY = colorRange[2]
        val maxX = colorRange[3]

        // can erase?
        for (y in minY .. maxY) {
            for (x in minX .. maxX) {
                if (targetGrid[y][x] != -1 && targetGrid[y][x] != color) {
                    return false
                }
            }
        }

        // erase
        for (y in minY .. maxY) {
            for (x in minX .. maxX) {
                targetGrid[y][x] = -1
            }
        }

        return true
    }

    private fun posOf(targetGrid: Array<IntArray>): MutableMap<Int, IntArray> {
        val pos = mutableMapOf<Int, IntArray>()
        targetGrid.forEachIndexed { y, eachRow ->
            eachRow.forEachIndexed { x, eachElement ->

                // minY, minX, maxY, maxX
                val rectangleRange = pos.getOrPut(eachElement) {intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)}

                // minY
                rectangleRange[0] = rectangleRange[0].coerceAtMost(y)
                // minX
                rectangleRange[1] = rectangleRange[1].coerceAtMost(x)
                // maxY
                rectangleRange[2] = rectangleRange[2].coerceAtLeast(y)
                // maxX
                rectangleRange[3] = rectangleRange[3].coerceAtLeast(x)

            }
        }
        return pos
    }

}

fun main() {
    val targetGrid = arrayOf(
        intArrayOf(1, 2, 1),
        intArrayOf(2, 1, 2),
        intArrayOf(1, 2, 1)
    )

    println(Solve2_JustUseQueue_Mine().isPrintable(targetGrid))
}