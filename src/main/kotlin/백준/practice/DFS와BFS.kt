package 백준.practice


// 이 솔루션 클래스를 테스트하기 위한 main 함수 예시
fun main() {
    val (N, M, V) = readln().split(" ").map { it.toInt() }
    val visitedDFS = BooleanArray(N + 1) { false }
    val visitedBFS = BooleanArray(N + 1) { false }
    val resultBuilderDFS = StringBuilder()
    val resultBuilderBFS = StringBuilder()

    val line: MutableList<MutableList<Int>> = MutableList(N + 1) {
        mutableListOf()
    }

    for (i in 0 until M) {
        val (S, E) = readln().split(" ").map { it.toInt() }
        line[S].add(E)
        line[E].add(S)
    }


    // 문제 조건: 방문할 수 있는 정점이 여러 개인 경우, 정점 번호가 작은 것을 먼저 방문
    // -> 인접 리스트의 각 연결 리스트를 오름차순으로 정렬
    for (i in 1..N) {
        line[i].sort()
    }

    DFS(V, line, visitedDFS, resultBuilderDFS)
    BFS(V, line, visitedBFS, resultBuilderBFS)

    println(resultBuilderDFS.trim())
    println(resultBuilderBFS.trim())

}

fun DFS(
    startNode: Int,
    line: MutableList<MutableList<Int>>,
    visitedDFS: BooleanArray,
    resultBuilderDFS: StringBuilder
) {
    visitedDFS[startNode] = true
    resultBuilderDFS.append("$startNode ")
    for (i in line[startNode]){
        if(visitedDFS[i] == false){
            DFS(i,line,visitedDFS,resultBuilderDFS)
        }
    }
}

fun BFS(
    startNode: Int,
    line: MutableList<MutableList<Int>>,
    visitedBFS: BooleanArray,
    resultBuilderBFS: StringBuilder
) {
    val q = ArrayDeque<Int>()
    q.add(startNode)
    visitedBFS[startNode] = true
    resultBuilderBFS.append("$startNode ")
    while (q.isNotEmpty()){
        val s = q.removeFirst()
        for( e in line[s]){
            if(visitedBFS[e] == false){
                q.add(e)
                visitedBFS[e] = true
                resultBuilderBFS.append("$e ")
            }
        }
    }
}