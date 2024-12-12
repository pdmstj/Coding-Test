d1, d2, d3 = map(int, input().split())

if d1 == d2 == d3:
    reward = 10000 + d1 * 1000
elif d1 == d2 or d1 == d3:
    reward = 1000 + d1 * 100
elif d2 == d3:
    reward = 1000 + d2 * 100
else:
    reward = max(d1, d2, d3) * 100

print(reward)
