def solution(myString, pat):
    # 문자열을 모두 소문자로 변환
    myString = myString.lower()
    pat = pat.lower()
    
    # pat이 myString에 포함되어 있는지 확인
    if pat in myString:
        return 1
    else:
        return 0
