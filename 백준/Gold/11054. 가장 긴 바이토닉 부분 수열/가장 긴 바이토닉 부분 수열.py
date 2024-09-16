def longest_bitonic_subsequence(arr):
    N = len(arr)
    
    # 1. 증가하는 부분 수열의 길이를 저장하는 DP 배열
    dp_up = [1] * N
    for i in range(1, N):
        for j in range(i):
            if arr[i] > arr[j]:
                dp_up[i] = max(dp_up[i], dp_up[j] + 1)
    
    # 2. 감소하는 부분 수열의 길이를 저장하는 DP 배열
    dp_down = [1] * N
    for i in range(N-2, -1, -1):
        for j in range(i+1, N):
            if arr[i] > arr[j]:
                dp_down[i] = max(dp_down[i], dp_down[j] + 1)
    
    # 3. dp_up[i] + dp_down[i] - 1의 최대값이 바이토닉 수열의 최대 길이
    max_len = 0
    for i in range(N):
        max_len = max(max_len, dp_up[i] + dp_down[i] - 1)
    
    return max_len

# 입력 처리
N = int(input())
arr = list(map(int, input().split()))

# 결과 출력
print(longest_bitonic_subsequence(arr))