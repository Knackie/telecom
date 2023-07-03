from typing import List
from cs54_list import nil, head, tail, add, instance_as_list
from cs54_tools import read_instances, split_instance, print_error_on_assertion


@print_error_on_assertion
def nieme(list: List[str], n: int) -> str:
    assert n > 0 and n <= len(list)
    if n == 1:
        return head(list)
    else:
        return nieme(tail(list), n - 1)


if __name__ == "__main__":
    # l = []
    # l = add('a', l)
    # assert(nieme(l, 1) == 'a')
    # l = add('b', l)
    # assert(nieme(l, 1) == 'b')
    # assert(nieme(l, 2) == 'a')
    # l = add('c', l)
    # assert(nieme(l, 1) == 'c')
    # assert(nieme(l, 2) == 'b')
    # assert(nieme(l, 3) == 'a')

    with open("./data/R9.txt", "w") as output_file:
        instances = read_instances("./data/T9.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            n, l = split_instance(instance)
            n, l = int(n), instance_as_list(l)
            output_file.write(f"{nieme(l, n)}\n")
