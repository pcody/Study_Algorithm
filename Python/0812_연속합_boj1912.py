import sys

def dp(n, arr):
    global res

    res[1] = arr[1]
    answer = res[1]
    
    for i in range(1, n + 1):
        res[i] = max(arr[i], res[i - 1] + arr[i])
        answer = max(answer, res[i])

    return answer

n = int(sys.stdin.readline().rstrip())
arr = [0] + list(map(int, sys.stdin.readline().split()))
# res[i] : i번째 숫자를 더할 때 최대 연속 합
# res[i] = max(arr[i], res[i - 1] + arr[i])
res = [0] * (n + 1)
print(dp(n, arr))