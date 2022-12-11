package com.example.algorithmpractice.string

import java.lang.StringBuilder
import java.util.*

/*7. 회문문자열
@since 2022.12.12.Mon
설명
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 "NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 대소문자를 구분하지 않습니다.

입력
첫 줄에 길이 100을 넘지 않는 공백의 없는 문자열이 주어집니다.

출력
첫 번째 줄에 회문 문자열인지의 결과의 YES 또는 NO로 출력합니다.

예시 입력 1
godG

예시 출력 1
YES

*/
/*
[풀기 전]
단어의 개수가 몇 개인지
짝수라면 절반을 나눠서 같은지 확인
홀수 라면 가운데 글자 기준으로 양 옆의 단어가 같은지 확인
대소문자 신경 안쓰므로 대문자 혹은 소문자로 통일하기

[풀고 난 후]
짝수 홀수로 나눠서 처리할 필요없음
무조건적으로 if, else로 나눠서 처리하지말고 if로 끝낼 수 있다면 if문으로만 작성하기
대소문자 무시하고 비교할 수 있는 ignoreCase가 있다.
String은 붋변이기 때문에 문자열을 수정하는 시점에 항상 새로운 객체를 생성하는데,
StringBuilder는 가변이기 때문에 동일 객체 내에서 문자열 변경이 가능해서 메모리 낭비가 없다.

*/

private fun solutionCode(str: String): String {
    val lowerStr = str.lowercase()
    var answer = "YES"

    println(str.length)

    // 방법 1.
    /*answer = if (lowerStr == lowerStr.reversed()) "YES"
    else "NO"*/

    // 방법 2.
    /*for (i in 0 until str.length / 2) {
        if (lowerStr[i] != lowerStr[str.length - 1 - i]) return "NO"
    }*/

    // 방법 3.
    val a = StringBuilder(str).reverse().toString()
    answer = if (str.equals(a, true)) "YES"
    else "NO"


    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val str = sc.next()
    val answer = solutionCode(str)
    println(answer)

}