def solution(n, times):
    answer = 0

    # 최소 몇 분이 걸리는지? -> 시간을 탐색해야함
    # 최소 시간 left
    # 최대 시간 right

    left = 1
    # 조건에 1분 이상 1000000000분 이하로 되어 있으나 overflow발생하므로
    # 최대 걸리는 시간은 아래처럼 변경
    right = max(times) * n
    while left <= right:
        mid = (left + right) // 2

        S = 0
        for time in times:
            # mid의 시간 동안 심사할 수 있는 사람 수
            S += mid // time

        if S < n:
            # mid의 시간동안 n명을 못 채우면 mid보다 큰 곳에서 다시 탐색
            left = mid + 1
        else:
            # mid의 시간동안 n명 이상을 채우면 mid보다 작은 곳에서 다시 탐색
            right = mid - 1
            answer = mid

    return answer

print(solution(6,[7, 10]),28)
print(solution(3,[1, 1, 1]),1)
print(solution(3,[1, 2, 3]),2)
print(solution(2,[1, 2]),2)