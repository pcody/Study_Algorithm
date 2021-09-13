import sys

def dp(N, M, arr, res):
    for n in range(1, N+1):
        for m in range(1, M+1):
            res[n][m] = arr[n-1][m-1] + res[n-1][m] + res[n][m-1] - res[n-1][m-1]

N, M = map(int, sys.stdin.readline().split())
arr, res = [], [[0] * (M+1)]
for _ in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))
    res.append([0] * (M+1))
K = int(sys.stdin.readline().rstrip())
dp(N, M, arr, res)
answerList = []
for k in range(K):
    x1,y1,x2,y2 = map(int, sys.stdin.readline().split())
    answerList.append(res[x2][y2] - res[x2][y1-1] - res[x1-1][y2] + res[x1-1][y1-1])

for answer in answerList:
    print(answer)