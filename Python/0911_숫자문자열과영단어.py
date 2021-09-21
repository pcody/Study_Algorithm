from enum import Enum, auto

def solution(s):
    answer = ''
    wordToInt = {'zero':0, 'one':1, 'two':2, 'three':3, 'four':4, 'five':5,
    'six':6, 'seven':7, 'eight':8, 'nine':9}
    temp = ''
    for i in range(len(s)):
        if s[i].isalpha():
            temp += s[i]
            if wordToInt.get(temp) != None:
                answer += str(wordToInt[temp])
                temp = ''
        else:
            answer += s[i]

    answer = int(answer)

    return answer

    

# print(solution("one4seveneight"),1478)
# print(solution("23four5six7"),234567)
# print(solution("2three45sixseven"),234567)
# print(solution("123"),123)
print(solution("1oneoneone"),1111)
print(solution("1zerotwozero3"),10203)