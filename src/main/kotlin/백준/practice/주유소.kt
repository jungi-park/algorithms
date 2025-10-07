package 백준.practice


fun main() {
    var answer: Long = 0

    val N = readln().toInt()

    val loads = readln().split(" ").map { it.toLong() }

    val gasStations = readln().split(" ").map { it.toLong() }

    var gasCost: Long = gasStations.first()

    for (i in 0 until N - 1) {
        val load = loads[i]

        if (gasCost > gasStations[i]) {
            gasCost = gasStations[i]
        }

        answer += load * gasCost
    }

    println(answer)
}