package 백준.practice

import kotlin.math.min


fun main() {
    var answer = Int.MAX_VALUE
    var (A, B) = readLine()!!.split(" ")
    val lastIndex = A.lastIndex
    var start = 0

    while (start + lastIndex <= B.lastIndex) {
        var imsi = 0
        val bSplit = B.substring(start..start + lastIndex)
        for (i in 0..lastIndex) {
            if (A[i] != bSplit[i]) {
                ++imsi
            }
        }
        answer = min(answer, imsi)
        ++start
    }

    println(answer)
}