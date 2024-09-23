import random


def make_table(rows, columns, value):
    table = []
    for _ in range(rows):
        row = []
        for _ in range(columns):
            row.append(value)
        table.append(row)
    return table


def make_table2(rows, columns):
    print([[random.randrange(10) for i in range(columns)] for j in range(rows)])


def make_table3(rows, columns, value):
    return list([[value] * columns] * rows)


def insertion_sort(a_list):
    """
    Check if leftmost is less than rightmost
    """
    if len(a_list) <= 1:
        return a_list
    for i in range(1, len(a_list)):
        while i > 0 and a_list[i] < a_list[i - 1]:
            temp = a_list[i]
            a_list[i] = a_list[i - 1]
            a_list[i - 1] = temp
            i -= 1
    return a_list


def split(a_list):
    mid = len(a_list) // 2
    return a_list[:mid], a_list[mid:]


def merge(left, right):
    merged = []
    il = 0
    ir = 0
    while (il < len(left)) and (ir < len(right)):
        if left[il] <= right[ir]:
            merged.append(left[il])
            il += 1
        else:
            merged.append(right[ir])
            ir += 1
    if il < len(left):
        merged += left[il:]
    else:
        merged += right[ir:]
    return merged


def merge_sort(a_list):
    """
    Break apart until lists of length one.
    Merge by which value is less than or greater than.
    """
    if len(a_list) <= 1:
        return a_list
    else:
        left, right = split(a_list)
        left = merge_sort(left)
        right = merge_sort(right)
        merged = merge(left, right)
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
    # print(make_table(3, 4, 5))
    # make_table2(3, 4)
    # print(make_table3(3, 4, 5))
    print(insertion_sort([5, 4, 3, 2, 1]))
    print(merge_sort([5, 4, 3, 2, 1]))
    print(quicksort([5, 4, 3, 2, 1]))


if __name__ == "__main__":
    main()
