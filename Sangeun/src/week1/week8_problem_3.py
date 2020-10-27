# https://programmers.co.kr/learn/courses/30/lessons/42840
def solution(answers):
    std1_pattern = '12345'
    std2_pattern = '21232425'
    std3_pattern = '3311224455'

    answer = [0, 0, 0]

    for idx in range(0, len(answers)):
        (std1_ans, std2_ans, std3_ans) = (
            int(std1_pattern[idx % len(std1_pattern)]), int(std2_pattern[idx % len(std2_pattern)]),
            int(std3_pattern[idx % len(std3_pattern)]))
        ans = answers[idx]
        answer[0] += (1 if ans == std1_ans else 0)
        answer[1] += (1 if ans == std2_ans else 0)
        answer[2] += (1 if ans == std3_ans else 0)

    mx = max(answer)
    answer = [idx+1 for idx,val in enumerate(answer) if val == mx]
    answer.sort()
    return answer
