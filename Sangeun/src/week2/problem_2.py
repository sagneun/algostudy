from collections import deque

def solution(prices):
    answer = []
    dq = deque(prices)

    sub_que = deque()
    for idx, price in enumerate(prices):

        cnt = 0
        if idx < (len(prices) - 1):
            sub_que.extend(prices[idx+1:])
            while len(sub_que) > 0:
                cmp_price = sub_que.pop()
                if cmp_price >= price:
                    cnt += 1

        answer.append(cnt)

    return answer
