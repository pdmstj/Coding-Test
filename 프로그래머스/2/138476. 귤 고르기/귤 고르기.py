def solution(k, tangerine):
    answer = 0
    num = 0
    number = {}
    
    for x in tangerine:
        if x in number: 
            number[x] += 1
        else:
            number[x] = 1
    dic = sorted(number.items(),key = lambda x : (-x[1],x[0]))
    for i in range(len(dic)):
        num += dic[i][1]
        answer += 1
        if num >= k:
            break
    
    return answer