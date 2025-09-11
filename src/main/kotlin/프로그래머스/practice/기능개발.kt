package 프로그래머스.practice

/*
* ArrayDeque는 addLast() 로 데이터를 넣고, last() 로 맨 위/뒤를 확인하고, removeLast() 로 맨 위/뒤를 제거하면 스택처럼 쓸 수 있어요.
* ArrayDeque는 addLast() 로 데이터를 넣고, first() 로 맨 앞을 확인하고, removeFirst() 로 맨 앞을 제거하면 큐처럼 쓸 수 있어요.
* first(),last() 는 해당 큐,스택이 비어있으면 오류가 발생하니 주의!!
* */
class 기능개발Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val q = ArrayDeque<Int>()
        val sppedsQ = ArrayDeque<Int>()
        q.addAll(progresses.toList())
        sppedsQ.addAll(speeds.toList())

        while (q.isNotEmpty()) {
            var feature = 0
            for (index in 0..q.lastIndex) {
                q[index] += sppedsQ[index]
            }

            while (q.isNotEmpty() && q.first() >= 100) {
                q.removeFirst()
                sppedsQ.removeFirst()
                feature += 1
            }

            if (feature > 0) {
                answer.add(feature)
            }
        }

        return answer.toIntArray()
    }
}

// 이 솔루션 클래스를 테스트하기 위한 main 함수 예시
fun main() {
    val sol = 기능개발Solution().solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
    println(sol)
}