# 최단 경로 알고리즘
# 노드와 간선들 중 가장 짧은 경로를 찾는 알고리즘

# 특정 노드에서 시작해 특정 노드에 도착하는 가장 짧은 경로
# 특정 노드에서 시작해 모든 노드까지 도착할 수 있는 가장 짧은 경로
#   이동 경로(가중치)에 양수만 사용된다면 Dijkstra 알고리즘
#   이동 경로(가중치)에 음수가 포함된다면 Bellman-ford 알고리즘
# 모든 노드에서 도착할 수 있는 가장 짧은 경로

# Dijkstra 알고리즘은 greedy 알고리즘으로
# 현재 상황에서 최선의 선택을 진행하며 단방향, 양방향(사이클) 모두 사용할 수 있다
# 너비 우선 탐색(BFS)와 유사하며
# 시작 노드에서 모든 노드간 거리 값을 저장하는 배열을 생성한 다음
# 인접 노드들의 거리를 구해 가장 짧은 경로를 해당 배열에 업데이트 해나가는 방식

# 시간복잡도
# 기준 노드에서 인접한 노드를 이동하는 모든 간선
# > 모든 간선을 이동하며 검사하므로 간선의 개수만큼 시간 소요 O(E)
# 우선 순위 큐에 데이터 삽입/삭제
# > 데이터 삽입/삭제가 간선의 개수만큼 발생 O(E)
# > 삽입/삭제가 발생했을 때 힙 유지 비용 O(logE)
# > O(ElogE)
# >>> O(E) + O(ElogE) = O(ElogE)

import sys
from heapq import *

def dijkstra(start, graph):
    # 초기 거리 값은 무한대로 설정
    distances = {node: sys.maxsize for node in graph}
    
    # 시작 노드의 거리는 0으로 설정
    distances[start] = 0

    # 우선순위큐를 설정
    # 거리 순 오름차순 정렬을 위해 (거리, 노드)순으로 큐에 데이터 삽입
    q = []
    heappush(q, (distances[start], start))

    # q가 빌 때 까지 루프 실행
    while q:
        curDistance, node = heappop(q)

        if distances[node] < curDistance:
            continue

        # 현재 노드와 인접한 노드를 순회
        for adjNode, distance in graph[node].items():
            # 거리합(현재 노드 도달 거리 + 인접 노드 도달 거리)
            accDistance = curDistance + distance
            
            # 거리합이 인접 노드의 기존 도달 거리보다 작다면 교체
            # 다음 인접 거리를 계산하기 위해 큐에 삽입(같은 노드가 있어도 다 저장된다)
            if accDistance < distances[adjNode]:
                distances[adjNode] = accDistance
                heappush(q, (accDistance, adjNode))
    
    return distances

graph = {
    'A': {'B': 10, 'C': 3},
    'B': {'C': 1, 'D': 2},
    'C': {'B': 4, 'D': 8, 'E': 2},
    'D': {'E': 7},
    'E': {'D': 9}
}
print(dijkstra('A', graph))
