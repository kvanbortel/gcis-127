"""
Author: Kayla Van Bortel
"""

import random


def random_list(size, min_value=0, max_value=None):
    """
    Generates a list of random numbers
    """
    rlist = []
    if max_value is None:
        max_value = size
    for _ in range(size):
        rlist.append(random.randint(int(min_value), int(max_value)))
    return rlist


def range_list(start, stop, step=1):
    """
    Generates a list given range parameters
    """
    # rlist = list(range(start, stop, step))
    a_range = range(start, stop, step)
    rlist = []
    for each in a_range:
        rlist.append(each)
    return rlist


def main():
    random.seed(1)
    print(random_list(10))
    print(range_list(10, 20, 1))
    print(range_list(8, 28, 2))


if __name__ == "__main__":
    main()
