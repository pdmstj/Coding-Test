from collections import deque

def solution(priorities, location):
    # 큐에 (우선순위, 인덱스) 형태로 삽입
    queue = deque([(p, i) for i, p in enumerate(priorities)])
    
    answer = 0  # 실행된 순서
    while queue:
        # 가장 앞에 있는 프로세스 꺼냄
        current = queue.popleft()
        
        # 큐에 남아있는 프로세스들 중 우선순위가 더 높은 프로세스가 있으면
        if any(current[0] < item[0] for item in queue):
            # 우선순위가 더 높은 프로세스가 있으면 뒤로 넣음
            queue.append(current)
        else:
            # 우선순위가 가장 높은 프로세스이면 실행
            answer += 1
            # 만약 우리가 찾는 프로세스라면
            if current[1] == location:
                return answer
