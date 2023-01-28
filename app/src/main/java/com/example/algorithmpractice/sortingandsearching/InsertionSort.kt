package com.example.algorithmpractice.sortingandsearching

import java.util.*

/**3. 삽입 정렬
@since 2023.1.28.Sat
설명
N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 삽입 정렬입니다.


입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다.
각 자연수는 정수형 범위 안에 있습니다.

출력
오름차순으로 정렬된 수열을 출력합니다.

예시 입력 1
6
11 7 5 6 10 9



예시 출력 1
5 6 7 9 10 11


 */
/*
[풀기 전]
오름차순
삽입 정렬: 이전 숫자들 for문으로 돌면서
현재 숫자가 더 크면 뒤(오름차순이므로)로 밀어준다.
이전 숫자를 삽입한다.
for문 i는 1부터 arr.size전까지
j = i-1
j가 -1이 아닌동안 while문 실해
tmp = arr[i]
arr[j] > tmp라면 arr[j+1] = arr[j]
아니라면 break
j--
j for문 빠져나온후
arr[j+1](밀린 자리)에 tmp 넣어주기


[풀고 난 후]

*/


private fun solutionCode(n: Int, arr: Array<Int>): Array<Int> {
    for (i in 1 until n) {
        val tmp = arr[i]
        var j = i-1
        while (j != -1) {
            if (arr[j] > tmp) arr[j+1] = arr[j]
            else break
            j--
        }
        arr[j+1] = tmp
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