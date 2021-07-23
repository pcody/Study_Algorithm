from heapq import *
import collections
import sys

def prim(graph, start_node):
    global visited
    visited[start_node] = 1
    edges = graph[start_node]
    heapify(edges)
    mst = []
    total_weight = 0

    while edges:
        weight, u, v = heappop(edges)

        if visited[v] == 0:
            visited[v] = 1
            mst.append((u, v))
            total_weight += weight

            for edge in graph[v]:
                if visited[edge[2]] == 0:
                    heappush(edges, edge)

    return total_weight


V, E = map(int, sys.stdin.readline().split())
graph = collections.defaultdict(list)
for i in range(E):
    u, v, weight = map(int, sys.stdin.readline().split())
    graph[u].append([weight, u, v])
    graph[v].append([weight, v, u])
visited = [0] * (V+1)

print(prim(graph, 1))