#!/usr/bin/env python3

from typing import List, Tuple, Set, Deque
from collections import deque

# return new containers state
def transfert(src: int, dst: int, containers: List[int], capacities: List[int]) -> Tuple[str, List[int]]:
    new_containers = containers.copy()

    fountain_index = len(capacities)

    if src == fountain_index:
        # assert new_containers[dst] < capacities[dst] # this assert was useful to detect useless transfert
        new_containers[dst] = capacities[dst]
        action_str = f"Remplir({dst})"
    elif dst == fountain_index:
        # assert new_containers[src] > 0 # this assert was useful to detect useless transfert
        new_containers[src] = 0
        action_str = f"Vider({src})"
    else:
        # assert(capacities[dst] - containers[dst] > 0) # this assert was useful to detect useless transfert

        available_volume_in_dst = capacities[dst] - new_containers[dst]
        volume_to_transfert = min(new_containers[src], available_volume_in_dst)
        new_containers[src] -= volume_to_transfert
        new_containers[dst] += volume_to_transfert
        action_str = f"Transvaser({src}, {dst})"

    return action_str, new_containers


def find_one_solution_rec(
    depth: int, target_volume: int, containers: List[int], capacities: List[int], log: List[str]
) -> Tuple[bool, List[str]]:
    if depth <= 0:
        return False, log

    fountain_index = len(capacities)

    # index == len(containers) is reserved for fountain
    for src in range(0, len(containers) + 1):
        for dst in range(0, len(containers) + 1):

            # skip transfert from and to the same container
            # including src == fountain_index and dst == fountain_index:
            if src == dst:
                continue
            # skip transfert from an empty container
            if src != fountain_index and containers[src] == 0:
                continue
            # skip transfert to a full container
            if dst != fountain_index and containers[dst] == capacities[dst]:
                continue

            # containers do not change, therefore we do not need to save them
            # apply transfert and register actions in log
            action_str, new_containers = transfert(src, dst, containers, capacities)

            if (src != fountain_index and new_containers[src] == target_volume) or (
                dst != fountain_index and new_containers[dst] == target_volume
            ):
                log.append(action_str)
                return True, log
            else:
                log.append(action_str)

            found, log = find_one_solution_rec(depth - 1, target_volume, new_containers, capacities, log)
            if found:
                return found, log
            # restore containers state / nothing to do since we work on new_containers was a copy
            # but we need to unregister the last action in the log
            log.pop()
    return False, log


def find_one_solution(max_depth: int, target_volume: int, capacities: List[int]) -> Tuple[bool, List[str]]:
    return find_one_solution_rec(max_depth, target_volume, [0] * len(capacities), capacities, list())


assert find_one_solution(6, 4, [5, 3]) == (
    True,
    ["Remplir(0)", "Transvaser(0, 1)", "Vider(1)", "Transvaser(0, 1)", "Remplir(0)", "Transvaser(0, 1)"],
)
assert find_one_solution(4, 6, [8, 5, 3]) == (
    True,
    ["Remplir(0)", "Transvaser(0, 1)", "Transvaser(1, 2)", "Transvaser(2, 0)"],
)
assert find_one_solution(8, 4, [100, 24, 25]) == (
    True,
    [
        "Remplir(0)",
        "Transvaser(0, 1)",
        "Transvaser(1, 2)",
        "Transvaser(0, 1)",
        "Vider(1)",
        "Transvaser(0, 1)",
        "Vider(1)",
        "Transvaser(0, 1)",
    ],
)

# too long ;(
# print(find_one_solution(14, 5, [100, 24, 25]))


def find_one_solution_with_memoization_rec(
    depth: int,
    target_volume: int,
    containers: List[int],
    capacities: List[int],
    log: List[str],
    memory: Set[Tuple[int, ...]],
) -> Tuple[bool, List[str]]:
    if depth <= 0:
        return False, log

    fountain_index = len(capacities)

    # index == len(containers) is reserved for fountain
    for src in range(0, len(containers) + 1):
        for dst in range(0, len(containers) + 1):

            # skip transfert from and to the same container
            # including src == fountain_index and dst == fountain_index:
            if src == dst:
                continue
            # skip transfert from an empty container
            if src != fountain_index and containers[src] == 0:
                continue
            # skip transfert to a full container
            if dst != fountain_index and containers[dst] == capacities[dst]:
                continue

            # containers do not change, therefore we do not need to save them
            # apply transfert and register actions in log
            action_str, new_containers = transfert(src, dst, containers, capacities)

            # check if we already evaluated this state
            # if yes, continue (no evaluation, no recursive search)
            new_state = tuple(new_containers)
            if new_state in memory:
                continue
            else:
                memory.add(new_state)

            if (src != fountain_index and new_containers[src] == target_volume) or (
                dst != fountain_index and new_containers[dst] == target_volume
            ):
                log.append(action_str)
                return True, log

            log.append(action_str)
            found, log = find_one_solution_with_memoization_rec(
                depth - 1, target_volume, new_containers, capacities, log, memory
            )
            if found:
                return found, log
            # restore containers state / nothing to do since we work on new_containers was a copy
            # but we need to unregister the last action in the log
            log.pop()
    return False, log


def find_one_solution_with_memoization(
    max_depth: int, target_volume: int, capacities: List[int]
) -> Tuple[bool, List[str]]:
    return find_one_solution_with_memoization_rec(
        max_depth, target_volume, [0] * len(capacities), capacities, list(), set()
    )


assert find_one_solution_with_memoization(6, 4, [5, 3]) == (
    True,
    ["Remplir(0)", "Transvaser(0, 1)", "Vider(1)", "Transvaser(0, 1)", "Remplir(0)", "Transvaser(0, 1)"],
)
assert find_one_solution_with_memoization(4, 6, [8, 5, 3]) == (
    True,
    ["Remplir(0)", "Transvaser(0, 1)", "Transvaser(1, 2)", "Transvaser(2, 0)"],
)
assert find_one_solution_with_memoization(8, 4, [100, 24, 25]) == (
    True,
    [
        "Remplir(0)",
        "Transvaser(0, 1)",
        "Transvaser(1, 2)",
        "Transvaser(0, 1)",
        "Vider(1)",
        "Transvaser(0, 1)",
        "Vider(1)",
        "Transvaser(0, 1)",
    ],
)

assert find_one_solution_with_memoization(14, 5, [100, 24, 25]) == (
    True,
    [
        "Remplir(0)",
        "Transvaser(0, 1)",
        "Transvaser(0, 2)",
        "Vider(1)",
        "Transvaser(0, 1)",
        "Vider(1)",
        "Transvaser(0, 1)",
        "Vider(1)",
        "Transvaser(2, 1)",
        "Vider(1)",
        "Transvaser(2, 1)",
        "Remplir(2)",
        "Transvaser(2, 0)",
        "Transvaser(0, 1)",
    ],
)

found_solution, solution = find_one_solution_with_memoization(1000, 42, [100, 24, 25])
assert found_solution
assert len(solution) == 227


def find_one_solution_breadth_first_search(target_volume: int, capacities: List[int]) -> Tuple[bool, List[str]]:
    containers = list()
    fountain_index = len(capacities)

    states_already_explored: Set[Tuple[int, ...]] = set()
    states_to_explore: Deque[Tuple[List[int], List[str]]] = Deque()
    states_to_explore.append(([0] * len(capacities), list()))

    solution_found = False

    while not solution_found or not states_to_explore:
        containers, log = states_to_explore.popleft()

        # index == len(containers) is reserved for fountain
        for src in range(0, len(containers) + 1):
            for dst in range(0, len(containers) + 1):
                # skip transfert from and to the same container
                # including src == fountain_index and dst == fountain_index:
                if src == dst:
                    continue
                # skip transfert from an empty container
                if src != fountain_index and containers[src] == 0:
                    continue
                # skip transfert to a full container
                if dst != fountain_index and containers[dst] == capacities[dst]:
                    continue

                # containers do not change, therefore we do not need to save them
                # apply transfert and register actions in log
                action_str, new_containers = transfert(src, dst, containers, capacities)

                # check if we already evaluated this state
                # if yes, continue (no evaluation, no recursive search)
                new_state = tuple(new_containers)
                if new_state in states_already_explored:
                    continue
                else:
                    duplicated_log = list(log)
                    duplicated_log.append(action_str)
                    if (src != fountain_index and new_containers[src] == target_volume) or (
                        dst != fountain_index and new_containers[dst] == target_volume
                    ):
                        return True, duplicated_log
                    else:
                        states_already_explored.add(new_state)
                        states_to_explore.append((new_containers, duplicated_log))
        pass
    return False, list()


assert find_one_solution_breadth_first_search(42, [100, 24, 25]) == (
    True,
    [
        "Remplir(1)",
        "Transvaser(1, 0)",
        "Remplir(1)",
        "Transvaser(1, 0)",
        "Transvaser(0, 2)",
        "Transvaser(2, 1)",
        "Transvaser(1, 0)",
        "Transvaser(2, 1)",
        "Transvaser(0, 2)",
        "Transvaser(2, 1)",
        "Transvaser(1, 0)",
        "Remplir(1)",
        "Transvaser(1, 0)",
        "Remplir(1)",
        "Transvaser(1, 0)",
        "Remplir(1)",
        "Transvaser(1, 0)",
        "Vider(0)",
        "Transvaser(1, 0)",
        "Remplir(1)",
        "Transvaser(1, 0)",
    ],
)


found_solution, solution = find_one_solution_breadth_first_search(1, [34, 55, 89, 144])
assert found_solution
assert len(solution) == 66


def replay_solution_log(capacities: List[int], actions_log: List[str], expected_volume: int = None):
    containers = [0] * len(capacities)

    for action in actions_log:
        verb, _, params = action[:-1].partition("(")
        params = tuple(map(int, params.split(",")))

        if verb == "Remplir":
            dst = params[0]
            containers[dst] = capacities[dst]
        elif verb == "Vider":
            src = params[0]
            containers[src] = 0
        elif verb == "Transvaser":
            src = params[0]
            dst = params[1]
            available_volume_in_dst = capacities[dst] - containers[dst]
            volume_to_transfert = min(containers[src], available_volume_in_dst)
            containers[src] -= volume_to_transfert
            containers[dst] += volume_to_transfert
        else:
            assert False, f"Warning unknown action named {verb} "

    if expected_volume:
        if expected_volume in containers:
            print(f"{expected_volume} was found in ", end="")
        else:
            print(f"{expected_volume} was not found in ", end="")
    print(containers)


instance = [34, 55, 89, 144]
target_volume = 1

print(f'Looking for a solution for: capacities={instance}, volume={target_volume}... ')
found_solution, actions_log = find_one_solution_breadth_first_search(target_volume, instance)
if not found_solution:
    print('Could not find a solution.')
else:
    print('Solution found.')
    print('Replaying solution... ', end='')
    replay_solution_log(instance, actions_log, target_volume)
