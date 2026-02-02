from collections import defaultdict

def solution(friends, gifts):
    n = len(friends)
    idx = {name: i for i, name in enumerate(friends)}

    give = [[0]*n for _ in range(n)]
    given = [0]*n
    received = [0]*n

    # 기록 정리
    for g in gifts:
        a, b = g.split()
        i, j = idx[a], idx[b]
        give[i][j] += 1
        given[i] += 1
        received[j] += 1

    score = [given[i] - received[i] for i in range(n)]
    next_month = [0]*n

    # 친구 쌍 비교 (한 번만!)
    for i in range(n):
        for j in range(i+1, n):
            if give[i][j] > give[j][i]:
                next_month[i] += 1
            elif give[i][j] < give[j][i]:
                next_month[j] += 1
            else:
                if score[i] > score[j]:
                    next_month[i] += 1
                elif score[i] < score[j]:
                    next_month[j] += 1
                # 같으면 아무도 안 받음

    return max(next_month)
