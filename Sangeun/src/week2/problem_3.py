# https://programmers.co.kr/learn/courses/30/lessons/42746
import functools
def compare(front_num, back_num):
    return int(front_num + back_num) - int(back_num + front_num)

def solution(numbers):
    numbers_ = [str(num) for num in numbers]
    numbers_ = sorted(numbers_, key=functools.cmp_to_key(compare), reverse=True)
    answer = ''.join(numbers_)

    if answer.startswith('0'):
        answer = str(int(answer))

    return answer
