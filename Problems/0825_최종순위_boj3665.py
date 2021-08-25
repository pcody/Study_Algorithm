import sys
from collections import defaultdict
from collections import deque

# 풀이방법
# 그래프를
# 5: 4,3,2,1
# 4: 3,2,1
# 3: 2,1
# 2: 1
# 1: None
# 에서

# infos for문을 돌면서
# 5: 4,3,2,1
# 4: 1
# 3: 2,1,4
# 2: 1,4
# 1: None
# 로 바꾸고 indegree를 계산하면
# 1 2 3 4 5
# 4 2 1 3 0
# -> 5 3 2 4 1 순

def topologySort(n, lastYear, m, infos):
    
    if m == 0:
        return lastYear

    graph = defaultdict(list)
    # graph를 만든다
    for j in range(n - 1):
        for i in range(j + 1, n):
            graph[lastYear[j]].append(lastYear[i])
    # print(graph)

    # infos에 담긴 순으로 그래프 변경
    # 후순위 팀들은 직전 순위 팀에 연결되어있음
    for x, y in infos:
        # y가 x의 후순위이면 x의 후순위에서 y를 제거하고 y의 후순위에 x를 연결
        if y in graph[x]:
            graph[x].remove(y)
            graph[y].append(x)
        # x가 y의 후순위이면 y의 후순위에서 x를 제거하고 x의 후순위에 y를 연결
        elif x in graph[y]:
            graph[y].remove(x)
            graph[x].append(y)
        
    # indegree를 만든다
    indegree = defaultdict(int)
    for teams in graph.values():
        for team in teams:
            indegree[team] += 1
    
    # q를 만들어서 1등팀(indegree 0)을 q에 넣는다
    q = deque()
    for team in lastYear:
        if indegree[team] == 0:
            q.append(team)

    # q를 돌면서 indegree를 줄이고, 0되는 것들은 다시 q에 넣음
    answer = []
    while q:
        team = q.popleft()
        answer.append(team)

        for next in graph[team]:
            indegree[next] -= 1
            if indegree[next] == 0:
                q.append(next)

    # 최종 answer가 n개가 아니면 빈리스트 리턴
    if len(answer) != n:
        answer = []
    return answer    

answerList = []
T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    n = int(sys.stdin.readline().rstrip())
    lastYear = list(map(int, sys.stdin.readline().split()))
    m = int(sys.stdin.readline().rstrip())
    infos = []
    for __ in range(m):
        infos.append(list(map(int, sys.stdin.readline().split())))
    
    answerList.append(topologySort(n, lastYear, m, infos))

for answer in answerList:
    if answer != []:
        for elem in answer:
            print(elem, end = ' ')
        print()
    else:
        print("IMPOSSIBLE")

# 답을 못 구할 때 빈리스트가 아닐 수도 있음을 처리해줘야함

# 반례
# 1
# 5
# 1 2 3 4 5
# 4        
# 2 3      
# 3 5      
# 5 2
# 2 4
# IMPOSSIBLE