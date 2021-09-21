N, S = map(int, input().split())
arr = list(map(int, input().split()))

f = -1
r = 0
fSum = 0
rSum = arr[0]
answer = N
while f < N - 1:
    if rSum - fSum < S:
        if r < N - 1:
            r += 1
            rSum += arr[r]
        else:
            f += 1
            fSum += arr[f]
    else: # subSum >= S
        answer = min(answer, r - f)
        f += 1
        fSum += arr[f]   

if answer == N:
    answer = 0
print(answer)