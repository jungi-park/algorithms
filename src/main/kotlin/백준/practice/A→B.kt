package 백준.practice

import java.util.ArrayDeque

fun main() {

    val (A, B) = readln().split(" ").map { it.toLong() }

    println(BFSAB(A, B))
}

fun BFSAB(start: Long, end: Long): Long {
    val qu = ArrayDeque<Pair<Long, Long>>()
    qu.add(start to 1)

    while (qu.isNotEmpty()) {
        val (value, cnt) = qu.removeFirst()
        if (value == end) {
            return cnt
        }
        val firstValue = value * 2
        val secondsValue = (value.toString() + "1").toLong()

        if (firstValue <= end) {
            qu.add(firstValue to cnt + 1)
        }

        if (secondsValue <= end) {
            qu.add(secondsValue to cnt + 1)
        }
    }
    return -1
}