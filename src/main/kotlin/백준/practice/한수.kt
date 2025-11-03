package 백준.practice


fun main() {
    var answer = 0
    val N = readln().toInt()
    outter@for (num in 1..N) {
        val strNumArr = num.toString().map { it.digitToInt() }

        val diffDefault = if (strNumArr.size == 1) {
            0
        } else {
            strNumArr[1] - strNumArr[0]
        }

        if(strNumArr.size == 1){
            ++answer
        }else{
            for (index in 0 until strNumArr.size - 1) {
                val diff = strNumArr[index + 1] - strNumArr[index]
                if(diffDefault != diff){
                    continue@outter
                }
            }
            ++answer
        }
    }


    println(answer)
}