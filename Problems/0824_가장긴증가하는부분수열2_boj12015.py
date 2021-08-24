import sys

def dp(N, A):
    global res, answer
    
    # res에 max값을 담아두고
    # A[i]보다 작은 값 중 최대 idx를 찾아서 넣는다
    res[0] = A[0]
    if N == 1:
        return 1
        
    for i in range(1, N):
        print(res)
        idx = binarySearch(res, A[i])
        res[idx] = A[i]
        print(res)
    
    answer = 0
    for i in range(N):
        if res[i] == sys.maxsize:
            break
        answer += 1

    return answer

def binarySearch(arr, T):
    retIdx = 0

    left = 0
    right = len(arr) - 1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] < T:
            left = mid + 1
        else:
            right = mid - 1
    retIdx = max(0, left)
    return retIdx

N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().split()))
res = [sys.maxsize] * N
print(dp(N, A))

# print(binarySearch([10,20,40,50,11,12,13,14], 18))
# a = [4,7,10,3,1,8,9,10,7,2,5,7]
# a.sort()
# print(binarySearch(a, 8))
# 8
# 10 20 40 50 11 12 13 14
# 12
# 4 7 10 3 1 8 9 10 7 2 5 7