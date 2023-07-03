from typing import List
import functools


def nil(list: List[str]) -> bool:
    return list == []


def head(list: List[str]) -> str:
    assert len(list) >= 1, "head() is not defined for an empty list"
    return list[0]


def tail(list: List[str]) -> List[str]:
    assert len(list) >= 1, "tail() is not defined for an empty list"
    return list[1:]


def add(c: str, list: List[str]) -> List[str]:
    return [c] + list


def instance_as_list(instance_str: str) -> List[str]:
    return functools.reduce(lambda one_list, c: add(c, one_list), reversed(instance_str), [])


def list_as_str(list: List[str]) -> str:
    return functools.reduce(lambda s, c: s + str(c), list, "")


if __name__ == "__main__":
    l = []

    try:
        head(l)
        raise ValueError("head should not be defined for empty list.")
    except AssertionError:
        pass

    try:
        tail([])
        raise ValueError("head should not be defined for empty list.")
    except AssertionError:
        pass

    l = add("c", l)
    assert head(l) == "c"
    assert nil(tail(l))
    l = add("b", l)
    assert tail(l) == ["c"]
    l = add("a", l)
    assert tail(l) == ["b", "c"]
    assert ["a", "b", "c"] == l
