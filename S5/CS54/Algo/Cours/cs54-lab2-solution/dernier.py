from typing import List
from cs54_list import nil, head, tail, add, instance_as_list
from cs54_tools import read_instances, print_error_on_assertion


@print_error_on_assertion
def dernier(list: List[str]) -> str:
    assert len(list) > 0
    if nil(tail(list)):
        return head(list)
    else:
        return dernier(tail(list))


if __name__ == "__main__":
    # l = []
    # l = add('a', l)
    # assert(dernier(l) == 'a')
    # l = add('b', l)
    # assert(dernier(l) == 'a')
    # l = add('c', l)
    # assert(dernier(l) == 'a')

    with open("./data/R7.txt", "w") as output_file:
        instances = read_instances("./data/T7.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            l = instance_as_list(instance)
            output_file.write(f"{dernier(l)}\n")
