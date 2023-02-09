package com.example.algorithmpractice.recursive


/**5. 이진트리 순회(DFS: Depth-First Search 깊이우선탐색)
@since 2023.2.8.Wed

설명
아래 그림과 같은 이진 트리를 전위순회와 후위순회를 연습해보세요.

           1(root)

     2            3

   4    5       6    7

입력



출력
전위순회 출력: 1 2 4 5 3 6 7
중위순회 출력: 4 2 5 1 6 3 7
후위순회 출력: 4 5 2 6 7 3 1


예시 입력 1


예시 출력 1



 */
/*
[풀기 전]
전위순회: 부모(기준) -> 왼쪽 자식 -> 오른쪽 자식
중위순회: 왼쪽 자식 -> 부모 -> 오른쪽 자식
후위순회: 왼똑 자식 -> 오른쪽 자식 -> 왼쪽
[풀고 난 후]
for문이 재귀보다 성능이 좋다.
스택프레임이 너무 많이 쌓이기 때문
*/



class Node(value: Int) {
    var data = value
    var lt: Node? = null
    var rt: Node? = null

    init {
        lt = null
        rt = null
    }

}

var root: Node = Node(0)

private fun DFS(root: Node?) {
    if (root == null) return
    else {
        //print("${root.data} " ) //전위
        DFS(root.lt) //왼쪽
        //print("${root.data} " ) //중위
        DFS(root.rt) //오른쪽
        print("${root.data} " ) //후

    }

}

fun main() {
    root = Node(1)
    root.lt = Node(2)
    root.rt = Node(3)
    root.lt!!.lt = Node(4)
    root.lt!!.rt = Node(5)
    root.rt!!.lt = Node(6)
    root.rt!!.rt = Node(7)
    DFS(root) // 100번지 root노드
}