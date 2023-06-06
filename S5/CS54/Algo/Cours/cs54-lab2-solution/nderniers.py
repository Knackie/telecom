from typing import List
from cs54_list import nil, head, tail, add, instance_as_list, list_as_str
from cs54_tools import read_instances, split_instance, print_error_on_assertion

from longueur import longueur


@print_error_on_assertion
def nderniers(list: List[str], n: int) -> List[str]:
    assert n >= 0 and n <= len(list)
    if n == longueur(list):
        return list
    else:
        return nderniers(tail(list), n)


def sauf_npremiers(list: List[str], n: int) -> List[str]:
    assert n >= 0 and n <= len(list)
    if n == 0:
        return list
    else:
        return sauf_npremiers(tail(list), n - 1)


@print_error_on_assertion
def nderniers_v2(list: List[str], n: int) -> List[str]:
    assert n >= 0 and n <= len(list)
    return sauf_npremiers(list, longueur(list) - n)


if __name__ == "__main__":
    # l = []
    # assert(nil(nderniers(l, 0)))
    # l = add('a', l)
    # assert(nil(nderniers(l, 0)))
    # assert(nderniers(l, 1) == [ 'a' ])
    # l = add('b', l)
    # assert(nil(nderniers(l, 0)))
    # assert(nderniers(l, 1) == [ 'a' ])
    # assert(nderniers(l, 2) == [ 'b', 'a' ])
    # l = add('c', l)
    # assert(nil(nderniers(l, 0)))
    # assert(nderniers(l, 1) == [ 'a' ])
    # assert(nderniers(l, 2) == [ 'b', 'a' ])
    # assert(nderniers(l, 3) == [ 'c', 'b', 'a' ])

    with open("./data/R11.txt", "w") as output_file:
        instances = read_instances("./data/T11.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            n, l = split_instance(instance)
            n, l = int(n), instance_as_list(l)

            assert nderniers(l, n) == nderniers_v2(l, n)

            output_file.write(f"{list_as_str(nderniers_v2(l, n))}\n")
