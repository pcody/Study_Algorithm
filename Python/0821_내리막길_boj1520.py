import sys

def dp(m, n, arr):
    global M, N, res, visited
    vecxy = [[-1, 0], [0, 1], [1, 0], [0, -1]]

    # 방문하지 않았으면 방문하고 값이 0이면 계산
    if not visited[m][n]:
        visited[m][n] = 1

        # 1,1 지점은 경로값이 1이다
        if m == 1 and n == 1:
            if res[m][n] == 0:
                res[m][n] = 1
        else:            
            if res[m][n] == 0:
                # 4방향을 돌면서
                for vecx, vecy in vecxy:
                    nx, ny = n + vecx, m + vecy
                    # 좌표가 범위 내이고
                    if 0 < nx <= N and 0 < ny <= M:
                        # 이전 좌표보다 높은 경우에만 계산
                        if arr[ny][nx] > arr[m][n]:
                            res[m][n] += dp(ny, nx, arr)

    # dp(m, n)은 res[m][n]을 계산해서 리턴한다
    return res[m][n]

M, N = map(int, sys.stdin.readline().split())
arr = [[0] * (N + 1)]
for _ in range(M):
    arr.append([0] + list(map(int, sys.stdin.readline().split())))
visited = [[0] * (N + 1) for _ in range(M + 1)]
res = [[0] * (N + 1) for _ in range(M + 1)]
print(dp(M, N, arr))