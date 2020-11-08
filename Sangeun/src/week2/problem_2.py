# https://programmers.co.kr/learn/courses/30/lessons/42584
from collections import deque
def solution(prices):
    answer = []
    for idx, price in enumerate(prices):
        cnt = 0
        if (idx+1) < len(prices):
            sub_que = deque(prices[idx+1:])
            while len(sub_que) > 0:
                cmp_price = sub_que.popleft()
                if cmp_price < price:
                    cnt += 1
                    break
                else:
                    cnt += 1

        answer.append(cnt)

    return answer
