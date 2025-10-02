package 백준.practice.none_solve

lateinit var graph: Array<MutableList<Int>> // 인접 리스트로 네트워크 연결을 표현
lateinit var visited: BooleanArray // 각 컴퓨터의 방문 여부를 저장
var infectedCount: Int = 0 // 웜 바이러스에 감염된 컴퓨터의 수

fun main() {
    // 1. 컴퓨터의 수 N을 입력받습니다. (첫째 줄)
    val N = readln().toInt() // <-- computerCount 대신 N으로 변수명도 변경하여 문제 설명과 일치시킵니다.

    // 2. 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수 M을 입력받습니다. (둘째 줄)
    val M = readln().toInt() // <-- M을 별도로 읽습니다.

    // 3. 인접 리스트와 방문 배열을 초기화합니다.
    // 컴퓨터 번호가 1번부터 시작하므로 N+1 크기로 만듭니다.
    graph = Array(N + 1) { mutableListOf() } // 위에서 읽은 N 값을 사용합니다.
    visited = BooleanArray(N + 1) { false }  // 위에서 읽은 N 값을 사용합니다.

    // 4. M개의 연결 정보를 입력받아 인접 리스트에 저장합니다.
    // 양방향 연결이므로 양쪽에 모두 추가합니다.
    repeat(M) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    // 5. 1번 컴퓨터부터 BFS 탐색을 시작합니다.
    bfs(1)

    // 6. 감염된 컴퓨터 수에서 1번 컴퓨터 자신을 제외하고 출력합니다.
    // (1번 컴퓨터는 감염시키고 그 외 컴퓨터 수를 세는 방식이므로, 1을 빼줍니다.)
    println(infectedCount - 1)
}

// 너비 우선 탐색 (BFS) 함수
fun bfs(startNode: Int) {
    // 큐를 생성하고 시작 노드를 큐에 추가합니다.
    val queue = ArrayDeque<Int>()
    queue.add(startNode) // add()는 요소를 큐의 끝에 추가합니다. (offer()와 유사)

    // 시작 노드를 방문 처리하고 감염된 컴퓨터 수에 포함합니다.
    visited[startNode] = true
    infectedCount++

    // 큐가 비어있지 않은 동안 계속 탐색합니다.
    while (queue.isNotEmpty()) {
        // 큐에서 노드를 하나 꺼냅니다. (가장 먼저 들어간 노드)
        val currentNode = queue.removeFirst() // removeFirst()는 큐의 맨 앞 요소를 꺼내고 제거합니다. (poll()과 유사)

        // 현재 노드와 연결된 다른 모든 이웃 노드를 확인합니다.
        for (neighbor in graph[currentNode]) {
            // 아직 방문하지 않은 이웃 노드라면 큐에 추가하고 방문 처리합니다.
            if (!visited[neighbor]) {
                visited[neighbor] = true // 방문했음을 표시
                infectedCount++ // 감염된 컴퓨터 수 증가
                queue.add(neighbor) // 큐에 이웃 노드 추가하여 나중에 탐색하도록 합니다.
            }
        }
    }
}