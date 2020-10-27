# https://programmers.co.kr/learn/courses/30/lessons/42577

def solution(phone_book):
    phone_book.sort(key=lambda x:len(x), reverse=True)

    while len(phone_book) > 1:
        tmp_num = phone_book.pop()
        tmp_result = [cmp_num for cmp_num in phone_book if cmp_num.startswith(tmp_num)]
        if len(tmp_result) > 0:
            return False
    return True
