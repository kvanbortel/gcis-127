"""
Author: Kayla Van Bortel
"""


def shift(a_list, index):
    """
    Beginning Insertion Sort
    """
    target = a_list[index]
    while index > 0 and target < a_list[index - 1]:
        a_list[index] = a_list[index - 1]
        index -= 1
    a_list[index] = target


def insertion_sort(a_list):
    for index in range(1, len(a_list)):
        shift(a_list, index)
    return a_list


def split(a_list):
    mid = (len(a_list) + 1) // 2  # bigger half is the left half
    half1 = a_list[:mid]
    half2 = a_list[mid:]
    return half1, half2


def merge(left, right):
    merged = []
    i1 = 0  # left index
    i2 = 0  # right index
    while (i1 < len(left)) and (i2 < len(right)):
        if left[i1] <= right[i2]:
            merged.append(left[i1])
            i1 += 1
        else:
            merged.append(right[i2])
            i2 += 1
    if i1 < len(left):
        merged += left[i1:]
    else:
        merged += right[i2:]
    return merged


def merge_sort(a_list):
    if len(a_list) <= 1:
        return a_list
    else:
        left, right = split(a_list)
        merged = merge(merge_sort(left), merge_sort(right))
        return merged


def partition(a_list, pivot):
    less = []
    same = []
    more = []
    for i in range(len(a_list)):
        if a_list[i] < pivot:
            less.append(a_list[i])
        elif a_list[i] > pivot:
            more.append(a_list[i])
        else:
            same.append(a_list[i])
    return less, same, more


def quicksort(a_list):
    if len(a_list) < 2:
        return a_list
    else:
        pivot = a_list[0]
        less, same, more = partition(a_list, pivot)
        sorted_less = quicksort(less)
        sorted_more = quicksort(more)
    return sorted_less + same + sorted_more


def main():
    print(split([1, 2, 3, 4, 5]))
    print(split([1, 2, 4, 5]))
    print(merge_sort([6, 5, 4, 3, 2, 1]))
    print(merge_sort([1]))
    print(merge_sort([5, 4, 3, 2, 1]))
    print(merge_sort([1, 2, 3, 4, 5]))
    print(quicksort([5, 4, 3, 2, 1]))


if __name__ == "__main__":
    main()
