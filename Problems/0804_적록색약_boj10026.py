import sys
from collections import deque
from copy import deepcopy

def bfs(N, arr, rg):
    vecx, vecy = [-1, 0, 1, 0], [0, 1, 0, -1]
    q = deque()

    # 구역 개수
    area = 0

    for j in range(N):
        for i in range(N):
            # x좌표: i, y좌표: j
            
            # 방문 안한 좌표는 시작점이 된다
            # 방문 처리 해주고 큐에 넣고
            # 신규 구역을 정한다
            if arr[j][i] == 'R' or arr[j][i] == 'G' or arr[j][i] == 'B':
                area += 1
                q.append((i, j))
                newArea = rg[arr[j][i]]
                arr[j][i] = area
            
                # 초기 좌표와 같은 구역인 것들만 큐를 돌면서 방문처리
                while q:
                    curX, curY = q.popleft()

                    for i in range(4):
                        nextX, nextY = curX + vecx[i], curY + vecy[i]
                        if 0 <= nextX < N and 0 <= nextY < N and (arr[nextY][nextX] == 'R' or arr[nextY][nextX] == 'G' or arr[nextY][nextX] == 'B'):
                            if rg[arr[nextY][nextX]] == newArea:
                                q.append((nextX, nextY))
                                # 별표 5개 밑줄쫙
                                # BFS는 방문 표시를 큐에 넣을 때 해야 중복 방문이 일어나지 않는다.... (메모리초과의 원인)
                                arr[nextY][nextX] = area
    return area

N = int(sys.stdin.readline().rstrip())
arr = []
for i in range(N):
    arr.append(list(sys.stdin.readline().rstrip()))

print(bfs(N, deepcopy(arr), {'R':1, 'G':2, 'B':3}), bfs(N, deepcopy(arr), {'R':1, 'G':1, 'B':2}))