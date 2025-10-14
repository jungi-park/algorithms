package 백준.practice

var answer = -1

fun main() {
    val n = readLine()!!.toInt()
    val (start, end) = readLine()!!.split(" ").map { it.toInt() }
    val m = readLine()!!.toInt()

    val line = MutableList(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1) { false }

    repeat(m) {
        val (s, e) = readLine()!!.split(" ").map { it.toInt() }
        line[s].add(e)
        line[e].add(s)
    }
    DFS촌수계산(start,end, line, 0,visited)

    println(answer)
}

fun `DFS촌수계산`(start: Int, end: Int, line: MutableList<MutableList<Int>>,cnt:Int,visited:BooleanArray){

    visited[start] = true

    if(start == end){
        answer = cnt
    }

    for(index in 0 until  line[start].size){
        val node = line[start][index]
        if(visited[node] != true){
            DFS촌수계산(node,end,line,cnt+1,visited)
        }
    }

}