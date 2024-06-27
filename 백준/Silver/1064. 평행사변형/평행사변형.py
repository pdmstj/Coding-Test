x1,y1,x2,y2,x3,y3=map(int,input().split())

#01
if ((x1-x2)*(y1-y3) == (x1-x3)*(y1-y2)): # ((y1-y2)/(x1-x2) == (y1-y3)/(x1-x3))
    print(-1.0)
    quit()
#02
ab = ((x1-x2)**2+(y1-y2)**2)**0.5
bc = ((x1-x3)**2+(y1-y3)**2)**0.5
ca = ((x2-x3)**2+(y2-y3)**2)**0.5

#03
tmp = [ab+bc,ab+ca,bc+ca]
res = max(tmp)-min(tmp)
print(res*2)