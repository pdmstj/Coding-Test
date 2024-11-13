def flip(matrix, i, j, N, M):
    # 3x3 부분 행렬을 뒤집는 함수
    for di in range(3):
        for dj in range(3):
            if 0 <= i + di < N and 0 <= j + dj < M:
                matrix[i + di][j + dj] = 1 - matrix[i + di][j + dj]

def min_operations(N, M, A, B):
    operations = 0
    # 행렬 A를 B로 변환하기 위한 연산을 진행
    for i in range(N - 2):
        for j in range(M - 2):
            if A[i][j] != B[i][j]:  # A와 B가 다르면 변환 필요
                flip(A, i, j, N, M)  # 3x3 영역 뒤집기
                operations += 1

    # 연산 후 A와 B가 동일한지 확인
    if A == B:
        return operations
    else:
        return -1

# 입력 처리
N, M = map(int, input().split())
A = [list(map(int, input().strip())) for _ in range(N)]
B = [list(map(int, input().strip())) for _ in range(N)]

# 결과 출력
result = min_operations(N, M, A, B)
print(result)
