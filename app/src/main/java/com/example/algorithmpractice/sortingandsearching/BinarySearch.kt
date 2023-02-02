package com.example.algorithmpractice.sortingandsearching

import java.util.*

/**8. 이분 탐색
@since 2023.2.2.Thu
설명
임의의 N개의 숫자가 입력으로 주어집니다.
N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요.
단 중복값은 존재하지 않습니다.




입력
첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.

출력
첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.



예시 입력 1
8 32
23 87 65 12 57 32 99 81




예시 출력 1
3



 */
/*
[풀기 전]
이분탐색이란: 문제의 답이 두 구간으로 나뉘는 것을 "이분적이다"라고 하며
이런 경우 이분 탐색을 사용해 결정 문제의 답이 달라지는 경계를 찾을 수 있다.

오름차순이든, 내림차순이든 일단 정렬이 먼저 되어있어야한다.
경계를 포함하는 구간 [lt, rt]을 잡은 뒤 구간의 길이를 절반씩 줄여나가며
lt, rt이 경계 지점에 위치하도록 하는 것

순차탐색: 앞부터 순서대로 하므로 마지막에 값을 찾을 때는 불리한 방법

먼저 오름차순으로 정렬한다.
Arrays.sort(arr)
rt가 lt보다 크거나 같을 동안 while문을 실행시킨다.
중간 인덱스 값을 구한다.
mid = (lt+rt)/2
배열의 중간 인덱스 값과 m이 같으면 answer을 return한다.

중간 인덱스 값이 m보다 크면
중간 인덱스 값부터 현재 rt까지 탐색할 필요가 없으므로
rt = mid - 1 이렇게 범위를 줄여준다.

중간 인덱스 값이 m보다 작으면
lt부터 중간 인덱스 값까지 탐색할 필요가 없으므로
lt = mid + 1

이분 탐색에서 rt는 무조건 작아지고
lt는 무조건 커진다.

[풀고 난 후]

*/


private fun solutionCode(n: Int, m: Int, arr: Array<Int>): Int {
    var answer = 0
    var lt = 0
    var rt = n - 1
    Arrays.sort(arr)
    while (lt <= rt) {
        val mid = (lt + rt) / 2
        if (arr[mid] == m) {
            answer = mid + 1
            break
        } else if (arr[mid] > m) rt = mid - 1
        else lt = mid + 1
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