def claS(n):
    if n==1 or n==2:
        return n
    else:
        return claS(n-1)+claS(n-2)