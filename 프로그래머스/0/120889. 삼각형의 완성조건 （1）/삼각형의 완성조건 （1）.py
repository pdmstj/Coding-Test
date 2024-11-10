def solution(sides):
    # 배열을 정렬하여 가장 긴 변을 구함
    sides.sort()
    # 가장 긴 변은 배열의 마지막 요소
    if sides[2] < sides[0] + sides[1]:
        return 1  # 삼각형을 만들 수 있음
    else:
        return 2  # 삼각형을 만들 수 없음
