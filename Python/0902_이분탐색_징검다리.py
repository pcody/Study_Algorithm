def solution(distance, rocks, n):
    answer = 0
    rocks.sort()

    # 바위 사이의 최소 거리 타겟값: mid
    left = 1
    right = distance
    while left <= right:
        mid = (left + right) // 2

        # 바위 사이 최소 거리가 mid일 때 바위의 개수 세기
        preRock = 0
        chk = 0
        for rock in rocks:
            if rock - preRock < mid:
                chk += 1
            else:
                preRock = rock
        if distance - preRock < mid:
            chk += 1

        # 제거한 바위의 수가 n보다 작으면
        # 최소 거리 mid보다 큰 거리에서 찾아야함

        # chk = n인 경우 mid보다 큰 값에서도 조건을 만족하는지 찾아야하므로
        # chk < n에 부등호를 넣어준다 -> chk <= n
        # 조건을 만족하는 값 중에서 최대 mid를 찾는다
        if chk <= n:
            left = mid + 1
            answer = max(answer, mid)
        else:
            right = mid - 1
            
    return answer

print(solution(25, [2, 14, 11, 21, 17], 2), 4)

# 2 11 14 17 21 25
# 2 9  3  3  4  4

# 범위를 만족하는 최대값을 구해야하는 문제에서는
# 기준 조건을 초과하는 범위에서 최소값을 구한다고 생각하면 될 것 같다
# a <= X <= b <= c 에서 a<=X<=b의 범위를 만족하는 최대값은 b이므로
# b <= X <= c에서 최소값을 찾으면 된다는 의미이다 
# 따라서 제거해야할 바위 수가 적거나 같은은 경우 left를 mid보다 올린 범위에서 재검하며,
# 이를 반복하여 만족하는 값을 찾으면 최종 a <= X <= b에서 최대값을 찾게 된다

# 이해를 돕기위해 다시 설명하면,
# a <= X <= b에서 최대값을, b <= X <= c에서는 최소값을 찾으면 된다