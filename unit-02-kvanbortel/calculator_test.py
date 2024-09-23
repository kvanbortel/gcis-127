"""
Author: Kayla Van Bortel
"""

import calculator


def test_add_5_7():
    # setup
    x = 5
    y = 7
    expected = "5 + 7 = 12"

    # invoke
    actual = calculator.add(x, y)

    # analysis
    assert actual == expected


def test_subtract_2_17():
    # setup
    x = 2
    y = 17
    expected = "2 - 17 = -15"

    # invoke
    actual = calculator.subtract(x, y)

    # analysis
    assert actual == expected


def test_multiply_3_9():
    # setup
    x = 3
    y = 9
    expected = "3 * 9 = 27"

    # invoke
    actual = calculator.multiply(x, y)

    # analysis
    assert actual == expected


def test_divide_12_6():
    # setup
    x = 12
    y = 6
    expected = "12 / 6 = 2.0"

    # invoke
    actual = calculator.divide(x, y)

    # analysis
    assert actual == expected


def test_divide_100_0():
    # setup
    x = 100
    y = 0
    expected = "100 / 0 = NaN"

    # invoke
    actual = calculator.divide(x, y)

    # analysis
    assert actual == expected


def test_exponent_10_3():
    # setup
    x = 10
    y = 3
    expected = "10^3 = 1000"

    # invoke
    actual = calculator.exponent(x, y)

    # analysis
    assert actual == expected
