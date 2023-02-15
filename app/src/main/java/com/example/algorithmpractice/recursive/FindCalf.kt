package com.example.algorithmpractice.recursive

import java.util.*

/**8. 송아지 찾기 1(BFS : 상태트리탐색) -> 최단거리  알고리즘
@since 2023.2.15.Wed

설명
현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면
현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
송아지는 움직이지 않고 제자리에 있다.
현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.





입력
첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다.
직선의 좌표 점은 1부터 10,000까지이다.



출력
점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.



예시 입력 1
5 14



예시 출력 1
3



 */
/*
[풀기 전]
현재 현수의 위치인 5에서
1, -1, 5로 트리를 그려나가면 최소횟수는 3이다.
5(현수) -1 +5 -5 = 14(송아지)

이미 큐에 들어간 애들은 더 이상 못들어가도록 체크
[풀고 난 후]

*/

private val dis = listOf(1, -1, 5) // 현수가 이동할 수 있는 수
private var ch = IntArray(0) // 이미 큐에 들어간 애들은 더 이상 못 들어가도록 체크하는 역할
private val Q: Queue<Int> = LinkedList()

private fun BFS(s: Int, e: Int): Int {
    ch = IntArray(100001)
    ch[s] = 1
    Q.offer(s) // 현수 위치 Q에 넣어주기
    var L = 0 //레벨

    while (Q.isNotEmpty()) {
        val len = Q.size //x의 레벨
        for (i in 0 until len) {
            val x = Q.poll()!! // 현재 현수 위치
            for (j in 0 until 3) {
                val nx = x + dis[j] // x의 자식노드에 1, -1, 5 더하기
                if (nx == e) return L+1 // 자식노드와(자식노드이므로 +1) 송아지의 위치가 같으면 레벨 리턴
                if (nx in 1..10000 && ch[nx] == 0) { // 좌표 값을 충족하고, 자식노드 전에 체크한 적 없는지
                    ch[nx] = 1
                    Q.offer(nx)
                }
            }
        }
        L++ // 레벨 ++
    }
    return 0

}


fun main() {
    val sc = Scanner(System.`in`)
    val s = sc.nextInt()
    val e = sc.nextInt()

    println(BFS(s, e))
}