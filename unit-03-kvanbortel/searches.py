"""
Author: Kayla Van Bortel
"""


def linear_search(a_list, target):
    """
    Searches a list for a target value and returns the index
    """
    for index in range(len(a_list)):
        if a_list[index] == target:
            return index
    return None


def binary_search(a_list, target, start=0, end=None):
    if end is None:
        end = len(a_list) - 1
    if start > end:
        return None
    mid = (start + end) // 2
    value = a_list[mid]
    if value == target:
        return mid
    elif value < target:  # target is to the right
        return binary_search(a_list, target, mid + 1, end)
    elif value > target:  # target is to the left
        return binary_search(a_list, target, start, mid - 1)


def main():
    print(linear_search(list(range(1, 101)), 1))
    print(linear_search(list(range(1, 101)), 50))
    print(linear_search(list(range(1, 101)), 100))
    print(linear_search(list(range(1, 101)), 101))


if __name__ == "__main__":
    main()
