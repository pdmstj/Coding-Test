N = int(input())
temp = [0] * N
sequence = list(map(int, input().split()))
for i in range(1, N + 1):
    
    temp[i - sequence[i - 1]:] = temp[i - sequence[i - 1] - 1:-1]
    temp[i - sequence[i - 1] - 1] = i

print(*temp)