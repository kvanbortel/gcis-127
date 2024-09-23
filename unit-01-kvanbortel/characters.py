"""
This program finds the sum and difference of two characters and then prints the corresponding ASCII character.
Author: Kayla Van Bortel
"""


def add_chars(char1, char2):
    """
    Prints the numerical ASCII sum of two characters and then the corresponding ASCII character
    """
    sum = ord(char1) + ord(char2)
    print("Sum is: ", sum)
    print("Resulting character is: ", chr(sum))


def subtract_chars(char1, char2):
    """
    Prints the numerical ASCII diffrence of two characters and then the corresponding ASCII character
    """
    difference = ord(char1) - ord(char2)
    print("Difference is: ", difference)
    print("Resulting character is: ", chr(difference))


def main():
    char1 = input("Enter a character: ")
    char2 = input("Enter a character: ")
    add_chars(char1, char2)
    subtract_chars(char1, char2)


main()

"""
1.) The ASCII table goes from 0 to 127. If a resulting code is outside of this range, there is no character
for it to respond to and thus it throws an error.

2.) The program expected a character, but found a string instead. When you type more than one character in a
row, the type becomes a string. It no longer works because there aren't ASCII codes for strings.
"""
