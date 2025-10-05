package 백준.practice


fun main() {
    var answer = 0
    val N = readln().toInt()
    val times = readln().split(" ").map { it.toInt() }.sorted()
    var t = 0

    for (i in 0 until N) {
        t =  t + times[i]
        answer = answer + t
    }

    println(answer)
}