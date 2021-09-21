import sys

def dp(N, A):
    answer = 0
    res = [sys.maxsize] * N

    for i in range(N):
        if i == 0:
            res[i] = A[i]
        else:
            idx = binarySearch(A[i], res)
            res[idx] = A[i]
    
    for i in range(N):
        if res[i] != sys.maxsize:
            answer += 1
        else:
            break

    return answer

def binarySearch(t, res):
    left = 0
    right = len(res)
    while left <= right:
        mid = (left + right) // 2

        # under bound
        # 작은 것들 중에서 가장 큰 값
        if res[mid] < t:
            left = mid + 1
        else:
            right = mid - 1
    
    answer = left
    return answer
    
# print(binarySearch(7, 10, [10,10,20,30,40,40,50]))
# print(binarySearch(7, 20, [10,10,20,30,40,40,50]))
# print(binarySearch(7, 30, [10,10,20,30,40,40,50]))
# print(binarySearch(7, 40, [10,10,20,30,40,40,50]))

# print(dp(7, [10,10,20,30,40,40,50]))

N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().split()))
print(dp(N, A))

