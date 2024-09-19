n, m = map(int, input().split())
l = list(map(int, input().split()))
s = 0

for i in range(n - 2):
    for j in range(i + 1, n - 1):
        for k in range(j + 1, n):
            r = l[i] + l[j] + l[k]
            if r <= m and r > s:
                s = r

print(s)
