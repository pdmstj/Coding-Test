T = int(input()) 
coins = [25, 10, 5, 1]

for _ in range(T):
    C = int(input())  # 거스름돈 (센트 단위)
    result = []
    
    for coin in coins:
        result.append(C // coin)  # 해당 동전 개수 계산
        C %= coin  # 남은 잔돈 업데이트
    
    print(*result)  # 리스트의 요소를 공백으로 구분하여 출력
