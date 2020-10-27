# https://programmers.co.kr/learn/courses/30/lessons/12943
def collatz(cur_num, seq):
    if seq >= 500:
        return -1
    if cur_num == 1:
        return seq
    if cur_num % 2 == 0:
        cur_num = cur_num // 2
    else:
        cur_num = cur_num * 3 + 1

    return collatz(cur_num, seq + 1)

def solution(num):
    answer = collatz(num, 0)
    return answer
