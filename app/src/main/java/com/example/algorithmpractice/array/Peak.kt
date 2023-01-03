package com.example.algorithmpractice.array

import java.util.*

/**10. 봉우리
@since 2023.1.3.Tue
설명
지도 정보가 N*N 격자판에 주어진다. 각 격자에는 그 지역의 높이가 쓰여있다.
각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역이다.
봉우리 지역이 몇 개 있는지 알아내는 프로그램을 작성하세요.
격자의 가장자리는 0으로 초기화 되었다고 가정한다.
만약 N=5이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개이다.
0 0 0 0 0 0 0
0 5 3 7 2 3 0
0 3 7 1 6 1 0
0 7 2 5 3 4 0
0 4 3 6 4 1 0
0 8 7 3 5 2 0
0 0 0 0 0 0 0

입력
첫 줄에 자연수 N이 주어진다. (2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다.
각 자연수는 100을 넘지 않는다.

출력
봉우리의 개수를 출력하세요.

예시 입력 1
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2

예시 출력 1
10

 */
/*
[풀기 전]
가장자리는 0으로 초기화된 배열을 다시 만들기
arrays[행][열]
격자판 이중 for문 실행
현재 값이 상하좌우 값보다 큰지 확인
현재 array[i][j]
상 arrays[i-1][j]
하 arrays[i+1][j]
좌 arrays[i][j-1]
우 arrays[i][j+1]
상하좌우값보다 크면 answer += 1

[풀고 난 후]
array[i][j] 시계방향으로 돌면서 큰지 확인
12시 3시 6시 9시
[-1, 0, 1, 0]
[ 0, 1, 0, -1]
-> 대각선도 포함되면 방법 1은 변수가 너무 많아지므로 배열 활용하기

조건문안에서 시계방향 좌표의 범위가 0부터 n-1전까지인지 체크 후,
현재 좌표보다 시계방향 좌표 중 하나라도 작은경우
flag 변수를 활용하여
flag  = false, for문 break하여 빠져나옴
flag가 true인 경우 answer += 1
*/

private fun solutionCode(n: Int, arr: Array<Array<Int>>): Int {
    var answer = 0
    val zArr = Array(n + 2) { Array(n + 2) { 0 } }
    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    // 방법 1.
    /*for (i in 1 until n + 1) {
        for (j in 1 until n + 1) {
            zArr[i][j] = arr[i - 1][j - 1]
        }
    }
    println(zArr.contentDeepToString())

    for (i in 1 until n + 1) {
        for (j in 1 until n + 1) {
            val now = zArr[i][j]
            val up = zArr[i - 1][j]
            val down = zArr[i + 1][j]
            val left = zArr[i][j - 1]
            val right = zArr[i][j + 1]
            println("now: $now up: $up down: $down  left: $left right: $right")
            if (now > up && now > down && now > left && now > right) {
                println("answer: $now")
                answer += 1
            }
        }
    }*/

    // 방법 2.
    for (i in 0 until n) {
        for (j in 0 until n) {
            var flag = true
            for (k in dx.indices) {
                val nx = i + dx[k] //행 좌표
                val ny = j + dy[k] //열 좌표
                if (nx in 0 until n && ny in 0 until n && arr[nx][ny] >= arr[i][j]) {
                    flag = false
                    break
                }
            }
            if (flag) answer += 1
        }
    }

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