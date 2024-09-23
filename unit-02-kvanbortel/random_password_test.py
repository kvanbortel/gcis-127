"""
Author: Kayla Van Bortel
"""

import random_password


def test_create_ascii_range_string():
    # steup
    start = 97
    stop = 100
    expected = "abc"

    # invoke
    actual = random_password.create_ascii_range_string(start, stop)

    # analysis
    assert actual == expected


def test_create_uppercase_letters_string():
    # setup
    expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    # invoke
    actual = random_password.create_uppercase_letters_string()

    # analysis
    assert actual == expected


def test_create_lowercase_letters_string():
    # setup
    expected = "abcdefghijklmnopqrstuvwxyz"

    # invoke
    actual = random_password.create_lowercase_letters_string()

    # analysis
    assert actual == expected


def test_create_digits_string():
    # setup
    expected = "0123456789"

    # invoke
    actual = random_password.create_digits_string()

    # analysis
    assert actual == expected


def test_create_symbols_string():
    # setup
    expected = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~"

    # invoke
    actual = random_password.create_symbols_string()

    # analysis
    assert actual == expected


def test_get_random_char_from_string():
    # setup
    a_string = "ab"
    expected1 = "a"
    expected2 = "b"

    # invoke
    actual = random_password.get_random_char_from_string(a_string)

    # analysis
    assert actual == expected1 or expected2
