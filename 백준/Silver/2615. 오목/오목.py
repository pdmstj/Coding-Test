# 오목판에서 4방향을 탐색하기 위한 방향 벡터
directions = [(0, 1), (1, 0), (1, 1), (1, -1)]  # 가로, 세로, 대각선, 역대각선

def check_winner(board):
    for y in range(19):
        for x in range(19):
            if board[y][x] != 0:  # 바둑알이 있는 경우만 체크
                color = board[y][x]
                for dx, dy in directions:
                    count = 1
                    nx, ny = x + dx, y + dy

                    # 한 방향으로 연속된 바둑알 확인
                    while 0 <= nx < 19 and 0 <= ny < 19 and board[ny][nx] == color:
                        count += 1
                        if count > 5:  # 여섯 개 이상 연속이면 무효
                            break
                        nx += dx
                        ny += dy

                    # 정확히 다섯 개가 연속된 경우
                    if count == 5:
                        # 이전 위치 확인: 여섯 개 연속을 방지
                        prev_x, prev_y = x - dx, y - dy
                        if 0 <= prev_x < 19 and 0 <= prev_y < 19 and board[prev_y][prev_x] == color:
                            continue

                        # 시작 위치 반환
                        return color, y + 1, x + 1  # y+1, x+1은 1-based 인덱스

    return 0, -1, -1  # 승자가 없는 경우

# 입력 받기
board = [list(map(int, input().split())) for _ in range(19)]

# 승자 판별
winner, row, col = check_winner(board)

# 결과 출력
if winner:
    print(winner)
    print(row, col)
else:
    print(0)
