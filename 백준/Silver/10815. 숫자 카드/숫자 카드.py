input()
l=set(map(int,input().split()))
input()
c=list(map(int,input().split()))
r=[]
for i in c:
    s= 1 if i in l else 0
    r.append(s)
print(*r[0:])