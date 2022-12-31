package com.example.algorithmpractice.array

import java.util.*

/**5. 소수(에라토스테네스 체)
@since 2022.12.31.Sat
설명
자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
제한시간은 1초입니다.

입력
첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.


출력
첫 줄에 소수의 개수를 출력합니다.

예시 입력 1
20

예시 출력 1
8

 */
/*
[풀기 전]
N+1만큼의 배열을 만들고 0으로 초기화
반목문 실행
배열[i] == 0이면 answer++
i배수는 1 할당

[풀고 난 후]

*/

private fun solutionCode(n: Int): Int {
    var answer = 0
    val list = Array(n+1) { 0 }
    for (i in 2..n) {
        if (list[i] == 0) {
            answer++
            for (j in i..n step i) list[j] = 1
        }
    }

    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val num = sc.nextInt()

    println(solutionCode(num))


}