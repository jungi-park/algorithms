package 프로그래머스.practice

import java.util.*

/*
* PriorityQueue
* */
class 프로세스Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val processQ = ArrayDeque<Pair<Int, Int>>()
        val prioritieQ = PriorityQueue<Int>({ a, b -> b - a })
        for (index in 0..priorities.lastIndex) {
            processQ.add(priorities[index] to index)
            prioritieQ.add(priorities[index])
        }

        while (processQ.isNotEmpty()) {
            val (processValue, processIndex) = processQ.poll()
            val prioritiValue = prioritieQ.first()
            if (processValue == prioritiValue) {
                prioritieQ.poll()
                answer++
                if (processIndex == location) return answer
            } else {
                processQ.add(processValue to processIndex)
            }
        }
        return answer
    }
}

fun main() {
    val sol = 프로세스Solution().solution(intArrayOf(1, 1, 9, 1, 1, 1), 0)
    println(sol)
}