import sys
input = sys.stdin.read

def solve():
    data = input().split()
    index = 0
    T = int(data[index])
    index += 1
    results = []

    for _ in range(T):
        N = int(data[index])
        index += 1
        prices = list(map(int, data[index:index+N]))
        index += N

        max_profit = 0
        max_price = 0

        for price in reversed(prices):
            if price > max_price:
                max_price = price
            else:
                max_profit += max_price - price

        results.append(str(max_profit))
    
    print('\n'.join(results))

solve()
