package practice.none_solve

class 피로도Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answerOne = 0
        var answerTwo = 0
        var kOne = k
        var kTwo = k

        // 첫 번째 정렬: 체력 소모 기준으로 오름차순 정렬
        val kOneSorted = dungeons.sortedBy { it[1] }
        for (dungeon in kOneSorted) {
            val need = dungeon[0]
            val damage = dungeon[1]
            if (kOne >= need) {
                answerOne++
                kOne -= damage
            }
        }

        // 두 번째 정렬: 필요 체력과 체력 소모의 차이 기준으로 오름차순 정렬
        val kTwoSorted = dungeons.sortedBy { it[1] - it[0] }
        for (dungeon in kTwoSorted) {
            val need = dungeon[0]
            val damage = dungeon[1]
            if (kTwo >= need) {
                answerTwo++
                kTwo -= damage
            }
        }

        // 두 경우 중 최대 클리어 가능한 던전 수 반환
        return maxOf(answerOne, answerTwo)
    }
}

// 이 솔루션 클래스를 테스트하기 위한 main 함수 예시
fun main() {
    val sol = 피로도Solution().solution(
        80,
        arrayOf(
            intArrayOf(80, 20),
            intArrayOf(50, 40),
            intArrayOf(30, 10),
        )
    )
    println(sol)
}