def solution(n):
    answer = 0
    # 1부터 n의 제곱근까지 반복
    for i in range(1, int(n**0.5) + 1):
        if n % i == 0:  # i가 n의 약수일 때
            answer += 1  # (i, n//i) 순서쌍
            if i != n // i:  # i와 n//i가 다르면 또 하나의 순서쌍이 존재
                answer += 1
    return answer