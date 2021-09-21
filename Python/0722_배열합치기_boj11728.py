import sys

N, M = map(int, sys.stdin.readline().split())
A = list(map(int, sys.stdin.readline().split()))
B = list(map(int, sys.stdin.readline().split()))

idxA = 0
idxB = 0

answer = []
while idxA < N and idxB < M:
    if A[idxA] < B[idxB]:
        answer.append(A[idxA])
        idxA += 1
    else:
        answer.append(B[idxB])
        idxB += 1
if idxA < N:
    answer.extend(A[idxA:])
if idxB < M:
    answer.extend(B[idxB:])

for i in answer:
    print(i, end=' ')