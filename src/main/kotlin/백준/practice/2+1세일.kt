package 백준.practice


fun main() {
    var answer = 0
    val N = readln().toInt()
    val price = mutableListOf<Int>()

    repeat(N) {
        price.add(readln().toInt())
    }

    price.sortByDescending { it }

    for (i in price.indices) {
        val cnt = i + 1
        if (cnt % 3 != 0) {
            answer += price[i]
        }
    }

    println(answer)
}