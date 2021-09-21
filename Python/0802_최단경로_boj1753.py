import sys
from collections import defaultdict
from heapq import *

def dijkstra(V, start, graphs):
    costs = [sys.maxsize] * (V + 1)
    
    q = []
    costs[start] = 0
    heappush(q, (0, start))

    while q:
        cost, cur = heappop(q)

        if cost > costs[cur]:
            continue

        for nCost, next in graphs[cur]:
            if cost + nCost < costs[next]:
                costs[next] = cost + nCost
                heappush(q, (cost + nCost, next))

    return costs


V, E = map(int, sys.stdin.readline().split())
start = int(sys.stdin.readline().rstrip())
graphs = defaultdict(list)
for i in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    graphs[u].append((w,v))

costs = dijkstra(V, start, graphs)
for i in range(1, V + 1):
    if costs[i] >= sys.maxsize:
        print("INF")
    else:
        print(costs[i])