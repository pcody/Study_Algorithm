import sys
from collections import defaultdict
from collections import deque

def dp(N, K, W, cost, graph):
    # node를 건설하는데 걸린 시간 max시간으로 갱신
    res = [0] * (N + 1)

    q = deque()
    indegree = [0] * (N + 1)
    for i in range(1, N + 1):
        for j in graph[i]:
            indegree[j] += 1
    
    for i in range(1, N + 1):
        if indegree[i] == 0:
            q.append(i)
            res[i] += cost[i]

    # 메모리초과가 나는 경우
    # 1. 결과(res)가 일단 개수 초과이거나
    # 2. q에 불필요하게 많이 들어가고 있다거나

    # 메모리 초과가 많이 났는데, indegree가 0일때만 q에 넣는 조건을 넣어주니 해결됨
    while q:
        cur = q.popleft()
        
        for next in graph[cur]:
            res[next] = max(res[next], res[cur] + cost[next])
            indegree[next] -= 1
            if indegree[next] == 0:
                q.append(next)

    return res[W]

answerList = []
T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N, K = map(int, sys.stdin.readline().split())
    cost = [0] + list(map(int, sys.stdin.readline().split()))
    graph = defaultdict(list)
    for __ in range(K):
        s, e = map(int, sys.stdin.readline().split())
        graph[s].append(e)
    W = int(sys.stdin.readline().rstrip())

    answerList.append(dp(N, K, W, cost, graph))

for answer in answerList:
    print(answer)
