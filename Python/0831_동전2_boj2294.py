import sys

def dp(N, K, coin, res):
    coin.sort()
    for k in range(K + 1):
        res[0][k] = sys.maxsize

    for k in range(1, K + 1):
        for i in range(1, N + 1):
            if coin[i] > k:
                res[i][k] = res[i - 1][k]
            else:
                res[i][k] = min(res[i - 1][k], res[i][k - coin[i]] + 1)

    if res[N][K] == sys.maxsize:
        return -1
    return res[N][K]

N, K = map(int, sys.stdin.readline().split())
coin = [0]
for _ in range(N):
    coin.append(int(sys.stdin.readline().rstrip()))
res = [[0] * (K + 1) for _ in range(N + 1)]
print(dp(N, K, coin, res))

# res[i][k] : i번째 동전까지 사용할 때 가치가 k원이 되는 최소 동전 수
# i\k 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
# 0
# 1   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
# 5   0  1  2  3  4  1  2  3  4  5  2  3  4  5  6  3
# 12  0  1  2  3  4  1  2  3  4  5  2  3  1  2  3  4

# coin[i] > k  res[i][k] = res[i-1][k]
# coin[i] <= k res[i][k] = min(res[i-1][k], res[i][k - coin[i]] + 1)

# i\k 0  1  2  3  4  5  6  7  8  9 10
# 0   0  0  0  0  0  0  0  0  0  0  0
# 2   0  0  1  
# 5   0
# 8   0