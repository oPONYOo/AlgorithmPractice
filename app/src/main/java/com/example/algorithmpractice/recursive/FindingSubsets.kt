package com.example.algorithmpractice.recursive

/**6. 부분 집합 구하기(DFS)
@since 2023.2.9.Thu

설명
자연수 N이 주어지면 1부터 N까지의 운소를 갖는 집합의 부분집합을
모두 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 자연수(1<=N<=10)이 주어집니다.


출력
첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래의 출력예제와
같은 순서로 출력한다.


예시 입력 1
3

예시 출력 1
1 2 3
1 2
1 3
1
2 3
2
3

 */
/*
[풀기 전]

[풀고 난 후]
왼쪽, 오른쪽으로 뻗게
*/




private var n: Int = 0
private var ch = IntArray(0)
private fun DFS(L: Int) {
    if (L == n + 1) {
       var tmp = ""
        for (i in 1..n) {
            if (ch[i] == 1) tmp+="$i "
        }
        if (tmp.isNotEmpty()) println(tmp)
    } else {
        ch[L] = 1 //사용
        DFS(L + 1)
        ch[L] = 0 //미사용
        DFS(L + 1)
    }

}


fun main() {
    n = 3
    ch = IntArray(n + 1)
    DFS(1) // 100번지 root노드


}