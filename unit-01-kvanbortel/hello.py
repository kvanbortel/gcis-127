"""
This program prints "Hello, World!" and then says hello to the name you enter.
Author: Kayla Van Bortel
"""


def hello_world():
    """
    Prints "Hello, World!"
    """
    print("Hello, World!")  # print "Hello, world!"


def hello_you():
    """
    Prints a personalized hello message
    """
    name = input('Enter your name: ')  # get user's name
    print("Hello,", name)  # print personalized message


def main():
    hello_world()
    hello_you()


main()
