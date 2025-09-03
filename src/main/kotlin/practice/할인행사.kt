package practice

class 할인행사Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val shoppingMap = mutableMapOf<String, Int>()

        for (i in 0..want.lastIndex) {
            shoppingMap.set(want.get(i), number.get(i))
        }

        var start = 0
        var end = if (discount.lastIndex < 9) {
            discount.lastIndex
        } else {
            9
        }

        while (end <= discount.lastIndex) {
            var flag = true
            val tenDayShoppingList = discount.slice(start..end)
            for ((itemName, itemCnt) in shoppingMap) {
                val presentCnt = tenDayShoppingList.count { it == itemName }
                if (presentCnt != itemCnt) {
                    flag = false
                    break
                }
            }
            if (flag) {
                answer++
            }
            start++
            end++
        }
        return answer
    }
}

// 이 솔루션 클래스를 테스트하기 위한 main 함수 예시
fun main() {
    val sol = 할인행사Solution().solution(
        arrayOf("banana", "apple", "rice", "pork", "pot"),
        intArrayOf(3, 2, 2, 2, 1),
        arrayOf(
            "chicken",
            "apple",
            "apple",
            "banana",
            "rice",
            "apple",
            "pork",
            "banana",
            "pork",
            "rice",
            "pot",
            "banana",
            "apple",
            "banana"
        )
    )
    println(sol)
}