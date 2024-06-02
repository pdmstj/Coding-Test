T = int(input())

def count(start, a, b, c):
    for i in range(start, N):
        a[i+1] = min(b[i] + 1, c[i] + 1)
        if e1[i] + e2[i] <= W:
            a[i+1] = min(a[i+1], a[i] + 1)
        if i > 0 and e1[i-1] + e1[i] <= W and e2[i-1] + e2[i] <= W:
            a[i+1] = min(a[i+1], a[i-1] + 2)
            
        if i < N-1:
            b[i+1] = a[i+1] + 1
            if e1[i] + e1[i+1] <= W:
                b[i+1] = min(b[i+1], c[i] + 1)
            
            c[i+1] = a[i+1] + 1
            if e2[i] + e2[i+1] <= W:
                c[i+1] = min(c[i+1], b[i] + 1)
                
    return a, b, c

for _ in range(T):
    N, W = map(int, input().split())
    
    e1 = list(map(int, input().split()))
    e2 = list(map(int, input().split()))
    
    a = [0 for _ in range(N + 1)]
    b = [0 for _ in range(N + 1)]
    c = [0 for _ in range(N + 1)]
 
    a[0] = 0
    b[0] = 1
    c[0] = 1
    
    a, b, c = count(0, a, b, c)
    ans = a[N]
    
    if N > 1 and e1[0] + e1[N-1] <= W:
        a[1] = 1
        b[1] = 2
        if e2[0] + e2[1] <= W:
            c[1] = 1
        else:
            c[1] = 2
    
        a, b, c = count(1, a, b, c)
        ans = min(ans, c[N-1] + 1)
    
    if N > 1 and e2[0] + e2[N-1] <= W:
        a[1] = 1
        c[1] = 2
        if e1[0] + e1[1] <= W:
            b[1] = 1
        else:
            b[1] = 2
            
        a, b, c = count(1, a, b, c)
        ans = min(ans, b[N-1] + 1)
        
    if N > 1 and e1[0] + e1[N-1] <= W and e2[0] + e2[N-1] <= W:
        a[1] = 0
        b[1] = 1
        c[1] = 1
    
        a, b, c = count(1, a, b, c)
        ans = min(ans, a[N-1] + 2)
    
    print(ans)