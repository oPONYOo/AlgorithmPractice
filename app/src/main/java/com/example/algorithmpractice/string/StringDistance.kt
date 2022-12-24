package com.example.algorithmpractice.string

import java.util.*
import kotlin.collections.ArrayList


/**10. 문자거리
@since 2022.12.25.Sun
설명
가장 짧은 문자거리
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를
출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어진다.
문자열의 길이는 100을 넘지 않는다.

출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

예시 입력 1
teachermode e

예시 출력 1
1 0 1 2 1 0 1 2 2 1 0

 */
/*
[풀기 전]
t e a c h e r m o d e
1 0 1 2 1 0 1 2 2 1 0
0 1 2 3 4 5 6 7 8 9 10
해당 문자의 index를 찾는다.
문자열 반복문으로 돌려서 현재 문자와 해당 문자의 index를 비교한다.
절대값 비교?

[풀고 난 후]
문자열의 0번부터 반복문을 실행시킨다.
이때 반복문을 돌릴때 가장 첫 번째 값은 최소 거리를 아직 알 수 없으므로 거리 변수를 큰 숫자로 설정해준다.
반복문을 돌리면서 해당 문자와 주어진 문자가 같다면 거리 변수를 0으로 설정해준다.
같지 않다면 거리 변수에 1을 더해준다.
배열의 문자열의 현재 인덱스에 거리 값를 넣어준다.

반대로 해당 문자열의 가장 끝부터 반복문을 실행시킨다.
이때 마찬가지로 가장 마지막 값에는 거리 변수를 큰 숫자로 설정해준다.
반복문을 돌리면서 해당 문자와 주어진 문자가 같다면 배열에 0으로 설정해준다.
같지 않다면 거리 변수에 1을 더해주고,
배열의 문자열의 현재 인덱스에 들어있는 값과 거리 값을 비교하여 작은 값을 넣어준다.


coerceAtMost: 호출된 객체가 특정 개체보다 작은지 아닌지를 확인해준다.
호출된 객체가 더 작으면 객체 자체를 반환하고 그렇지 않으면 최대 객체를 반환한다.

*/

private fun solutionCode(str: String, c: Char): ArrayList<Int> {
    val answer = ArrayList<Int>(str.length)
    var distance = 1000

    for (i in str.indices) {
        if (str[i] == c) {
            distance = 0
            answer.add(distance)
        } else {
            distance++
            answer.add(distance)

        }
    }

    distance = 1000
    for (i in str.length - 1 downTo 0) {
        if (str[i] == c) distance = 0
        else {
            distance++
            answer[i] = answer[i].coerceAtMost(distance)
        }
    }

    println(answer)
    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val str = sc.next()
    val c = sc.next()[0]
    for (i in solutionCode(str, c)) {
        print("$i ")
    }


}