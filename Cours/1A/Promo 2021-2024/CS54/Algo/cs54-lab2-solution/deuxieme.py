from typing import List
from cs54_list import nil, head, tail, add, instance_as_list
from cs54_tools import read_instances, print_error_on_assertion


@print_error_on_assertion
def deuxieme(list: List[str]) -> str:
    assert len(list) > 1
    return head(tail(list))


if __name__ == "__main__":
    # l = []
    # l = add('a', l)
    # l = add('b', l)
    # assert(deuxieme(l) == 'a')
    # l = add('c', l)
    # assert(deuxieme(l) == 'b')

    with open("./data/R6.txt", "w") as output_file:
        instances = read_instances("./data/T6.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            l = instance_as_list(instance)
            output_file.write(f"{deuxieme(l)}\n")
