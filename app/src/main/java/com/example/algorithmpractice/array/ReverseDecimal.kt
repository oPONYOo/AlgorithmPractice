package com.example.algorithmpractice.array

import java.util.*
import kotlin.collections.ArrayList

/**6. 뒤집은 소수
@since 2023.1.1.Sun
설명
N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는
프로그램을 작성하세요. 예를 들어 32를 뒤집으면 23이고, 23은 소수이다.
그러면 23을 출력하낟. 단 910을 뒤집으면 19로 숫자화 해야한다.
첫 자리부터 연속된 0은 무시한다.

입력
첫 줄에 자연수의 개수 N(2<=N<=100)이 주어지고,
그 다음 줄에 N개의 자연수가 주어진다.
각 자연수의 크기는 100,000를 넘지 않는다.


출력
첫 줄에 뒤집은 소수를 출력합니다.
출력 순서는 입력된 순서대로 출력합니다.

예시 입력 1
9
32 55 62 20 250 370 200 30 100

예시 출력 1
23 2 73 2 3

 */
/*
[풀기 전]
넘어온 배열 반복문 실행
뒤집기
앞에 0 없애기
1이 아니고,
2 - 자기 자신 전까지 로 나눴을 때 나머지가 0이면
리턴할 배열에 추가

[풀고 난 후]
10잔수화 공식 활용해서 뒤집기
t = n % 10
n = n * 10 + t
tmp = tmp /10

*/

private fun solutionCode(n: Int, array: Array<Int>): ArrayList<Int> {
    val answer = ArrayList<Int>()
    var count = 0
    // 방법 1.
    for (i in array.indices) {
        var tmp = array[i]
        var res = 0
        while (tmp > 0) {
            val t = tmp % 10
            res = res * 10 + t
            tmp /= 10
        }
        if (isPrime(res)) answer.add(res)
    }

    // 방법 2.
    /*array.forEach {
        val str = it.toString()
        val num = str.reversed().toInt()
        for (i in 2 until num ) if (num % i == 0) count++
        if (count <= 1 && num != 1) answer.add(num)
        count = 0
    }*/


    return answer
}

private fun isPrime(num: Int): Boolean {
    if (num == 1) return false
    for (i in 2 until num) {
        if (num % i == 0) return false
    }
    return true
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