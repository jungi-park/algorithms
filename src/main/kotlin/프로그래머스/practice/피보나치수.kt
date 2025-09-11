package 프로그래머스.practice
/*
* Int 자리수 범위는 0 ~ 65535 이기 때문에 스택오버플로우를 피하기 위해 나눠서 저장
* */
class 피보나치수Solution {
    fun solution(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1

        val list = mutableListOf(0, 1)
        for (i in 2..n) {
            val lastIndex = list.size - 1
            val one = list.get(lastIndex)
            val two = list.get(lastIndex - 1)
            val three = (one + two) % 1234567
            list.add(three)
        }
        val lastIndex = list.size  - 1
        return list.get(lastIndex)
    }
}

// 이 솔루션 클래스를 테스트하기 위한 main 함수 예시
fun main() {
    val sol = 피보나치수Solution().solution(0)
    println(sol)
}