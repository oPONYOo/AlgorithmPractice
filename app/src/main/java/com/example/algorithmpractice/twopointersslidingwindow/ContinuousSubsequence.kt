package com.example.algorithmpractice.twopointersslidingwindow

import java.util.*

/**4. 연속부분수열(복합적 문제)
@since 2023.1.7.Sat
설명
N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는
프로그램을 작성하세요.
만약 N=8, M=6이고 수열이 다음과 같다면
1 2 1 3 1 1 1 2
합이 6이 되는 연속부분수열은 {2, 1, 3},{1, 3, 1, 1},{3, 1, 1, 1}로 총 3가지입니다.

입력
첫 줄에 N(5<=N<=100,000)과 M(1<=M<=100,000,000)이 주어진다.
수열의 원소값은 1,000을 넘지 않는 자연수이다.

출력
첫쨰 줄에 경우의 수를 출력한다.

예시 입력 1
8 6
1 2 1 3 1 1 1 2

예시 출력 1
3

 */
/*
[풀기 전]
포인터 2개 p1, p2
p1 ~ p2가 6이 되는지
p2가 n보다 작을동안 for문 실행
sum += arr[p2]
sum이 6이라면 answer++
sum이 6보다 크거나 같을동안 while문 실행
sum -= arr[p1++]
빼고 다시 sum이 6인지 확인 후 6이라면 answer++

[풀고 난 후]

*/

private fun solutionCode(n: Int, m: Int, arr: Array<Int>): Int {
    var answer = 0
    var sum = 0
    var p1 = 0


    for (p2 in 0 until n) {
        sum += arr[p2]
        if (sum == m) answer++
        while (sum >= m) {
            sum -= arr[p1++]
            if (sum == m) answer++
        }

    }



    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }

    println(solutionCode(n, m, arr))


}