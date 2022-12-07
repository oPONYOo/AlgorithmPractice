package com.example.algorithmpractice.string

import android.text.style.CharacterStyle
import java.util.*
import kotlin.collections.ArrayList

/*5. 특정 문자 뒤집기
@since 2022.12.07.Wed
설명
영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
특수 문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.

출력
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.

예시 입력 1
a#b!GE*T@S

예시 출력 1
S#T!EG*B@a

*/


private fun solutionCode(str: String): String {
    val answer = str.toCharArray()
    var lt = 0
    var rt = str.length - 1
    while (lt < rt) {
        if (!answer[lt].isLetter()) {
            lt += 1
        } else if (!answer[rt].isLetter()) {
            rt -= 1
        }
        else {
            val tmp = answer[lt]
            answer[lt] = answer[rt]
            answer[rt] = tmp
            lt += 1
            rt -= 1
        }

    }


    var answerStr = ""

    for (c in answer) {
        answerStr = answerStr.plus(c)
    }


    return answerStr
}

fun main() {
    val sc = Scanner(System.`in`)
    val str = sc.next()
    val answer = solutionCode(str)
    println(answer)

}