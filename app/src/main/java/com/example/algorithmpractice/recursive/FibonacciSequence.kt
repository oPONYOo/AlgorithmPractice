package com.example.algorithmpractice.recursive

import java.util.*

/**4. 피보나치 수열(메모리제이션)
@since 2023.2.7.Tue

설명
1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여
다음 숫자가 되는 수열이다.

2) 입력은 피보나치 수열의 총 항의 수이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.


입력
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.


출력
첫 줄에 피보나치 수열을 출력합니다.


예시 입력 1
10

예시 출력 1
1 1 2 3 5 8 13 21 34 55



 */
/*
[풀기 전]
재귀함수: 자기 자신 호출하는 함수
메모리제이션 활용해서 성능 높이기

[풀고 난 후]
for문이 재귀보다 성능이 좋다.
스택프레임이 너무 많이 쌓이기 때문
*/
private var fibo = IntArray(0)

private fun DFS(n: Int): Int {
    // 방법 1.
    /*return when (n) {
        1 -> 1
        2 -> 1
        else -> DFS(n-2) + DFS(n-1)
    }*/

    if (fibo[n] > 0) return fibo[n]
    return when (n) {
        1, 2 -> {
            fibo[n] = 1
            fibo[n]
        }
        else -> {
            fibo[n] = DFS(n - 2) + DFS(n - 1)
            fibo[n]
        }
    }
}


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
//    for (i in 1..n) print("${DFS(i)} ")
    fibo = IntArray(n + 1)
    DFS(n)
    for (i in 1..n) print("${fibo[i]} ")

}