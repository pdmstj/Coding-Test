#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

char* solution(const char* my_string, const char* alp) {
    int len = strlen(my_string);
    // my_string과 동일한 길이 + 널 문자('\0')를 위한 공간을 할당
    char* answer = (char*)malloc(len + 1); 

    for (int i = 0; i < len; i++) {
        if (my_string[i] == alp[0]) {
            // 대문자로 변환
            answer[i] = toupper(my_string[i]);
        } else {
            answer[i] = my_string[i];
        }
    }
    answer[len] = '\0'; // 문자열 끝에 널 문자 추가
    return answer;
}
