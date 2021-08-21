import sys
from collections import defaultdict
from collections import deque

def dfs(N, M, V):
    global graph, visited, answers
    visited[V] = 1
    answers.append(V)
    graph[V].sort()

    for next in graph[V]:
        if not visited[next]:
            dfs(N, M, next)

def bfs(N, M, V):
    global graph, visited, answers
    q = deque([V])
    visited[V] = 1

    while q:
        s = q.popleft()
        answers.append(s)

        for e in graph[s]:
            if not visited[e]:
                visited[e] = 1
                q.append(e)

N, M, V = map(int, sys.stdin.readline().split())
graph = defaultdict(list)
for _ in range(M):
    s, e = map(int, sys.stdin.readline().split())
    graph[s].append(e)
    graph[e].append(s)

visited = [0] * (N + 1)
answers = []
dfs(N, M, V)
for answer in answers:
    print(answer, end = ' ')

print()
visited = [0] * (N + 1)
answers = []
bfs(N, M, V)
for answer in answers:
    print(answer, end = ' ')
