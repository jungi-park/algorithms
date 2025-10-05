package 백준.practice

val m = arrayOf(
    Pair(1, 1), Pair(-1, 1), Pair(1, -1), Pair(-1, -1), Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0)
)

fun main() {
    val result = mutableListOf<Int>()

    while (true) {
        var answer = 0

        val (w, h) = readLine()!!.split(" ").map { it.toInt() }

        if (w == 0 && h == 0) break

        val map = MutableList(h) { readln().split(" ").map { it.toInt() }.toMutableList() }

        for (hi in 0 until h) {
            for (wi in 0 until w) {
                if (map[hi][wi] != 0) {
                    DFS(hi, wi, w, h, map)
                    answer++
                }
            }
        }
        result.add(answer)
    }

    for (r in result) {
        println(r)
    }
}

fun DFS(hPoint: Int, wPoint: Int, width: Int, height: Int, map: MutableList<MutableList<Int>>) {
    map[hPoint][wPoint] = 0
    for ((mh, mw) in m) {
        val newH = hPoint + mh
        val newW = wPoint + mw
        if (newH in 0 until height && newW in 0 until width) {
            if (map[newH][newW] != 0) {
                DFS(newH, newW, width, height, map)
            }
        }
    }

}