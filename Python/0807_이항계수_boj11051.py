import sys
# sys.setrecursionlimit(10**6)
# 재귀 깊이를 정하니 메모리초과가 나오던데 이유를 모르겠다..

divisor = 10007

def binomCoef(n, k):
    global res

    if n <= 1:
        if res[n][k] == 0:
            res[n][k] = 1
        return res[n][k]
    else: # n > 1
        if n == k:
            if res[n][k] == 0:
                res[n][k] = 1
            return res[n][k]
        # n != k
        elif k <= 1:
            if res[n][k] == 0:
                res[n][k] = n % divisor
                res[n][k] %= divisor
            return res[n][k]
        else:
            if res[n][k] == 0:
                res[n][k] = binomCoef(n-1, k-1) % divisor + binomCoef(n-1, k) % divisor
                res[n][k] %= divisor
            return res[n][k]

N, K = map(int, sys.stdin.readline().split())
res = [[0] * (K + 1) for _ in range(N + 1)]
print(binomCoef(N,K) % divisor)