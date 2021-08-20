def solution(distance, rocks, n):
    answer = 0
    rocks.sort()

    # 최소 거리는 1, 최대 거리는 distance
    left = 1
    right = distance
    while left <= right:
        # 타겟거리(mid)에서 제거할 바위 수를 세고 n과 비교
        mid = (left + right) // 2

        rockCnt = 0
        prevRock = 0
        for rock in rocks:
            if rock - prevRock < mid:
                rockCnt += 1
            else:
                prevRock = rock
        # 마지막 바위와 도착지 거리도 세야 하므로 if문 추가
        if distance - prevRock < mid:
            rockCnt += 1

        # 제거할 바위 수가 n보다 많으면 타겟거리(mid)가 좁다는 의미로 탐색 범위를 넓혀야 하므로
        # mid+1 ~ right 에서 재검하면 되고

        # n보다 적으면 타겟거리(mid)가 넓다는 의미로 탐색 범위를 좁혀야하므로
        # left ~ mid-1 에서 재검하면 된다

        # 범위를 만족하는 최대값을 구해야하는 문제에서는
        # 기준 조건을 초과하는 범위에서 최소값을 구한다고 생각하면 될 것 같다
        # a <= X <= b <= c 에서 a<=X<=b의 범위를 만족하는 최대값은 b이므로
        # b <= X <= c에서 최소값을 찾으면 된다는 의미이다 
        # 따라서 제거해야할 바위 수가 적은 경우 left를 mid보다 올린 범위에서
        # 재검하게 되는데, 이 범위에서 최소값을 찾으면 된다
        
        # 이해를 돕기위해 다시 설명하면,
        # a <= X <= b에서 최대값을, b <= X <= c에서는 최소값을 찾으면 된다
        if rockCnt <= n:
            left = mid + 1
            answer = max(answer, mid)
        else:
            right = mid - 1
            
    return answer

print(solution(25,[2, 14, 11, 21, 17],2),4)