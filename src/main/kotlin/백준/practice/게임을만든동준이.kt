package 백준.practice


fun main() {
    var answer = 0

    val N = readln().toInt()

    val scores = mutableListOf<Int>()

    repeat(N) {
        val score = readln().toInt()
        scores.add(score)
    }

    for (i in N-1 downTo 1) {
        var backNum = scores[i]
        var frontNum = scores[i-1]
        while (frontNum >= backNum){
            --frontNum
            ++answer
        }
        scores[i-1] = frontNum
    }

    println(answer)
}