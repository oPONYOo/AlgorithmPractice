package com.example.algorithmpractice.hashmap

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**3. 매출액의 종류(hash, sliding window)
@since 2023.1.14.Sat
설명
현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의
매출 기록을 주고 연속된 K일 동안의 매출액의 종류를 각 구간별로 구하라고 했습니다.
만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
20 12 20 10 23 17 10
각 연속 4일간의 구간의 매출종류는
첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터
각 구간별 매출액의 종류를 출력하는 프로그램을 작성하세요.

입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번쨰 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

출력
첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.


예시 입력 1
7 4
20 12 20 10 23 17 10

예시 출력 1
3 4 4 3

 */
/*
[풀기 전]
lt, rt
hashmap key: arr[k]
      value: 횟수

key의 개수 answer.add
sliding마다 map에서 lt값 1빼주기
0이면 remove

[풀고 난 후]

*/

private fun solutionCode(n: Int, k: Int, arr: Array<Int>): ArrayList<Int> {
    val answer = ArrayList<Int>()
    val map = HashMap<Int, Int>()

    for (i in 0 until k-1) {
        map[arr[i]] = if (map[arr[i]] == null) 1 else map[arr[i]]!! + 1
    }
    println(map)
    for ((lt, rt) in (k-1 until n).withIndex()) {
        map[arr[rt]] = if (map[arr[rt]] == null) 1 else map[arr[rt]]!! + 1
        answer.add(map.size)
        println(map)
        println(arr[lt])
        map[arr[lt]] = map[arr[lt]]!! - 1
        if (map[arr[lt]] == 0) map.remove(arr[lt])
    }

    // 방법 2.
    /*var rt = 0

    while (rt < n) {
        map[arr[rt]] = if (map[arr[rt]] == null) 1 else map[arr[rt]]!! + 1
        if (rt - lt == k - 1) {
            answer.add(map.keys.size)
            map[arr[lt]] = map[arr[lt]]!! - 1
            if (map[arr[lt]] == 0) map.remove(arr[lt])
            lt++
        }
        rt++
    }*/

    /*for (rt in 0 until n) {
        map[arr[rt]] = if (map[arr[rt]] == null) 1 else map[arr[rt]]!! + 1
        if (rt - lt == k - 1) {
            answer.add(map.keys.size)
            map[arr[lt]] = map[arr[lt]]!! - 1
            if (map[arr[lt]] == 0) map.remove(arr[lt])
            lt++
        }
    }*/

    return answer

}


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }


    solutionCode(n, k, arr).forEach {
        print("$it ")
    }

}