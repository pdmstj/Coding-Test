def solution(arr, k):
    # k가 홀수일 경우: 각 원소에 k를 곱함
    if k % 2 == 1:
        return [x * k for x in arr]
    # k가 짝수일 경우: 각 원소에 k를 더함
    else:
        return [x + k for x in arr]
