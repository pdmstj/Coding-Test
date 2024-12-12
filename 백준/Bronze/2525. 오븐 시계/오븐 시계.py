A, B = map(int, input().split())
C = int(input())

total_minutes = B + C

new_minutes = total_minutes % 60
added_hours = total_minutes // 60

new_hours = (A + added_hours) % 24

print(new_hours, new_minutes)
