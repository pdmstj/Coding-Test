from collections import Counter

def solution(topping):

    left = set()
    right = Counter(topping)  
    answer = 0

    for i in range(len(topping) - 1):
        left.add(topping[i])
        right[topping[i]] -= 1
        
        if right[topping[i]] == 0:
            del right[topping[i]]
        
        if len(left) == len(right):
            answer += 1

    return answer
