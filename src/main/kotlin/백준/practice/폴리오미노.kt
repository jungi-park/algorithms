package 백준.practice


fun main() {
    var answer = StringBuilder()
    val A = "AAAA"
    val B = "BB"
    var flag = false

    val board = readln().split(".")

    for (b in board) {
        if (b.isNotEmpty()) {
            var len = b.length
            var str = ""

            val aCnt = len / 4
            len = len % 4

            val bCnt = len / 2
            len = len % 2

            if (len !== 0) {
                flag = true
                break
            }

            str = str + A.repeat(aCnt)
            str = str + B.repeat(bCnt)
            answer.append(str)
        }
        answer.append(".")
    }

    if (flag) {
        println(-1)
    } else {
        println(answer.toString().substring(0 until answer.length - 1))
    }
}