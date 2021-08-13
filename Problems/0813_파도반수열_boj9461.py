import sys

def dp(N):
    global res
    res[1] = 1
    if N == 1:
        return res[1]
    res[2] = 1
    if N == 2:
        return res[2]
    res[3] = 1

    for i in range(4, N + 1):
        res[i] = res[i - 2] + res[i - 3]

    return res[N]

T = int(sys.stdin.readline().rstrip())
answerList = []
for i in range(T):
    N = int(sys.stdin.readline().rstrip())
    res = [0] * (N + 1)
    answerList.append(dp(N))
for answer in answerList:
    print(answer)