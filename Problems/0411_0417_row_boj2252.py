import sys
from collections import defaultdict
from collections import deque

def topologySort(N, M, graphs):
    indegrees = [0] * (N + 1)
    q= deque()
    answerList = []

    # 진입차수를 만든다
    for i in range(1, N + 1):
        for e in graphs[i]:
            indegrees[e] += 1
    
    # 진입차수가 0인 것들을 q, 정답리스트에 담는다
    for i in range(1, N + 1):
        if indegrees[i] == 0:
            q.append(i)
            answerList.append(i)

    while q:
        # cur를 q에서 pop하고
        cur = q.popleft()

        # cur에 연결된 모든 것들의 진입차수를 빼줌
        for next in graphs[cur]:
            indegrees[next] -= 1
            # 빼면서 진입차수가 0이 되면 큐에 넣음
            if indegrees[next] == 0:
                q.append(next)
                answerList.append(next)

    return answerList    

N, M = map(int, sys.stdin.readline().split())
graphs = defaultdict(list)
for _ in range(M):
    s, e = map(int, sys.stdin.readline().split())
    graphs[s].append(e)

answerList = topologySort(N, M, graphs)
for answer in answerList:
    print(answer, end = ' ')