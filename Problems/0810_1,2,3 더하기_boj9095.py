import sys

def dp(N, res):
    if res[1] == 0:
        res[1] = 1
    if N == 1:
        return res[1]

    if res[2] == 0:
        res[2] = 2
    if N == 2:
        return res[2]
    
    if res[3] == 0:
        res[3] = 4
    
    for i in range(4, N + 1):
        if res[i] == 0:
            res[i] = res[i - 1] + res[i - 2] + res[i - 3]

    return res[N]

T = int(sys.stdin.readline().rstrip())
answerList = []
res = [0] * 12
for i in range(T):
    n = int(sys.stdin.readline().rstrip())
    answerList.append(dp(n, res))

for answer in answerList:
    print(answer)

# 1 -> 1      1
# 2 -> 1+1    2
#      2
# 3 -> 2+1    4
#      1+2
#      1+1+1
#      3
# 4 -> 3+1    7
#      1+3
#      2+2
#      2+1+1
#      1+2+1
#      1+1+2
#      1+1+1+1
# 5 -> 3+2   13
#      2+3
#      1+2+2
#      2+1+2
#      2+2+1
#      3+1+1
#      1+3+1
#      1+1+3
#      2+1+1+1
#      1+2+1+1
#      1+1+2+1
#      1+1+1+2
#      1+1+1+1+1
# 6 -> 1+1+1+1+1+1 -> 1  24
#      1+1+1+1+2   -> 5
#      1+1+1+3     -> 4
#      1+1+2+2     -> 6
#      1+2+3       -> 6
#      2+2+2       -> 1
#      3+3         -> 1