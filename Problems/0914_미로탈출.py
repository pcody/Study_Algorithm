from collections import defaultdict
from collections import deque
from heapq import *
import sys

def solution(n, start, end, roads, traps):
    answer = 0
    
    graph = defaultdict(list)
    graphR = defaultdict(list)

    # 정방향, 역방향 모두 넣는다
    for a, b, w in roads:
        graph[a].append([b, w])
        graphR[b].append([a, w])

    cost = {node: 0 for node in range(1, n + 1)}
    cost[start] = 0
    r = {node: 0 for node in range(1, n + 1)}
    q = deque()
    q.append([cost[start], start])

    while q:
        # v: 현재 노드에 도착했을때 비용, r%2: 0정방향, 1역방향
        v, cur = q.popleft()
        if cur in traps:
            r[cur] += 1

        if cost[cur] < v:
            continue

        if cur == end:
            break

        # 일반노드 -> 방문횟수가 짝수인 노드 전부
        if cur not in traps:
            for next, w in graph[cur]:
                if r[next] % 2 == 0:
                    if cost[next] < v + w:
                        cost[next] = v + w
                        q.append([v + w, next])
        else:
        # trap에 있는 노드일 경우
        # trap노드 -> trap노드
        # trap노드 -> 일반노드

        # trap노드의 방문이 짝수 일 때
        # trap노드 -> 정방향 그래프에서 찾음
        # trap노드 -> 역방향 그래프에서 방문횟수가 짝수인 trap노드에 갈 수 있음
            if r[cur] % 2 == 0:
                for next, w in graph[cur]:
                    if r[next] % 2 == 0:
                        if cost[next] < v + w:
                            cost[next] = v + w
                            q.append([v + w, next])
                for next, w in graphR[cur]:
                    if r[next] % 2 == 0:
                        if cost[next] < v + w:
                            cost[next] = v + w
                            q.append([v + w, next])

        # trap노드의 방문이 홀수 일 때
        # trap노드 -> 역방향 그래프에서 찾음
        # trap노드 -> 정방향 그래프에서 방문횟수가 홀수인 trap노드에 갈 수 있음
            else:
                for next, w in graphR[cur]:
                    if r[next] % 2 == 0:
                        if cost[next] < v + w:
                            cost[next] = v + w
                            q.append([v + w, next])
                for next, w in graph[cur]:
                    if r[next] % 2 == 1:
                        if cost[next] < v + w:
                            cost[next] = v + w
                            q.append([v + w, next])

    # print(cost)
    answer = cost[end]
    return answer

print(solution(3,1,3,[[1, 2, 2], [3, 2, 3]],[2]), 5)
print(solution(4,1,4,[[1, 2, 1], [3, 2, 1], [2, 4, 1]],[2, 3]), 4)
print(solution(5,1,5,[[1, 2, 1], [2, 3, 3], [3, 1, 2], [3, 4, 2], [4, 2, 3], [4, 5, 1]],[2,3,4]), 9)