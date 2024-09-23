"""
This program declares and initializes variables, then prints them out
Author: Kayla Van Bortel
"""


def variable_practice():
    """
    Declare and initialize the variables, then print them
    """
    age_in_months = 225
    days_in_a_year = 365
    first_pet_name = "Fido"
    first_five_digits_of_pi = 3.14159

    print(age_in_months, days_in_a_year, first_pet_name, first_five_digits_of_pi)


def functions_practice():
    """
    Declare variables with different expression types
    """
    addition = 1 + 2
    mod = 7 % 2
    floor_division = 14 // 5
    exponent = 2 ** 2

    print(addition, mod, floor_division, exponent)


def prompt_and_print():
    """
    Prompt the user for two numbers and return them added, subtracted, multiplied, and divided
    """
    num1 = input("Enter a number: ")
    num2 = input("Enter a number: ")
    num1 = float(num1)
    num2 = float(num2)

    print(num1, "+", num2, "=", num1 + num2)
    print(num1, "-", num2, "=", num1 - num2)
    print(num1, "*", num2, "=", num1 * num2)
    print(num1, "/", num2, "=", num1 / num2)


def main():
    variable_practice()
    functions_practice()
    prompt_and_print()


main()
