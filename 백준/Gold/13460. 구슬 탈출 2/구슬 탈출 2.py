from collections import deque

# 이동할 네 방향 정의 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def move(x, y, dx, dy, board):
    count = 0
    # 벽이나 구멍을 만나기 전까지 이동
    while board[x + dx][y + dy] != '#' and board[x][y] != 'O':
        x += dx
        y += dy
        count += 1
    return x, y, count

def solution(board):
    n = len(board)
    m = len(board[0])
    
    # BFS를 위한 큐와 방문 처리 배열
    queue = deque()
    visited = set()
    
    # 초기 상태 설정
    rx = ry = bx = by = 0
    
    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                rx, ry = i, j
            elif board[i][j] == 'B':
                bx, by = i, j
    
    # 큐에 초기 상태 추가: (빨간 구슬 위치, 파란 구슬 위치, 이동 횟수)
    queue.append((rx, ry, bx, by, 0))
    visited.add((rx, ry, bx, by))
    
    while queue:
        rx, ry, bx, by, depth = queue.popleft()
        
        # 10번 이상 움직인 경우 -1 반환
        if depth >= 10:
            return -1
        
        # 네 방향으로 기울이기
        for i in range(4):
            nrx, nry, r_count = move(rx, ry, dx[i], dy[i], board)  # 빨간 구슬 이동
            nbx, nby, b_count = move(bx, by, dx[i], dy[i], board)  # 파란 구슬 이동
            
            # 파란 구슬이 구멍에 빠지면 무시
            if board[nbx][nby] == 'O':
                continue
            
            # 빨간 구슬이 구멍에 빠지면 성공
            if board[nrx][nry] == 'O':
                return depth + 1
            
            # 두 구슬이 같은 위치에 있는 경우, 더 많이 이동한 구슬을 한 칸 뒤로
            if nrx == nbx and nry == nby:
                if r_count > b_count:
                    nrx -= dx[i]
                    nry -= dy[i]
                else:
                    nbx -= dx[i]
                    nby -= dy[i]
            
            if (nrx, nry, nbx, nby) not in visited:
                visited.add((nrx, nry, nbx, nby))
                queue.append((nrx, nry, nbx, nby, depth + 1))
    
    return -1
n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]
print(solution(board))
