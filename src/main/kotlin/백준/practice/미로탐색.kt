package 백준.practice


fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }

    val map = MutableList(N) { readln().map { it.digitToInt() }.toMutableList() }

    println(BFS(map, N, M))

}

fun BFS(map: MutableList<MutableList<Int>>, n: Int, m: Int): Int {

    val q = ArrayDeque<Triple<Int, Int, Int>>() // (x, y, dist)를 저장
    val move = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
    q.add(Triple(0, 0, 1))
    map[0][0] = 0

    while (q.isNotEmpty()) {
        val (x, y, dist) = q.removeFirst()

        if (x == n - 1 && y == m - 1) {
            return dist
        }

        for ((mX, mY) in move) {
            val newX = x + mX
            val newY = y + mY
            if (newX in 0 until n && newY in 0 until m && map[newX][newY] != 0) {
                q.add(Triple(newX, newY, dist+1))
                map[newX][newY] = 0
            }
        }

    }

    return 0
}

