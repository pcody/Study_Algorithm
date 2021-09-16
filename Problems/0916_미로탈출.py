from collections import defaultdict
from heapq import *
import sys

def solution(n, start, end, roads, traps):
    answer = 0

    # 그래프 양 방향 두개 생성
    graph = defaultdict(dict)
    graphR = defaultdict(dict)
    for A, B, W in roads:
        graph[A][B] = min(graph[A][B] if graph[A].get(B) else sys.maxsize, W)
        graphR[B][A] = min(graph[B][A] if graph[B].get(A) else sys.maxsize, W)

    # 트랩노드 방문 횟수, 노드 도달 가중치 해시
    # 일반노드는 방문 횟수 0
    visited = dict()
    cost = dict()
    for i in range(1, n + 1):
        visited[i] = 0
        cost[i] = sys.maxsize

    # 다익스트라를 위한 힙큐와 시작노드 가중치 0
    cost[start] = 0
    q = []
    heapify(q)
    heappush(q, [cost[start], start])

    while q:
        curCost, curNode = heappop(q)

        # 저장된 가중치가 더 낮은 경우에는 큐를 돌지 않음
        if cost[curNode] < curCost:
            continue

        if curNode == end:
            break
        
        # 일반노드
        # 다음 노드 방문횟수 % 2 가 1이면 방문하지 않음
        if curNode not in traps:
            for nextNode, w in graph[curNode].items():
                if visited[nextNode] % 2 == 0:
                    if cost[nextNode] > curCost + w:
                        if nextNode in traps:
                            visited[nextNode] += 1
                        cost[nextNode] = curCost + w
                        heappush(q, [cost[nextNode], nextNode])
        # 트랩노드
        # 현재 노드 방문횟수 % 2 가 0
        # 정방향
        # 다음 노드가 트랩이고 방문횟수 % 2 가 1이면 방문하지 않음
        # 역방향
        # 다음 노드가 트랩이고 방문횟수 % 2 가 1이면 방문

        # 현재 노드 방문횟수 % 2 가 1
        # 역방향
        # 다음 노드가 트랩이고 방문횟수 % 2 가 1이면 방문하지 않음
        # 정방향
        # 다음 노드가 트랩이고 방문횟수 % 2 가 1이면 방문
        else:
            if visited[curNode] % 2 == 0:
                for nextNode, w in graph[curNode].items():
                    if visited[nextNode] % 2 == 0:
                        if nextNode in traps:
                            visited[nextNode] += 1
                            cost[nextNode] = curCost + w
                            heappush(q, [cost[nextNode], nextNode])
                        else:
                            if cost[nextNode] > curCost + w:
                                cost[nextNode] = curCost + w
                                heappush(q, [cost[nextNode], nextNode])
                for nextNode, w in graphR[curNode].items():
                    # 역방향 에서는 나머지 1인 트랩만 방문할 것
                    # 나머지 1에 걸리는 것들은 무조건 트랩
                    if visited[nextNode] % 2 == 1:
                        visited[nextNode] += 1
                        cost[nextNode] = curCost + w
                        heappush(q, [cost[nextNode], nextNode])
            else:
                for nextNode, w in graph[curNode].items():
                    # 정방향 에서는 나머지 1인 트랩만 방문할 것
                    # 나머지 1에 걸리는 것들은 무조건 트랩
                    if visited[nextNode] % 2 == 1:
                        visited[nextNode] += 1
                        cost[nextNode] = curCost + w
                        heappush(q, [cost[nextNode], nextNode])
                for nextNode, w in graphR[curNode].items():
                    if visited[nextNode] % 2 == 0:
                        if nextNode in traps:
                            visited[nextNode] += 1
                            cost[nextNode] = curCost + w
                            heappush(q, [cost[nextNode], nextNode])
                        else:
                            if cost[nextNode] > curCost + w:
                                cost[nextNode] = curCost + w
                                heappush(q, [cost[nextNode], nextNode])
    
    # print(cost)
    answer = cost[end]
    return answer


print(solution(3,1,3,[[1,2,2],[3,2,3]],[2]),5)
print(solution(4,1,4,[[1,2,1],[3,2,1],[2,4,1]],[2,3]),4)
