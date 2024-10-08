#include <vector>
using namespace std;

vector<int> solution(int start_num, int end_num) {
    vector<int> answer;  // 결과를 담을 벡터
    
    // start_num에서 end_num까지 1씩 감소
    for (int i = start_num; i >= end_num; --i) {
        answer.push_back(i);  // 벡터에 i 추가
    }
    
    return answer;  // 결과 반환
}
