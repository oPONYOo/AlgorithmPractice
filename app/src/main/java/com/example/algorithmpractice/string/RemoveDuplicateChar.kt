package com.example.algorithmpractice.string

import java.util.*
import kotlin.collections.HashMap

/*6. 중복문자제거
@since 2022.12.07.Wed
설명
소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.


입력
첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.

출력
첫 줄에 중복문자가 제거된 문자열을 출력합니다.

예시 입력 1
ksekkset

예시 출력 1
kset

*/


private fun solutionCode(str: String): String {
    var answer = ""

    // 방법 1.
    /*for (s in str) {
        if (answer.indexOf(s) == -1) answer += s
    }*/

    // 방법 2.
    for (i in str.indices) {
        if (str.indexOf(str[i]) == i) answer += str[i]
    }


    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val str = sc.next()
    val answer = solutionCode(str)
    println(answer)

}