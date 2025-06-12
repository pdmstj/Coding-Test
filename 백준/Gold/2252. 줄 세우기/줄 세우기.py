import sys
import heapq
from collections import defaultdict, deque

input = sys.stdin.read
data = input().split()
N = int(data[0])
M = int(data[1])

adj = [[] for _ in range(N + 1)]
indegree = [0] * (N + 1)

idx = 2
for _ in range(M):
    A = int(data[idx])
    B = int(data[idx + 1])
    adj[A].append(B)
    indegree[B] += 1
    idx += 2

queue = deque()
for i in range(1, N + 1):
    if indegree[i] == 0:
        queue.append(i)

result = []

while queue:
    current = queue.popleft()
    result.append(current)

    for neighbor in adj[current]:
        indegree[neighbor] -= 1
        if indegree[neighbor] == 0:
            queue.append(neighbor)

print(' '.join(map(str, result)))