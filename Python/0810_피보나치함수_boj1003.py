import sys

def dp(N):
    global res
    res[0] = [1, 0]
    if N == 0:
        return res[0]
    res[1] = [0, 1]
    if N == 1:
        return res[1]
    
    for i in range(2, N + 1):
        res[i] = [res[i - 1][0] + res[i - 2][0], res[i - 1][1] + res[i - 2][1]]

    return res[N]

T = int(sys.stdin.readline().rstrip())
answerList = []
for i in range(T):
    res = [[0, 0] for _ in range(41)]
    N = int(sys.stdin.readline().rstrip())
    dp(N)
    answerList.append((res[N][0], res[N][1]))

for answer in answerList:
    print(answer[0], answer[1])

# (0, 1)
# dp(5) = dp(4) + dp(3) (2, 3) + (1, 2) = (3, 5)
# dp(4) = dp(3) + dp(2) (1, 2) + (1, 1) = (2, 3)
# dp(3) = dp(2) + dp(1) (1, 1) + (0, 1) = (1, 2)
# dp(2) = dp(1) + dp(0) (1, 1)
# dp(1) = 1 (0, 1)
# dp(0) = 1 (1, 0)
# res[N] : dp(N)을 호출했을 때 출력된 0, 1의 개수