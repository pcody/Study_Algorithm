import sys

def dp(N, A):
    global res
    answer = 0

    for j in range(1, N + 1):
        temp = 0
        for i in range(1, j):
            if A[i] > A[j]:
                temp = max(temp, res[i])
        res[j] = temp + 1
        answer = max(answer, res[j])
    
    return answer

N = int(sys.stdin.readline().rstrip())
A = [0] + list(map(int, sys.stdin.readline().split()))
res = [0] * (N + 1)
print(dp(N, A))