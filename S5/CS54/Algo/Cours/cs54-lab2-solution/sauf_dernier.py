from typing import List
from cs54_list import nil, head, tail, add, instance_as_list, list_as_str
from cs54_tools import read_instances, print_error_on_assertion


@print_error_on_assertion
def sauf_dernier(list: List[str]) -> List[str]:
    assert len(list) > 0
    if nil(tail(list)):
        return []
    else:
        return add(head(list), sauf_dernier(tail(list)))


if __name__ == "__main__":
    # l = []
    # l = add('a', l)
    # assert(nil(sauf_dernier(l)))
    # l = add('b', l)
    # assert(sauf_dernier(l) == [ 'b' ])
    # l = add('c', l)
    # assert(sauf_dernier(l) == [ 'c', 'b' ])

    with open("./data/R8.txt", "w") as output_file:
        instances = read_instances("./data/T8.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            l = instance_as_list(instance)
            output_file.write(f"{list_as_str(sauf_dernier(l))}\n")
