import sys
input = sys.stdin.read

def main():
    commands = input().splitlines()
    N = int(commands[0])
    stack = []
    result = []
    
    for i in range(1, N + 1):
        command = commands[i]
        if command[0] == '1':  # 1 X: X를 스택에 추가
            _, x = command.split()
            stack.append(int(x))
        elif command[0] == '2':  # 2: 스택의 맨 위 정수를 출력 후 제거
            if stack:
                result.append(stack.pop())
            else:
                result.append(-1)
        elif command[0] == '3':  # 3: 스택에 들어있는 정수의 개수를 출력
            result.append(len(stack))
        elif command[0] == '4':  # 4: 스택이 비어있는지 확인
            result.append(1 if not stack else 0)
        elif command[0] == '5':  # 5: 스택의 맨 위 정수를 출력
            if stack:
                result.append(stack[-1])
            else:
                result.append(-1)
    
    # 결과 출력
    sys.stdout.write('\n'.join(map(str, result)) + '\n')

if __name__ == "__main__":
    main()
