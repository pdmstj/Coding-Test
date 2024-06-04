def search(color):
    min_count = float('inf')  # 초기 최소값 설정
    for k in range(N - 7):
        for l in range(M - 7):
            count = 0
            for u in range(4):
                for i in range(2):
                    for j in range(8):
                        if arr[color][i][j] != mat[i + k + (u * 2)][j + l]:  # 색상 비교
                            count += 1
            min_count = min(min_count, count)  # 최소값 갱신
    return min_count

N, M = map(int, input().split())
mat = [list(input()) for _ in range(N)]
arr = {
    'W': [['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
          ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W']],
    'B': [['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
          ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B']]
}

result_white = search('W')  # 흰색 체스판 경우
result_black = search('B')  # 검정색 체스판 경우

print(min(result_white, result_black))  # 더 작은 값 출력