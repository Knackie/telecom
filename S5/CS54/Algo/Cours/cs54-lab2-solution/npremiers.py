from typing import List
from cs54_list import nil, head, tail, add, instance_as_list, list_as_str
from cs54_tools import read_instances, split_instance, print_error_on_assertion


@print_error_on_assertion
def npremiers(list: List[str], n: int) -> List[str]:
    assert n >= 0 and n <= len(list)
    if n == 0:
        return []
    else:
        return add(head(list), npremiers(tail(list), n - 1))


if __name__ == "__main__":
    # l = []
    # assert(nil(npremiers(l, 0)))
    # l = add('a', l)
    # assert(nil(npremiers(l, 0)))
    # assert(npremiers(l, 1) == [ 'a' ])
    # l = add('b', l)
    # assert(nil(npremiers(l, 0)))
    # assert(npremiers(l, 1) == [ 'b' ])
    # assert(npremiers(l, 2) == [ 'b', 'a' ])
    # l = add('c', l)
    # assert(nil(npremiers(l, 0)))
    # assert(npremiers(l, 1) == [ 'c' ])
    # assert(npremiers(l, 2) == [ 'c', 'b' ])
    # assert(npremiers(l, 3) == [ 'c', 'b', 'a' ])

    with open("./data/R10.txt", "w") as output_file:
        instances = read_instances("./data/T10.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            n, l = split_instance(instance)
            n, l = int(n), instance_as_list(l)
            output_file.write(f"{list_as_str(npremiers(l, n))}\n")
