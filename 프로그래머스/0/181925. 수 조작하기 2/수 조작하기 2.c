#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// numLog_len은 배열 numLog의 길이입니다.
char* solution(int numLog[], size_t numLog_len) {
    // 조작 결과를 저장할 문자열을 동적 할당합니다. 최대 numLog_len - 1 만큼의 문자가 들어가므로.
    char* answer = (char*)malloc(numLog_len);  // numLog_len 만큼의 공간을 확보합니다.
    
    // 각 단계의 차이를 보고 적절한 문자를 추가
    int idx = 0;
    for (size_t i = 1; i < numLog_len; i++) {
        int diff = numLog[i] - numLog[i - 1];
        if (diff == 1) {
            answer[idx++] = 'w';  // 1 증가 -> 'w'
        } else if (diff == -1) {
            answer[idx++] = 's';  // 1 감소 -> 's'
        } else if (diff == 10) {
            answer[idx++] = 'd';  // 10 증가 -> 'd'
        } else if (diff == -10) {
            answer[idx++] = 'a';  // 10 감소 -> 'a'
        }
    }
    
    // 문자열 끝에 NULL 문자 추가
    answer[idx] = '\0';
    
    return answer;
}
