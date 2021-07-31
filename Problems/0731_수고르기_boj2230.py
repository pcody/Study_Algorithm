import sys

N, M = map(int, sys.stdin.readline().split())
arr = []
for i in range(N):
    arr.append(int(sys.stdin.readline().rstrip()))

arr.sort()
left = 0
right = left + 1

answer = sys.maxsize
while left < N - 1:
    diff = arr[right] - arr[left]
    if diff >= M:
        answer = min(answer, diff)
        left += 1
        right = left + 1
    else:
        if right < N-1:
            right += 1
        else:
            left += 1

print(answer)