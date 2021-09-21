import sys
from collections import deque

def bfs(M, N, cabbages):
    visited = [[0] * M for _ in range(N)]
    q = deque()
    vecxy = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    
    cnt = 0
    for j in range(N):
        for i in range(M):
            if not visited[j][i] and cabbages[j][i] == 1:
                cnt += 1
                q.append([i, j])
                visited[j][i] = cnt
                while q:
                    x, y = q.popleft()
                    
                    for vecx, vecy in vecxy:
                        nx, ny = vecx + x, vecy + y
                        if 0 <= nx < M and 0 <= ny < N:
                            if not visited[ny][nx] and cabbages[ny][nx] == 1:
                                visited[ny][nx] = cnt
                                q.append([nx, ny])
    return cnt



answerList = []
T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    M, N, K = map(int, sys.stdin.readline().split())
    cabbages = [[0] * M for _ in range(N)]
    for k in range(K):
        X, Y = map(int, sys.stdin.readline().split())
        cabbages[Y][X] = 1

    answerList.append(bfs(M, N, cabbages))

for answer in answerList:
    print(answer)