def solution(n, k):
    answer = []
    # k의 배수를 1부터 차례대로 찾음
    for i in range(1, n // k + 1):
        answer.append(k * i)
    return answer
