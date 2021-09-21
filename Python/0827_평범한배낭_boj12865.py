import sys

def dp(N, K, W, V):
    global res

    # res의 x축
    for k in range(1, K + 1):
        # res의 y축
        for n in range(1, N + 1):
            if W[n] > k:
                res[n][k] = max(res[n - 1][k], res[n][k - 1])
            else:
                res[n][k] = max(res[n - 1][k], V[n] + res[n - 1][k - W[n]])

    return res[n][k]

N, K = map(int, sys.stdin.readline().split())
W, V = [0], [0]
for _ in range(N):
    w, v = map(int, sys.stdin.readline().split())
    W.append(w)
    V.append(v)
res = [[0] * (K + 1) for _ in range(N + 1)]
print(dp(N, K, W, V))

# N\K  0  1  2  3  4  5  6  7
# 0 0  0  0  0  0  0  0  0  0
# 1 6  0  0  0  0  0  0  13 13
# 2 4  0  0  0  0  8  8  13 13
# 3 3  0  0  0  6  8  8  13 14
# 4 5  0  0  0  6  8  12 13 14

# res[n][k] = res[n-1][k]                             (W[n] > k)
#             max(res[n-1][k], V[n]+res[n-1][k-W[n]]) (W[n] =< k)