def dfs(graph, visited, v):
    visited[v] = True
    count = 1 
    for i in graph[v]:
        if not visited[i]:
            count += dfs(graph, visited, i)
    return count

n = int(input())  
m = int(input())  
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n + 1)

print(dfs(graph, visited, 1) - 1)