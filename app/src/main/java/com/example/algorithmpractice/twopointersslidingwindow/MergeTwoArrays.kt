package com.example.algorithmpractice.twopointersslidingwindow

import java.util.*
import kotlin.collections.ArrayList


/**1. 두 배열 합치기(two pointers algorithm)
@since 2023.1.5.Thu
설명
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로
합쳐 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

출력
오름차순으로 정렬된 배열을 출력합니다.

예시 입력 1
3
1 3 5
5
2 3 6 7 9

예시 출력 1
1 2 3 3 5 6 7 9

 */
/*
[풀기 전]
포인터 2개
p1 p2
p1이 n보다 작을 경우 while문 실행
arr1[p1] arr2[p2] 비교하여 작으면(같으면 아무거나 먼저) answer배열에 추가
포인터는 1씩 증가

남은 배열은 다시 while문 실행?

[풀고 난 후]
p1 < n && p2 < m
p1이 n보다 작고 p2가 m보다 작을경우 while문 실행
-> 둘 중 하나만 커져도 while문 멈춤

후치연산자 활용하기

남은 배열이 무엇인지 모르니까
두 배열 모두 조건에 부합할 시 while문 실행
*/

private fun solutionCode(n: Int, m: Int, arr1: Array<Int>, arr2: Array<Int>): ArrayList<Int> {
    val answer = ArrayList<Int>()
    var p1 = 0
    var p2 = 0
    while (p1 < n && p2 < m) {
        if (arr1[p1] < arr2[p2]) answer.add(arr1[p1++])
        else answer.add(arr2[p2++])
    }
    while (p1 < n) answer.add(arr1[p1++])
    while (p2 < m) answer.add(arr2[p2++])
    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val arr1 = Array(n) { 0 }
    for (i in 0 until n) {
        arr1[i] = sc.nextInt()
    }
    val m = sc.nextInt()
    val arr2 = Array(m) { 0 }
    for (i in 0 until m) {
        arr2[i] = sc.nextInt()
    }
    for (x in solutionCode(n, m, arr1, arr2)) {
        print("$x ")
    }


}