package 백준.practice

val 숫자판점프MOVE = arrayOf((0 to 1), (0 to -1), (1 to 0), (-1 to 0))

fun main() {
    val answer = mutableSetOf<String>()

    val map = MutableList(5) {
        readln().split(" ").toMutableList()
    }

    for (x in 0 until 5) {
        for (y in 0 until 5) {
            숫자판점프DFS(x, y, map, 1, answer, map[x][y])
        }
    }

    println(answer.size)
}

fun 숫자판점프DFS(
    sx: Int,
    sy: Int,
    map: MutableList<MutableList<String>>,
    step: Int,
    answer: MutableSet<String>,
    nowString:String
) {
    if(step == 6){
        answer.add(nowString)
        return
    }

    for ((mx, my) in 숫자판점프MOVE) {
        val nx = sx + mx
        val ny = sy + my

        if (nx in 0 until 5 && ny in 0 until 5){
            val nWord = map[nx][ny]
            숫자판점프DFS(nx,ny,map,step+1,answer,nowString+nWord)
        }
    }

}