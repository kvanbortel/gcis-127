"""
Five-function calculator
Author: Kayla Van Bortel
"""


def add(x, y):
    """
    Add two numbers
    """
    return str(x) + " + " + str(y) + " = " + str(x + y)


def subtract(x, y):
    """
    Subtract two numbers
    """
    return str(x) + " - " + str(y) + " = " + str(x - y)


def multiply(x, y):
    """
    Multiply two numbers
    """
    return str(x) + " * " + str(y) + " = " + str(x * y)


def divide(x, y):
    """
    Divide two numbers
    """
    s = str(x) + " / " + str(y) + " = "
    if y == 0:
        return s + "NaN"
    return s + str(x / y)


def exponent(x, y):
    """
    Raises x to the y
    """
    return str(x) + "^" + str(y) + " = " + str(x ** y)


def main():
    x = int(input("Enter x: "))
    y = int(input("Enter y: "))
    print(add(x, y))
    print(subtract(x, y))
    print(multiply(x, y))
    print(divide(x, y))
    print(exponent(x, y))


if __name__ == "__main__":
    main()
