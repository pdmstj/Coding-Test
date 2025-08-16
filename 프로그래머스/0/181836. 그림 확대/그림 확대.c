#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char** solution(const char* picture[], size_t picture_len, int k) {
    size_t orig_height = picture_len;            // 원본 높이
    size_t orig_width = strlen(picture[0]);      // 원본 너비

    size_t new_height = orig_height * k;         // 확대된 높이
    size_t new_width = orig_width * k;           // 확대된 너비

    // 결과 배열 동적 할당
    char** answer = (char**)malloc(sizeof(char*) * new_height);

    size_t idx = 0; // answer의 현재 줄 인덱스
    for (size_t i = 0; i < orig_height; i++) {
        // 가로로 k배 확장된 문자열 만들기
        char* expanded_row = (char*)malloc(new_width + 1); // +1은 '\0'
        size_t pos = 0;
        for (size_t j = 0; j < orig_width; j++) {
            for (int x = 0; x < k; x++) {
                expanded_row[pos++] = picture[i][j];
            }
        }
        expanded_row[new_width] = '\0';

        // 세로로 k배 확장: 같은 줄을 k번 넣기
        for (int y = 0; y < k; y++) {
            answer[idx] = (char*)malloc(new_width + 1);
            strcpy(answer[idx], expanded_row);
            idx++;
        }

        free(expanded_row);
    }

    return answer;
}
