package com.example.algorithmpractice.sortingandsearching

import java.util.*
import kotlin.collections.ArrayList

/**7. 좌표 정렬(compareTo)
@since 2023.2.1.Wed
설명
N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.

입력
첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.

출력
N개의 좌표를 정렬하여 출력하세요.



예시 입력 1
5
2 7
1 3
1 2
2 5
3 6




예시 출력 1
1 2
1 3
2 5
2 7
3 6



 */
/*
[풀기 전]
x값이 같으면 y값으로 정렬
     다르면 x값 기준으로 정렬

이중 for문 실행
x값 기준으로 먼저 좌표 정렬

[풀고 난 후]
Comparable 인터페이스를 상속받는 data class 생성
kotlin에서 제공하는 compareValuesBy()를 통해 간단하게 compareTo()를 구현할 수 있다.
compareValuesBy()에 비교할 두개의 객체 a, b와 가변인자 selectors를 받는다.
selectors는 람다로 비교할 타입 T를 넘겨받아 Comparable을 리턴해주고,
compareValuesBy()에서는 두 개의 Comparable을 비교한 값이
0이 아니라면 return해주고,
0이라면 계속해서 다음 가변인자를 비교해줍니다.
이런식으로 클래스의 필드에 따라 우선순위를 두어 compareTo()를 구현할 수 있다.


*/



data class Position(var x: Int, var y: Int) : Comparable<Position> {

    override fun compareTo(other: Position): Int {
        return compareValuesBy(
            this, other, {it.x}, {it.y}

        )     }

}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val arr = ArrayList<Position>()
    for (i in 0 until n) {
        val x = sc.nextInt()
        val y = sc.nextInt()
        arr.add(Position(x, y))
    }

    arr.sort()
    for (p in arr) {
        println("${p.x} ${p.y}")
    }

}