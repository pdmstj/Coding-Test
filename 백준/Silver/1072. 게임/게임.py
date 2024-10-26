import sys
input = sys.stdin.readline

x, y = map(int, input().split())

current_win_rate = (y * 100) // x

# 승률이 99% 이상이면 승률을 올릴 수 없으므로 -1을 출력
if current_win_rate >= 99:
    print(-1)
    exit()

# 이분 탐색을 통해 필요한 최소 추가 게임 횟수를 찾기
left, right = 1, x  # left는 1로 시작하고, right를 x로 설정

while left <= right:
    mid = (left + right) // 2
    # mid 만큼 게임을 더 이겼을 때의 새로운 승률
    new_win_rate = ((y + mid) * 100) // (x + mid)

    # 새로운 승률이 기존 승률보다 크면 더 작은 범위에서 탐색
    if new_win_rate > current_win_rate:
        right = mid - 1
    else:
        left = mid + 1
print(left)
