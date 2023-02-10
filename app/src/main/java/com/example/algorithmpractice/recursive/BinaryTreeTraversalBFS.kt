package com.example.algorithmpractice.recursive

import java.util.LinkedList
import java.util.Queue

/**7. 이진트리 순회(BFS: Breadth-First Search)
@since 2023.2.10.Fri

설명
아래 그림과 같은 이진 트리를 전위순회와 후위순회를 연습해보세요.

       1(root)

   2            3

 4    5       6    7

입력



출력
레벨 탐색 순회 출력: 1 2 3 4 5 6 7


예시 입력 1


예시 출력 1



 */
/*
[풀기 전]
넓이우선탐색: 레벨 탐색
레벨 순서대로 출력
루트에서 한 번만에 갈 수 있는 노드들 탐색
큐 사용
[풀고 난 후]

*/



class Node2(value: Int) {
    var data = value
    var lt: Node2? = null
    var rt: Node2? = null

    init {
        lt = null
        rt = null
    }

}

var root2: Node2 = Node2(0)

private fun BFS(root2: Node2?) {
    val Q: Queue<Node2> = LinkedList()
    Q.offer(root2)
    var L = 0
    while (Q.isNotEmpty()) {
        val len = Q.size
        print("$L : ")
        for (i in 0 until len) {
            val cur = Q.poll()
            print("${cur!!.data} ")
            if (cur.lt != null) Q.offer(cur.lt)
            if (cur.rt != null) Q.offer(cur.rt)
        }
        L++
        println()
    }
}

fun main() {
    root2 = Node2(1)
    root2.lt = Node2(2)
    root2.rt = Node2(3)
    root2.lt!!.lt = Node2(4)
    root2.lt!!.rt = Node2(5)
    root2.rt!!.lt = Node2(6)
    root2.rt!!.rt = Node2(7)
    BFS(root2) // 100번지 root노드
}