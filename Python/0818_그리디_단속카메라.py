def solution(routes):
    answer = 0

    # left->right 순서 기준으로 정렬하고
    N = len(routes)
    routes.sort(key = lambda x : (x[0], x[1]))
    
    # 초기값은 0번째 값
    left, right = routes[0][0], routes[0][1]
    i = 0
    # answer는 1부터 세고, 추가해야하면 더함
    answer += 1

    # i는 N-2까지
    while i < N - 1:
        # 초기값은 0부터, i는 1부터 비교 시작
        i += 1
        flag = 0
        nLeft, nRight = routes[i][0], routes[i][1]
        
        # 왼쪽보다 next왼쪽이 크고  오른쪽보단 작으면 교체
        if left <= nLeft <= right:
            left = nLeft
        # 범위 바깥이면 flag 1로 바꿔줌
        else:
            flag = 1

        # flag가 1이면 범위 바깥이므로 오른쪽은 계산할 필요 없음
        # next오른쪽이 기존 오른쪽보다 작으면 교체
        if not flag and nRight <= right:
            right = nRight

        # flag가 1이면 범위 바깥이므로 카메라 대수 추가
        # left, right은 next값으로 변경해줌
        if flag:
            left = nLeft
            right = nRight
            answer += 1

    return answer

print(solution([[-20,15], [-14,-5], [-18,-13], [-5,-3]]), 2)
print(solution([[-20,15], [-14,-5], [-18,-13], [-5,-3], [-2, 1], [-12, -7]]))
print(solution([[-20,15], [-14,-5], [-22, 17], [15,16], [-18,-13], [-5,-3], [-2, 1], [-12, -7]]))
print(solution([[-2, -1], [1, 2], [-3, 0]]), 2)
print(solution([[0, 0]]), 1)
print(solution([[0, 1], [0, 1], [1, 2]]), 1)
print(solution([[0, 1], [2, 3], [4, 5], [6, 7]]), 4)
print(solution([[-20, 15], [-14, 5], [-18, -13], [-5, -3]]), 2)
print(solution([[-20, 15], [-20, 15], [-14, 5], [-18, -13], [-5, -3]]), 2)
print(solution([[-100,100],[50,170],[150,200],[-50,-10],[10,20],[30,40]]), 4)
print(solution([[0,12],[1,12],[2,12],[3,12],[5,6],[6,12],[10,12]]))
print(solution([[-2,-1], [1,2],[-3,0]])) #2
print(solution([[0,0],]), 1)
print(solution([[0,1], [0,1], [1,2]]), 1)
print(solution([[0,1], [2,3], [4,5], [6,7]]), 4)
print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]]), 2)
print(solution([[-20,15], [-14,-5], [-18,-13], [-5,-3]]), 2)
print(solution([[-20,15], [-20,-15], [-14,-5], [-18,-13], [-5,-3]]), 2)
print(solution([[-7,0], [-6,-4], [-5,-3], [-3,-1], [-1,4], [1,2], [3,4]]), 4)
print(solution([[-5,-3], [-4,0], [-4,-2], [-1, 2], [0,3], [1,5], [2,4] ]), 2)
print(solution([[0,1], [1,2], [2,3] ,[3,4], [5,4], [5,6], [6,7] , [7,8], [8,9] ,[9,10], [10,11], [11,12], [12,13], [13,14] , [14,15] ]), 8)
#             left    right
# -20 15      -20      15
# -18 -13     -18      -13
# -14 -5      -14      -13
#  -5 -3      -5