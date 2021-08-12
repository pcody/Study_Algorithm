import sys

# O(n*n)
def solve(N, A):
    global res
    answer = 1
    res[0] = 1
    for j in range(1, N):
        cnt = 0
        for i in range(j):
            if A[i] < A[j]:
                # 같을 때 길이 안 셈
                cnt = max(res[i], cnt)
        res[j] = cnt + 1
        answer = max(answer, res[j])

    return answer
    
    
            
N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().split()))
# i번째 원소를 마지막으로 하는 LIS의 길이 저장
res = [0] * N
print(solve(N, A))

# 6
# 10 11 12 10 13 14

# 8
# 10 15 20 10 11 12 13 14