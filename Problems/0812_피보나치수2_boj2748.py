import sys

def dp(n):
    global res
    res[1] = 1
    
    for i in range(2, n + 1):
        res[i] = res[i - 1] + res[i - 2]
    
    return res[n]
    
n = int(sys.stdin.readline().rstrip())
res = [0] * (n + 1)
print(dp(n))