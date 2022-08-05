from typing import List
from cs54_list import nil, head, tail, add, instance_as_list, list_as_str
from cs54_tools import read_instances, print_error_on_recursion_limit

from retourne import retourne

from sys import setrecursionlimit

setrecursionlimit(20000)


def nnaturels_helper(n: int) -> List[str]:
    assert n >= 0
    if n == 0:
        return add(str(0), [])
    else:
        return add(str(n), nnaturels_helper(n - 1))


@print_error_on_recursion_limit
def nnaturels(n: int) -> List[str]:
    return retourne(nnaturels_helper(n))


def nnaturels_v2_helper(n: int, todo: int) -> List[str]:
    if todo == -1:
        return []
    else:
        return add(str(n), nnaturels_v2_helper(n + 1, todo - 1))


@print_error_on_recursion_limit
def nnaturels_v2(n: int) -> List[str]:
    assert n >= 0
    return nnaturels_v2_helper(0, n)


if __name__ == "__main__":
    # assert nnaturels(0) == [ 0 ]
    # assert nnaturels(1) == [ 0, 1 ]
    # assert nnaturels(2) == [ 0, 1, 2 ]

    # assert nnaturels_v2(0) == [ 0 ]
    # assert nnaturels_v2(1) == [ 0, 1 ]
    # assert nnaturels_v2(2) == [ 0, 1, 2 ]

    with open("./data/R16.txt", "w") as output_file:
        instances = read_instances("./data/T16.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            n = int(instance)

            #            assert nnaturels(n) == nnaturels_v2(n)

            output_file.write(f"{list_as_str(nnaturels_v2(n))}\n")
