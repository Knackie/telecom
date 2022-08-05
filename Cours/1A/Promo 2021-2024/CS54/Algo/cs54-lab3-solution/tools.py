import time

def verbose(decorated):
    """Decorator to apply to any function definition.
    It will print the function name and its arguments for each function calls.

    Args:
        decorated: the function to be decorated

    Returns:
        the result of the decorated function.
    """
    prof = 0

    def inner(*args, **kwargs):
        nonlocal prof
        dec = "   " * prof
        print(f"{dec}{decorated.__name__}{str(args)[:100]}", "")
        prof += 1
        res = decorated(*args, **kwargs)
        print(f"{dec} = {str(res)[:100]}")
        prof -= 1
        return res

    return inner


def timeit(decorated):
    """Decorator to apply to any function definition.
    It will print the execution time of the function.

    Args:
        decorated: the function to be decorated

    Returns:
        the result of the decorated function.
    """

    def inner(*args, **kwargs):
        start = time.perf_counter()
        res = decorated(*args, **kwargs)
        end = time.perf_counter()
        print(f'{decorated.__name__}{args} tooks {end-start:2f} sec.')

        return res

    return inner