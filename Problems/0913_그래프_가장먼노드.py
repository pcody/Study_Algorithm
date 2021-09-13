import sys
from heapq import *
from collections import defaultdict

def solution(n, edge):
    answer = 0

    graph = defaultdict(list)
    for s, e in edge:
        # 그래프에 노드의 가중치를 같이 추가할 수 있음
        graph[s].append(e)
        graph[e].append(s)
    
    cost = {i:sys.maxsize for i in range(1, n + 1)}
    cost[1] = 0
    q = []
    heapify(q)
    heappush(q, (cost[1], 1))

    while q:
        curCost, cur = heappop(q)

        if cost[cur] < curCost:
            continue

        for next in graph[cur]:
            if curCost + 1 < cost[next]:
                cost[next] = curCost + 1
                heappush(q, (cost[next], next))

    answerList = sorted(cost.values(), reverse = True)
    answer = answerList.count(answerList[0])
    return answer

print(solution(6,[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]), 3)