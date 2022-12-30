package com.example.algorithmpractice.array

import java.util.*
import kotlin.collections.ArrayList

/**2. 보이는 학생
@since 2022.12.30.Fri
설명
선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가
앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는 선생님이 볼 수 있는
학생의 수를 구하는 프로그램을 작성하세요.
(어떤 학생이 자기 앞에 서 있는 학생들보다 크면 그 학생은 보이고,
작거나 같으면 보이지 않습니다.)

입력
첫 줄에 정 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의
키가 앞에서부터 순서대로 주어진다.

출력
선생님이 볼 수 있는 최대학생수를 출력한다.

예시 입력 1
8
130 135 148 140 145 150 150 153

예시 출력 1
5

 */
/*
[풀기 전]
키 배열을 만든다.
맨 처음 키는 앞에 비교할 대상이 없으므로 추가한다.
두번 째 키부터 배열에 있는 값들과 비교한다.
크면 추가한다.
배열의 크기를 리턴한다.

[풀고 난 후]
이중 for문 x
키 배열에서 가장 큰 값(max)보다 크면 추가

*/

private fun solutionCode(n: Int, numbers: Array<Int>): Int {
    val height = ArrayList<Int>()
    height.add(numbers[0])

    // 방법 1.
    /*for (i in 1 until numbers.size) {
        if (numbers[i] > height.max() ) height.add(numbers[i])
    }*/

    // 방법 2.
    numbers.forEach { if (it > height.max()) height.add(it) }
    println(height)

    return height.size
}

fun main() {
    val sc = Scanner(System.`in`)
    val num = sc.nextInt()
    val arr = Array(num) { 0 }
    for (i in 0 until num) {
        arr[i] = sc.nextInt()
    }
    println(solutionCode(num, arr))



}