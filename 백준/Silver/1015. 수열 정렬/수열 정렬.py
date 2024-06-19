import sys
input = sys.stdin.readline

# 입력
N = int(input())
numlist = list(map(int, input().split()))

# 대소관계 파악
cnt = 0
for num in range(1, 1001):
    for i in range(N):
        if numlist[i] == num:
            numlist[i] = str(cnt)
            cnt += 1

        if cnt == N:
            # 출력
            print(" ".join(numlist))
            exit()