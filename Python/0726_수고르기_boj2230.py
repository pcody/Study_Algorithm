import sys

N, M = map(int, sys.stdin.readline().split())
A = []
for i in range(N):
    A.append(int(sys.stdin.readline().rstrip()))

A.sort()
answer = 2000000000
front = 0
rear = 1
while front < N-1:
    temp = abs(A[front] - A[rear])
    if temp >= M:
        answer = min(answer, temp)
        front += 1
    else:
        if rear < N - 1:
            rear += 1
        else:
            front += 1

print(answer)