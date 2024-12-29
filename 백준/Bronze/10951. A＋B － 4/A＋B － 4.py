import sys

for line in sys.stdin:
    try:
        A, B = map(int, line.split())
        if 0 < A < 10 and 0 < B < 10:
            print(A + B)
        else:
            break
    except:
        break
