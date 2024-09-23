"""
Author: Kayla Van Bortel
"""

import practice


def test_absolute_difference_2_5():
    # setup
    a = 2
    b = 5
    expected = 3

    # invoke
    actual = practice.absolute_difference(a, b)

    # analysis
    assert actual == expected


def test_absolute_difference_5_2():
    # setup
    a = 5
    b = 2
    expected = 3

    # invoke
    actual = practice.absolute_difference(a, b)

    # analysis
    assert actual == expected


def test_absolute_difference_0_0():
    # setup
    a = 0
    b = 0
    expected = 0

    # invoke
    actual = practice.absolute_difference(a, b)

    # analysis
    assert actual == expected
