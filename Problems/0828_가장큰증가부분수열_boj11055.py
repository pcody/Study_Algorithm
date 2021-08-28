import sys

def dp(N, A):
    global res
    
    answer = 0
    for j in range(1, N + 1):
        temp = 0
        for i in range(1, j):
            # A[j]보다 작은 값에서 res[i]의 최대값을 구한다
            if A[i] < A[j]:
                temp = max(res[i], temp)
        # 1~j-1에서 res의 최대값 + j번째 A값이 res[j]에 저장됨
        res[j] = temp + A[j]
        # answer는 그 res[j] 중 최대값을 구해야함
        answer = max(res[j], answer)
    
    return answer
    
N = int(sys.stdin.readline().rstrip())
A = [0] + list(map(int, sys.stdin.readline().rsplit()))
res = [0] * (N + 1)
print(dp(N, A))