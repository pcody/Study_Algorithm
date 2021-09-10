from collections import defaultdict

def solution(n, results):
    answer = 0

    wins, loses = defaultdict(set), defaultdict(set)

    for winner, loser in results:
        wins[winner].add(loser)
        loses[loser].add(winner)
    
    # i가 승리한 set() wins[i]
    # i가 패배당한 set() loses[i]
    for i in range(1, n + 1):
        for loser in wins[i]:
            # i에게 진 loser들은 i를 이긴 집합에게도 짐
            loses[loser].update(loses[i])
        for winner in loses[i]:
            # i를 이긴 winner들은 i에게 진 집합에게도 이김
            wins[winner].update(wins[i])

    # 이긴 집합 + 진 집합 = n - 1이 되는 것들만 개수를 셈
    for i in range(1, n + 1):
        if len(wins[i]) + len(loses[i]) == n - 1:
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
