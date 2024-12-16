def solution(s):
    answer = 0
    i = 0
    while i < len(s):
        x = s[i]  # 첫 글자
        x_count = 0
        other_count = 0
        
        # 현재 분리할 문자열의 끝을 탐색
        while i < len(s):
            if s[i] == x:
                x_count += 1
            else:
                other_count += 1
            
            i += 1
            
            # x와 다른 문자의 개수가 같아지면 분리
            if x_count == other_count:
                break
        
        # 분리 완료 후 하나 증가
        answer += 1
    
    return answer