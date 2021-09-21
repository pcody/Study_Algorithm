import sys
import collections
import heapq

# 입력 부분
N = int(sys.stdin.readline().rstrip())
coordinate = []
for i in range(N):
    coordinate.append([i] + list(map(int, sys.stdin.readline().split())))

# 각 좌표별로 정렬한 리스트를 따로 만든다.
coordx = sorted(coordinate, key = lambda x : x[1])
coordy = sorted(coordinate, key = lambda x : x[2])
coordz = sorted(coordinate, key = lambda x : x[3])

# 좌표별 정렬된 리스트에서 인접 행성끼리 가중치를 계산하여 리스트에 담는다.
graph = collections.defaultdict(list)
for i in range(1, N):
    ix1, x1, _, _ = coordx[i-1]
    ix2, x2, _, _ = coordx[i]
    iy1, _, y1, _ = coordy[i-1]
    iy2, _, y2, _ = coordy[i]
    iz1, _, _, z1 = coordz[i-1]
    iz2, _, _, z2 = coordz[i]

    # 양방향 그래프로 간선 정보를 입력해둔다.
    graph[ix1].append([abs(x1-x2), ix1, ix2])
    graph[iy1].append([abs(y1-y2), iy1, iy2])
    graph[iz1].append([abs(z1-z2), iz1, iz2])
    graph[ix2].append([abs(x1-x2), ix2, ix1])
    graph[iy2].append([abs(y1-y2), iy2, iy1])
    graph[iz2].append([abs(z1-z2), iz2, iz1])

print(graph)

# Prim 알고리즘
def prim(graph, start_node):
    global visited, answer
    visited[start_node] = 1
    edges = graph[start_node]
    heapq.heapify(edges)

    while edges:
        weight, u, v = heapq.heappop(edges)
        if visited[v] == 0:
            visited[v] = 1
            answer += weight

            for elem in graph[v]:
                if visited[elem[2]] == 0:
                    heapq.heappush(edges, elem)

answer = 0
visited = [0] * N 
prim(graph, 0)
print(answer)