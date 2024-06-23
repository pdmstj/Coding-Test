import sys
input = sys.stdin.readline

stack = []
n = int(input())
cnt = 1

for _ in range(n) :
  stack.append(int(input()))

x = stack.pop()
for _ in range(n-1) :
  y = stack.pop()  
  
  if x < y : 
    x = y
    cnt += 1

print(cnt)