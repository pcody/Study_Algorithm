import sys
from collections import defaultdict
from itertools import combinations

def makeNodeDepth(node):
    global depth
    return (node, depth[node])

n = int(sys.stdin.readline().rstrip())
depth = defaultdict(int)
graph = defaultdict(dict)
parent = defaultdict(int)
child = defaultdict(list)
leaf = []
root = 1
answerList = []

for i in range(n - 1):
    P, C, W = map(int, sys.stdin.readline().split())
    graph[P].update({C:W})
    graph[C].update({P:W})
    depth[C] += depth[P] + 1
    parent[C] = P
    child[P].append(C)

# 리프노드를 찾고
for i in range(1, n + 1):
    if child[i] == []:
        leaf.append(i)

# 공통부모를 찾고
for leaf1, leaf2 in combinations(leaf, 2):
    p1, p2 = set(), set()
    p = parent[leaf1]
    while p != 0:
        p1.add(p)
        p = parent[p]

    p = parent[leaf2]
    while p != 0:
        p2.add(p)
        p = parent[p]

    # 공통부모 교집합
    interSet = list(p1.intersection(p2))
    for i in range(len(interSet)):
        interSet[i] = [interSet[i], depth[interSet[i]]]
    interSet.sort(key = lambda x : x[1], reverse = True)
    cParent, cDepth = interSet[0]

    # 가중치 계산
    distance1 = 0
    c = leaf1
    p = parent[c]
    while p != parent[cParent]:
        distance1 += graph[c][p]
        c = p
        p = parent[c]

    distance2 = 0
    c = leaf2
    p = parent[c]
    while p != parent[cParent]:
        distance2 += graph[c][p]
        c = p
        p = parent[c]

    # print(leaf1, leaf2, cParent, distance1+distance2)
    # 가중치 합을 더한다
    answerList.append(distance1 + distance2)

print(max(answerList))