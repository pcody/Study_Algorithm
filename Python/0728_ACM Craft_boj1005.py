import sys
from collections import deque

def topologySort(N, graph, constructionTime, W):
    q = deque()
    indegrees = [0] * (N + 1)
    
    # 진입차수를 계산한다
    for i in range(1, N + 1):
        if graph.get(i) != None:
            for building in graph[i]:
                indegrees[building] += 1
    # print(f'2.indegrees: {indegrees}')

    # 노드별 시간 계산할 리스트
    nodeTime = [0] * (N + 1)
    # 진입차수가 0인 노드를 큐에 넣는다
    for i in range(1, N + 1):
        if indegrees[i] == 0:
            q.append(i)
            # 노드 자신의 건설시간을 초기값으로 넣는다.
            nodeTime[i] = constructionTime[i]

    # 큐에서 하나씩 뽑으면서 루프를 돈다
    while q:
        X = q.popleft()
        
        # 마지막 노드면 함수 종료
        if X == W:
            # print(f'3.step: {step}')
            return nodeTime[X]
        
        # 중간 노드일 때
        else:
            # 연결된 노드가 있는 것들만 계산
            if graph[X]:
                # 다음 진입차수가 0인 것들을 큐에 넣는다
                for Y in graph[X]:
                    if indegrees[Y] > 0: 
                        # 진입차수를 1 빼준다
                        indegrees[Y] -= 1
                        # 신규node의(Y) nodeTime 기존 값과 신규 루트로 들어오는 값 중 큰 값으로 교체
                        nodeTime[Y] = max(nodeTime[Y], nodeTime[X] + constructionTime[Y])
                    if indegrees[Y] == 0:
                        q.append(Y)
            

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

# 1
# 8 9
# 2 1 3 2 3 2 1 1
# 1 2
# 3 2
# 1 4
# 2 5
# 2 6
# 4 6
# 6 5
# 5 7
# 8 7
# 7