package com.example.algorithmpractice.hashmap

import java.util.*
import kotlin.collections.HashMap

/**2. 아나그램(hash)
@since 2023.1.13.Fri
설명
Anagram이란 두 문자열이 알파벳의 나열 순사는 다르지만 그 구성이 일치하면
두 단어는 아나그램이라고 합니다.
예를 들면 AbaAeCe와 baeeACA는 알파벳을 나열 순서는 다르지만
그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면
상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는
프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.

입력
첫 줄에는 첫 번째 단어가 입력되고, 두 번째 줄에는
두 번째 단어가 입력됩니다. 단어의 길이는 100을 넘지 않습니다.

출력
두 단어가 아나그램이면 "YES"를 출력하고, 아니면 "NO"를 출력합니다.

예시 입력 1
AbaAeCe
baeeACA

예시 출력 1
YES

예시 입력 2
abaCC
Caaab

예시 출력 2
NO
 */
/*
[풀기 전]
hashMap 문자열 for문 실행
Key값으로 문자, Value값으로 횟수 할당
두 번째 문자열 for문 돌리면서
map Key에 해당 문자 존재하고, value가 0이 아니면 --1
만약 존재하지않고 0이라면 return NO

[풀고 난 후]

*/

private fun solutionCode(str1: String, str2: String): String {
    val answer = "YES"
    val map = HashMap<Char, Int>()
    for (s in str1) map[s] = if (map[s] == null) 1 else map[s]!! + 1


    for (s in str2) {
        if (!map.containsKey(s) || map[s]!! == 0) return "NO"
        map[s] = map[s]!! - 1

    }
    return answer

}


fun main() {
    val sc = Scanner(System.`in`)
    val str1 = sc.next()
    val str2 = sc.next()


    println(solutionCode(str1, str2))


}