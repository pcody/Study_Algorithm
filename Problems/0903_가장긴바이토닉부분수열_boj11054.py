import sys

def dp(N, A, res1, res2):
    answer = 0

    for i in range(N):
        temp = 0
        for j in range(i):
            if A[j] < A[i]:
                temp = max(temp, res1[j])
        res1[i] = temp + 1

    for i in range(N - 1, -1, -1):
        temp = 0
        for j in range(N - 1, i - 1, -1):
            if A[j] < A[i]:
                temp = max(temp, res2[j])
        res2[j] = temp + 1

    for i in range(N):
        answer = max(answer, res1[i] + res2[i] - 1)

    return answer
    
N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().split()))
res1, res2 = [0] * N, [0] * N
print(dp(N, A, res1, res2))