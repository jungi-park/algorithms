package 프로그래머스.base

class 나머지구하기Solution {
    fun solution(num1: Int, num2: Int): Int {
        var answer: Int = -1
        answer = num1 % num2
        return answer
    }
}

// 이 솔루션 클래스를 테스트하기 위한 main 함수 예시
fun main() {
    val sol = 나머지구하기Solution().solution(3,2)
    println(sol)
}