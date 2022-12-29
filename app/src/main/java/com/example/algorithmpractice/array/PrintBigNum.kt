package com.example.algorithmpractice.array

import java.util.*
import kotlin.collections.ArrayList

/**1. 큰 수 출력하기
@since 2022.12.29.Thu
설명
N(1<=N<=100)개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을
작성하세요.(첫 번째 수는 무조건 출력한다.)

입력
첫 줄에 자연수 N이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.

출력
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.

예시 입력 1
6
7 3 9 5 6 12

예시 출력 1
7 9 6 12

 */
/*
[풀기 전]


[풀고 난 후]


*/

private fun solutionCode(n: Int, numbers: Array<Int>): ArrayList<Int> {
    val answer = ArrayList<Int>()
//    var front = numbers[0]
    answer.add(numbers[0])

    // 방법 1.
    for (i in 1 until numbers.size) {
        if (numbers[i] > numbers[i-1]) answer.add(numbers[i])
    }

    // 방법 2.
    /*numbers.forEach {
        if (it > front) answer.add(it)
        front = it
    }*/


    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val num = sc.nextInt()
    val arr = Array(num) { 0 }
    for (i in 0 until num) {
        arr[i] = sc.nextInt()
    }
    solutionCode(num, arr).forEach {
        print("$it ")
    }


}