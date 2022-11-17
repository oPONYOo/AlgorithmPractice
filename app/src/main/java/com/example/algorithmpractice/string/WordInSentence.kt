package com.example.algorithmpractice.string

import java.util.*

/*3. 문장 속 단어
@since 2022.11.17.Thu
설명
한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
문장 속의 각 단어는 공백으로 구분된다.


입력
첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어진다. 문장은 영어 알파벳으로만 구성되어 있다.

출력
첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
단어를 답으로 한다.

예시 입력 1
it is time to study

예시 출력 1
study

*/
fun solution1(str: String): String {
    var answer = ""
    var min = 0


    /* 방법 1.
    val strList = str.split(" ")
    strList.forEach {
        if (it.length > min) {
            min = it.length
            answer = it
        }
    }
    return answer*/


    /* 방법 2.
    var changeStr = str
    var pos = str.indexOf(" ") //공백 위치
    while (pos != -1) {
        val tmp = changeStr.substring(0, pos)
        val len = tmp.length
        if (len > min) {
            min = len
            answer = tmp
        }
        changeStr = changeStr.substring(pos + 1) //공백 위치 + 1
        pos = changeStr.indexOf(" ")
    }
    if (changeStr.length > min) answer = changeStr //마지막 단어 뒤에 공백이 없기 때문에 while문 밖에서 처리 필요

    return answer
*/
    // 방법 3.
    return str.split(" ").maxByOrNull { it.length }!!
}

fun main() {
    val sc = Scanner(System.`in`)
    val str = sc.nextLine()
    println(solution1(str))
}