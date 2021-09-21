import sys
from heapq import *

def dijkstra(N, M, start, end, maze):
    global vecx, vecy

    # 가중치를 저장할 2차원 리스트, 시작점의 가중치는 0
    costs = [[sys.maxsize] * N for _ in range(M)]
    costs[start[0]][start[1]] = 0

    # 우선순위큐(최소힙) 생성
    q = []
    heappush(q, (0, start))

    while q:
        curCost, cur = heappop(q)
        curX, curY = cur

        if curCost > costs[curY][curX]:
            continue

        for i in range(4):
            nextX, nextY = curX + vecx[i], curY + vecy[i]
            if 0 <= nextX < N and 0 <= nextY < M:
                if curCost + maze[nextY][nextX] < costs[nextY][nextX]:
                    costs[nextY][nextX] = curCost + maze[nextY][nextX]
                    heappush(q, (curCost + maze[nextY][nextX], (nextX, nextY)))

    return costs

N, M = map(int, sys.stdin.readline().split())
maze = [[] for _ in range(M)]
for i in range(M):
    maze[i] = list(map(int, sys.stdin.readline().rstrip()))

start = (0, 0)
end = (N - 1, M - 1)
vecx = [-1, 0, 1, 0]
vecy = [0, 1, 0, -1]
costs = dijkstra(N, M, start, end, maze)
print(costs[end[1]][end[0]])