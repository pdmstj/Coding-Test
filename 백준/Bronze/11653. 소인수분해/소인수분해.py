def prime_factorization(n):
    factors = []
    divisor = 2
    while n >= divisor:
        while n % divisor == 0:
            factors.append(divisor)
            n //= divisor
        divisor += 1

    for factor in factors:
        print(factor)

n = int(input())
if n > 1:
    prime_factorization(n)
