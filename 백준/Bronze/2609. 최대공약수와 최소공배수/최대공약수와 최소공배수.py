import math

# 두 자연수 입력 받기
a, b = map(int, input().split())

# 최대공약수 계산
gcd = math.gcd(a, b)

# 최소공배수 계산
lcm = (a * b) // gcd

# 결과 출력
print(gcd)
print(lcm)
