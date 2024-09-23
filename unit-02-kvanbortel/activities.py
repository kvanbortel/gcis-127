"""
Returns the result of boolean expressions
Author: Kayla Van Bortel
"""


def boolean_expressions(a, b, c):
    print(a, b, c)
    print(a, " is greater than ", b, ": ", a > b, sep="")
    print(b, " is equal to ", c, ": ", b == c, sep="")
    print(a, " is less than or equal to ", c, ": ", a <= c, sep="")
    print(a, " is not equal to ", c, ": ", a != c, sep="")
    print(a, " is greater than both ", b, " and ", c, ": ", a > b and a > c, sep="")
    print(b, " is less than ", c, " or ", a, " is less than ", b, ": ", b < c or a < b, sep="")


def main():
    boolean_expressions(1, 2, 3)
    boolean_expressions(5, 2, 7)
    boolean_expressions(7, 10, 1)


main()
