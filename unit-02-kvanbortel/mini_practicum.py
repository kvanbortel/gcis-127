"""
Author: Kayla Van Bortel
"""


def convert_height():
    height = input("Enter your height in inches: ")
    feet = int(height) // 12
    inches = int(height) % 12
    print("You are ", feet, "\' ", inches, "\"", " tall", sep="")


def before(letter):
    letter_number = ord(letter)
    print(chr(letter_number))
    print(chr(letter_number - 1))
    print(chr(letter_number - 2))
    print(chr(letter_number - 3))


def main():
    convert_height()
    before("X")


main()
