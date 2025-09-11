package 프로그래머스.practice

import kotlin.math.ceil

/*
* 일반적인 토너먼트 대진표에서 두 참가자가 맞붙으려면 홀수 번호와 그 다음 짝수 번호가 한 조를 이루게 됩니다. 예를 들어, 1번은 2번과, 3번은 4번과, 5번은 6번과 붙죠.

이때, "두 참가자 A와 B가 인접한 번호이고, A가 홀수 B가 짝수(A+1=B)이거나, A가 짝수 B가 홀수(B+1=A)인 경우"를 판단하려면:

A와 B의 차이가 1이면서
둘 중 하나가 홀수이고 다른 하나가 짝수여야 합니다.
*
* */
class 예상대진표Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 1
        var aPosition = a
        var bPosition = b
        while (true){
            if ((aPosition - 1 == bPosition && aPosition % 2 == 0) || (bPosition - 1 == aPosition && bPosition % 2 == 0)) {
                return answer // 만나면 현재 라운드 수를 반환
            }
            val aTemp = ceil((aPosition.toDouble()/2)).toInt()
            val bTemp = ceil((bPosition.toDouble()/2)).toInt()

            aPosition = aTemp
            bPosition = bTemp
            answer += 1
        }
    }
}

fun main() {
    val sol = 예상대진표Solution().solution(16, 9, 11)
    println(sol)
}