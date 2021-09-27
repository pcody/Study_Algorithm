import sys
import math
from itertools import *

def isPrimeNum(num):
    if num == 1:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

T = int(sys.stdin.readline().rstrip())
answerList = []
for _ in range(T):
    n = int(sys.stdin.readline().rstrip())
    primeNum = []
    answer = []
    for i in range(2, n + 1):
        if isPrimeNum(i):
            primeNum.append(i)
    for a in primeNum:
        b = n - a
        if not isPrimeNum(b):
            continue
        else:
            if answer == []:
                answer = [a, b]
                if a == b:
                    break
            else:
                if abs(answer[0] - answer[1]) > abs(a - b):
                    answer = [a, b]
                    if a == b:
                        break
    answerList.append(answer)

for answer in answerList:
    print(answer[0], answer[1])