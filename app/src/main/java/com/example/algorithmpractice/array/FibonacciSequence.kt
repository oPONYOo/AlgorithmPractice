package com.example.algorithmpractice.array

import java.util.*
import kotlin.collections.ArrayList

/**4. 피보나치 수열
@since 2022.12.30.Fri
설명
1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여
다음 숫자가 되는 수열이다.

2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면
1 1 2 3 5 8 13을 출력하면 된다.

입력
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.


출력
첫 줄에 피보나치 수열을 출력한다.

예시 입력 1
10

예시 출력 1
1 1 2 3 5 8 13 21 34 55

 */
/*
[풀기 전]
앞의 2개의 수로 배열에 1, 1추가
2부터 n만큼 for문 실행
배열에 (배열[i-2] + 배열[i-1]) 추가

[풀고 난 후]

*/

private fun solutionCode(n: Int): ArrayList<Int> {
    val answer = ArrayList<Int>()
    answer.add(1)
    answer.add(1)
    for (i in 2 until n) answer.add(answer[i - 2] + answer[i - 1])
    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val num = sc.nextInt()

    for (c in solutionCode(num)) print("$c ")


}