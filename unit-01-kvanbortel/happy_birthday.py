"""
This program formats your birthday into a message.
Author: Kayla Van Bortel
"""


def bday_message():
    """
    Asks for birthday data and then prints a message with it
    """
    name = input("Enter your name: ")
    birth_month = input("Enter your birth month: ")
    birth_day = input("Enter your birth day: ")
    birth_year = input("Enter your birth year: ")

    print(name, ", your birthday is on", birth_month, birth_day, ",", birth_year, "!")


def main():
    bday_message()
    bday_message()
    bday_message()


main()
