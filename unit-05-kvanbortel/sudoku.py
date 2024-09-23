"""
This program checks to see if a sudoku answer is valid
Author: Kayla Van Bortel
"""

import re

FULL_SET = {'1', '2', '3', '4', '5', '6', '7', '8', '9'}


def solution_as_list(filename):
    """
    This returns the board as a 2D list
    """
    solution_board = []
    try:
        with open(filename) as file:
            for line in file:
                line = line.strip()
                row = []
                for value in line:
                    if not re.match("[1-9]", value):
                        raise ValueError
                    row.append(value)
                solution_board.append(row)
        return solution_board
    except FileNotFoundError:
        print(filename, "not found")
        return None
    except ValueError:
        print(value, "is not a number in", filename)
        return None


def format_board(filename, invalid_row=-1, invalid_column=-1):
    """
    This returns a nicely formatted board with any invalid squares in red
    """
    board = solution_as_list(filename)
    r_count = 0
    c_count = 0
    for row in board:
        r_count += 1
        for value in row:
            c_count += 1
            if invalid_row == r_count - 1 and invalid_column == c_count - 1:
                print("\033[31m" + "[" + value + "]", end="")
            else:
                print("\033[37m" + "[" + value + "]", end="")
            if c_count % 3 == 0:
                print(" ", end="")
            if c_count == 9:
                c_count = 0
        if r_count % 3 == 0:
            print()
        print()


def validate_board(filename):
    """
    This checks to see if the rows, columns, and regions are valid in the solution board
    """
    # Check for valid rows
    board = solution_as_list(filename)
    if board is None:
        return None
    for ri in range(len(board)):
        r_set = set()
        row = board[ri]
        for ci in range(len(row)):
            value = row[ci]
            if value in r_set:  # if the value is already in the set, it's a duplicate and return board
                format_board(filename, ri, ci)
                return False
            r_set.add(value)  # adds new values to the set

    # Check for valid columns
    for ci in range(len(board[0])):
        c_set = set()
        for ri in range(len(board)):
            value = board[ri][ci]
            if value in c_set:
                format_board(filename, ri, ci)
                return False
            c_set.add(value)

    # Check for valid regions
    for r_groupi in range(3):
        row_start = r_groupi * 3
        for c_groupi in range(3):
            col_start = c_groupi * 3
            region = set()
            for ri in range(3):
                for ci in range(3):
                    r = row_start + ri
                    c = col_start + ci
                    value = board[r][c]
                    if value in region:
                        format_board(filename, ri, ci)
                        return False
                    region.add(value)
    return True


def main():
    for validity in ("invalid", "valid"):
        num = 1
        file_found = True
        while file_found:
            file_str = "data/sud_files/" + validity
            if num < 10:
                file_str += "_00" + str(num) + ".sud"
            elif num < 100:
                file_str += "_0" + str(num) + ".sud"
            else:
                file_str += "_" + str(num) + ".sud"
            is_valid = validate_board(file_str)
            if is_valid is None:
                file_found = False
            elif is_valid:
                print("Solution is valid!")
            else:
                print("Solution is not valid!")
            num += 1


if __name__ == "__main__":
    main()
