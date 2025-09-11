package 프로그래머스.practice

class JadenCase문자열만들기Solution {
    /**
     * 주의사항
     * split(" ")는 공백을 기준으로 문자열을 분리합니다.
     * 이때, 연속된 공백이나 문자열의 시작/끝 공백은 빈 문자열("")로 처리되어
     * JadenCase의 공백 유지 규칙에 부합합니다.
    * */
    fun solution(s: String): String {
        val strArr = s.split(" ").map { word ->
            if (word.isEmpty()) {
                ""
            } else {
                val firstChar = word.first()
                val restOfWord = word.drop(1)
                if (firstChar.isLetter()) {
                    firstChar.uppercase() + restOfWord.lowercase()
                } else {
                    firstChar + restOfWord.lowercase()
                }
            }
        }
        return strArr.joinToString(" ")
    }
}

fun main() {
    val sol = JadenCase문자열만들기Solution().solution("for the last week")
    println(sol)
}