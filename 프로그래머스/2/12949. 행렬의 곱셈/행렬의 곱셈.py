def solution(arr1, arr2):

    m = len(arr1)     
    n = len(arr1[0])   
    p = len(arr2[0])   
    answer = [[0] * p for _ in range(m)]
    
    for i in range(m): 
        for j in range(p): 
            for k in range(n): 
                answer[i][j] += arr1[i][k] * arr2[k][j]
    
    return answer
