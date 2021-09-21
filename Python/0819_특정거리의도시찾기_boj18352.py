import sys
from collections import defaultdict
from heapq import *

def dikjstra(N, M, K, X, graphs):
    distances = {node: sys.maxsize for node in range(1, N + 1)}
    
    hq = []
    distances[X] = 0
    heappush(hq, (0, X))

    while hq:
        cost, cur = heappop(hq)

        if distances[cur] < cost:
            continue

        for next in graphs[cur]:
            nCost = cost + 1

            if nCost < distances[next]:
                distances[next] = nCost
                heappush(hq, (nCost, next))

    return distances

N, M, K, X = map(int, sys.stdin.readline().split())
graphs = defaultdict(list)
for _ in range(M):
    A, B = map(int, sys.stdin.readline().split())
    graphs[A].append(B)

res = dikjstra(N, M, K, X, graphs)
flag = 0
for node, cost in res.items():
    if cost == K:
        flag = 1
        print(node)
if not flag:
    print(-1)