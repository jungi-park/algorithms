package 백준.practice

import java.util.ArrayDeque

val MOVE = arrayOf(1 to 0, -1 to 0, 0 to -1, 0 to 1)

fun main() {
    val answer = mutableListOf<Int>()

    val (M, N, K) = readLine()!!.split(" ").map { it.toInt() }

    val map = MutableList(M) { MutableList(N) { 0 } }

    repeat(K) {
        val (oneX, oneY, twoX, twoY) = readLine()!!.split(" ").map { it.toInt() }
        for (x in oneX until twoX) {
            for (y in oneY until twoY) {
                map[y][x] = 1
            }
        }
    }

    for (x in 0 until M) {
        for (y in 0 until N) {
            if (map[x][y] != 1) {
                answer.add(BFS영역구하기(map, x, y, M, N))
            }
        }
    }

    answer.sort()
    println(answer.size)
    println(answer.joinToString(" "))
}

fun BFS영역구하기(map: MutableList<MutableList<Int>>, sx: Int, sy: Int, width: Int, height: Int): Int {
    val qu = ArrayDeque<Pair<Int, Int>>()
    var area = 0
    qu.add(sx to sy)
    map[sx][sy] = 1
    while (qu.isNotEmpty()) {
        val (x, y) = qu.removeFirst()
        ++area

        for ((mx, my) in MOVE) {
            val newX = x + mx
            val newY = y + my

            if (newX in 0 until width && newY in 0 until height && map[newX][newY] != 1) {
                qu.add(newX to newY)
                map[newX][newY] = 1
            }
        }
    }
    return area
}