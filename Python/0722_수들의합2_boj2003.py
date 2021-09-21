import sys

N, M = map(int, sys.stdin.readline().split())
A = list(map(int, sys.stdin.readline().split()))

preSum1, preSum2 = 0, A[0]
idx1, idx2 = -1, 0
cnt = 0

# preSum1,
# preSum2 -> 지속 누적
# if 부분합(preSum2-preSum1) > M
#   -> preSum1을 증가시킨다.
# else:
#   -> preSum2을 증가시킨다.
#   -> preSum2 - preSum1 == M이면 cnt += 1
while idx1 < N:
    if preSum2 - preSum1 > M:
        idx1 += 1
        preSum1 += A[idx1]
    else:
        if preSum2 - preSum1 == M:
            cnt += 1
        if idx2 < N-1:
            idx2 += 1
            preSum2 += A[idx2]
        elif idx2 == N-1:
            idx1 += 1
            if idx1 < N:
                preSum1 += A[idx1]
print(cnt)

