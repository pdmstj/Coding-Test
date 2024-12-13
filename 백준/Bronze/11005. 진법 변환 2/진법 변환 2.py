def decimal_to_base(n, base):
    chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    result = []

    while n > 0:
        remainder = n % base
        result.append(chars[remainder])
        n //= base

    return ''.join(result[::-1])

n, b = map(int, input().split())

print(decimal_to_base(n, b))
