n=int(input())
L=list(map(int,input().split()))
M=max(L)
sum=0
for i in L:
    sum+=i/M*100
print(sum/n)