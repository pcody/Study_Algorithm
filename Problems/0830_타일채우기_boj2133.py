import sys

def dp(N, res):

    if N == 1:
        return res[1]
    res[2] = 3
    if N == 2:
        return res[2]
    
    if N == 3:
        return res[3]

    res[4] = 11
    if N == 4:
        return res[4]

    if N == 5:
        return res[5]

    for i in range(6, N + 1):
        if i % 2 == 0:
            temp = 0
            for j in range(2, i - 2, 2):
                temp += res[j] * 2
            res[i] = temp + res[i - 2] * 3 + 2

    return res[N]
    
N = int(sys.stdin.readline().rstrip())
res = [0] * (N + 1)
print(dp(N, res))

# 점화식을 생각하기가 어려웠음 사실 구글링 + 그림그려서
# a가 최종 개수이고 b는 새로 생기는 특수모양이므로 상수 2임
# 마지막 a(n)에서 새로 생기는 2개를 더해주어야 하고
# a(n) = b(2)*a(n-2) + b(4)*a(n-4) + b(6)*a(n-6) + ... + b(n-2)*a(2) + 2
# 1 0
# 2 3
# 3 0
# 4 11
# 5 0
# 6 153
# 7 0
# 8 ...