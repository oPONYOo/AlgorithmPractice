package com.example.algorithmpractice.array

import java.util.*
import kotlin.collections.ArrayList

/**8. 등수구하기
@since 2023.1.1.Sun
설명
N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로
출력하는 프로그램을 작성하세요.
같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
즉 가장 높은 점수가 92점인데 92점이 3명 존재하면
1등이 3명이고 그 다음 학생은 4등이 된다.

입력
첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.

출력
입력된 순서대로 등수를 출력한다.

예시 입력 1
5
87 89 92 100 76

예시 출력 1
4 3 2 1 5

 */
/*
[풀기 전]
0부터 n-1까지
점수 배열 반복문 실행 i
이중 반복문 실행 j
조건: 배열[i] 보다 배열[j]이 클 경우에만 등수 증가  rank += 1
answer배열 현재 인덱스에 rank 넣기
rank 1로 초기화

[풀고 난 후]


*/

private fun solutionCode(n: Int, scores: Array<Int>): Array<Int> {
    val answer = Array(n) { 0 }
    var rank = 1

    // 방법 1.
    for (i in 0 until n) {
        for (j in 0 until n) if (scores[i] < scores[j]) rank += 1
        answer[i] = rank
        rank = 1
    }

    // 방법 2.
    /*scores.forEachIndexed { idx, i ->
        scores.forEach { j ->
            if (i < j) rank += 1
        }
        answer[idx] = rank
        rank = 1
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
    for (i in solutionCode(num, arr)) print("$i ")


}