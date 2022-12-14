package com.example.algorithmpractice.twopointersslidingwindow

import java.util.*

/**5. 연속된 자연수의 합(two pointers)
@since 2023.1.8.Sun
설명
N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로
정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
만약 N=15이면
7+8=15
4+5+6=15
1+2+3+4+5=15
와 같이 총 3가지의 경우가 존재한다.

입력
첫 번째 줄에 양의 정수 N(7<=N<=1000)이 주어집니다.

출력
첫 줄에 총 경우의 수를 출력한다.

예시 입력 1
15

예시 출력 1
3

 */
/*
[풀기 전]
방법 1.
포인터 2개 lt, rt
연속된 자연수로 n을 만들기 위해 1부터 n/2+1까지의 배열 arr을 만든다.
0부터 n/2+1까지 for문 실행
sum에 배열의 lt부터 rt까지의 합을 더한다
sum이 15인 경우 answer++
sum이 15랑 같거나 클경우 작아질때까지 배열의 lt값 빼주고 lt++
뺄때마다 sum이 15인 경우 answer++

[풀고 난 후]
방법 2.
1부터 14까지 for문 실행
sum에 연속되는 수의 합 할당
k에 n-sum 할당
k가 0보다 작을 경우 반복문 중단
연속되는 숫자 2개 이상이므로 i가 1보다 크고,
k의 나머지가 0인경우 answer++

방법 3.
방법 2와 동일
while문 활용
*/

private fun solutionCode(n: Int): Int {
    var answer = 0
    var sum = 0
    var lt = 0
    val m = n / 2 + 1
    val arr = Array(m) { 0 }


    for (i in 0 until m) arr[i] = i + 1

    // 방법 1.
    /* for (rt in 0 until m) {
         sum += arr[rt]
         if (sum == n) answer++
         while (sum >= n) {
             sum -= arr[lt++]
             if (sum == n) answer++
         }

     }*/

    // 방법 2.
    for (i in 1 until n) {
        sum += i
        val k = n - sum
        if (k < 0) break
        else if (i > 1 && k % i == 0) answer++
    }

    // 방법 3.
    /*var cnt = 1
    var k = n - 1
    while (k > 0) {
        cnt++
        k -= cnt
        if (k % cnt == 0) answer++
    }*/



    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()


    println(solutionCode(n))


}