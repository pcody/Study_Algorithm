import sys
from collections import defaultdict
sys.setrecursionlimit(10 ** 8)

def dfs(n, graph, visited, node, distance):
    global start, mDistance
    if child[node] == []:
        if distance > mDistance:
            start = node
            mDistance = distance
        return
    
    for nextNode in graph[node]:
        if visited[nextNode] == 0:
            visited[nextNode] = 1
            dfs(n, graph, visited, nextNode, distance + graph[node][nextNode])
            visited[nextNode] = 0

n = int(sys.stdin.readline().rstrip())
# 딕셔너리: 10000*(4+4)*3(부모1,자식2)byte = 240000byte = 0.24mbyte
# 리스트: 10001*4byte = 40001byte = 40kbyte
graph = defaultdict(dict)
visited = [0] * (n + 1)
child = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    n1, n2, w = map(int, sys.stdin.readline().split())
    graph[n1].update({n2: w})
    graph[n2].update({n1: w})
    child[n1].append(n2)

start, mDistance = 0, 0
visited[1] = 1
dfs(n, graph, visited, 1, 0)
visited[1] = 0

# visited = [0] * (n + 1)
visited[start] = 1
for nextNode in graph[start]:
    visited[nextNode] = 1
    dfs(n, graph, visited, nextNode, graph[start][nextNode])
    visited[nextNode] = 0
visited[1] = 0
print(mDistance)