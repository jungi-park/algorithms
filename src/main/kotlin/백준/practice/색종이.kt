package 백준.practice


fun main() {
    var answer = 0
    val map = MutableList(100) {
        MutableList(100) { 0 }
    }

    val cnt = readLine()!!.toInt()

    repeat(cnt) {
        val (sx, sy) = readLine()!!.split(" ").map { it.toInt() }
        val ex = sx + 10
        val ey = sy + 10

        for (x in sx until ex) {
            for (y in sy until ey) {
                map[x][y] = 1
            }
        }
    }

    for (x in 0 until 100) {
        for (y in 0 until 100) {
            if (map[x][y] == 1) {
                ++answer
            }
        }
    }

    println(answer)
}