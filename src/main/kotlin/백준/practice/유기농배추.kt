package 백준.practice

val MOVEs = arrayOf(
    Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0)
)

fun main() {
    val answer = mutableListOf<Int>()

    val T = readln().toInt()

    repeat(T) {
        var cnt = 0
        val (M, N, K) = readln().split(" ").map { it.toInt() }

        val map =  MutableList(N){ MutableList(M){0} }

        for (i in 0 until K){
            val (x,y) = readln().split(" ").map { it.toInt() }
            map[y][x] = 1
        }

        for (y in 0 until N){
            for(x in 0 until M){
                if(map[y][x] == 1){
                    유기농배추DFS(x,y,map,M,N)
                    cnt++
                }
            }
        }

        answer.add(cnt)

    }

    for (a in answer){
        println(a)
    }
}

fun `유기농배추DFS`(x:Int,y:Int,map:MutableList<MutableList<Int>>,width:Int,height:Int){

    map[y][x] = 0
    for((mx,my) in MOVEs){
        val newX = x+mx
        val newY = y+my

        if(newX in 0 until width && newY in 0 until height && map[newY][newX] == 1){
            유기농배추DFS(newX,newY,map,width,height)
        }
    }

}