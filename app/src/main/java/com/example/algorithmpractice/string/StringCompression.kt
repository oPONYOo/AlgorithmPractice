package com.example.algorithmpractice.string

import java.util.*


/**11. 문자열 압축
@since 2022.12.25.Sun
설명
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
단 반복횟수가 1인 경우 생략합니다.

입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

출력
첫 줄에 압축된 문자열을 출력한다.

예시 입력 1
KKHSSSSSSSE

예시 출력 1
K2HS7E

 */
/*
[풀기 전]
문자열을 반복문을 실행시킨다.
나오는 문자를 변수에 할당한다.
반복되는 문자가 있을 때마다 ++1
반복되지 않으면 1로 초기화하고,
반복 횟수가 1보다 클때 answer 변수에 반복횟수 붙혀주기

[풀고 난 후]
i, i+1을 비교하려면 문자열 끝에 공백을 추가해준다.
단, 반복문 돌릴때 공백은 제외하고 돌린다.

*/

private fun solutionCode(str: String): String {
    val s = "$str "
    var answer = ""
    var c = str[0]
    var num = 0
    // 방법 1.
    /*for (i in s) {
        if (i == c) num++
        else {
            answer += c
            if (num > 1) answer += num.toString()
            num = 1
        }
        c = i


    }*/

    // 방법 2.
    var cnt = 1
    for (i in 0 until s.length - 1) {
        if (s[i] == s[i + 1]) cnt++
        else {
            answer += s[i]
            if (cnt > 1) answer += cnt.toString()
            cnt = 1
        }
    }

    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val str = sc.next()
    print(
        solutionCode(str)
    )


}