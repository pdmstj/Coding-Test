def solution(n, m):
    def gcd(a, b):
        while b:
            a, b = b, a % b
        return a

    gcd_value = gcd(n, m)
    lcm_value = (n * m) // gcd_value
    
    return [gcd_value, lcm_value]
