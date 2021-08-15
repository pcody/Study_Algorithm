import sys

def dp(N, M, res):
    # mCn을 구하면 된다
    if N == M or M <= 1 or N <= 0:
        if res[M][N] == 0:
            res[M][N] = 1
        return res[M][N]
    if N == 1:
        if res[M][N] == 0:
            res[M][N] = M
        return res[M][N]
    else:
        if res[M][N] == 0:
            res[M][N] = dp(N-1, M-1, res) + dp(N, M-1, res)
        return res[M][N]

T = int(sys.stdin.readline().rstrip())
answerList = []
for _ in range(T):
    N, M = map(int, sys.stdin.readline().split())
    res = [[0] * (M + 1) for _ in range(M + 1)]
    answerList.append(dp(N, M, res))
for answer in answerList:
    print(answer)