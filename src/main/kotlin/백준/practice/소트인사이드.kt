package 백준.practice


fun main() {
    var answer = ""

    answer = readln().map { it.digitToInt() }.sortedDescending().joinToString("")

    println(answer)
}