package com.example.algorithmpractice.array

import java.util.*


/**12. 멘토링
@since 2023.1.4.Wed

설명
현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해
멘토링 시스템을 만들려고 합니다.
멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가
멘티의 수학공부를 도와주는 것입니다.
선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면 A학생은 M번의 수학테스트에서
모두 B학생보다 등수가 앞서야 합니다.
M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만 들 수 있는 경우가
총 몇 가지 인지 먼저 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다.
학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.

만약 한 주에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면
3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.

출력
첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.

예시 입력 1
4 3
3 4 1 2
4 3 2 1
3 1 4 2

예시 출력 1
3

힌트
출력설명
(3,1),(3,2),(4,2)와 같이 3가지 경우의 (멘토, 멘티) 짝을 만들 수 있다.

 */
/*
[풀기 전]
m: 시험 본 횟수
n: 학생 수
멘토와 멘티가 짝을 이룰 수 있는 경우를 찾기
멘토의 성적은 m번 모두 멘티보다 좋아야한다.
경우의 수: n * n
멘토 멘티가 될수 있는 총 경우 i,j 1부터 n(학생번호)까지 이중 for문 실행
그 안에서 짝이될 수 있는지 확인
        k 0부터 m-1
        s 0부터 n-1 arr[m][n] 이중 for문 실행
        k번째 시험에서 s(n)번째 등수가 i(멘토일때) pi = i번째 등수
        k번째 시험에서 s(n)번째 등수가 j(멘티일때) pj = j번째 등수
cnt: i등수가 j보다 작아야 앞에있는 등수 if (pi < pj) cnt += 1
answer: cnt개수와 테스트 개수같은지
[풀고 난 후]

*/

private fun solutionCode(n: Int, m: Int, arr: Array<Array<Int>>): Int {
    var answer = 0
    for (i in 1 until n + 1) {  //멘토
        for (j in 1 until n + 1) {  //멘티
            var cnt = 0
            for (k in 0 until m) { //시험 본 횟수
                var pi = 0 // i가 몇 등
                var pj = 0
                for (s in 0 until n) { // 등수 0부터 n등
                    if (arr[k][s] == i) pi = s
                    if (arr[k][s] == j) pj = s

                }
                if (pi < pj) cnt += 1
            }
            if (cnt == m) answer += 1


        }
    }

    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val arr = Array(m) { Array(n) { 0 } }
    for (i in 0 until m) {
        for (j in 0 until n) {
            arr[i][j] = sc.nextInt()
        }
    }

    println(solutionCode(n, m, arr))


}