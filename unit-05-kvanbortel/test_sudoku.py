"""
Author: Kayla Van Bortel
"""

import sudoku


def test_solution_as_list_non_numerical():
    # Setup
    filename = "data/invalid_006.sud"
    expected = None

    # Invoke
    actual = sudoku.solution_as_list(filename)

    # Analyze
    assert actual == expected


def test_solution_as_list_file_not_found():
    # Setup
    filename = "data/not_here.txt"
    expected = None

    # Invoke
    actual = sudoku.solution_as_list(filename)

    # Analyze
    assert actual == expected
