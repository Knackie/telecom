#!/usr/bin/env python3

from typing import List, Tuple

def take(object_index: int, bag: List[bool]) -> List[bool]:
    bag[object_index] = True
    return bag


def drop(object_index: int, bag: List[bool]) -> List[bool]:
    bag[object_index] = False
    return bag


def weight(bag: List[bool], weights: List[int]):
    return sum((weight * bag[index] for index, weight in enumerate(weights)))


assert take(2, [False, False, False, False]) == [False, False, True, False]
assert drop(2, [True, True, True, True]) == [True, True, False, True]
assert weight([True, False, False, True], [5, 4, 3, 2]) == 7


def find_one_best_solution_rec(
    capacity: int, weights: List[int], depth: int, bag: List[bool], best_bag: List[bool]
) -> List[bool]:
    """This function looks for one of the best solution of the knapsack problem
    (which objects to take to maximise the profit while keeping  total weight of the bag below its initial capacity).

    Args:
        capacity (int): remaining capacity of the bag. Each taken object decreases the capacity by its weight.
        weights (List[int]): objects weights.
        depth (int): lookup depth.
        bag (List[bool]): current bag, bag[i] is True is object i is inside the bag.
        best_bag (List[bool]): best solution found until now.

    Returns:
        List[bool]: a bag that is the best solution found.
    """
    if weight(bag, weights) >= weight(best_bag, weights):
        best_bag = list(bag)

    if depth >= len(weights):
        return best_bag

    if weights[depth] <= capacity:
        bag = take(depth, bag)
        best_bag = find_one_best_solution_rec(capacity - weights[depth], weights, depth + 1, bag, best_bag)
        bag = drop(depth, bag)

    best_bag = find_one_best_solution_rec(capacity, weights, depth + 1, bag, best_bag)

    return best_bag


def generic_find_one_best_solution_rec(
    capacity: int, weights: List[int], depth: int, bag: List[bool], best_bag: List[bool]
) -> List[bool]:
    """This function looks for one of the best solution of the knapsack problem
    (which objects to take to maximise the profit while keeping  total weight of the bag below its initial capacity).

    **This function is written using the classical template of a backtracking search.**

    Args:
        capacity (int): initial capacity of the bag. It is not updated during the lookup.
        weights (List[int]): objects weights.
        depth (int): lookup depth.
        bag (List[bool]): current bag, bag[i] is True is object i is inside the bag.
        best_bag (List[bool]): best solution found until now.

    Returns:
        List[bool]: a bag that is the best solution found.
    """
    if depth >= len(weights):
        return best_bag

    for action in [True, False]:
        # store "old state"
        old_value = bag[depth]

        # perform "action"
        bag[depth] = action

        if weight(bag, weights) <= capacity:
            if weight(bag, weights) >= weight(best_bag, weights):
                best_bag = list(bag)  # make a copy of bag

            best_bag = generic_find_one_best_solution_rec(capacity, weights, depth + 1, bag, best_bag)

        # cancel "action" / restore "old state"
        bag[depth] = old_value

    return best_bag


def find_one_best_solution(capacity: int, weights: List[int]) -> List[bool]:
    # return find_one_best_solution_rec(capacity, weights, 0, [ False ] * len(weights), [ False ] * len(weights))
    return generic_find_one_best_solution_rec(capacity, weights, 0, [False] * len(weights), [False] * len(weights))


# warning, some problems have multiple solutions therefore the assert might fails with another implementations
assert find_one_best_solution(4, [3, 2, 2]) == [False, True, True]
assert find_one_best_solution(8, [5, 4, 3, 2]) == [True, False, True, False]
assert find_one_best_solution(10, [5, 4, 3, 2]) == [True, False, True, True]
assert find_one_best_solution(10, [5, 4, 3, 3]) == [False, True, True, True]


def generic_find_all_best_solutions_rec(
    capacity: int, weights: List[int], depth: int, bag: List[bool], best_bags: List[List[bool]], best_weight: int
) -> Tuple[int, List[List[bool]]]:
    """This function looks for all the best solutions of the knapsack problem
    (which objects to take to maximise the profit while keeping  total weight of the bag below its initial capacity).

    **This function is written using the classical template of a backtracking search.**

    Args:
        capacity (int): initial capacity of the bag. It is not updated during the lookup.
        weights (List[int]): objects weights.
        depth (int): lookup depth.
        bag (List[bool]): current bag, bag[i] is True is object i is inside the bag.
        best_bags (List[List[bool]]): best solutions found until now.
        best_weight (int): weight of the best bags (of course, all best bags have the same weight).

    Returns:
        Tuple[int, List[List[bool]]: tuple that contains (maximal weight found, list of all bests bags whose weight is maximal).
    """
    if depth >= len(weights):
        return best_weight, best_bags

    for action in [True, False]:
        # store "old state"
        old_value = bag[depth]

        # perform "action"
        bag[depth] = action

        if weight(bag, weights) <= capacity:
            expected_weight = weight(bag, weights)
            if expected_weight >= best_weight:
                if expected_weight > best_weight:
                    best_bags.clear()
                if bag not in best_bags:
                    best_bags.append(list(bag))  # make a copy of bag
                best_weight = expected_weight

            best_weight, best_bags = generic_find_all_best_solutions_rec(
                capacity, weights, depth + 1, bag, best_bags, best_weight
            )

        # cancel "action" / restore "old state"
        bag[depth] = old_value

    return best_weight, best_bags


def find_all_best_solutions(capacity: int, weights: List[int]) -> Tuple[int, List[List[bool]]]:
    return generic_find_all_best_solutions_rec(capacity, weights, 0, [False] * len(weights), list(), 0)


assert find_all_best_solutions(4, [3, 2, 2]) == (4, [[False, True, True]])
assert find_all_best_solutions(8, [5, 4, 3, 2]) == (8, [[True, False, True, False]])
assert find_all_best_solutions(10, [5, 4, 3, 2]) == (10, [[True, False, True, True]])
assert find_all_best_solutions(10, [5, 4, 3, 3]) == (10, [[False, True, True, True]])

expected_solutions = [
    [True, True, True, False, True, True, False],
    [True, True, True, False, False, True, True],
    [True, False, True, True, True, False, False],
    [True, False, True, True, False, False, True],
    [True, False, False, True, True, True, True],
    [False, True, True, True, False, False, False],
    [False, True, False, True, True, True, False],
    [False, True, False, True, False, True, True],
]
computed_weight, computed_solutions = find_all_best_solutions(15, [2, 3, 5, 7, 1, 4, 1])
assert computed_weight == 15
for expected_solution in expected_solutions:
    assert expected_solution in computed_solutions


def profit(bag: List[bool], prices: List[int]):
    return sum((profit * bag[index] for index, profit in enumerate(prices)))


def generic_find_all_best_loot_solutions_rec(
    capacity: int,
    weights: List[int],
    prices: List[int],
    depth: int,
    bag: List[bool],
    best_bags: List[List[bool]],
    best_profit: int,
) -> Tuple[int, List[List[bool]]]:
    """This function looks for all the best solutions of the knapsack problem
    (which objects to take to maximise the profit while keeping  total weight of the bag below its initial capacity).

    **This function is written using the classical template of a backtracking search.**

    Args:
        capacity (int): initial capacity of the bag. It is not updated during the lookup.
        weights (List[int]): objects weights.
        prices (List[int]): objects prices.
        depth (int): lookup depth.
        bag (List[bool]): current bag, bag[i] is True is object i is inside the bag.
        best_bags (List[List[bool]]): best solutions found until now.
        best_profit (int): profit of the best bags (of course, all best bags have the same profit).

    Returns:
        Tuple[int, List[List[bool]]: tuple that contains (maximal profit found, list of all bests bags whose profit is maximal).
    """
    if depth >= len(weights):
        return best_profit, best_bags

    for action in [True, False]:
        # store "old state"
        old_value = bag[depth]

        # perform "action"
        bag[depth] = action

        if weight(bag, weights) <= capacity:
            expected_profit = profit(bag, prices)
            if expected_profit >= best_profit:
                if expected_profit > best_profit:
                    best_bags.clear()
                if bag not in best_bags:
                    best_bags.append(list(bag))  # make a copy of bag
                best_profit = expected_profit

            best_profit, best_bags = generic_find_all_best_loot_solutions_rec(
                capacity, weights, prices, depth + 1, bag, best_bags, best_profit
            )

        # cancel "action" / restore "old state"
        bag[depth] = old_value

    return best_profit, best_bags


def find_all_best_loot_solutions(capacity: int, weights: List[int], prices: List[int]) -> Tuple[int, List[List[bool]]]:
    return generic_find_all_best_loot_solutions_rec(capacity, weights, prices, 0, [False] * len(weights), list(), 0)


# if weights == profits then it should compute the previously obtained results
assert find_all_best_loot_solutions(10, [5, 4, 3, 2], [5, 4, 3, 2]) == (10, [[True, False, True, True]])

assert find_all_best_loot_solutions(20, [18, 15, 10], [25, 24, 15]) == (25, [[True, False, False]])
assert find_all_best_loot_solutions(15, [2, 3, 5, 7, 1, 4, 1], [10, 5, 15, 7, 6, 18, 3]) == (
    54,
    [[True, True, True, False, True, True, False]],
)
