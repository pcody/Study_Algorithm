import sys
from collections import defaultdict
from collections import deque

N = int(sys.stdin.readline().rstrip())
graph = defaultdict(list)
parent = defaultdict(int)
root = 1
for i in range(N-1):
    n1, n2 = map(int, sys.stdin.readline().split())
    graph[n1].append(n2)
    graph[n2].append(n1)

q = deque([root])
while q:
    curNode = q.popleft()

    for nextNode in graph[curNode]:
        if parent[nextNode] == 0:
            parent[nextNode] = curNode
            q.append(nextNode)
            
for i in range(2, N + 1):
    print(parent[i])