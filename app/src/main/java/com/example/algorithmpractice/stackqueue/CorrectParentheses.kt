package com.example.algorithmpractice.stackqueue

import java.util.*

/**1. 올바른 괄호
@since 2023.1.17.Tue
설명
괄호가 입력되면 올바른 괄호이면 "YES", 올바르지 않으면 "NO"를 출력합니다.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (())()은 올바른 괄호가 아니다.

입력
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.

출력
첫 번째 줄에 YES, NO를 출력한다.

예시 입력 1
(()(()))(()

예시 출력 1
NO

 */
/*
[풀기 전]
LinkedList에 문자 넣기
여는 괄호면 push()
닫는 괄호면 넣은 거 pop()
[풀고 난 후]

*/

private fun solutionCode(s: String): String {
    val answer = "YES"
    val list = LinkedList<Char>()
    s.toCharArray().forEach {
        if (it == '(') list.push(it)
        else {
            if (list.isEmpty()) return "NO"
            list.pop()
        }
    }
    if (list.isNotEmpty()) return "NO"
    return answer

}


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.next()

    println(solutionCode(n))

}