#include <string>
#include <algorithm>

using namespace std;

bool solution(string s) {
    // 문자열 s를 소문자로 변환
    transform(s.begin(), s.end(), s.begin(), ::tolower);

    // 문자열 s의 'p'의 개수와 'y'의 개수를 비교해 같으면 true를 반환
    // 'p'와 'y'의 개수가 0이어도 둘의 개수가 0으로 같기 때문에 true를 반환
    int pCount = count(s.begin(), s.end(), 'p');
    int yCount = count(s.begin(), s.end(), 'y');

    return pCount == yCount;
}