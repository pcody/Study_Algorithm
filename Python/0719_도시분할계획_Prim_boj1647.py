# 0719 숙제.. Prim으로 풀어보기
# 집 개수(Vertex)가 2~100,000 이라 N^2 의 프림으로 풀면 100*10^8 = 100초 걸려서 1초제한 초과
# 간선 M이 1~1,000,000 이라 크루스칼 ElogE하면 6*10^6 = 0.06초

import sys
import collections
import heapq

def prim(graph, start_node):
    global visited, answer, lastWeight
    visited[start_node] = 1
    edges = graph[start_node]
    heapq.heapify(edges)
    mst = []

    while edges:
        weight, A, B = heapq.heappop(edges)

        if visited[B] == 0:
            visited[B] = 1
            mst.append((A, B))
            answer += weight
            lastWeight = weight

            for elem in graph[B]:
                if visited[elem[2]] == 0:
                    heapq.heappush(edges, elem)
                    


N, M = map(int, sys.stdin.readline().split())
graph = collections.defaultdict(list)
for i in range(M):
    A, B, weight = map(int, sys.stdin.readline().split())
    graph[A].append([weight, A, B])
    graph[B].append([weight, B, A])
visited = [0] * (N + 1)
answer = 0
lastWeight = 0
prim(graph, 1)
print(answer - lastWeight)


