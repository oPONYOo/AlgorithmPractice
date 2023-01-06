package com.example.algorithmpractice.twopointersslidingwindow

import java.util.*
import kotlin.collections.ArrayList

/**2. 공통원소 구하기(two pointers algorithm)
@since 2023.1.6.Fri
설명
A, B 두 개의 집합이 주어지면 두 집합의 공통원소를 추출하여 오름차순으로 출력하는
프로그램을 작성하세요.

입력
첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
두 번째 줄에 N개의 배열 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
각 집합의 원소는 1,000,000,000 이하의 자연수입니다.

출력
두 집합의 공통원소를 오름차순 정렬하여 출력합니다.

예시 입력 1
5
1 3 9 5 2
5
3 2 5 7 8

예시 출력 1
2 3 5

 */
/*
[풀기 전]
먼저 오름차순으로 정렬
포인터 2개
p1 < n && p2 < m
p1이 n보다 작고 p2가 m보다 작을경우 while문 실행
-> 둘 중 하나만 커져도 while문 멈춤
arr1[p1] arr2[p2] 비교하여 같으면 answer배열에 추가 후에 포인터 둘다 동시에 증
                         직으면 작은쪽의 포인터 증가

후치연산자 활용하기

남은 배열이 무엇인지 모르니까
두 배열 모두 조건에 부합할 시 while문 실행

[풀고 난 후]

*/

private fun solutionCode(n: Int, m: Int, arr1: Array<Int>, arr2: Array<Int>): ArrayList<Int> {
    val answer = ArrayList<Int>()
    val a = arr1.sortedArray()
    val b = arr2.sortedArray()
    var p1 = 0
    var p2 = 0
    while (p1 < n && p2 < m) {
        println(a[p1])
        println(b[p2])
        if (a[p1] == b[p2]) {
            answer.add(a[p1++])
            p2++
        }
        else if (a[p1] < b[p2]) p1++
        else p2++

    }



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