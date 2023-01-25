package com.example.algorithmpractice.sortingandsearching

import java.util.*

/**1. 선택 정렬
@since 2023.1.25.Wed
설명
N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 선택 정렬입니다.


입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다.
각 자연수는 정수형 범위 안에 있습니다.

출력
오름차순으로 정렬된 수열을 출력합니다.

예시 입력 1
6
13 5 11 7 23 15



예시 출력 1
5 7 11 13 15 23


 */
/*
[풀기 전]
이중 for문 실행
i는 0부터 n-1전까지
idx에 i할당
j는 i+1 부터 n전까지 돌면서 가장 작은 값을 찾아서 자리 바꾸기
arr[idx]:현재 값
arr[j]: arr[idx] 다음값들
arr[j] < arr[idx] 작을 때 idx = j
j for문 끝나고 arr[i], arr[idx] 서로 값 바꿔주기


[풀고 난 후]
j가 끝까지 돌기때문에 i는 끝까지 돌 필요없다.
*/


private fun solutionCode(n: Int, arr: Array<Int>): Array<Int> {
    var idx: Int
    for (i in 0 until n - 1) {
        idx = i
        for (j in i + 1 until n) if (arr[j] < arr[idx]) idx = j
        val tmp = arr[i]
        arr[i] = arr[idx]
        arr[idx] = tmp
    }

    return arr

}


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }
    for (x in solutionCode(n, arr)) {
        print("$x ")
    }

}