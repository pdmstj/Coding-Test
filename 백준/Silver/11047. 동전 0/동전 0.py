def min_coin_count(N, K, coins):
    count = 0
    for coin in reversed(coins):
        if K == 0:
            break
        count += K // coin
        K %= coin
    return count

N, K = map(int, input().split())
coins = [int(input()) for _ in range(N)]

print(min_coin_count(N, K, coins))
