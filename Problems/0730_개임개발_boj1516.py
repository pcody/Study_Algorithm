import sys
from collections import deque
from collections import defaultdict

def topologySort(N, node, buildTime, buildOrder):
    
    # 큐, 노드에 도달하는데 걸리는 시간, 진입차수를 만들어준다
    q = deque()
    nodeTime = [0] * (N + 1)
    indegrees = [0] * (N + 1)

    q.append(node)
    while q:
        cur = q.popleft()
        # 연결된 node들의 초기 건설시간을 자기자신으로 초기화
        nodeTime[cur] = buildTime[cur]
        
        # 목표점이 node지만 node를 출발점으로 생각해서 진입차수를 계산할 것임
        # cur보다 먼저 건설되어야하는 Order에 있는 건물들을 q에 넣고 루프를 돌면서 진입차수 계산
        for next in buildOrder[cur]:
            indegrees[next] += 1
            q.append(next)
    
    # q를 node부터 시작할 수 있도록 초기화
    q.clear()
    q.append(node)

    # print(f'q: {q}')
    # print(f'buildTime: {buildTime}')
    # print(f'buildOrder: {buildOrder}')
    # print(f'indegrees: {indegrees}')
    # print(f'nodeTime: {nodeTime}')
    # print(f'graphs: {graphs}')

    answer = nodeTime[node]
    while q:
        cur = q.popleft()

        for next in buildOrder[cur]:
            if indegrees[next] != 0:
                indegrees[next] -= 1
                nodeTime[next] = max(nodeTime[next], nodeTime[cur] + buildTime[next])
                answer = max(answer, nodeTime[next])
            if indegrees[next] == 0:
                q.append(next)

    return answer

N = int(sys.stdin.readline().rstrip())
buildTime = [0] * (N + 1)
buildOrder = defaultdict(list)
for i in range(1, N + 1):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in temp[1:-1]:
        buildOrder[i].append(j)
    buildTime[i] = temp[0]

for node in range(1, N + 1):
    print(topologySort(N, node, buildTime, buildOrder))

# 5
# 10 -1
# 10 -1
# 4 2 1 -1
# 4 3 1 -1
# 3 3 -1