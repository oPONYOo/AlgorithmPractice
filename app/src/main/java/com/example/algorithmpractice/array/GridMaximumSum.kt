package com.example.algorithmpractice.array

import java.util.*

/**9. 격자판 최대합
@since 2023.1.2.Mon
설명
5*5 격자판에 아래와 같이 숫자가 적혀있습니다.
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

N*N의 격자판이 주어지면
각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력합니다.

입력
첫 줄에 자연수 N이 주어진다. (2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다.
각 자연수는 100을 넘지 않는다.

출력
최대 합을 출력합니다.

예시 입력 1
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

예시 출력 1
155

 */
/*
[풀기 전]
arrays[행][열]
격자판 이중 for문 실행
column(행):    (0,0) ... (n,0) n번실행 배열[i][j]
row(열):       (0,0) ... (0,n) n번실행 배열[j][i]
대각선:      (0,0) ... (n,n) 조건: i==j/ (0,n) ... (n,0) 조건 i+j  == n-1
각각의  합이 answer보다 크면 answer = 합
행과 열 합의 변수는 j 반복 끝날때 마다 0으로 초기화

[풀고 난 후]
Math.max(Int, Int) -> coerceAtLeast
큰 값 구하기

두 대각선 구할때 j는 굳이 필요없으므로
이중 for문, 조건문 필요없음
배열[i][i]
배열[i][n - i - 1]
*/

private fun solutionCode(n: Int, arrays: Array<Array<Int>>): Int {
    var answer = 0
    var sum1 = 0
    var sum2 = 0

    // 방법 1.
    /*var rowSum = 0
    var columnSum = 0
    var diagonal1 = 0
    var diagonal2 = 0
    for (i in 0 until n) { // y 행
        for (j in 0 until n) { // x  열
            if (i == j) diagonal1 += arrays[i][j]
            if (i + j == n - 1) diagonal2 += arrays[i][j]
            rowSum += arrays[i][j]
            columnSum += arrays[j][i]
        }
        if (rowSum > answer) answer = rowSum
        if (columnSum > answer) answer = columnSum
        if (diagonal1 > answer) answer = diagonal1
        if (diagonal2 > answer) answer = diagonal2

        rowSum = 0
        columnSum = 0
    }*/

    // 방법 2.
    for (i in 0 until n) { // 행
        sum1 = 0
        sum2 = 0
        for (j in 0 until n) { // 열
            sum1 += arrays[i][j]
            sum2 += arrays[j][i]
        }
        answer = answer.coerceAtLeast(sum1)
        answer = answer.coerceAtLeast(sum2)
    }
    sum1 = 0
    sum2 = 0
    for (i in 0 until n) {
        sum1 += arrays[i][i]
        sum2 += arrays[i][n - i - 1]
    }
    answer = answer.coerceAtLeast(sum1)
    answer = answer.coerceAtLeast(sum2)

    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val num = sc.nextInt()
    val arr = Array(num) { Array(num) { 0 } }
    for (i in 0 until num) {
        for (j in 0 until num) {
            arr[i][j] = sc.nextInt()
        }
    }

    println(solutionCode(num, arr))


}