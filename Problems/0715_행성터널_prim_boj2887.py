import heapq
import collections
import sys

def Find(x, parent):
    if x == parent[x]:
        return x
    else:
        parent[x] = Find(parent[x], parent)
        return parent[x]

def Union(x, y, parent, weight):
    global answer
    inx = x
    x = Find(x, parent)
    y = Find(y, parent)

    if x == y:
        return

    parent[y] = x
    answer += weight

N = int(sys.stdin.readline().rstrip())
coordinate = []
for i in range(N):
    coordinate.append([i] + list(map(int, sys.stdin.readline().split())))

coordx = sorted(coordinate, key = lambda x : x[1])
coordy = sorted(coordinate, key = lambda x : x[2])
coordz = sorted(coordinate, key = lambda x : x[3])
print(coordinate)
print(coordx)
print(coordy)
print(coordz)

edges = []
for i in range(1, N):
    ix1, x1, _, _ = coordx[i-1]
    ix2, x2, _, _ = coordx[i]
    iy1, _, y1, _ = coordy[i-1]
    iy2, _, y2, _ = coordy[i]
    iz1, _, _, z1 = coordz[i-1]
    iz2, _, _, z2 = coordz[i]

    edges.append([abs(x1-x2), ix1, ix2])
    edges.append([abs(y1-y2), iy1, iy2])
    edges.append([abs(z1-z2), iz1, iz2])

edges.sort()
print(edges)

answer = 0
parent = dict()
for edge in edges:
    weight, x, y = edge
    if parent.get(x) == None:
        parent[x] = x
    if parent.get(y) == None:
        parent[y] = y

    Union(x, y, parent, weight)

print(answer)
    


