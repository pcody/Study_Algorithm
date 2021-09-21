import sys

def dp(n, sticker):
    global res
    
    res[1] = [sticker[0][1], sticker[1][1]]
    if n == 1:
        return res[1]

    res[2] = [max(res[1][1] + sticker[0][2], res[1][0]), max(res[1][0] + sticker[1][2], res[1][1])]
    if n == 2:
        return res[2]

    for i in range(3, n + 1):
        # 0: 윗줄에서 고름, 1: 아랫줄에서 고름
        res[i] = [max(res[i - 1][1], res[i - 2][1]) + sticker[0][i],
                    max(res[i - 1][0], res[i - 2][0]) + sticker[1][i]]
    return res[n]

T = int(sys.stdin.readline().rstrip())
answerList = []
for _ in range(T):
    n = int(sys.stdin.readline().rstrip())
    sticker = []
    res = [0] * (n + 1)
    for __ in range(2):
        sticker.append([0] + list(map(int, sys.stdin.readline().split())))
    answerList.append(dp(n, sticker))
for answer in answerList:
    print(max(answer))