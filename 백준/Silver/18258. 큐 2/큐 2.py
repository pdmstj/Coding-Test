import sys
from collections import deque

input = sys.stdin.read
def main():
    data = input().splitlines()
    n = int(data[0])
    queue = deque()
    result = []
    
    for command in data[1:n+1]:
        cmd = command.split()
        if cmd[0] == 'push':
            queue.append(int(cmd[1]))
        elif cmd[0] == 'pop':
            if queue:
                result.append(str(queue.popleft()))
            else:
                result.append('-1')
        elif cmd[0] == 'size':
            result.append(str(len(queue)))
        elif cmd[0] == 'empty':
            if queue:
                result.append('0')
            else:
                result.append('1')
        elif cmd[0] == 'front':
            if queue:
                result.append(str(queue[0]))
            else:
                result.append('-1')
        elif cmd[0] == 'back':
            if queue:
                result.append(str(queue[-1]))
            else:
                result.append('-1')
    
    sys.stdout.write("\n".join(result) + "\n")

if __name__ == "__main__":
    main()
