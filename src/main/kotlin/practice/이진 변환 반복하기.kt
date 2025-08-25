package practice

class 이진변환반복하기Solution {
    fun solution(s: String): IntArray {
        var execCnt = 0
        var zeroCnt = 0
        var currentStr = s
        while (currentStr != "1"){
            execCnt += 1
            zeroCnt += currentStr.count { it == '0' }
            val removedZero = currentStr.replace("0","").length
            currentStr = removedZero.toString(2)
        }
        return intArrayOf(execCnt,zeroCnt)
    }
}

// 이 솔루션 클래스를 테스트하기 위한 main 함수 예시
fun main() {
    val sol = 이진변환반복하기Solution().solution("110010101001")
    println(sol.joinToString(","))
}