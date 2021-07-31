import sys
from collections import defaultdict
from collections import deque

def topologySort(N, buildTime, indegrees, graphs):
    q = deque()
    answer = [0] * (N + 1)
    for i in range(1, N + 1):
        if indegrees[i] == 0:
            q.append(i)

    while q:
        cur = q.popleft()
        answer[cur] += buildTime[cur]

        for next in graphs[cur]:
            indegrees[next] -= 1
            answer[next] = max(answer[next], answer[cur])
            if indegrees[next] == 0:
                q.append(next)
    return answer
            
N = int(sys.stdin.readline().rstrip())
buildTime = [0] * (N + 1)
indegrees = [0] * (N + 1)
graphs = defaultdict(list)
for i in range(1, N + 1):
    temp = list(map(int, sys.stdin.readline().split()))
    buildTime[i] = temp[0]
    indegrees[i] = len(temp[1:-1])
    for j in temp[1:-1]:
        graphs[j].append(i)

answer = topologySort(N, buildTime, indegrees, graphs)
for i in range(1, N + 1):
    print(answer[i])


# import sys
# from collections import deque

# input = sys.stdin.readline
# N = int(input())

# # 노드와 간선의 정보 저장한다고 생각하면 됨
# building = [[] for _ in range(N + 1)]
# # 각 노드의 진입차수 저장
# indegree = [0] * (N + 1)
# # 건물 짓는데 걸리는 시간
# cost = [0] * (N + 1)

# for i in range(1, N + 1):
#     data = list(map(int, input().split()))[:-1]
#     cost[i] = data[0]
#     building_data = data[1:]

#     # 간선 연결 및 진입차수 설정
#     for j in building_data:
#         building[j].append(i)
#         indegree[i] += 1


# # 위상 정렬 함수
# def topology_sort():
#     result = [0] * (N + 1)
#     q = deque()

#     for i in range(1, N + 1):
#         if indegree[i] == 0:
#             q.append(i)

#     while q:
#         now = q.popleft()
#         # 큐에서 꺼낸 노드 번호에 해당하는 건물을 짓는데 걸리는 시간 저장
#         # 선수 건물 짓는데 걸리는 시간이 포함되어 있음!
#         # 즉, '선수 건물 짓는데 걸리는 시간 + 현재 건물 짓는데 걸리는 시간'이 저장됨
#         result[now] += cost[now]
#         for b in building[now]:
#             indegree[b] -= 1
#             # b번호 건물을 짓기 전에 먼저 지어야하는 선수 건물 짓는데 걸리는 시간으로 갱신
#             result[b] = max(result[b], result[now])
#             if indegree[b] == 0:
#                 q.append(b)

#     return result


# answer = topology_sort()
# for i in range(1, N + 1):
#     print(answer[i])

## 진입차수를 매번 계산해야하고 nodeTime 리스트 또한 메모이제이션 기법으로 사용하지 못한다
## 이러한 이유로 메모리초과 문제가 발생하는 듯 하다
# import sys
# from collections import deque
# from collections import defaultdict

# def topologySort(N, node, buildTime, buildOrder):
    
#     # 큐, 노드에 도달하는데 걸리는 시간, 진입차수를 만들어준다
#     q = deque()
#     nodeTime = [0] * (N + 1)
#     indegrees = [0] * (N + 1)

#     q.append(node)
#     while q:
#         cur = q.popleft()
#         # 연결된 node들의 초기 건설시간을 자기자신으로 초기화
#         nodeTime[cur] = buildTime[cur]
        
#         # 목표점이 node지만 node를 출발점으로 생각해서 진입차수를 계산할 것임
#         # cur보다 먼저 건설되어야하는 Order에 있는 건물들을 q에 넣고 루프를 돌면서 진입차수 계산
#         for next in buildOrder[cur]:
#             indegrees[next] += 1
#             q.append(next)
    
#     # q를 node부터 시작할 수 있도록 초기화
#     q.clear()
#     q.append(node)

#     # print(f'q: {q}')
#     # print(f'buildTime: {buildTime}')
#     # print(f'buildOrder: {buildOrder}')
#     # print(f'indegrees: {indegrees}')
#     # print(f'nodeTime: {nodeTime}')
#     # print(f'graphs: {graphs}')

#     answer = nodeTime[node]
#     while q:
#         cur = q.popleft()

#         for next in buildOrder[cur]:
#             if indegrees[next] != 0:
#                 indegrees[next] -= 1
#                 nodeTime[next] = max(nodeTime[next], nodeTime[cur] + buildTime[next])
#                 answer = max(answer, nodeTime[next])
#             if indegrees[next] == 0:
#                 q.append(next)

#     return answer

# N = int(sys.stdin.readline().rstrip())
# buildTime = [0] * (N + 1)
# buildOrder = defaultdict(list)
# for i in range(1, N + 1):
#     temp = list(map(int, sys.stdin.readline().split()))
#     for j in temp[1:-1]:
#         buildOrder[i].append(j)
#     buildTime[i] = temp[0]

# for node in range(1, N + 1):
#     print(topologySort(N, node, buildTime, buildOrder))

# # 5
# # 10 -1
# # 10 -1
# # 4 2 1 -1
# # 4 3 1 -1
# # 3 3 -1