num = int(input())

if num < 100:
    print(num)
else:
    count = 0
    for i in range(100, num + 1):
        digits = []
        n = i
        digits.append(n % 10)
        while n // 10 != 0:
            n //= 10
            digits.append(n % 10)
        
        diffs = set()
        for a in range(1, len(digits)):
            diffs.add(digits[a] - digits[a-1])
        
        if len(diffs) == 1:
            count += 1
    
    print(count + 99)
