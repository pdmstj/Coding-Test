def solution(my_string, n):
    # 문자열의 각 문자를 n번 반복하여 새로운 문자열 생성
    result = ''.join([char * n for char in my_string])
    return result
