package 백준.practice


fun main() {
    var answer = 0

    val S = readln()

    var oneCnt = 0

    var zeroCnt = 0

    var nowNum = S.first()

    if (S.first() == '1') {
        ++oneCnt
    } else {
        ++zeroCnt
    }

    for (num in S) {
        if (nowNum != num) {
            nowNum = num
            if (num == '1') {
                ++oneCnt
            } else {
                ++zeroCnt
            }
        }
    }

    answer = if (oneCnt < zeroCnt) {
        oneCnt
    } else {
        zeroCnt
    }

    println(answer)
}