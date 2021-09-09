import sys
from collections import defaultdict
from heapq import *

def solution(n, edge):
    answer = 0

    graph = defaultdict(list)
    for x, y in edge:
        graph[x].append((y, 1))
        graph[y].append((x, 1))

    distances = {node: sys.maxsize for node in range(1, n + 1)}
    distances[1] = 0

    q = []
    heappush(q, (distances[1], 1))

    while q:
        curDistance, curNode = heappop(q)

        if distances[curNode] < curDistance:
            continue

        for adjNode, distance in graph[curNode]:
            accDistance = curDistance + distance

            if accDistance < distances[adjNode]:
                distances[adjNode] = accDistance
                heappush(q, (accDistance, adjNode))

    answerList = list(distances.values())
    answerList.sort(reverse = True)
    answer = answerList.count(answerList[0])

    return answer

print(solution(6, [[3,6],[4,3],[3,2],[1,3],[1,2],[2,4],[5,2]]), 3)
