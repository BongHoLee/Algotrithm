package dynamicpro_book.ch2

class Minimum_Cost_Between_Stations2 {

    // F(s, d) = MIN { F(s, s+i) + F(s+i, d) }

    fun minimumCost(stations: Array<IntArray>, start: Int, dest: Int) : Int {

        if (dest - start == 1 || start == dest) {
            return stations[start][dest]
        }

        var min = stations[start][dest]
        for (i in start+1 until dest) {

            // F(s, s + i)
            val left = minimumCost(stations, start, i)

            // F(s + i, d)
            val right = minimumCost(stations, i, dest)

            min = Math.min(min, left + right)
        }

        return min
    }
}

fun main() {
    val stations = arrayOf(
        intArrayOf(0, 10, 75, 94),
        intArrayOf(-1, 0, 35, 50),
        intArrayOf(-1, -1, 0, 80),
        intArrayOf(-1, -1, -1, 0)


    )

    println(Minimum_Cost_Between_Stations2().minimumCost(stations, 0, 3))
}