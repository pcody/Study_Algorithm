import sys
from heapq import *

def topologySort(graphs, N):
    # 순서대로 담을 정답리스트
    answerList = []

    # indegrees 만들기
    indegrees = [0] * (N + 1)
    for x in graphs.keys():
        for y in graphs[x]:
            indegrees[y] += 1

    # 순서 (최소)힙 만들기
    orderList = []
    heapify(orderList)
    for i in range(1, N + 1):
        if indegrees[i] == 0:
            heappush(orderList, i)

    while orderList:
        x = heappop(orderList)
        answerList.append(x)

        for y in graphs[x]:
            indegrees[y] -= 1
            if indegrees[y] == 0:
                heappush(orderList, y)
    
    return answerList


# N, M 입력받기
N, M = map(int, sys.stdin.readline().split())

# graphs 만들기
graphs = dict()
for i in range(M):
    x, y = map(int, sys.stdin.readline().split())
    if graphs.get(x):
        graphs[x].append(y)
    else:
        graphs[x] = [y]
    if graphs.get(y):
        pass
    else:
        graphs[y] = []
for i in range(1, N + 1):
    if graphs.get(i) == None:
        graphs[i] = []
        
answer = topologySort(graphs, N)
for elem in answer:
    print(elem, end = ' ')





