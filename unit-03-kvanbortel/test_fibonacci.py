"""
Author: Kayla Van Bortel
"""

import fibonacci


def test_fibonacci_naive_0():
    # setup
    n = 0
    expected = None

    # invoke
    actual = fibonacci.fibonacci_naive(n)

    # analysis
    assert actual == expected


def test_fibonacci_naive_1():
    # setup
    n = 1
    expected = 0

    # invoke
    actual = fibonacci.fibonacci_naive(n)

    # analysis
    assert actual == expected


def test_fibonacci_naive_2():
    # setup
    n = 2
    expected = 1

    # invoke
    actual = fibonacci.fibonacci_naive(n)

    # analysis
    assert actual == expected


def test_fibonacci_naive_9():
    # setup
    n = 9
    expected = 21

    # invoke
    actual = fibonacci.fibonacci_naive(n)

    # analysis
    assert actual == expected


def test_fibonacci_fast_0():
    # setup
    n = 0
    expected = None

    # invoke
    actual = fibonacci.fibonacci_fast(n)

    # analysis
    assert actual == expected


def test_fibonacci_fast_1():
    # setup
    n = 1
    expected = 0

    # invoke
    actual = fibonacci.fibonacci_fast(n)

    # analysis
    assert actual == expected


def test_fibonacci_fast_2():
    # setup
    n = 2
    expected = 1

    # invoke
    actual = fibonacci.fibonacci_fast(n)

    # analysis
    assert actual == expected


def test_fibonacci_fast_9():
    # setup
    n = 9
    expected = 21

    # invoke
    actual = fibonacci.fibonacci_fast(n)

    # analysis
    assert actual == expected
