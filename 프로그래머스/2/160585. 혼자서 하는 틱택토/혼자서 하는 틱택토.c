#include <stdio.h>
#include <stdbool.h>

bool is_winner(const char* board[], char player) {
    for (int i = 0; i < 3; i++)
        if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
            return true;
    for (int i = 0; i < 3; i++)
        if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
            return true;
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
        return true;
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
        return true;
    return false;
}

int solution(const char* board[], size_t board_len) {
    int o_count = 0, x_count = 0;
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == 'O') o_count++;
            if (board[i][j] == 'X') x_count++;
        }

    bool o_win = is_winner(board, 'O');
    bool x_win = is_winner(board, 'X');

    if (x_count > o_count) return 0;
    if (o_count - x_count > 1) return 0;
    if (o_win && x_win) return 0;
    if (o_win && o_count != x_count + 1) return 0;
    if (x_win && o_count != x_count) return 0;

    return 1;
}
