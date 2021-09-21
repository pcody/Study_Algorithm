import sys

def dp(n, k, coin, res):
    
    res[0] = 1

    for j in range(1, n + 1):
        for i in range(1, k + 1):
            if coin[j] <= i:
                res[i] += res[i - coin[j]]

    return res[k]

n, k = map(int, sys.stdin.readline().split())
coin = [0]
for _ in range(n):
    coin.append(int(sys.stdin.readline().rstrip()))
res = [0] * (k + 1)
print(dp(n, k, coin, res))

# j\i k= 0  1  2  3  4  5  6  7  8  9 10
# 0      0  0  0  0  0  0  0  0  0  0  0
# 1      1  1  1  1  1  1  1  1  1  1  1
# 2      1  1  2  2  3  3  4  4  5  5  6
# 5      1  1  2  2  3  4  5  6  8  9 10

# res[j][i] : j번째 동전까지 사용했을 때 가치합이 k=i가 되는 경우의 수
# coin[j] < k=i  
# coin[j] >= k=i 