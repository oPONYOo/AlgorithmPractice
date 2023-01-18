package com.example.algorithmpractice.stackqueue

import java.util.*

/**2. 괄호문자제거
@since 2023.1.18.Wed
설명
입력된 문자열에서 소괄호 () 사이에 존재하는 모든 문자를 제거하고
남은 문자만 출력하는 프로그램을 작성하세요.

입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

출력
남은 문자만 출력한다.

예시 입력 1
(A(BC)D)EF(G(H)(IJ)K)LM(N)

예시 출력 1
EFLM

 */
/*
[풀기 전]
LinkedList에 여는 괄호와 알파벳만 push
닫는 괄호가 나오면 열린 괄호가 나올때 까지
while문 실행해서 pop

answer에 list에 남은 문자열을 뒤집어서 더해준다.
[풀고 난 후]
코틀린에서 while문의 body없이 사용가능
while(조건) {}
*/

private fun solutionCode(s: String): String {
    var answer = ""
    val list = LinkedList<Char>()
    var c = ' '

    s.toCharArray().forEach {
        if (it != ')') list.push(it)
        else {
            while (list.pop() != '(') {
            }
            /*while (c != '(') {
                c = list.pop()
            }
            c = ' '*/
        }
    }



    list.reversed().forEach {
        answer += it
    }

    return answer

}


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.next()

    println(solutionCode(n))

}