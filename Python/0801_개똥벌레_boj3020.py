import sys

N, H = map(int, sys.stdin.readline().split())

# 감은 생겼는데, 이분탐색에서 답을 구할 때
# left, right, mid 중에서 어떤걸로 구해야할지 잘 모르겠다...ㅎ;ㅎ

# 종유석의 길이를 담을 리스트
upObs = []
# 석순의 길이를 담을 리스트
downObs = []
# 정답 변수
answerList = []

for i in range(N):
    temp = int(sys.stdin.readline().rstrip())
    if i % 2 == 0:
        # 짝수는 석순
        downObs.append(temp)    
    else:
        # 홀수는 종유석
        upObs.append(temp)

# 길이 오름차순으로 정렬
upObs.sort()
downObs.sort()

# print(f'종유석:{upObs}')
# print(f'석  순:{downObs}')
# 개똥벌레는 1층부터 H층까지 지나간다
for h in range(1, H + 1):
    # 이분탐색 인덱스 설정, 참고로 N은 짝수임
    left = 0
    right = N // 2 - 1
    # left와 right이 같은 지점까지 탐색할 것임
    # 탈출 조건은 h층 지나갈 때 길이가 H-h+1 이상인 최소 인덱스 찾을 때
    target = H - h + 1
    upNum = 0
    while left <= right:
        mid = (left + right) // 2
        # 총 높이 H, 개똥벌레의 비행 층수에서 걸리는
        # 타겟 높이를 찾고 개수(N//2 - 해당인덱스 + 1)리턴
        if upObs[mid] < target:
            left = mid + 1
        else:
            upNum = N // 2 - mid
            right = mid - 1

    left = 0
    right = N // 2 - 1
    target = h
    downNum = 0
    while left <= right:
        mid = (left + right) // 2
        if downObs[mid] < target:
            left = mid + 1
        else:
            downNum = N // 2 - mid
            right = mid - 1
    
    # print(f'{h}층 종유석{upNum} 석순{downNum}')

    answerList.append(upNum + downNum)

answer = min(answerList)
print(answer, answerList.count(answer))