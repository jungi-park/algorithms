package 백준.practice

import kotlin.math.pow


fun main() {
    var answer = 0

    var X = readLine()!!.toInt()

    while (X != 0) {
        var bar = 0

        for (i in 0..6){
            if (2.toDouble().pow(i)<= X && X < 2.toDouble().pow(i+1)){
                bar = 2.toDouble().pow(i).toInt()
                break
            }
        }

        X = X - bar
        answer += 1
    }

    println(answer)
}