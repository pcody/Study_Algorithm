import sys

def dp(N, arr):
    global res
    answer = 0
    res[1] = 1
    if N == 1:
        return res[1]
    
    for i in range(2, N + 1):
        temp = 0
        for j  in range(1, i):
            if arr[j] < arr[i]:
                temp = max(temp, res[j])
        res[i] = temp + 1
        answer = max(answer, res[i])
    return answer

N = int(sys.stdin.readline().rstrip())
arr = [0] + list(map(int, sys.stdin.readline().split()))
res = [0] * (N + 1)

# N-1번째 가장 긴 증가하는 부분수열에
# N번째를 더했을 때 검사해서 res[N]에 넣기
print(dp(N, arr))