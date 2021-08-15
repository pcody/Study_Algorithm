import sys

def dp(N, T, P, res):
    for j in range(N, 0, -1):
        if j + T[j] == N + 1:
            res[1][j] = P[j]
        elif j + T[j] < N + 1:
            res[1][j] = P[j] + max(res[1][j + T[j]], res[0][j + T[j]])
        else:
            if j + 1 < N + 1:
                res[1][j] = max(res[1][j+1], res[0][j+1])
            else:
                res[1][j] = 0

        if j + 1 < N + 1:
            res[0][j] = max(res[1][j+1], res[0][j+1])
        else:
            res[0][j] = 0

N = int(sys.stdin.readline().rstrip())
T, P = [0], [0]
for i in range(N):
    t, p = map(int, sys.stdin.readline().split())
    T.append(t)
    P.append(p)
res = [[0 for _ in range(N + 1)] for _ in range(2)]
dp(N, T, P, res)
print(max(res[1][1], res[0][1]))

# res[1][j] = P[j]+res[1][j+T[j]]
# res[0][j] = max(res[0][j+1], res[1][j+1])
# 1:일한다, 0:안한다
# 7 - 1:0, 0:0
# 6 - 1:0, 0:0
# 5 - 1:P[5]+res[1][7], 0:max(res[0][6],res[1][6])
# 4 - 1:P[4]+res[1][4+T[4]], 0:max(res[0][5],res[1][5])
# 3
# 2
# 1


