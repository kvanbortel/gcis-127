"""
Author: Kayla Van Bortel
"""

import searches


def test_binary_search_midpoint_7():
    # setup
    a_list = [1, 3, 5, 7, 9, 11, 13]
    target = 7
    expected = 3

    # invoke
    actual = searches.binary_search(a_list, target)

    # analysis
    assert actual == expected


def test_binary_search_11():
    # setup
    a_list = [1, 3, 5, 7, 9, 11, 13]
    target = 11
    expected = 5

    # invoke
    actual = searches.binary_search(a_list, target)

    # analysis
    assert actual == expected


def test_binary_search_3():
    # setup
    a_list = [1, 3, 5, 7, 9, 11, 13]
    target = 3
    expected = 1

    # invoke
    actual = searches.binary_search(a_list, target)

    # analysis
    assert actual == expected


def test_binary_search_none():
    # setup
    a_list = [1, 3, 5, 7, 9, 11, 13]
    target = 8
    expected = None

    # invoke
    actual = searches.binary_search(a_list, target)

    # analysis
    assert actual == expected
