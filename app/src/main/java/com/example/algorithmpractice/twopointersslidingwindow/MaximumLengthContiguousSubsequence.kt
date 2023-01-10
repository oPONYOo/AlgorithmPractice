package com.example.algorithmpractice.twopointersslidingwindow

import java.util.*

/**6. 최대 길이 연속부분수열
@since 2023.1.11.Wed
설명
0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을
0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만
구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
만약 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
1 1 0 0 1 1 0 1 1 0 1 1 0 1
여러분이 만들 수 있는 1이 연속된 연속부분수열은
1 1 0 0 1 1 1 1 1 1 1 1 0 1 이며 그 길이는 8입니다.


입력
첫 번째 줄에 수열의 길이인 자연수 N(5<=N<=100,000)이 주어집니다.
두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.

출력
첫 줄에 최대 길이를 출력하세요.

예시 입력 1
14 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1
예시 출력 1
8


 */
/*
[풀기 전]
포인터 2개 lt, rt
0부터 n-1까지 for문 실행
cnt: 0의 개수
length: rt와 lt의 현재 거리
k: 1으로 변경 가능한 횟수
arr[rt]이 0이면 cnt++
arr[rt]이 1이면 cnt가 k보다 클 동안 while문 실행
arr[++lt]가 0이면 cnt--
While문 빠져나온 후 length, answer비교해서 큰 값 answer에 할당
[풀고 난 후]

*/

private fun solutionCode(n: Int, k: Int, arr: Array<Int>): Int {
    var answer = 0
    var lt = 0
    var cnt = 0
    // 방법 1.
    for (rt in 0 until n) {
        if (arr[rt] == 0) cnt++
        else {
            while (cnt > k) if (arr[++lt] == 0) cnt--
            val length = rt - lt
            answer = answer.coerceAtLeast(length)
        }
    }
    // 방법 2.
    /*for (rt in 0 until n) {
        if (arr[rt] == 0) cnt++
        while (cnt > k) {
            if (arr[lt] == 0) cnt--
            lt++
        }
        answer = answer.coerceAtLeast((rt - lt + 1))
    }*/

    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val arr = Array(n) { 0 }

    for (i in 0 until n) arr[i] = sc.nextInt()
    println(solutionCode(n, k, arr))


}