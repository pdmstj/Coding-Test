import sys
input = sys.stdin.readline

colors=["black","brown","red","orange","yellow","green","blue","violet","grey","white"]
d={}
for i in range(10):
    d[colors[i]]=str(i)
    
a=input().rstrip()
b=input().rstrip()
c=input().rstrip()

ans=d[a]+d[b]
ans+= ('0'*int(d[c]))
print( int(ans))