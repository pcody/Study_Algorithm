def underBound(arr, t):
    answer = 0

    left = 0
    right = len(arr) - 1
    while left <= right:
        mid = (left + right) // 2

        # 타겟보다 작은 값 들 중 최대 값
        if arr[mid] < t:
            left = mid + 1
        else:
            # mid 값을 구했는데 타겟보다 크거나 같음
            # 여기서 right은 계속해서 타겟보다 크거나 같음
            right = mid - 1

    # right의 최소값은 타겟과 동일한 값임
    # 여기서 1 뺀 mid - 1이 타겟보다 작은 값들 중 최대 값임
    answer = right
    return answer

def upperBound(arr, t):
    answer = 0

    left = 0
    right = len(arr) - 1
    while left <= right:
        mid = (left + right) // 2

        # 타겟보다 큰 값들 중 최소값
        if t < arr[mid]:
            right = mid - 1
        else:
            # mid 값을 구했는데 타겟보다 작거나 같음
            # 여기서 left는 최대 타겟과 동일
            left = mid + 1
    # 여기서 1 더한 mid + 1이 타겟보다 큰 값들 중 최소 값
    answer = left
    return answer
    
def binarySearch(arr, t):
    return underBound(arr, t), upperBound(arr, t)

# under bound
# 타겟보다 작은 값 들 중 최대 값

# upper bound
# 타겟보다 큰 값들 중 최소값

print(binarySearch([10,10,20,30,40,40,50], 10))
print(binarySearch([10,10,20,30,40,40,50], 15))
print(binarySearch([10,10,20,30,40,40,50], 20))
print(binarySearch([10,10,20,30,40,40,50], 30))
print(binarySearch([10,10,20,30,40,40,50], 40))
print(binarySearch([10,10,20,30,40,40,50], 45))
print(binarySearch([10,10,20,30,40,40,50], 50))
print(binarySearch([10,10,20,30,40,40,50], 51))