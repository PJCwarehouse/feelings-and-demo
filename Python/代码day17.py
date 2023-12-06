def sum(n):
    n=(n>0)and(n+sum(n-1))
    return n
print(sum(10))