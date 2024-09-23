"""
Author: Kayla Van Bortel
"""

import sorts


def test_shift_reverse_4():
    # setup
    a_list = [5, 4, 3, 2, 1]
    index = 4
    expected = [1, 5, 4, 3, 2]

    # invoke
    sorts.shift(a_list, index)

    # analysis
    assert expected == a_list


def test_shift_reverse_1():
    # setup
    a_list = [5, 4, 3, 2, 1]
    index = 1
    expected = [4, 5, 3, 2, 1]

    # invoke
    sorts.shift(a_list, index)

    # analysis
    assert expected == a_list


def test_shift_1_0():
    # setup
    a_list = [1]
    index = 0
    expected = [1]

    # invoke
    sorts.shift(a_list, index)

    # analysis
    assert expected == a_list


def test_insertion_sort_random_10():
    # setup
    a_list = [10, 50, 45, 23, 18, 99, 3, 12, 74, 6]
    expected = [3, 6, 10, 12, 18, 23, 45, 50, 74, 99]

    # invoke
    actual = sorts.insertion_sort(a_list)

    # analysis
    assert expected == actual


def test_insertion_sort_sorted_10():
    # setup
    a_list = list(range(10))
    expected = list(range(10))

    # invoke
    actual = sorts.insertion_sort(a_list)

    # analysis
    assert expected == actual


def test_insertion_sort_reverse_10():
    # setup
    a_list = list(range(9, -1, -1))
    expected = list(range(10))

    # invoke
    actual = sorts.insertion_sort(a_list)

    # analysis
    assert expected == actual


def test_quicksort_reverse():
    a_list = [5, 4, 3, 2, 1]
    expected = [1, 2, 3, 4, 5]

    actual = sorts.quicksort(a_list)

    assert actual == expected


def test_quicksort_base():
    a_list = [1]
    expected = [1]

    actual = sorts.quicksort(a_list)

    assert actual == expected
