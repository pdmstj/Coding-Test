
x_coords = []
y_coords = []

for _ in range(3):
    x, y = map(int, input().split())
    x_coords.append(x)
    y_coords.append(y)

x4 = 0
y4 = 0

for x in x_coords:
    if x_coords.count(x) == 1:  
        x4 = x

for y in y_coords:
    if y_coords.count(y) == 1:
        y4 = y

print(x4, y4)
