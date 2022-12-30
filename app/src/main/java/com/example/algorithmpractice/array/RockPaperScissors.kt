package com.example.algorithmpractice.array

import java.util.*


/**2. 보이는 학생
@since 2022.12.30.Fri
설명
A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면
A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
예를 들어 N=5이면
회수 1 2 3 4 5
A   2 3 3 1 3
B   1 1 2 2 3
승자 A B A B D

두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지
출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어진다.
두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어진다.
세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어진다.

출력
각 줄에 각 회의 승자를 출력한다. 비겼을 경우 D를 출력한다.

예시 입력 1
5
2 3 3 1 3
1 1 2 2 3

예시 출력 1
A
B
A
B
D

 */
/*
[풀기 전]
A, B 배열 for문 실행
숫자가 같으면 D
A 기준으로 B보다 1차이로 크면 A
              2차이로 작으면 A
              같으면 D
              나머지 경우 B


[풀고 난 후]

*/

private fun solutionCode(n: Int, a: Array<Int>, b: Array<Int>): String {
    var answer = ""

    for (i in 0 until n) {
        answer += if (a[i] == b[i]) "D"
        else if (a[i] - b[i] == 1) "A"
        else if (b[i] - a[i] == 2) "A"
        else "B"
    }

    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val num = sc.nextInt()
    val a = Array(num) { 0 }
    val b = Array(num) { 0 }
    for (i in 0 until num) {
        a[i] = sc.nextInt()
    }
    for (i in 0 until num) {
        b[i] = sc.nextInt()
    }
    for (c in solutionCode(num, a, b)) {
        println(c)
    }



}