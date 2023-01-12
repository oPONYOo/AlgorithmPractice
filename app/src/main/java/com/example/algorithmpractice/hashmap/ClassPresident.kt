package com.example.algorithmpractice.hashmap

import java.util.*
import kotlin.collections.HashMap

/**1. 학급 회장(hash)
@since 2023.1.12.Thu
설명
학급 회장을 뽑는데 후보로 기호 A,B,C,D,E 후보가 등록을 했습니다.
투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)기
쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지
출력하는 프로그램을 작성하세요.
반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.

입력
첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
두 번째 줄에 N개의 투표용지에 쓰여져 있던
각 후보의 기호가 선생님이 발표한 순서대로 입력됩니다

출력
학급 회장으로 선택된 기호를 출력합니다.

예시 입력 1
15
BACBACCACCBDEDE

예시 출력 1
C

 */
/*
[풀기 전]
for문 i 0부터 n-1까지 실행
hashmap key값으로 기호 넣어주기
        value 값으로 해당 기호 횟수
[풀고 난 후]

*/

private fun solutionCode(n: Int, str: String): Char {
    var answer = ' '
//    val map = hashMapOf('A' to 0, 'B' to 0, 'C' to 0, 'D' to 0, 'E' to 0)
    val map = HashMap<Char, Int>()
    for (s in str) {
        map[s] = if (map[s] == null) 0 else map[s]!!+1
        /*var cnt = map[s]!!
        map[s] = ++cnt*/
    }


    var max = 0
    map.entries.forEach {
        if (it.value > max) {
            max = it.value
            answer = it.key
        }
    }
    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val str = sc.next()


    println(solutionCode(n, str))


}