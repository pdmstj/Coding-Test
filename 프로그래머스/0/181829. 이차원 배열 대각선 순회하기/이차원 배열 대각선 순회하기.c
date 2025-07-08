#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// board_rows는 2차원 배열 board의 행 길이, board_cols는 2차원 배열 board의 열 길이입니다.
int solution(int** board, size_t board_rows, size_t board_cols, int k) {
    int answer = 0;

    // 모든 행을 순회
    for (size_t i = 0; i < board_rows; i++) {
        for (size_t j = 0; j < board_cols; j++) {
            // 조건 i + j <= k 를 만족하는 경우만 합에 더함
            if ((int)(i + j) <= k) {
                answer += board[i][j];
            }
        }
    }

    return answer;
}