package com.example.algorithmpractice.string

import android.icu.number.IntegerWidth
import java.lang.StringBuilder
import java.util.*

/**8. 숫자만 추출
@since 2022.12.15.Thu
설명
문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
만약 "tgeOa1h205er"에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수로 만들면 1205이 됩니다.
추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.

입력
첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.

출력
첫 줄에 자연수를 출력합니다.

예시 입력 1
g0en2T0s8eSoft

예시 출력 1
208

 */
/*
[풀기 전]
숫자만 남기기
맨 앞에 0인지 확인

[풀고 난 후]
isDigit() 메서드로 숫자인지 확인이 가능하다.
toInt() 메서드가 맨 앞에 0을 없애준다.
-> 내부 구현에서 문자열을 char단위로 순회하면서 * 10을 해주어 자릿수를 올리면서 값들을 모두 합친다.
10진수화 공식활용 answer = answer * 10 + (x - 48)
---------------------------------------------
0-9의 아스키 코드는 48-57
문자를 아스키 코드로 바꾸려면 문자.code 혹은 문자.toByte()
문자열의 각 문자를 아스키 코드를 변환하려면 문자열.toByteArray()

*/

private fun solutionCode(str: String): Int {
    var answer = 0

    // 방법 .1
    /*val n = "[^0-9]".toRegex()
    val onlyNum = str.replace(n, "").toInt()*/

    // 방법 2.
    /*var numStr = ""
    str.forEach {
        if (it.code in 48..58) numStr += it
    }*/

    //방법 3.
    /*var numStr = ""
    str.forEach {
        if (it.isDigit()) numStr += it
    }*/

    // 방법 4.
    val c = str.toByteArray()
    c.forEach {
        if (it in 48..57) {
        answer = answer * 10 + (it - 48)
    }

    }

    println(answer)


    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val str = sc.next()
    val answer = solutionCode(str)
    println(answer)

}