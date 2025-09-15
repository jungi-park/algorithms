package 백준.practice


fun main() {
    var answer = 0
    val N = readln().toInt()
    val aArr = readln().split(" ").map { it.toInt() }.sorted()
    val bArr = readln().split(" ").map { it.toInt() }.sortedByDescending { it }

    for(index in 0 until N) {
        answer = answer + (aArr[index] * bArr[index])
    }

    println(answer)
}