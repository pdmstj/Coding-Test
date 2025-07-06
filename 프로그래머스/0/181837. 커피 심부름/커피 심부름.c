#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// order_len은 배열 order의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* order[], size_t order_len) {
    int answer = 0;

    for (size_t i = 0; i < order_len; i++) {
        const char* menu = order[i];

        if (
            strcmp(menu, "iceamericano") == 0 || strcmp(menu, "americanoice") == 0 ||
            strcmp(menu, "hotamericano") == 0 || strcmp(menu, "americanohot") == 0 ||
            strcmp(menu, "americano") == 0 || strcmp(menu, "anything") == 0
        ) {
            answer += 4500;
        }
        else if (
            strcmp(menu, "icecafelatte") == 0 || strcmp(menu, "cafelatteice") == 0 ||
            strcmp(menu, "hotcafelatte") == 0 || strcmp(menu, "cafelattehot") == 0 ||
            strcmp(menu, "cafelatte") == 0
        ) {
            answer += 5000;
        }
    }

    return answer;
}
