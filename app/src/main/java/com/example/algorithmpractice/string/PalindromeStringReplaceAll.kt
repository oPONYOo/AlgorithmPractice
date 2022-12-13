package com.example.algorithmpractice.string

import java.lang.StringBuilder
import java.util.*

/**8. 펠린드롬(정규식이용)
@since 2022.12.12.Mon
설명
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 펠린드롬이라고 합니다.
문자열이 입력되면 해당 문자열이 펠린드롬이면 "YES", 아니면 "NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.

입력
첫 줄에 길이 100을 넘지 않는 공백의 없는 문자열이 주어집니다.

출력
첫 번째 줄에 팰린드롬인지의 결과의 YES 또는 NO로 출력합니다.

예시 입력 1
found7, time: study; Yduts; emit, 7Dnuof

예시 출력 1
YES

 */
/*
[풀기 전]
문자인 것만 붙혀주기
공백 없애주기
ignoreCase를 사용하여 대소문자 무시한 후 reverse시켜서 같은지 비교
[풀고 난 후]
자바에서는 replaceAll() 메소드로 정규식을 치환할 수 있는데,
코틀린에서는 toRegex()와 replace()로 가능하다.
^가 부정의 의미
정규식을 잘 사용하면 공백을 따로 제거해주지 않아도 된다.
*/

private fun solutionCode(str: String): String {
    var answer = "NO"

    // 방법 1. (정규식 사용x)
    /*var onlyLetter = ""
    val s = str.replace(" ", "")
    s.forEach {
        if (it.isLetter()) {
            onlyLetter += it
        }
    }
    val reverse = StringBuilder(onlyLetter).reverse().toString()
    if (onlyLetter.equals(reverse, true))  answer = "YES"
*/

    // 방법 2.(정규식 사용o)
    val notLetter = "[^A-Z]".toRegex()
    val a = str.uppercase().replace(notLetter, "")

    val reverse = StringBuilder(a).reverse().toString()
    if (a == reverse) answer = "YES"
    println(a)

    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val str = sc.nextLine()
    val answer = solutionCode(str)
    println(answer)

}