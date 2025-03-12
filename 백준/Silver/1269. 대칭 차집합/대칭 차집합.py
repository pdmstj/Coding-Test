n, m = map(int, input().split())
A = set(map(int, input().split()))
B = set(map(int, input().split()))
symmetric_difference = A ^ B
print(len(symmetric_difference))