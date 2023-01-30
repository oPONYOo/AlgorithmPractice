package com.example.algorithmpractice.sortingandsearching

import java.util.*

/**5. 중복 확인
@since 2023.1.30.Mon
설명
현수네 반에는 N명의 학생들이 있습니다.
선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서
각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.
두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.

출력
첫 번째 줄에 D 또는 U를 출력한다.



예시 입력 1
8
20 25 52 30 39 33 43 39


예시 출력 1
D



 */
/*
[풀기 전]
N명의 학생들의 숫자가 서로 중복인지 아닌지
방법1. HashMap
방법2. 이중 for문 실행
방법3. 오름차순 정렬 후, for문 실행
[풀고 난 후]

*/


private fun solutionCode(n: Int, arr: Array<Int>): String {
    val answer = "U"

    //방법 1.
    /*val map = HashMap<Int, Int>()
    for (i in 0 until n) {
        if (map[arr[i]] != null ) return "D"
        map[arr[i]] = 1
    }*/


    // 방법 2.
    /*for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            if (arr[i] == arr[j]) {
                return "D"
            }
        }
    }
*/

    //방법 3.
    arr.sort()
    for (i in 0 until n-1) {
        if (arr[i] == arr[i+1]) return "D"
    }
    return answer

}


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }
    println(solutionCode(n, arr))
}