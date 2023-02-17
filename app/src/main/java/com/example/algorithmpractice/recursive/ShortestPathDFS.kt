package com.example.algorithmpractice.recursive

/**9. Tree 말단 노드까지의 가장 짧은 경로(DFS)
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
말단노드: 자식이 없는 노드
최단거리 문제는 BFS로 푸는게 맞음
연습으로 DFS로 풀어보기
자식이 하나만 있으면 성립X


[풀고 난 후]


*/


class Node_9(value: Int) {
    var data = value
    var lt: Node_9? = null
    var rt: Node_9? = null

    init {
        lt = null
        rt = null
    }

}

var root9: Node_9 = Node_9(0)

private fun DFS(L: Int, root: Node_9?): Int { // root는 노드를 가리키므로 계속 변동한다.
    return if (root!!.lt == null && root.rt == null) L // root가 가르키는 노드의 레벨
    else DFS(L + 1, root.lt).coerceAtMost(DFS(L + 1, root.rt))


}

fun main() {
    root9 = Node_9(1) //레벨 0
    root9.lt = Node_9(2) // 1
    root9.rt = Node_9(3) // 1
    root9.lt!!.lt = Node_9(4) // 2
    root9.lt!!.rt = Node_9(5)// 2

    println(DFS(0, root9))
}