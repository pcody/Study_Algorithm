import sys

def dp(n):
    global res

    # 0 계산
    res[0] = 0
    if n == 0:
        return res[0]

    # 1 계산
    res[1] = 1
    if n == 1:
        return res[1]

    # 2부터 n번째까지 계산
    for i in range(2, n + 1):
        res[i] = res[i - 1] + res[i - 2]
    
    return res[n]


n = int(sys.stdin.readline().rstrip())
res = [-1] * (n + 1)
print(dp(n))