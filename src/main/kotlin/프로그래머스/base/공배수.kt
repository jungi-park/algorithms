package 프로그래머스.base

class Solution {
    fun solution(number: Int, n: Int, m: Int): Int {
        var answer: Int = 0 // 초기값 설정

        // number가 n의 배수이면서 m의 배수인지 확인하는 조건문
        if (number % n == 0 && number % m == 0) {
            answer = 1 // 조건에 맞으면 1 반환
        }

        return answer
    }
}

// 이 솔루션 클래스를 테스트하기 위한 main 함수 예시
fun main() {
    val sol = Solution().solution(60,2,3)
    println(sol)
}