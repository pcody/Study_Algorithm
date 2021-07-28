import sys
from collections import deque

def topologySort(N, graph, constructionTime, W):
    midAns = []
    q = deque()
    indegrees = [0] * (N + 1)
    
    # 진입차수를 계산한다
    for i in range(1, N + 1):
        if graph.get(i) != None:
            for building in graph[i]:
                indegrees[building] += 1
    # print(f'2.indegrees: {indegrees}')

    # 진입차수가 0인 노드 중 W와 연결된 노드를 찾아서 큐에 넣는다
    startList = []
    for i in range(1, N + 1):
        if indegrees[i] == 0:
            tempq = deque()
            tempq.append(i)

            while tempq:
                temp = tempq.popleft()
                if temp == W:
                    startList.append(i)
                    break
                for j in graph[temp]:
                    tempq.append(j)
    # print(f'3.startList: {startList}')

    
    # 스텝별 시간 계산할 딕셔너리
    step = dict()        
    stepIdx = 0
    for i in startList:
        q.append([stepIdx,i])  
        # 첫 번째 스텝에는 시작 노드의 건설시간을 넣는다
        if step.get(stepIdx) == None:
            step[stepIdx] = [constructionTime[i]]
        else:
            step[stepIdx].append(constructionTime[i])

    # 큐에서 하나씩 뽑으면서 루프를 돈다
    while q:
        stepIdx, X = q.popleft()
        
        # 마지막 노드면 건설시간을 더하고 루프 탈출
        if X == W:
            # print(f'3.step: {step}')
            temp = 0
            for i in step:
                temp += max(step[i])
            midAns.append(temp)
            f = 1
            break
        
        # 중간 노드일 때
        else:
            # 뒤가 더이상 없으면 pass
            if graph[X] == []:
                pass
            else:
                # 다음 진입차수가 0인 것들을 큐에 넣는다
                for Y in graph[X]:
                    indegrees[Y] -= 1
                    if indegrees[Y] == 0:
                        q.append([stepIdx + 1, Y])
                        if step.get(stepIdx + 1) == None:
                            step[stepIdx + 1] = [constructionTime[Y]]
                        else:
                            step[stepIdx + 1].append(constructionTime[Y])
    return min(midAns)
            

answer = []
T = int(sys.stdin.readline().rstrip())
for i in range(T):
    N, K = map(int, sys.stdin.readline().split())
    constructionTime = list(map(int, sys.stdin.readline().split()))
    constructionTime.insert(0, 0)
    graph = dict()
    for j in range(K):
        X, Y = map(int, sys.stdin.readline().split())
        if graph.get(X) == None:
            graph[X] = [Y]
        else:
            graph[X].append(Y)
        if graph.get(Y) == None:
            graph[Y] = []
    W = int(sys.stdin.readline().rstrip())
    if graph.get(W) == None:
        graph[W] = []
    # print(f'1.graph: {graph}')
    answer.append(topologySort(N, graph, constructionTime, W))

for elem in answer:
    print(elem)

# 1
# 5 4
# 1 1 1 1 1
# 1 2
# 3 2
# 1 4
# 2 5
# 5

# 1
# 5 3
# 1 1 1 1 1
# 1 2
# 1 4
# 2 5
# 3

# 1
# 4 3
# 1 1 1 1
# 1 2
# 3 2
# 1 4
# 4


### 진입차수가 0인 노드가 합쳐지지 않는 경우는 됨
### 진입차수가 0인 노드가 합쳐지는 경우 계산을 못함
# def topologySort(N, graph, constructionTime, W):
#     midAns = []
#     q = deque()
#     indegrees = [0] * (N + 1)
    
#     # 진입차수를 계산한다
#     for i in range(1, N + 1):
#         if graph.get(i) != None:
#             for building in graph[i]:
#                 indegrees[building] += 1
#     print(f'2.indegrees: {indegrees}')

#     # 시작할 노드를 찾아서 큐에 넣는다
#     f = 0
#     for i in range(1, N + 1):
#         if f:
#             break
#         # 스텝별 시간 계산할 딕셔너리
#         step = dict()        
#         stepIdx = 0
#         indegrees2 = indegrees.copy()
#         if indegrees2[i] == 0:
#             q.append([stepIdx,i])  
#             # 첫 번째 스텝에는 시작 노드의 건설시간을 넣는다
#             if step.get(stepIdx) == None:
#                 step[stepIdx] = [constructionTime[i]]
#             else:
#                 step[stepIdx].append(constructionTime[i])

#             # 큐에서 하나씩 뽑으면서 루프를 돈다
#             while q:
#                 stepIdx, X = q.popleft()
                
#                 # 마지막 노드면 건설시간을 더하고 루프 탈출
#                 if X == W:
#                     # print(f'3.step: {step}')
#                     temp = 0
#                     for i in step:
#                         temp += max(step[i])
#                     midAns.append(temp)
#                     f = 1
#                     break
                
#                 # 중간 노드일 때
#                 else:
#                     # 뒤가 더이상 없으면 pass
#                     if graph[X] == []:
#                         pass
#                     else:
#                         # 다음 진입차수가 0인 것들을 큐에 넣는다
#                         for Y in graph[X]:
#                             indegrees2[Y] -= 1
#                             if indegrees2[Y] == 0:
#                                 q.append([stepIdx + 1, Y])

#                                 if step.get(stepIdx + 1) == None:
#                                     step[stepIdx + 1] = [constructionTime[Y]]
#                                 else:
#                                     step[stepIdx + 1].append(constructionTime[Y])
#     return min(midAns)