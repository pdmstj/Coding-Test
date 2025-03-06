def classify_triangle(a, b, c):
    if a + b + c != 180:
        return "Error"
    if a == 60 and b == 60 and c == 60:
        return "Equilateral"
    
    if a == b or b == c or a == c:
        return "Isosceles"
    return "Scalene"

a = int(input())
b = int(input())
c = int(input())

print(classify_triangle(a, b, c))
