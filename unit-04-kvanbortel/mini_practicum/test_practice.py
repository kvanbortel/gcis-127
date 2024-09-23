"""
Author: Kayla Van Bortel
"""

import practice


def test_power_neg():
    # setup
    base = 2
    exponent = -1
    expected = None

    # invoke
    actual = practice.power(base, exponent)

    # analysis
    assert actual == expected


def test_power_0():
    # setup
    base = 2
    exponent = 0
    expected = 1

    # invoke
    actual = practice.power(base, exponent)

    # analysis
    assert actual == expected


def test_power_1():
    # setup
    base = 2
    exponent = 1
    expected = 2

    # invoke
    actual = practice.power(base, exponent)

    # analysis
    assert actual == expected


def test_power_2():
    # setup
    base = 2
    exponent = 2
    expected = 4

    # invoke
    actual = practice.power(base, exponent)

    # analysis
    assert actual == expected


def test_power_3():
    # setup
    base = 2
    exponent = 3
    expected = 8

    # invoke
    actual = practice.power(base, exponent)

    # analysis
    assert actual == expected
