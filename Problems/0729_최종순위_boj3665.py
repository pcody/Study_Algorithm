import sys
from collections import defaultdict
from collections import deque

def topologySort(N, graphs, lastYear):
    # 정답리스트
    answerList = defaultdict()

    # 진입차수를 만든다
    indegrees = [0] * (N + 1)
    for x in graphs:
        for y in graphs[x]:
            indegrees[y] += 1

    # queue를 만든다
    q = deque()
    for i in range(1, N + 1):
        if indegrees[lastYear[i]] == 0:
            answerList[lastYear.index(i)] = i
        else:
            q.append(lastYear[i])

    # answerList 원소 개수가 N개면 순위가 바뀌지 않았음을 의미
    # 원소 개수가 0개면 순위를 찾을 수 없으므로 그대로 리턴
    temp =  len(answerList)
    if temp == 0 or temp == N:
        return answerList

    # 순서를 새로 정해서 ansQ에 담고
    qlen = len(q)
    ansQ = deque()
    while q:
        x = q.popleft()
        
        if indegrees[x] != 0:
            indegrees[x] -= 1
            for y in graphs[x]:
                indegrees[y] -= 1
            q.append(x)
        else:
            ansQ.append(x)
        
    # answerList의 비어있는 순서에 차례로 넣어준 뒤 리턴
    for i in range(1, N + 1):
        if answerList.get(i) == None:
            answerList[i] = ansQ.popleft()
    # print(f'graphs: {graphs}')
    # print(f'lastYear: {lastYear}')
    # print(f'indegrees: {indegrees}')
    # print(f'answerList: {answerList}')
    # print(f'q: {q}')
    return answerList


   
        
answers = []
T = int(sys.stdin.readline().rstrip())
for i in range(T):
    N = int(sys.stdin.readline().rstrip())
    lastYear = [0] + list(map(int, sys.stdin.readline().split()))
    M = int(sys.stdin.readline().rstrip())
    graphs = defaultdict(list)
    for j in range(M):
        x, y = map(int, sys.stdin.readline().split())
        graphs[x].append(y)
        graphs[y].append(x)
    answers.append(topologySort(N, graphs, lastYear))

for answer in answers:
    if answer == {}:
        print("IMPOSSIBLE")
    else:
        for key in sorted(list(answer.keys())):
            print(answer[key], end = ' ')
        print()
