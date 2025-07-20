#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

char** solution(const char* myStr) {
    char** result = (char**)malloc(sizeof(char*) * 100000);  // 충분히 큰 공간
    int count = 0;  // 저장된 문자열 수
    int len = strlen(myStr);
    char buffer[1000001];  // 한 조각 저장용 버퍼
    int bufIdx = 0;

    for (int i = 0; i <= len; i++) {
        char c = myStr[i];

        // 구분자이거나 문자열의 끝인 경우
        if (c == 'a' || c == 'b' || c == 'c' || c == '\0') {
            if (bufIdx > 0) {  // 저장된 문자가 있다면
                buffer[bufIdx] = '\0';
                result[count] = (char*)malloc(bufIdx + 1);
                strcpy(result[count], buffer);
                count++;
                bufIdx = 0;  // 버퍼 초기화
            }
            // 연속된 구분자면 그냥 넘김
        } else {
            buffer[bufIdx++] = c;
        }
    }

    // 아무 문자열도 저장하지 못한 경우
    if (count == 0) {
        result[0] = (char*)malloc(6);  // "EMPTY" + null
        strcpy(result[0], "EMPTY");
        count = 1;
    }

    // 마지막에 NULL 포인터를 붙여서 종료 표시 (필요하면)
    result = realloc(result, sizeof(char*) * count);  // 메모리 낭비 줄이기
    return result;
}
