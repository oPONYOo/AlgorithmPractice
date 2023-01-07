package com.example.algorithmpractice.twopointersslidingwindow

import java.util.*
import kotlin.collections.ArrayList

/**3. 최대 매출(Sliding Window)
@since 2023.1.7.Sat
설명
현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고
연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
만약 N=1이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
12 15 11 20 25 10 20 19 13 15
연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
여러분이 현수를 도와주세요.

입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

출력
첫 줄에 최대 매출액을 출력합니다.

예시 입력 1
10 3
12 15 11 20 25 10 20 19 13 15

예시 출력 1
56

 */
/*
[풀기 전]
Sliding Window: n크기의 창문 만들어서 밀기
이중 for문 X
k만큼 arr를 돌면서 sum에 값을 더한다.
K부터 n-1까지 for문 실행
sum 값에 arr[i]를 더하고, arr[i-k]를 뺸다.
-> 연속적인 k만큼의 합을 유지함.

[풀고 난 후]
coerceAtLeast 메소드로 answer, sum 증
큰값을 answer에 할당
*/

private fun solutionCode(n: Int, k: Int, arr: Array<Int>): Int {
    var sum = 0
    for (i in 0 until k) sum += arr[i]
    var answer = sum
    for(i in k until n) {
        sum += (arr[i] - arr[i - k])
        answer = answer.coerceAtLeast(sum)
    }


    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }

    println(solutionCode(n, k, arr))


}