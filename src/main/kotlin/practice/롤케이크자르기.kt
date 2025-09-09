package practice

/*
* slice()와 distinct()는 각각 O(N)에 가까운 연산을 수행할 수 있습니다. 이것이 N번 반복되는 for 루프 안에 들어있으므로
* 총 시간 복잡도는: O(N×(N+N))=O(N의2승)
* N의 최대값이 1,000,000입니다. 10의 6승 에 다시 2승을 곱한 10의 12승 처리
* 일반적으로 1초당 컴퓨터가 처리할 수 있는 연산 횟수는 1억번(약 10의 8승) 정도입니다.
* 이는 주어진 시간 제한(보통 1~5초)을 훨씬 초과하므로 **시간 초과(Time Limit Exceeded, TLE)**가 발생합니다.
* */
class 롤케이크자르기Solution {
    fun solution(topping: IntArray): Int {
        val n = topping.size
        var fairCutWays = 0

        // 1. leftCounts 배열 계산
        val leftCounts = IntArray(n) // 각 i까지의 토핑 종류 수
        val leftSet = HashSet<Int>()
        for (i in 0 until n) {
            leftSet.add(topping[i])
            leftCounts[i] = leftSet.size
        }

        // 2. rightCounts 배열 계산
        val rightCounts = IntArray(n) // 각 i부터의 토핑 종류 수 (역순으로 채움)
        val rightSet = HashSet<Int>()
        // 역순으로 순회
        for (i in n - 1 downTo 0) {
            rightSet.add(topping[i])
            rightCounts[i] = rightSet.size
        }

        // 3. 공평하게 자르는 방법 수 세기
        // 자르는 지점 i는 0부터 n-2까지 (즉, topping[i] 뒤를 자름)
        for (i in 0 until n - 1) {
            // 왼쪽 조각의 종류 수 (topping[0] ~ topping[i]) == rightCounts[i]와 동일
            val leftDistinctTypes = leftCounts[i]

            // 오른쪽 조각의 종류 수 (topping[i+1] ~ topping[n-1])
            val rightDistinctTypes = rightCounts[i + 1]

            if (leftDistinctTypes == rightDistinctTypes) {
                fairCutWays++
            }
        }

        return fairCutWays
    }
}

// 이 솔루션 클래스를 테스트하기 위한 main 함수 예시
fun main() {
    val sol = 롤케이크자르기Solution().solution(intArrayOf(1, 2, 1, 3, 1, 4, 1, 2))
    println(sol)
}