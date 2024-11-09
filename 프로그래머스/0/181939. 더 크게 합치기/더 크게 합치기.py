def solution(a, b):
    # a ⊕ b와 b ⊕ a를 계산
    ab = int(str(a) + str(b))
    ba = int(str(b) + str(a))
    # 더 큰 값을 반환
    return max(ab, ba)
