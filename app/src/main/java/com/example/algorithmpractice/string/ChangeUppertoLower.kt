package com.example.algorithmpractice.string

import java.util.*
/* 2. 대소문자 변환
@since 2022.11.16.Wed
설명
대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여
출력하는 프로그램을 작성하세요.


입력
첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
문자열은 영어 알파벳으로만 구성되어 있습니다.

출력
첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력한다.
*/

// 대문자 아스키코드 65-90
// 소문자         97-122
fun solution(str: String): String {
    var change = ""
    str.forEach {
        change = if (it.isLowerCase()) change.plus(it.uppercase()) else change.plus(it.lowercase())
        /*change =
            if (it.code >= 97) change.plus((it.code - 32).toChar()) else change.plus((it.code + 32).toChar())*/
    }
    return change
}

fun main() {
    val sc = Scanner(System.`in`)
    val str = sc.next()
    println(solution(str))
}