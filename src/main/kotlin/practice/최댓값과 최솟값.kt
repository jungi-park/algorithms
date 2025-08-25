package practice

class 최댓값과최솟값Solution {
    fun solution(s: String): String {
        var answer = ""
        val numArr = s.split(" ").map { it.toInt() }
        answer = "${numArr.minOrNull()} ${numArr.maxOrNull()}"
        return answer
    }
}

// 이 솔루션 클래스를 테스트하기 위한 main 함수 예시
fun main() {
    val sol = 최댓값과최솟값Solution().solution("-1 -2 -3 -4")
    println(sol)
}