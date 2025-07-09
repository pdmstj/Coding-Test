#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* myString, const char* pat) {
    int myLen = strlen(myString);
    int patLen = strlen(pat);
    int lastIdx = -1;

    for (int i = myLen - patLen; i >= 0; i--) {
        if (strncmp(&myString[i], pat, patLen) == 0) {
            lastIdx = i + patLen; 
            break;
        }
    }

    if (lastIdx != -1) {
        char* answer = (char*)malloc(lastIdx + 1); 
        strncpy(answer, myString, lastIdx);
        answer[lastIdx] = '\0';
        return answer;
    }

    char* answer = (char*)malloc(1);
    answer[0] = '\0';
    return answer;
}
