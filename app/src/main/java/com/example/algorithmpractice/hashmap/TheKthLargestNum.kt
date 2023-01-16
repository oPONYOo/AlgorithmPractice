package com.example.algorithmpractice.hashmap

import java.util.*

/**5. K번째 큰 수(TreeSet)
@since 2023.1.16.Mon
설명
현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다.
같은 숫자의 카드가 여러장 있을 수 있습니다. 현수는 이 중 3장을 뽑아
각 카드에 적힌 수를 합한 값을 기록하려고 합니다.
3장을 뽑을 수 있는 모든 경우를 기록합니다. 기록한 값 중 K번째로 큰 수를
출력하는 프로그램을 작성하세요.
만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19....이고 K값이 3이라면
K번째 큰 값은 22입니다.

입력
첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고,
그 다음 줄에 N개의 카드값이 입력된다.

출력
첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.


예시 입력 1
10 3
13 15 34 23 45 65 33 11 26 42
예시 출력 1
143

 */
/*
[풀기 전]
TreeSet 중복제거+정렬(내림차순, 오름차순)
3중 for문 실행
같은 숫자의 카드 여러장 있을 수 있음
내립차순 정렬 k번째 수 가져오기 없으면 -1
[풀고 난 후]
Collections.reverseOrder()
-> 내림차순 정렬 가능
*/

private fun solutionCode(n: Int, k: Int, arr: Array<Int>): Int {
    val answer = 0
    val set = TreeSet<Int>(Collections.reverseOrder())
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            for (t in j + 1 until n) set.add(arr[i] + arr[j] + arr[t])
        }

    }

    set.forEachIndexed { idx, x ->
        if (idx == k - 1) return x
    }





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



    println(solutionCode(n, k, arr))

}