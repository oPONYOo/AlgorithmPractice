package com.example.algorithmpractice.hashmap

import java.util.*
import kotlin.collections.HashMap

/**4. 모든 아나그램 찾기(hash ,sliding window)
@since 2023.1.15.Sun
설명
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

입력
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.

출력
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.


예시 입력 1
bacaAacba
abc

예시 출력 1
3

 */
/*
[풀기 전]
두 개의 hashmap만들어서 같으면 answer++

[풀고 난 후]

*/

private fun solutionCode(s: String, n: String): Int {
    var answer = 0
    val map1 = HashMap<Char, Int>()
    val map2 = HashMap<Char, Int>()

    for (c in n.toCharArray()) map2[c] = if (map2[c] == null) 1 else map2[c]!! + 1
    for (i in 0 until n.length - 1) map1[s[i]] = if (map1[s[i]] == null) 1 else map1[s[i]]!! + 1

    for ((lt, rt) in (n.length - 1 until s.length).withIndex()) {
        map1[s[rt]] = if (map1[s[rt]] == null) 1 else map1[s[rt]]!! + 1
        if (map1 == map2) answer++
        map1[s[lt]] = map1[s[lt]]!! - 1
        if (map1[s[lt]] == 0) map1.remove(s[lt])
    }


    return answer

}


fun main() {
    val sc = Scanner(System.`in`)
    val s = sc.next()
    val n = sc.next()



    println(solutionCode(s, n))

}