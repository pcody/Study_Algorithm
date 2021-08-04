import sys
from collections import deque

def solution(P, arr):
    reverse = 0

    while P:
        p = P.popleft()

        if p == 'R':
            # 0:정, 1:역
            if reverse == 0:
                reverse = 1
            else:
                reverse = 0
        elif p == 'D':
            # arr이 비었으면 예외발생한다
            if not arr:
                raise

            if reverse == 0:
                # 정방향 -> D: left 지우기
                arr.popleft()
            else:
                # 역방향 -> D: right 지우기
                arr.pop()

    arr = list(arr)
    if reverse == 0 or arr == []:
        return arr
    else:
        return arr[-1 : 0 : -1] + [arr[0]]

answerList = []
T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    P = deque(sys.stdin.readline().rstrip())
    n = int(sys.stdin.readline().rstrip())
    arr = sys.stdin.readline().rstrip()[1:-1].split(',')
    if arr != ['']:
        arr = deque(arr)
    else:
        arr = []
    
    flag = 0
    # arr이 빈 리스트이면 예외발생하여 flag = 1
    try:
        arr = solution(P, arr)
    except Exception as e:
        # print(e)
        flag = 1

    if flag:
        answerList.append('error')
    else:
        answerList.append('[' + ','.join(arr) + ']')

for answer in answerList:
    print(answer)

# 5
# DDD
# 2
# [1,2]
# RDD
# 2
# [1,2]
# RDRD
# 3
# [1,2,3]
# RRRRRRR
# 3
# [1,2,3]
# R
# 0
# []