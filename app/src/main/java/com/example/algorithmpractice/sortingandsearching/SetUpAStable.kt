package com.example.algorithmpractice.sortingandsearching

import java.util.*

/**10. 마구간 정하기(결정 알고리즘)
@since 2023.2.4.Sat
설명
N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며,
마구간간에 좌표가 중복되는 일은 없습니다.
현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다.
각 마구간에는 한 마리의 말만 넣을 수 있고,
가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는
그 최대값을 출력하는 프로그램을 작성하세요.



입력
첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.




출력
첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.




예시 입력 1
5 3
1 2 8 4 9




예시 출력 1
3



 */
/*
[풀기 전]
결정알고리즘
오름차순으로 정렬
while문 실행
lt: 나올 수 있는 최소 거리 1
rt: 나올 수 있는 최대 거리 arr.max - arr.min
mid: 가장 가까운 말의 임시 거리 (lt+rt)/2

임시로 가장 가까운 말의 거리를 정했을 때 c마리의 말이 들어갈 수 있는지 확인하는 로직 작성
ep에 미리 첫 번째 값 넣어놓고
cnt 1(마리) 넣어놓고
for문 1부터 arr.size - 1까지 실행
말과 말의 거리가 임시 거리보다 크거나 같을 때
ep = arr[i]
cnt++
왜 크거나 같아야하는지??
-> 임시 거리가 최대 거리일 수 있으니 같아야하고,
   임시 거리보다 더 긴 거리(최대 거리)가 있을 수 있으니 커야한다.

cnt가 마구간에 들어가야할 말의 수인 c보다 크거나 같으면
c마리는 당연히 포함한다.
anwer = mid
mid보다 작은 쪽은 볼 필요 없으므로
lt = mid + 1

cnt가 마구간에 들어가야할 말의 수인 c보다 작으면
mid보다 큰 쪽은 볼 필요 없으므로
rt = mid - 1

[풀고 난 후]
*/

private fun getDistance(arr: Array<Int>, m: Int): Int { //마구간에 넣을 수 있는 말이 몇 마리 인지
    var ep = arr[0] //첫 번째 말을 미리 할당
    var cnt =  1 // 할당한 말의 수
    for (i in 1 until arr.size) {
        if (arr[i] - ep >= m) {
            ep = arr[i]
            cnt++
        }
    }

    return cnt
}

private fun solutionCode(n: Int, c: Int, arr: Array<Int>): Int {
    var answer = 0
    var lt = 1
    var rt = arr.max() - arr.min()
    Arrays.sort(arr)
    while (lt <= rt) {
        val mid = (lt + rt) / 2
        if (getDistance(arr, mid) >= c ) {
            answer = mid
            lt = mid + 1
        } else rt = mid - 1
    }
    return answer

}


fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }
    print("${solutionCode(n, m, arr)}")
}