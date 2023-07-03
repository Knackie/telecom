from typing import List
from cs54_list import nil, head, tail, add, instance_as_list, list_as_str
from cs54_tools import read_instances, split_instance

from dernier import dernier
from sauf_dernier import sauf_dernier

from retourne import retourne_v2


def concat(list_a: List[str], list_b: List[str]) -> List[str]:
    if nil(list_a):
        return list_b
    else:
        return concat(sauf_dernier(list_a), add(dernier(list_a), list_b))


def concat_helper(list_a: List[str], list_b: List[str]) -> List[str]:
    if nil(list_a):
        return list_b
    else:
        return concat_helper(tail(list_a), add(head(list_a), list_b))


def concat_v2(list_a: List[str], list_b: List[str]) -> List[str]:
    return concat_helper(retourne_v2(list_a), list_b)


if __name__ == "__main__":
    # l1 = []
    # l2 = []
    # assert(nil(concat(l1, l2)))

    # l1 = [ 'a' ]
    # l2 = []
    # assert(concat(l1, l2) == [ 'a' ])

    # l1 = []
    # l2 = [ 'a' ]
    # assert(concat(l1, l2) == [ 'a' ])

    # l1 = [ 'a' ]
    # l2 = [ 'b' ]
    # assert(concat(l1, l2) == [ 'a', 'b' ])

    # l1 = [ 'a', 'b' ]
    # l2 = [ ]
    # assert(concat(l1, l2) == [ 'a', 'b' ])

    # l1 = [ ]
    # l2 = [ 'a', 'b' ]
    # assert(concat(l1, l2) == [ 'a', 'b' ])

    # l1 = [ 'a', 'b' ]
    # l2 = [ 'c' ]
    # assert(concat(l1, l2) == [ 'a', 'b', 'c' ])

    # l1 = [ 'a' ]
    # l2 = [ 'b', 'c' ]
    # assert(concat(l1, l2) == [ 'a', 'b', 'c' ])

    with open("./data/R13.txt", "w") as output_file:
        instances = read_instances("./data/T13.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            l1, l2 = split_instance(instance)
            l1, l2 = instance_as_list(l1), instance_as_list(l2)

            assert concat(l1, l2) == concat_v2(l1, l2)

            output_file.write(f"{list_as_str(concat(l1, l2))}\n")
