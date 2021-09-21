import sys

def dp(N, T, P):
    global res
    # 1:먹는다 0:안먹는다

    for i in range(N):
        if i + T[i] < N + 1:
            res[i + T[i]] = max(res[i + T[i]], res[i] + P[i])
        res[i + 1] = max(res[i + 1], res[i])
        
    return res


N = int(sys.stdin.readline().rstrip())
T, P = [], []
for i in range(N):
    t, p = map(int, sys.stdin.readline().split())
    T.append(t)
    P.append(p)
res = [0] * (N + 1)

print(dp(N, T, P))