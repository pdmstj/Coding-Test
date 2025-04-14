import sys
import heapq

input = sys.stdin.read
data = input().split()

N = int(data[0])
commands = list(map(int, data[1:]))

heap = []
output = []

for x in commands:
    if x == 0:
        if heap:
            output.append(str(heapq.heappop(heap)))
        else:
            output.append('0')
    else:
        heapq.heappush(heap, x)

print('\n'.join(output))
