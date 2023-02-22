package com.example.algorithmpractice.recursive

import java.util.*

/**11. 경로 탐색(인접행렬)
@since 2023.2.22.Wed

설명
방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를
출력하는 프로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
1 2 3 4 5
1 2 5
1 3 4 2 5
1 3 4 5
1 4 2 5
1 4 5

총 6가지 입니다.


입력
첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다.
그 다음부터 M주에 걸쳐 연결정보가 주어진다.


출력
총 가지 수를 출력한다.


예시 입력 1
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5

예시 출력 1



 */
/*
[풀기 전]
중복된 노드가 없어야한다.
방문한 노드는 또 방문할 수 없음


[풀고 난 후]


*/

private var n = 0
private var m = 0
private var answer = 0
private var graph = Array(n) { Array(m) { 0 } }
private var ch = IntArray(0)

private fun DFS(v: Int) { // v: 현재 노드
    if (v == n) answer++ // 정점이면 ++
    else { // 아니면 1부터 n+1까지 반복문 실행
        for (i in 1 until n + 1) {
            if (graph[v][i] == 1 && ch[i] == 0) { // v -> i로 갈 수 있는지, 방문한적 없는지 체크
                ch[i] = 1 // 방문했다고 체크
                DFS(i)
                // back
                ch[i] = 0 // 돌아오면 방문한거 취소
            }
        }
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt() // 노드 개수
    m = sc.nextInt() // 간선
    graph = Array(n + 1) { Array(n + 1) { 0 } } // 인접행렬
    ch = IntArray(n + 1)
    for (i in 0 until m) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        graph[a][b] = 1
    }
    ch[1] = 1 // 방문했었는지 체크
    DFS(1)
    println(answer)
}