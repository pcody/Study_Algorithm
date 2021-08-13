import sys

def dp(N):
    global res
    res[0] = 0
    res[1] = 1

    for i in range(2, N + 1):
        res[i] = res[i - 1] + res[i - 2]
    
    return res[N]
    
N = int(sys.stdin.readline().rstrip())
res = [0] * (N + 1)
print(dp(N))

# 1
# 10
# 100
# 101
# 1000
# 1001
# 1010
# 10000
# 10001
# 10010
# 10100
# 10101
# 100000
# 100001
# 100010
# 100100
# 101000
# 100101
# 101001
# 101010

# 1 - 1
# 2 - 1
# 3 - 2
# 4 - 3
# 5 - 5
# 6 - 8