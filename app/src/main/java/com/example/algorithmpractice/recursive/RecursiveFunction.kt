package com.example.algorithmpractice.recursive

import java.util.*

/**1. 재귀함수(스택프레임)
@since 2023.2.5.Sun

설명
자연수 N이 입력되면 재귀함수를 이용하여
1부터 N까지를 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄은 정수 N(3<=N<=1)이 입력된다.


출력
첫째 줄에 출력한다.


예시 입력 1
3


예시 출력 1
1 2 3



 */
/*
[풀기 전]
재귀함수: 자기 자신 호출하는 함수

[풀고 난 후]
재귀함수는 스택을 사용한다.
스택의 제일 상단 DFS(n)부터 pop
호출했던 라인부터 실행
*/


private fun DFS(n: Int){

    if (n == 0) return
    else {
        DFS(n - 1)
        print("$n ")
    }


}


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    DFS(n)
}