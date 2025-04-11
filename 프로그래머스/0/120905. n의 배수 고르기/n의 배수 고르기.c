#include <stdio.h>
#include <stdlib.h>

int* solution(int n, int numlist[], size_t numlist_len) {
    int* temp = (int*)malloc(sizeof(int) * numlist_len);
    int count = 0;

    for (int i = 0; i < numlist_len; i++) {
        if (numlist[i] % n == 0) {
            temp[count++] = numlist[i];
        }
    }

    int* answer = (int*)malloc(sizeof(int) * count);
    for (int i = 0; i < count; i++) {
        answer[i] = temp[i];
    }

    free(temp);
    return answer;
}
