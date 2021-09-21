import sys

def dp(N, M, arr):
    global res
    
    for j in range(1, N + 1):
        for i in range(1, M + 1):
            res[j][i] = max(res[j][i - 1], res[j - 1][i], res[j - 1][i - 1]) + arr[j][i]
    
    return res[N][M]

N, M = map(int, sys.stdin.readline().split())
# 메모리제한 256MB
# 1 <= N, M <= 1000
# 메모리 최대값
# (N + 1)*(M + 1) * 4Byte = 1001*1001*4Bytes = 4008004Bytes = 3.8MB
# 2차원 리스트 2개를 써도 메모리제한 안 걸림
arr = [[0] * (M + 1)]
for _ in range(N):
    arr.append([0] + list(map(int, sys.stdin.readline().split())))
res = [[0] * (M + 1) for _ in range(N + 1)]
print(dp(N, M, arr))