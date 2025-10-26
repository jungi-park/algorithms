package 백준.practice

import java.util.ArrayDeque

val MOVES = arrayOf((0 to 1), (0 to -1), (1 to 0), (-1 to 0))

fun main() {
    var answer = mutableListOf<Int>()

    val N = readln().toInt()

    val map = MutableList(N) { readln().map { it.digitToInt() }.toMutableList() }

    for (x in 0 until N) {
        for (y in 0 until N) {
            if (map[x][y] == 1) {
                val cnt = 단지번호붙이기BFS(x, y, map, N)
                answer.add(cnt)
            }
        }
    }
    answer.sort()
    println(answer.size)
    for (a in answer){
        println(a)
    }
}

fun 단지번호붙이기BFS(sx: Int, sy: Int, map: MutableList<MutableList<Int>>, size: Int): Int {
    val q = ArrayDeque<Pair<Int, Int>>()
    var cnt = 1

    q.add((sx to sy))
    map[sx][sy] = 0

    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()

        for ((mx, my) in MOVES) {
            val nx = x + mx
            val ny = y + my

            if (nx in 0 until size && ny in 0 until size) {
                if (map[nx][ny] == 1) {
                    q.add((nx to ny))
                    ++cnt
                    map[nx][ny] = 0
                }
            }
        }
    }
    return cnt
}