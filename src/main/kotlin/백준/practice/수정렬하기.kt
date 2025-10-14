package 백준.practice


fun main() {

    val N = readln().toInt()

    val set = mutableSetOf<Int>()

    repeat(N){
        val num = readln().toInt()
        set.add(num)
    }
    val result = set.sorted()

    for (a in result){
        println(a)
    }

}