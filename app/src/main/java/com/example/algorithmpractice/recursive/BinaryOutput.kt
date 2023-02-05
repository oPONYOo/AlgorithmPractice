package com.example.algorithmpractice.recursive

import java.util.*

/**2. 재귀함수를 이용한 이진수 출력
@since 2023.2.5.Sun

설명
10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요.
단 재귀함수를 이용해서 출력해야 합니다.


입력
첫 번째 줄은 10진수 N(1<=N<=1,000)이 주어집니다.


출력
첫째 줄에 이진수를 출력하세요.


예시 입력 1
11


예시 출력 1
1011



 */
/*
[풀기 전]
재귀함수: 자기 자신 호출하는 함수
10진수를 2진수로 변환

[풀고 난 후]
1%2 = 1
2%2 = 0
5%2 = 1
11%2= 1
*/


private fun DFS(n: Int) {


    // 방법1. 반환값 Stirng일 경우
    /*return if (n != 0) DFS(n / 2) + n % 2 else {
        ""
    }*/

    if (n == 0) return
    else {
        DFS(n / 2)
        print("${n % 2}")
    }


}


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    DFS(n)
}