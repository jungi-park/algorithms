package 백준.practice.none_solve

fun main() {
    // 1. 입력 방식 변경: readln() 대신 br.readLine() 사용
    val (N, M) = readln().split(" ").map { it.toInt() }

    // dbj를 처음부터 Set으로 받습니다.
    // List로 받은 다음 Set으로 변환하는 것보다 Set으로 직접 구성하는 것이 효율적입니다.
    val dbjSet = HashSet<String>(N) // 예상 크기를 지정하여 HashSet 생성 효율 높임
    repeat(N) {
        dbjSet.add(readln())
    }

    // bj는 리스트로 받거나, 바로 비교에 사용할 수 있도록 Set으로 받습니다.
    // 여기서는 `dbjSet`과 `bjSet`의 교집합을 구할 것이므로 `bj`도 `Set`으로 받는게 좋습니다.
    val bjSet = HashSet<String>(M)
    repeat(M) {
        bjSet.add(readln())
    }


    // 2. Set끼리 교집합을 구합니다.
    // 이미 Set이므로 추가적인 toHashSet() 변환이 필요 없습니다.
    val answer = dbjSet.intersect(bjSet).toList().sorted()

    println(answer.size)
    for (re in answer){
        println(re)
    }

}