from collections import Counter

def solution(want, number, discount):
    # 원하는 제품과 그 수량을 Counter로 만듦
    want_count = Counter({want[i]: number[i] for i in range(len(want))})
    
    # discount에서 10일씩 확인하며 슬라이딩 윈도우 방식으로 검사
    answer = 0
    for i in range(len(discount) - 9):  # 10일 연속 할인 기간을 검사
        # 해당 기간 동안의 10일 제품을 슬라이딩 윈도우로 취합
        current_discount = discount[i:i+10]
        current_count = Counter(current_discount)
        
        # 원하는 제품의 수량이 정확히 맞는지 비교
        if all(current_count[product] >= want_count[product] for product in want_count):
            answer += 1
    
    return answer
