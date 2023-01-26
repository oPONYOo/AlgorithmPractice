package com.example.algorithmpractice.sortingandsearching

import java.util.*

/**2. 버블 정렬
@since 2023.1.26.Thu
설명
N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 버블 정렬입니다.


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
버블정렬: 서로 이웃한 두 수를 비교해서 바꿔주기

이중 for문 실행
i는 0부터 n-1전까지
j는 0부터 n-1-i전까지
비교횟수가 줄어들어야하므로
j가 i보다 1 적게 돌아야함


[풀고 난 후]

*/


private fun solutionCode(n: Int, arr: Array<Int>): Array<Int> {

    for (i in 0 until n - 1) {
        for (j in 0 until n - 1 - i) {
            if (arr[j] > arr[j + 1]) {
                val tmp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = tmp
            }
        }
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