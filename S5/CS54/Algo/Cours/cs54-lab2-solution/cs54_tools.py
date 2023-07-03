from typing import List, Tuple


def read_instances(filename: str) -> List:
    with open(filename, "r") as input_file:
        instance_count = int(input_file.readline())
        instances = [instance.strip() for instance in input_file.readlines()]
        assert instance_count == len(instances)
        return instances


def split_instance(instance: str) -> Tuple[str,...]:
    return tuple(map(str.strip, instance.split(",")))


def print_error_on_assertion(func):
    def decorator(*args, **kwargs):
        try:
            return func(*args)
        except AssertionError:
            return "ASSERTION ERROR"

    return decorator


def print_error_on_recursion_limit(func):
    def decorator(*args, **kwargs):
        try:
            return func(*args)
        except RecursionError:
            return "ERROR (RECURSION OVERFLOW)"

    return decorator


if __name__ == "__main__":
    instances = read_instances("./data/T1.txt")
    print(instances)

    instances = read_instances("./data/T3.txt")
    instances = [split_instance(instance) for instance in instances]
    print(instances)
