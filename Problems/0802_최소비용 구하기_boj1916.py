import sys
from collections import defaultdict
from heapq import *

def dijkstra(N, start, graphs):
    # costs = [sys.maxsize] * (N + 1)
    costs = {i: sys.maxsize for i in range(1, N + 1)}
    q = []

    costs[start] = 0
    heappush(q, (0, start))

    while q:
        curCost, cur = heappop(q)
        if curCost > costs[cur]:
            continue

        # for next, nextCost in graphs[cur].items():
        for nextCost, next in graphs[cur]:
            if curCost + nextCost < costs[next]:
                costs[next] = curCost + nextCost
                heappush(q, (curCost + nextCost, next))

    return costs

N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())
# graphs = defaultdict(dict)
graphs = defaultdict(list)
for i in range(M):
    depCity, arrCity, cost = map(int, sys.stdin.readline().split())
    # graphs[depCity][arrCity] = cost
    graphs[depCity].append((cost, arrCity))
start, end = map(int, sys.stdin.readline().split())
print(graphs)
costs = dijkstra(N, start, graphs)
# print(costs)
print(costs[end])