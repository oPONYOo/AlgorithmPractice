package com.example.algorithmpractice.recursive

import java.util.*
import kotlin.collections.ArrayList

/**13. 그래프 최단거리(BFS)
@since 2023.3.6.Mon

설명
다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선 수를 출력하세요.

입력
첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다.
그 다음부터 M주에 걸쳐 연결정보가 주어진다.


출력
1번 정점에서 각 정점으로 가는 최소 간선 수를 2번 정점부터 차례대로 출력하세요.


예시 입력 1
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

예시 출력 1
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
 */
/*
[풀기 전]
dis[nv] = dis[v]+1


[풀고 난 후]


*/

private var n = 0 // 정점의 개수
private var m = 0 // 간선의 개수
private var graph = ArrayList<ArrayList<Int>>()
private var ch = IntArray(0)
private var dis = IntArray(0)

private fun BFS(v: Int) { // v: 현재 노드
    val queue = LinkedList<Int>()
    ch[v] = 1
    dis[v] = 0
    queue.offer(v)
    while (queue.isNotEmpty()) {
        val cv = queue.poll() // 현재 지점
        for (nv in graph[cv as Int]) {
            if (ch[nv] == 0) {
                ch[nv] = 1
                queue.offer(nv)
                dis[nv] = dis[cv] + 1
            }
        }
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt() // 노드 개수
    m = sc.nextInt() // 간선
    for (i in 0 until n + 1) {
        graph.add(ArrayList())
    }
    ch = IntArray(n + 1)
    dis = IntArray(n + 1)
    for (i in 0 until m) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        graph[a].add(b)
    }
    BFS(1)
    for (i in 2..n) {
        println("$i : ${dis[i]}" )
    }
}