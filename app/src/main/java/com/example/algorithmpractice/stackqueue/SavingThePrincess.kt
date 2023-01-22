package com.example.algorithmpractice.stackqueue

import java.util.*

/**6. 공주 구하기
@since 2023.1.22.Sun
설명
정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.
정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다.
정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.
왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다.
그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다.
그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다.
한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다.
그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.
이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다.

예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자.
처음에는 3번 왕자가 3을 외쳐 제외된다.
이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고
마지막까지 남게 된 7번 왕자에게 공주를 구하러갑니다.
N과 k가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.


입력
첫 줄에 자연수 N(5<=N<=1,000)과 K(2<=K<=9)가 주어진다.


출력
잘려진 조각의 총 개수를 나타내는 정수를 한 줄에 출력한다.


예시 입력 1
8 3

예시 출력 1
7


 */
/*
[풀기 전]
LinkedList에 왕자 넣기
list가 비어있지 않는동안 반복문 실행
1부터 k-1만큼 head값 뒤로 넣어주기
k값 poll
list에 값 1개 일 때 answer에 넣어주기
[풀고 난 후]
Queue
offer: 값 넣기
poll: head값 빼고 return
*/

private fun solutionCode(n: Int, k: Int): Int {
    var answer = 0
    val q = LinkedList<Int>()
    for (i in 1 until n + 1) q.offer(i)
    while (q.isNotEmpty()) {
        for (i in 1 until k) q.offer(q.poll())
        q.poll()
        if (q.size == 1) answer = q.poll() as Int
    }

    return answer

}


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()

    println(solutionCode(n, k))

}