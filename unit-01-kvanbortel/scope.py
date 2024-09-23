"""
This program tests different examples of variable scopes
Author: Kayla Van Bortel
"""
INT_DOZEN = 12
LETTER_A = "A"
FLOAT_THREE = 3.0


def print_param(p):
    """
    Prints the argument passed to it
    """
    print(p)


def print_local():
    """
    Prints the local variable declared in the function
    """
    local = 4
    print(local)


def print_which(INT_DOZEN):
    """
    Prints the local variable declared in the function
    """
    INT_DOZEN = 15
    print(INT_DOZEN)


def main():
    print_param(INT_DOZEN)
    print_param(LETTER_A)
    print_param(FLOAT_THREE)
    local = 13  # noqa: F841
    print_local()
    print_which(INT_DOZEN)


main()
