def solution(n, computers):
    visited = [False] * n  # 방문 여부를 체크하는 리스트
    answer = 0  # 네트워크의 개수
    
    def dfs(node):
        # 현재 컴퓨터(node)가 속한 네트워크의 모든 컴퓨터를 탐색
        visited[node] = True
        for neighbor in range(n):
            if computers[node][neighbor] == 1 and not visited[neighbor]:
                dfs(neighbor)
    
    # 모든 컴퓨터를 검사하면서 네트워크 개수를 셈
    for i in range(n):
        if not visited[i]:
            dfs(i)  # 새로운 네트워크를 찾으면 DFS를 시작
            answer += 1  # 네트워크 개수 증가
    
    return answer
