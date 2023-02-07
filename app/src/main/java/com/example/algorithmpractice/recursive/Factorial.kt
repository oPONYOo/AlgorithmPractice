package com.example.algorithmpractice.recursive

import java.util.*

/**3. 팩토리얼
@since 2023.2.6.Mon

설명
자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
예를 들어 5! = 5*4*3*2*1 = 120입니다.


입력
첫 번째 줄은 지얀수 N(1<=N<=100)이 주어집니다.


출력
첫째 줄에 N팩토리얼 값을 출력합니다..


예시 입력 1
5


예시 출력 1
120



 */
/*
[풀기 전]
재귀함수: 자기 자신 호출하는 함수


[풀고 난 후]

*/

private fun DFS(n: Int): Int {
//    sum = n-1

    return if (n == 1) 1
    else n * DFS(n-1)


}


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    println(DFS(n))
}