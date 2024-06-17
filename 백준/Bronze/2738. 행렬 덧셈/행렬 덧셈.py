N, M = input().split()
N, M = int(N), int(M)
arr = []
arr2 = []
for i in range(N):
    arr.append(list(map(int, input().split())))
for j in range(N):
    arr2.append(list(map(int, input().split())))

for k in range(N):
    for l in range(M):
        arr[k][l] = arr[k][l] + arr2[k][l]

for q in arr:
    print(*q)