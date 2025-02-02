# 입력 받기
N, M = map(int, input().split())

# 초기 바구니 상태 설정 (1번부터 N번까지)
ball = list(range(1, N + 1))

# M번의 교환 연산 수행
for _ in range(M):
    i, j = map(int, input().split())
    ball[i-1], ball[j-1] = ball[j-1], ball[i-1]  # i, j는 1부터 시작하므로 인덱스 보정

# 결과 출력
print(*ball)
