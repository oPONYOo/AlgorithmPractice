package com.example.algorithmpractice.stackqueue

import java.util.*

/**4. 후위식 연산(postfix)
@since 2023.1.18.Fri
설명
후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.


입력
첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.

출력
연산한 결과를 출력합니다.


예시 입력 1
352+*9-

예시 출력 1
12

 */
/*
[풀기 전]
stack에 숫자 push
연산자 만나면 2개 pop
lt-rt

[풀고 난 후]
isDigit() 숫자인지 확인
0-9의 아스키 코드는 48-57
문자를 아스키 코드로 바꾸려면 문자.code 혹은 문자.toByte() 혹은 문자..digitToInt()
캐릭터형 문자 - 48 = 실제 숫자
*/

private fun solutionCode(s: String): Int {
    var answer = 0
    val stack = Stack<Int>()
    for (x in s.toCharArray()) {
        if (x.isDigit()) stack.push(x.code - 48)
        else {
            val rt = stack.pop()
            val lt = stack.pop()
            when (x) {
                '+' -> stack.push(lt + rt)
                '-' -> stack.push(lt - rt)
                '*' -> stack.push(lt * rt)
                '/' -> stack.push(lt / rt)
            }
        }
    }

    answer = stack[0]
    return answer

}


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.next()

    println(solutionCode(n))

}