"""
Author: Kayla Van Bortel
"""


def indexing():
    a_string = "Here are some characters"
    print(len(a_string))
    print(a_string[0])
    print(a_string[(len(a_string) - 1)])
    print(a_string[3])
    print(a_string[6])
    print(a_string[-(len(a_string))])
    print(a_string[-1])


def main():
    indexing()


if __name__ == "__main__":
    main()
