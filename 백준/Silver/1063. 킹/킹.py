def main():
    import sys
    input = sys.stdin.read
    data = input().split()

    # 현재 위치
    now_x = ord(data[0][0]) - ord('A') + 1
    now_y = int(data[0][1])
    
    # 장애물 위치
    R_now_x = ord(data[1][0]) - ord('A') + 1
    R_now_y = int(data[1][1])
    
    # 명령의 수
    N = int(data[2])
    commands = data[3:]

    for command in commands:
        check = False
        next_x, next_y = 0, 0

        for char in command:
            if char == 'R':
                if now_x + 1 > 8:
                    check = True
                    continue
                next_x += 1
            elif char == 'L':
                if now_x - 1 < 1:
                    check = True
                    continue
                next_x -= 1
            elif char == 'B':
                if now_y - 1 < 1:
                    check = True
                    continue
                next_y -= 1
            elif char == 'T':
                if now_y + 1 > 8:
                    check = True
                    continue
                next_y += 1

        if check:
            continue

        if (now_x + next_x) == R_now_x and (now_y + next_y) == R_now_y:
            if 1 <= R_now_x + next_x <= 8 and 1 <= R_now_y + next_y <= 8:
                now_x += next_x
                now_y += next_y
                R_now_x += next_x
                R_now_y += next_y
        else:
            now_x += next_x
            now_y += next_y

    print(f"{chr(now_x + ord('A') - 1)}{now_y}")
    print(f"{chr(R_now_x + ord('A') - 1)}{R_now_y}")

if __name__ == "__main__":
    main()
