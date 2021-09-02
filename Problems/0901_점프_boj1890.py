import sys

def dp(N, arr, res):
    
    res[0][0] = 1
    for j in range(N):
        for i in range(N):
            if j == N - 1 and i == N - 1:
                break
            
            if res[j][i] > 0:
                ni = i + arr[j][i]
                nj = j + arr[j][i]
                if 0 <= ni < N:
                    res[j][ni] += res[j][i]
                if 0 <= nj < N:
                    res[nj][i] += res[j][i]
    
    return res[N - 1][N - 1]

N = int(sys.stdin.readline().rstrip())
arr = []
for _ in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))
res = [[0] * N for _ in range(N)]
print(dp(N, arr, res))
