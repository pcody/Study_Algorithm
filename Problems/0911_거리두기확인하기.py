# 상좌하우
uldrxy = [[0,-1],[-1,0],[0,1],[1,0]]
# 상상좌좌하하우우
uullddrrxy = [[0,-2],[-2,0],[0,2],[2,0]]
# 좌상,좌하,우하,우상
luldrdruxy = [[-1,-1],[-1,1],[1,1],[1,-1]]

def solution(places):
    global uldrxy, uullddrrxy, luldrdruxy
    answer = []

    for j in range(len(places)):
        people = []
        flag = 0
        # print(f'{j+1}번 방')
        # 'P'의 위치를 모두 구해서
        for k in range(5):
            for i in range(5):
                if places[j][k][i] == 'P':
                    people.append([i, k])
        
        # people에 좌표가 없으면 검사 안 하고 answer는 1 넣음
        if people == []:
            flag = 1
            answer.append(1)

        if flag == 0:
            # 주변을 돌면서 검사하기
            for x, y in people:
                if flag == 1:
                    break
                # 상좌하우 검사
                for k in range(4):
                    if flag == 1:
                        break
                    nx, ny = x + uldrxy[k][0], y + uldrxy[k][1]
                    if 0 <= nx < 5 and 0 <= ny < 5:
                        if places[j][ny][nx] == 'P':
                            answer.append(0)
                            flag = 1
                            break
                # 상상좌좌하하우우 검사
                for k in range(4):
                    if flag == 1:
                        break
                    nx, ny = x + uullddrrxy[k][0], y + uullddrrxy[k][1]
                    if 0 <= nx < 5 and 0 <= ny < 5:
                        if places[j][ny][nx] == 'P':
                            if uullddrrxy[k] == [0,-2]:
                                if places[j][y-1][x] == 'O':
                                    answer.append(0)
                                    flag = 1
                                    break
                            elif uullddrrxy[k] == [-2,0]:
                                if places[j][y][x-1] == 'O':
                                    answer.append(0)
                                    flag = 1
                                    break
                            elif uullddrrxy[k] == [0,2]:
                                if places[j][y+1][x] == 'O':
                                    answer.append(0)
                                    flag = 1
                                    break
                            elif uullddrrxy[k] == [2,0]:
                                if places[j][y][x+1] == 'O':
                                    answer.append(0)
                                    flag = 1
                                    break
                # 좌상,좌하,우하,우상 검사
                for k in range(4):
                    if flag == 1:
                        break
                    nx, ny = x + luldrdruxy[k][0], y + luldrdruxy[k][1]
                    if 0 <= nx < 5 and 0 <= ny < 5:
                        if places[j][ny][nx] == 'P':
                            # 좌상
                            if luldrdruxy[k] == [-1,-1]:
                                if not (places[j][y][x-1] == 'X' and places[j][y-1][x] == 'X'):
                                    answer.append(0)
                                    flag = 1
                                    break
                            # 좌하
                            elif luldrdruxy[k] == [-1,1]:
                                if not (places[j][y][x-1] == 'X' and places[j][y+1][x] == 'X'):
                                    answer.append(0)
                                    flag = 1
                                    break
                            # 우하
                            elif luldrdruxy[k] == [1,1]:
                                if not (places[j][y][x+1] == 'X' and places[j][y+1][x] == 'X'):
                                    answer.append(0)
                                    flag = 1
                                    break
                            # 우상
                            elif luldrdruxy[k] == [1,-1]:
                                if not (places[j][y][x+1] == 'X' and places[j][y-1][x] == 'X'):
                                    answer.append(0)
                                    flag = 1
                                    break
            if flag == 0:
                answer.append(1)

    return answer


print(solution([["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]), [1, 0, 1, 1, 1])
print(solution([["POOOP", "OPXOX", "OPXPX", "OOXOX", "POXXP"]]))
print(solution([["PXOOO", "OOOOO", "PXOOO", "OOOOO", "OOOPO"]]))

