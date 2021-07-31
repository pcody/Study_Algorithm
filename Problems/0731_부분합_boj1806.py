import sys

N, S = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

left = -1
right = left+1
lSum, rSum = 0, arr[0]

answer = N + 1
while left < N - 1:
    subSum = rSum - lSum
    if subSum < S:
        if right < N - 1:
            right += 1
            rSum += arr[right]
        else:
            break
    else:
        answer = min(answer, right - left)
        left += 1
        lSum += arr[left]
if answer > N:
    print(0)
else:
    print(answer)