package 백준.practice


fun main() {
    var answer = 0

    val line =  readln()
    val splitMinusLine = line.split("-")


        answer += splitMinusLine[0].split("+").map { it.toInt() }.sum()

        for (i in 1 until splitMinusLine.size) {
            answer -= splitMinusLine[i].split("+").map { it.toInt() }.sum()
        }


    println(answer)
}