import sys

def dp(N, P, res):
    answer = 0

    for i in range(1, N + 1):
        res[i][1] = P[1]

    for j in range(2, N + 1):
        for i in range(1, N + 1):
            if j - i >= 0:
                res[i][j] = max(res[i-1][j], res[i][j-i] + P[i])
            else:
                res[i][j] = res[i-1][j]

    for i in range(1, N + 1):
        answer = max(answer, res[i][N])
    return answer


N = int(sys.stdin.readline().rstrip())
P = [0] + list(map(int, sys.stdin.readline().split()))
res = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
answer = dp(N, P, res)
print(answer)

#     1  2  3  4  5  6 ... N
# P1  1  2  3  4  5  6 ... N
# P2  1  5  6  10 11
# P3  1  5  6  10
# P4  1  5  6  10
# i-1개 팩 카드를 가지고 만들 수 있는 N개 카드 최대 금액, i번째 팩을 살때 비교
# (직전 값)과 (i줄의 N-i번 값) 비교
# res[i][N] = max(res[i-1][N], res[i][N-i]+P[i])