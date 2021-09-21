def solution(name):
    answer = 0
    N = len(name)

    answerList = []
    bef = 0
    for cur in range(N):
        if name[cur] == 'A':
            pass
        else:
            # if cur != 0:
            #     if cur - bef <= bef + N - cur:
            #         answer += cur - bef
            #     else:
            #         answer += bef + N - cur
            answerList.append(cur)
            bef = cur
            temp = ord(name[cur])-ord('A')
            if temp <= 12:
                answer += temp
            else:
                answer += 26-temp

    print(answerList, answer)

    return answer

solution("JEROEN")
solution("ABAAAAAAAAABB")
solution("JAZ")
solution("ABBAAAAAB",7)
solution("ABAAAABB",7)
#     a b c d e f
#  -1 0 1 2 3 4 5
#     0 5 4 3 2 1
