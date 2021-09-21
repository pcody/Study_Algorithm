from collections import deque

def solution(number, k):
    answer = ''
    number = list(number)
    N = len(number)

    # 0 ~ k 인덱스 중 최대값 찾아서 그 앞은 버린다
    # cnt : 버린 개수
    maxIdx, maxNum = 0, number[0]
    for idx in range(k + 1):
        num = number[idx]
        if num > maxNum:
            maxIdx, maxNum = idx, num
    number = number[maxIdx:]
    cnt = maxIdx

    
    n = N - cnt
    answerList = deque()
    i = -1
    while i < n - 1:
        i += 1
        # i를 큐에 넣고 i+1과 비교
        answerList.append(number[i])
        
        if i < n - 1:
            # compareNum
            cNum = number[i + 1]
            while True:
                # cnt가 k이상이거나 큐가 비었으면 탈출
                if cnt >= k or not answerList:
                    break
                # cnt가 k미만이고 큐가 안 비었으면 pop해서 비교
                qNum = answerList.pop()
                if qNum >= cNum:
                    # pop한게 크면 다시 넣음
                    answerList.append(qNum)
                    break
                else:
                    cnt += 1
    
    # k개 수를 제거하지 못했을 때는 뒤에서부터 뺀다
    while cnt < k:
        cnt += 1
        answerList.pop()
    
    answer = ''.join(list(answerList))

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
print(solution("321456789", 2), "3456789")
print(solution("321456789", 3), "456789")
print(solution("325416189", 4), "56189")
print(solution("2453212345", 4), "532345")
print(solution("2453512345", 4), "552345")
print(solution("532123451", 4), "53451")