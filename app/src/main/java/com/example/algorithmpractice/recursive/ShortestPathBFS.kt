package com.example.algorithmpractice.recursive

import java.util.LinkedList

/**10. Tree 말단 노드까지의 가장 짧은 경로(BFS)
@since 2023.2.17.Fri

설명

아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중
가장 짧은 길이를 구하는 프로그램을 작성하세요.
각 경로의 길이는 루트노트에서 말단노드까지 가는데 이동하는 횟수를 즉 간선(에지)의
개수를 길이로 하겠습니다.

      1(root)

  2            3

4    5

가장 짧은 길이는 3번 노드까지의 길이인 1이다.

입력



출력



예시 입력 1


예시 출력 1



 */
/*
[풀기 전]



[풀고 난 후]


*/


data class Node_10(val value: Int) {
    var data = value
    var lt: Node_10? = null
    var rt: Node_10? = null

    init {
        lt = null
        rt = null
    }

}

var root10: Node_10 = Node_10(0)

private fun BFS(root: Node_10?): Int {
    val Q = LinkedList<Node_10>()
    Q.offer(root)
    var L = 0
    while (Q.isNotEmpty()) {
        val len = Q.size
        println(len)
        for (i in 0 until len) {
            val cur = Q.poll() // 현재 노드
            println(cur)
            if (cur!!.lt == null && cur.rt == null) return L
            if (cur.lt != null) Q.offer(cur.lt)
            if (cur.rt != null) Q.offer(cur.rt)
        }
        L++
    }
    return 0
}

fun main() {
    root10 = Node_10(1) //레벨 0
    root10.lt = Node_10(2) // 1
    root10.rt = Node_10(3) // 1
    root10.lt!!.lt = Node_10(4) // 2
    root10.lt!!.rt = Node_10(5)// 2

    println(BFS( root10))
}