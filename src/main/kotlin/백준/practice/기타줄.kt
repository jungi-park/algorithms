package 백준.practice

import kotlin.collections.*


fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    var answer = 0
    var minPack = Int.MAX_VALUE
    var minOne = Int.MAX_VALUE
    var leftCnt = N

    for (i in 0 until M) {
        val (pack, one) = readln().split(" ").map { it.toInt() }
        if (minPack > pack) {
            minPack = pack
        }
        if (minOne > one) {
            minOne = one
        }
    }

    while (leftCnt > 0) {

        if (leftCnt >= 6) {
            val onePrice = minOne * 6
            if (onePrice >= minPack) {
                answer += (leftCnt / 6) * minPack

            } else {
                answer += (leftCnt / 6) * onePrice
            }
            leftCnt = leftCnt % 6
        }else{
            val leftOnePack = minOne * leftCnt
            if(leftOnePack >= minPack){
                answer += minPack
            }else{
                answer += leftOnePack
            }
            leftCnt = 0
        }
    }

    println(answer)
}