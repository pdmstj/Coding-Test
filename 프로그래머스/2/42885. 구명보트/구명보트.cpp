#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> people, int limit) {
    int count = 0;
    int light = 0;  // 가장 가벼운 사람의 인덱스
    int heavy = people.size() - 1;  // 가장 무거운 사람의 인덱스
    
    // 몸무게를 오름차순으로 정렬
    sort(people.begin(), people.end());

    while (light <= heavy) {
        // 가장 가벼운 사람 + 가장 무거운 사람 <= 무게제한
        if (people[light] + people[heavy] <= limit) {
            light++;
        }
        // 가장 무거운 사람만 탈 수 있는 경우
        heavy--;
        // 구명보트 사용
        count++;
    }
    
    return count;
}