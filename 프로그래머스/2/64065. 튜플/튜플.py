import re

def solution(s):
    # 1. 문자열에서 { }로 감싸진 부분을 추출
    sets = re.findall(r'\{([0-9,]+)\}', s)
    
    # 2. 각 집합을 숫자 리스트로 변환
    sets = [set(map(int, item.split(','))) for item in sets]
    
    # 3. 집합의 크기 순으로 정렬
    sets.sort(key=len)
    
    # 4. 원소 추출하기
    result = []
    previous_set = set()
    
    for current_set in sets:
        new_element = current_set - previous_set
        result.append(new_element.pop())  
        previous_set = current_set
    
    return result