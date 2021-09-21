import sys
# 재귀 limit이 오히려 메모리 초과가 난다..
# sys.setrecursionlimit(10**6)
divisor = 15746

def dp(N):
    global res

    res[0] = 1
    res[1] = 1
    if N == 1:
        return res[1]

    for i in range(2, N + 1):
        res[i] = (res[i - 1] + res[i - 2]) % divisor
    
    return res[N]

N = int(sys.stdin.readline().rstrip())
res = [0] * (N + 1)
print(dp(N) % divisor)

# N = 1
# 1

# N = 2
# 00
# 11

# N = 3
# 100
# 001
# 111

# N = 4
# (N=2) + (N=3)
