def solution(number, k):
    answer = 0
    number = list(number)
    
    # 0 ~ k 중 맨 앞자리 수를 고름
    fIdx = number.index(max(number[:k+1]))
    # fIdx 보다 앞에 있는 수 만큼 cnt센다
    cnt = fIdx
    # fIdx 보다 앞에 있는 수는 제거한다
    number = number[fIdx:]

    while cnt < k:
        n = len(number)
        cur, next, delIdx = -1, 0, n - 1
        while next < n - 1:
            cur += 1
            next += 1
            if number[cur] < number[next]:
                delIdx = cur
                break
        number = number[:delIdx] + number[delIdx + 1:]
        cnt += 1

    answer = ''.join(number)
    return answer

print(solution("1924", 2), "94")
print(solution("1231234", 3), "3234")
print(solution("4177252841", 4), "775841")
print(solution("77252841", 2), "775841")
print(solution("21211112", 2), "221112")
print(solution("123456789", 4), "56789")
print(solution("987654321", 2), "9876543")
print(solution("789654321", 2), "9654321")
print(solution("798654321", 2), "9865432")