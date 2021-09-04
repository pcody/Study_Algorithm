import sys
divisor = 1000000000

def dp(N, K, res):
    
    for k in range(2, K + 1):
        for n in range(1, N + 1):
            res[n][k] = ((res[n][k - 1] % divisor) + (res[n - 1][k] % divisor)) % divisor
    
    return res[N][K] % divisor
    
N, K = map(int, sys.stdin.readline().split())
res = [[1] * (K + 1) for _ in range(N + 1)]
print(dp(N, K, res) % divisor)

# n\k 1  2  3
# 0   1  1  1 0+0+0
# 1   1  2  3 1+0+0 0+1+0 0+0+1
# 2   1  3  6 2+0+0 0+2+0 0+0+2 1+1+0 1+0+1 1+1+0
# 3   1  4
# 4   1  5
# 5   1  6
# 6   1  7
# 7   1  8
# 8   1  9
# 9   1  10
# 10  1  11
# 11  1  12
# 12  1  13
# 13  1  14
# 14  1  15
# 15  1  16
# 16  1  17
# 17  1  18
# 18  1  19
# 19  1  20
# 20  1  21