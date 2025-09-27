package 백준.practice

import kotlin.math.min


fun main() {
    var answer = Int.MAX_VALUE // 최소 다시 칠하기 횟수를 저장할 변수
    val (N, M) = readln().split(" ").map { it.toInt() }
    val originalMap = MutableList(N) { readln().map { it }.toMutableList() }

    // 모든 가능한 8x8 시작점을 탐색하는 중첩 for 루프
    // startX는 0부터 N-8까지
    for (startX in 0..N - 8) {
        // startY는 0부터 M-8까지
        for (startY in 0..M - 8) {

            var paintCountWhenStartWithW = 0 // 시작 칸이 'W'일 때 칠해야 하는 횟수
            var paintCountWhenStartWithB = 0 // 시작 칸이 'B'일 때 칠해야 하는 횟수

            // 현재 8x8 부분 보드를 순회 (startX, startY로부터 시작)
            for (i in 0 until 8) { // 현재 부분 보드 내에서의 상대적인 행 인덱스
                for (j in 0 until 8) { // 현재 부분 보드 내에서의 상대적인 열 인덱스
                    val currentX = startX + i // 원본 맵에서의 실제 행 인덱스
                    val currentY = startY + j // 원본 맵에서의 실제 열 인덱
                    val currentTile = originalMap[currentX][currentY]

                    // (i + j)는 8x8 부분 보드 내에서의 상대적인 위치를 기준으로 색깔을 결정합니다.
                    // (i + j) % 2 == 0 : 첫 칸과 같은 색
                    // (i + j) % 2 == 1 : 첫 칸과 다른 색

                    // 첫 칸이 'W'라고 가정했을 때, 해당 (i, j) 위치에 와야 할 색
                    val expectedW = if ((i + j) % 2 == 0) 'W' else 'B'
                    // 첫 칸이 'B'라고 가정했을 때, 해당 (i, j) 위치에 와야 할 색
                    val expectedB = if ((i + j) % 2 == 0) 'B' else 'W'

                    // 'W'로 시작하는 체스판과 비교
                    if (currentTile != expectedW) {
                        paintCountWhenStartWithW++
                    }

                    // 'B'로 시작하는 체스판과 비교
                    if (currentTile != expectedB) {
                        paintCountWhenStartWithB++
                    }
                }
            }

            // 현재 8x8 부분 보드에 대한 최소 칠하기 횟수
            val resultForCurrentBlock = min(paintCountWhenStartWithW, paintCountWhenStartWithB)
            // 전체 최소값 (answer)과 비교하여 업데이트
            answer = min(answer, resultForCurrentBlock)
        }
    }

    println(answer) // 최종 결과 출력
}