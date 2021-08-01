## 시간초과...
# import sys
# from collections import defaultdict
# from heapq import *

# def dijkstra(N, X, K, graphs):
#     # heapq 생성
#     visitQ = []
#     # 비용을 담을 리스트, 시작점 X의 비용 초기값 0
#     costs = [sys.maxsize] * (N + 1)
#     costs[X] = 0
#     heappush(visitQ, (0, X))

#     while visitQ:
#         # heapq에서 꺼내고 비용이 작으면 교체
#         cost, cur = heappop(visitQ)
#         if cost < costs[cur]:
#             costs[cur] = cost

#         # cur에 연결된 모든 정점은 cur비용+1 하여 삽입
#         for next in graphs[cur]:
#             heappush(visitQ, (cost + 1, next))

#     return costs


# N, M, K, X = map(int, sys.stdin.readline().split())
# graphs = defaultdict(list)
# answerList = []
# for i in range(1, M + 1):
#     start, end = map(int, sys.stdin.readline().split())
#     graphs[start].append(end)

# f = 0
# costs = dijkstra(N, X, K, graphs)
# for i in range(1, N + 1):
#     if costs[i] == K:
#         f = 1
#         print(i)
# if f == 0:
#     print(-1)

import sys
from collections import defaultdict
from heapq import *

def dijkstra(N, X, K, graphs):
    # heapq 생성
    visitQ = []
    # 비용을 담을 리스트, 시작점 X의 비용 초기값 0
    costs = [sys.maxsize] * (N + 1)
    costs[X] = 0
    heappush(visitQ, (0, X))

    while visitQ:
        # heapq에서 꺼냈는데 비용이 기존보다 크면 넘어감
        cost, cur = heappop(visitQ)

        # 우선순위큐를 사용하므로 큐에서 꺼낸 노드의 비용이 기존보다 큰 것이 나올 수 있음
        if costs[cur] < cost:
            continue

        # cur에 연결된 모든 정점은 계산한 비용이 기존 비용보다 작다면 삽입
        # 모든 정점을 삽입하기보다 비용이 작아지는 경우만 큐에 넣으면 시간초과가 발생하지 않음
        for next in graphs[cur]:
            if cost + 1 < costs[next]:
                costs[next] = cost + 1
                heappush(visitQ, (cost + 1, next))

    return costs


N, M, K, X = map(int, sys.stdin.readline().split())
graphs = defaultdict(list)
answerList = []
for i in range(1, M + 1):
    start, end = map(int, sys.stdin.readline().split())
    graphs[start].append(end)

f = 0
costs = dijkstra(N, X, K, graphs)
for i in range(1, N + 1):
    if costs[i] == K:
        f = 1
        print(i)
if f == 0:
    print(-1)