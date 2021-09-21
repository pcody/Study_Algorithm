import sys
divisor = 10007

def dp(n):
    global res

    res[1] = 1
    if n == 1:
        return res[1]
    
    res[2] = 3
    if n == 2:
        return res[2]

    for i in range(3, n + 1):
        res[i] = res[i - 1] + res[i - 2] * 2
    return res[n]
    
n = int(sys.stdin.readline().rstrip())
res = [0] * (n + 1)

print(dp(n) % divisor)