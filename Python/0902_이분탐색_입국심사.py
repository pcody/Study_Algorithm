def solution(n, times):
    answer = 0

    left = 1
    right = max(times) * n
    while left <= right:
        mid = (left + right) // 2

        chk = 0
        for time in times:
            chk += mid // time

        if chk < n:
            left = mid + 1
        else:
            right = mid - 1

        # 마지막 조건에서 left = right = mid 이므로
        # else를 실행할 것으로 예상됨
        # 여기서 answer에 right을 입력하면 정답-1 한 값이므로
        # left를 대입함
        answer = left
        
    return answer

print(solution(6, [7, 10]), 28)