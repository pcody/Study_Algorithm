
def count(people):
    global N, K, hamb, maxValue, maxPeople;
    if people >= maxPeople:
        if maxValue < hamb.count(0):
            maxValue = hamb.count(0);
        return maxValue;
    # for j in range(N):
        # if hamb[j] != 'H' and hamb[j] != 0:
        #     if !hamb[j][1]:
        #         for i in range(-K, K + 1):

N, K = map(int, input().split());
temp = input();
maxValue = 0;
maxPeople = temp.count('P');
hamb = [];
for _ in range(N):
    if temp[_] == 'P':
        hamb.append(_);
    else:
        hamb.append(temp[_]);

print(hamb);
# print(count(0));