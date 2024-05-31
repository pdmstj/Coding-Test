#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <iostream>
#include <stdlib.h>
#include <time.h>
using namespace std;

int N, M;
int arr[7 + 1];

void DFS(int depth) {
    if (depth == M) {
        for (int i = 0;i < M;i++) {
            printf("%d ", arr[i]);
        }
        printf("\n");
    }
    else {
        for (int i = 1;i <= N;i++) {
            arr[depth] = i;
            DFS(depth + 1);
        }
    }
}

int main(void) {

    scanf("%d %d", &N, &M);

    DFS(0);

    return 0;
}