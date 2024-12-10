from collections import deque

# 입력 받기
N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    graph[B].append(A)

# BFS를 이용한 최단 거리 계산
def bfs(start):
    distances = [-1] * (N + 1)  # 방문하지 않은 곳은 -1
    distances[start] = 0
    queue = deque([start])
    
    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if distances[neighbor] == -1:  # 아직 방문하지 않은 경우
                distances[neighbor] = distances[current] + 1
                queue.append(neighbor)
    
    return distances

distances = bfs(1)

# 결과 분석
max_distance = max(distances)
farthest_barns = [i for i, d in enumerate(distances) if d == max_distance]

# 가장 작은 헛간 번호와 동일한 거리의 헛간 개수
barn_number = min(farthest_barns)
barn_count = len(farthest_barns)

# 출력
print(barn_number, max_distance, barn_count)
