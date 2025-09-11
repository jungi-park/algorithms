package 프로그래머스.practice

/*
* Int 자리수 범위는 0 ~ 65535 이기 때문에 스택오버플로우를 피하기 위해 나눠서 저장
* */
class 귤고르기Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var num = k
        var answer: Int = 0
        val grouped = tangerine.groupBy { it }.mapValues { it.value.size }.entries.sortedByDescending { it.value }
            .associate { it.key to it.value }

        for ((f, v) in grouped) {
            num = num - v
            answer = answer + 1
            if (num <= 0) return answer
        }

        return answer
    }
}

// 이 솔루션 클래스를 테스트하기 위한 main 함수 예시
fun main() {
    val sol = 귤고르기Solution().solution(2, intArrayOf(1, 1, 1, 1, 2, 2, 2, 3))
    println(sol)
}