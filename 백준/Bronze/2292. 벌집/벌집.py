def find_min_steps(N):
    if N == 1:
        return 1  
    
    layer = 1 
    max_number = 1  
    
    while max_number < N:
        max_number += 6 * layer  
        layer += 1 
    
    return layer

N = int(input())
print(find_min_steps(N))
