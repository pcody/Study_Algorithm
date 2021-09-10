from collections import defaultdict
from collections import deque

def solution(n, results):
    answer = 0

    # 순위의 순방향 역방향 둘다 그래프를 만듦
    graphForward = defaultdict(list)
    graphReverse = defaultdict(list)
    for A, B in results:
        graphForward[A].append(B)
        graphReverse[B].append(A)

    # 0 순방향, 1 역방향
    indegree = [[0, 0] for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in graphForward[i]:
            indegree[j][0] += 1
        for j in graphReverse[i]:
            indegree[j][1] += 1

    flag = 0
    answerDict = defaultdict(int)
    q = deque()
    for i in range(1, n + 1):
        # 순방향
        if indegree[i][0] == 0:
            answerDict[i] = 1
            q.append((i, 1))
            
    # 순방향에서 q에 시작점이 여러개면 반대방향으로
    if len(q) > 1:
        q.clear()
        answerDict.clear()
        flag = 1

        for i in range(1, n + 1):
            # 역방향
            if indegree[i][1] == 0:
                answerDict[i] = 1
                q.append((i, 1))

    # 역방향으로 만든 q도 시작점이 여러개면 0 리턴
    if len(q) > 1:
        for i in range(1, n + 1):
            if indegree[i][0] == indegree[i][1] and sum(indegree[i]) + 1 == n:
                answer += 1
        return answer

    while q:
        cur, lv = q.popleft()

        if flag == 0:
            for next in graphForward[cur]:
                indegree[next][0] -= 1
                if indegree[next][0] == 0:
                    answerDict[next] = max(answerDict[next], lv + 1)
                    q.append((next, lv + 1))
        else:
            for next in graphReverse[cur]:
                indegree[next][1] -= 1                
                if indegree[next][1] == 0:
                    answerDict[next] = max(answerDict[next], lv + 1)
                    q.append((next, lv + 1))
    
    answerList = sorted(list(answerDict.items()), key = lambda x : (x[1], x[0]))

    for i in range(n):
        if i < n - 1:
            if answerList[i][1] != answerList[i + 1][1]:
                answer += 1
            else:
                break
        else:
            if answerList[i][1] != answerList[i - 1][1]:
                answer += 1

    return answer

print(solution(5, [[4,3],[4,2],[3,2],[1,2],[2,5]]),2)
print(solution(5, [[4,3],[4,2],[3,2],[1,2],[2,5]]),2)
print(solution(7, [[4,3],[4,2],[3,2],[1,2],[2,5],[5,6],[6,7]]),4)
print(solution(6, [[1,2],[2,3],[3,4],[4,5],[5,6]]),6)
print(solution(5, [[1,4],[4,2],[2,5],[5,3]]),5)
print(solution(5, [[3,5],[4,2],[4,5],[5,1],[5,2]]),1)
print(solution(3, [[1,2],[1,3]]), 1)
print(solution(8, [[1,2],[3,4],[5,6],[7,8]]),0)
print(solution(9, [[1,2],[1,3],[1,4],[1,5],[6,1],[7,1],[8,1],[9,1]]),1)
print(solution(3, [[3,2],[3,1]]), 1)
print(solution(6, [[4,3],[4,2],[3,2],[1,2],[2,5],[2,6]]),0)
print(solution(6, [[1,6],[2,6],[3,6],[4,6]]),0)
print(solution(6, [[1,2],[2,3],[3,4],[4,5],[5,6],[2,4],[2,6]]),6)
print(solution(4, [[4,3],[4,2],[3,2],[3,1],[4,1], [2,1]]),4)
print(solution(4, [[1,2],[1,3],[3,4]]),1)

print(solution(5, [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]), 2)
print(solution(7, [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5], [5,6], [6,7]]), 4)
print(solution(6, [[1,2], [2,3], [3,4], [4,5], [5,6]]), 6)
print(solution(5, [[1, 4], [4, 2], [2, 5], [5, 3]]), 5)
print(solution(5, [[3, 5], [4, 2], [4, 5], [5, 1], [5, 2]]), 1)
print(solution(3, [[1,2],[1,3]]), 1)
print(solution(6, [[1,6],[2,6],[3,6],[4,6]]), 0)
print(solution(8, [[1,2],[3,4],[5,6],[7,8]]),0)
print(solution(9, [[1,2],[1,3],[1,4],[1,5],[6,1],[7,1],[8,1],[9,1]]), 1)
print(solution(6, [[1,2],[2,3],[3,4],[4,5],[5,6],[2,4],[2,6]]), 6)
print(solution(4, [[4,3],[4,2],[3,2],[3,1],[4,1], [2,1]]), 4)
print(solution(3,[[3,2],[3,1]]), 1)
print(solution(4, [[1,2],[1,3],[3,4]]), 1)