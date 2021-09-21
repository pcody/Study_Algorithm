import sys

def Find(x, parent):
    if x == parent[x]:
        return x
    else:
        parent[x] = Find(parent[x], parent)
        return parent[x]

def Union(x, y, parent, weight):
    global summation, lastWeight
    x = Find(x, parent)
    y = Find(y, parent)

    if x == y:
        return

    parent[x] = y
    summation += weight
    lastWeight = weight

N, M = map(int, sys.stdin.readline().split())
graph = []
for i in range(M):
    graph.append(list(map(int,sys.stdin.readline().split())))

graph.sort(key = lambda x : x[2])
parent = dict()
summation = 0
lastWeight = 0
for elem in graph:
    A, B, C = elem
    if parent.get(A) == None:
        parent[A] = A
    if parent.get(B) == None:
        parent[B] = B
    
    Union(B, A, parent, C)

print(summation-lastWeight)
