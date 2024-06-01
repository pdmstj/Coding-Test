import sys
import math

def dfs(idx, cnt, x_sum, y_sum):
    global answer
    if cnt == n // 2:
        other_x_sum = total_x_sum - x_sum
        other_y_sum = total_y_sum - y_sum
        distance = math.sqrt((other_x_sum - x_sum) ** 2 + (other_y_sum - y_sum) ** 2)
        answer = min(answer, distance)
        return
    
    if idx == n:
        return
    
    dfs(idx + 1, cnt + 1, x_sum + points[idx][0], y_sum + points[idx][1])
    dfs(idx + 1, cnt, x_sum, y_sum)

t = int(input())

for _ in range(t):
    n = int(input())
    points = [tuple(map(int, input().split())) for _ in range(n)]
    
    total_x_sum = sum(point[0] for point in points)
    total_y_sum = sum(point[1] for point in points)
    answer = float('inf')
    
    dfs(0, 0, 0, 0)
    print(answer)