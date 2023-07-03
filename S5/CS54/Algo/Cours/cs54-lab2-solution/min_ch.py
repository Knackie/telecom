from typing import List
from cs54_list import nil, head, tail, add, instance_as_list
from cs54_tools import read_instances, print_error_on_assertion


def min_ch_helper(list: List[str], current_min: str) -> str:
    if nil(list):
        return current_min
    else:
        return min_ch_helper(tail(list), min(head(list), current_min))


@print_error_on_assertion
def min_ch(list: List[str]) -> str:
    assert len(list) > 0
    return min_ch_helper(tail(list), head(list))


if __name__ == "__main__":
    # l = []
    # l = add('b', l)
    # assert(min_ch(l) == 'b')
    # l = add('a', l)
    # assert(min_ch(l) == 'a')
    # l = add('c', l)
    # assert(min_ch(l) == 'a')

    with open("./data/R14.txt", "w") as output_file:
        instances = read_instances("./data/T14.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            l = instance_as_list(instance)
            output_file.write(f"{min_ch(l)}\n")
