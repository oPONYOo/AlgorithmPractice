package com.example.algorithmpractice.string

import java.util.*
import kotlin.collections.ArrayList

/*4. 단어 뒤집기
@since 2022.11.23.Wed
설명
N 개의 단가이 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 자연수 N(3<=N<=20)이 주어진다.
두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어진다. 단어는 영어 알파벳으로만 구성되어 있다.

출력
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력한다.

예시 입력 1
3
good
Time
Big

예시 출력 1
doog
emiT
GiB

*/


// String은 항상 새로운 객체를 생성하는데, StringBuilder는 처음 만든 객체로 계속 쓰기 때문에 메모리 낭비가 없다.
fun solution(idx: Int, str: ArrayList<String>): ArrayList<String> {
    val answer = ArrayList<String>()
    str.forEach {
//  방법 3.
        /*val cList = it.toCharArray()
        var lt = 0
        var rt = it.length - 1
        while (lt < rt) {
            val tmp = cList[lt]
            cList[lt] = cList[rt]
            cList[rt] = tmp
            lt++
            rt--
        }
        var answerStr = ""

        for (c in cList) {
            answerStr = answerStr.plus(c)
        }
        answer.add(answerStr)*/
//  방법 1.
        answer.add(StringBuilder(it).reverse().toString())
//  방법 2
//        answer.add(it.reversed())
    }

    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val idx = sc.nextInt()
    val str = ArrayList<String>(idx)
    for (i in 0 until idx) {
        str.add(sc.next())
    }
    val answer = solution(idx, str)
    answer.forEach {
        println(it)
    }

}