#!/usr/bin/env python3

from typing import List, Tuple
from tools import verbose, timeit

# BEWARE: row and column start at 1 while index starts at 0
def index_for_pyramid_arranged_by_rows(row: int, column: int) -> int:
    return (row * (row - 1)) // 2 + column - 1


assert index_for_pyramid_arranged_by_rows(1, 1) == 0
assert index_for_pyramid_arranged_by_rows(2, 1) == 1
assert index_for_pyramid_arranged_by_rows(2, 2) == 2
assert index_for_pyramid_arranged_by_rows(3, 1) == 3
assert index_for_pyramid_arranged_by_rows(3, 2) == 4
assert index_for_pyramid_arranged_by_rows(3, 3) == 5


def length_for_pyramid_height(height: int) -> int:
    return (height * (height + 1)) // 2


assert (length_for_pyramid_height(5)) == 15


def is_pyramid_correct(values: List[int], depth: int, height: int) -> bool:
    assert depth < len(values)
    assert length_for_pyramid_height(height) == len(values)

    for row in range(1, height):
        for column in range(1, row + 1):
            index_max_of_values = index_for_pyramid_arranged_by_rows(row + 1, column + 1)
            if index_max_of_values <= depth:
                v1 = values[index_for_pyramid_arranged_by_rows(row + 1, column)]
                v2 = values[index_for_pyramid_arranged_by_rows(row + 1, column + 1)]
                v3 = values[index_for_pyramid_arranged_by_rows(row, column)]

                if abs(v1 - v2) != v3:
                    return False

    return True


# full correct pyramids are corrects
assert is_pyramid_correct([1, 2, 3], 2, 2) == True
assert is_pyramid_correct([1, 3, 2], 2, 2) == True
assert is_pyramid_correct([2, 1, 3], 2, 2) == True
assert is_pyramid_correct([2, 3, 1], 2, 2) == True

# prefixes of correct pyramids are corrects
assert is_pyramid_correct([2, 3, 1], 1, 2) == True
assert is_pyramid_correct([2, 3, 1], 0, 2) == True

# full wrong pyramids are wrong
assert is_pyramid_correct([3, 1, 2], 2, 2) == False
assert is_pyramid_correct([1, 3, 2, 4, 5, 6], 5, 3) == False

# prefixes of full wrong pyramids could be corrects
assert is_pyramid_correct([3, 1, 2], 0, 2) == True
assert is_pyramid_correct([3, 1, 2], 1, 2) == True
assert is_pyramid_correct([3, 1, 2], 2, 2) == False

assert is_pyramid_correct([1, 3, 2, 4, 5, 6], 0, 3) == True
assert is_pyramid_correct([1, 3, 2, 4, 5, 6], 1, 3) == True
assert is_pyramid_correct([1, 3, 2, 4, 5, 6], 2, 3) == True
assert is_pyramid_correct([1, 3, 2, 4, 5, 6], 3, 3) == True
assert is_pyramid_correct([1, 3, 2, 4, 5, 6], 4, 3) == False
assert is_pyramid_correct([1, 3, 2, 4, 5, 6], 5, 3) == False


def find_one_solution_rec(depth: int, values: List[int], height: int) -> Tuple[bool, List[int]]:
    if depth >= len(values):
        return True, values

    for value in range(1, len(values) + 1):
        if value not in values[:depth]:
            values[depth] = value

            if is_pyramid_correct(values, depth, height):
                found, solution = find_one_solution_rec(depth + 1, values, height)
                if found:
                    return found, solution
            # we do need not restore the previous state, since it is overwritten during the next step of iteration
            # values[depth] = 0
    return False, []


def find_one_solution(height: int) -> List[int]:
    _, solution = find_one_solution_rec(0, [0] * length_for_pyramid_height(height), height)
    return solution


# BEWARE: some problems have multiple solutions therefore the assert might fails with another implementations
# assert find_one_solution(2) == [1, 2, 3]
# assert find_one_solution(3) == [1, 3, 4, 5, 2, 6]
# assert find_one_solution(4) == [3, 2, 5, 7, 9, 4, 8, 1, 10, 6]
# assert find_one_solution(5) == [5, 4, 9, 7, 11, 2, 8, 1, 12, 10, 6, 14, 15, 3, 13]


def find_all_solution_rec(
    depth: int, values: List[int], height: int, solutions: List[List[int]]
) -> Tuple[bool, List[List[int]]]:
    if depth >= len(values):
        solutions.append(list(values))
        return True, solutions

    for value in range(1, len(values) + 1):
        if value not in values[:depth]:
            values[depth] = value

            if is_pyramid_correct(values, depth, height):
                _, solutions = find_all_solution_rec(depth + 1, values, height, solutions)
            # we do need not restore the previous state, since it is overwritten during the next step of iteration
            # values[depth] = 0

    return len(solutions) > 0, solutions


def find_all_solutions(height: int) -> List[List[int]]:
    _, solutions = find_all_solution_rec(0, [0] * length_for_pyramid_height(height), height, list())
    return solutions


# assert len(find_all_solutions(2)) == 4
# assert len(find_all_solutions(3)) == 8
# assert len(find_all_solutions(4)) == 8
# assert len(find_all_solutions(5)) == 2 # ~ 1.35 sec.
# assert len(find_all_solutions(6)) == 0 # ~ 43.5 sec.
# same for height in [7, 12]


# BEWARE: row and diagonal start at 1 while index starts at 0
def index_for_pyramid_arranged_by_diagonal(diagonal: int, row: int) -> int:
    return (diagonal * (diagonal - 1)) // 2 + row - 1


assert index_for_pyramid_arranged_by_diagonal(1, 1) == 0
assert index_for_pyramid_arranged_by_diagonal(2, 1) == 1
assert index_for_pyramid_arranged_by_diagonal(2, 2) == 2
assert index_for_pyramid_arranged_by_diagonal(3, 1) == 3
assert index_for_pyramid_arranged_by_diagonal(3, 2) == 4
assert index_for_pyramid_arranged_by_diagonal(3, 3) == 5


def is_pyramid_correct_by_diagonal(values: List[int], depth: int, height: int) -> bool:
    assert depth <= len(values)
    assert length_for_pyramid_height(height) == len(values)

    for diag in range(1, height + 1):
        for row in range(2, diag + 1):
            index_max_of_values = index_for_pyramid_arranged_by_diagonal(diag, row)
            if index_max_of_values <= depth:
                v1 = values[index_for_pyramid_arranged_by_diagonal(diag - 1, row - 1)]
                v2 = values[index_for_pyramid_arranged_by_diagonal(diag, row - 1)]
                v3 = values[index_for_pyramid_arranged_by_diagonal(diag, row)]

                if abs(v1 - v2) != v3:
                    return False

    return True


assert is_pyramid_correct_by_diagonal([1, 3, 2], 2, 2) == True
assert is_pyramid_correct_by_diagonal([1, 2, 3], 2, 2) == False
assert is_pyramid_correct_by_diagonal([5, 2, 3, 6, 4, 1], 6, 3) == True


def find_all_solutions_using_propagation_rec(
    diag: int, values: List[int], height: int, solutions: List[List[int]]
) -> Tuple[bool, List[List[int]]]:
    if diag > height:
        solutions.append(list(values))
        return True, solutions

    index_where_diagonal_starts = index_for_pyramid_arranged_by_diagonal(diag, 1)
    for value in range(1, len(values) + 1):

        if value not in values[:index_where_diagonal_starts]:
            values[index_where_diagonal_starts] = value

            # try to propagate the value
            propagation_succeeded = True
            row = 2
            while propagation_succeeded and row <= diag:
                v1 = values[index_for_pyramid_arranged_by_diagonal(diag - 1, row - 1)]
                v2 = values[
                    index_where_diagonal_starts + row - 2
                ]  # values[index_for_pyramid_arranged_by_diagonal(diag, row-1)]
                v3 = abs(v1 - v2)

                index_v3 = index_where_diagonal_starts + row - 1  # index_for_pyramid_arranged_by_diagonal(diag, row)
                if v3 not in values[:index_v3]:
                    values[index_v3] = v3
                else:
                    propagation_succeeded = False
                row += 1

            if propagation_succeeded:
                _, solutions = find_all_solutions_using_propagation_rec(diag + 1, values, height, solutions)

            # we do need not restore the previous state, since it is overwritten during the next step of iteration
            # values[index_where_diagonal_starts] = 0
            # and the rest of the diagonal which was filled...

    return len(solutions) > 0, solutions


def find_all_solutions_using_propagation(height: int) -> List[List[int]]:
    _, solutions = find_all_solutions_using_propagation_rec(1, [0] * length_for_pyramid_height(height), height, list())
    return solutions


assert len(find_all_solutions_using_propagation(2)) == 4
assert len(find_all_solutions_using_propagation(3)) == 8
assert len(find_all_solutions_using_propagation(4)) == 8
assert len(find_all_solutions_using_propagation(5)) == 2  # ~ 0.05 sec.
assert len(find_all_solutions_using_propagation(6)) == 0  # ~ 0.66 sec.
# assert len(find_all_solutions_using_propagation(7)) == 0 # ~ 10.65 sec.
# assert len(find_all_solutions_using_propagation(8)) == 0 # ~ 163 sec.
# same for height in [7, 12]
