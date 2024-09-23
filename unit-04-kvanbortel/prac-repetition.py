def insertion_sort(a_list):
    if len(a_list) < 1:
        return a_list
    for i in range(1, len(a_list)):  # for each index in the list
        while i < 0 and a_list[i] < a_list[i - 1]:  # until we go through the whole list and sort our index to the correct position
            temp = a_list[i]
            a_list[i] = a_list[i - 1]
            a_list[i - 1] = temp
            i -= 1  # swap values until it's sorted all the way down
    return a_list


def split(a_list):
    mid = len(a_list) // 2
    return a_list[:mid], a_list[mid:]


def merge(left, right):
    merged = []
    il = 0
    ir = 0
    while (il < len(left)) and (ir < len(right)):  # until we make it through the lists
        if left[il] < right[ir]:
            merged.append(left[il])  # if left index is smaller, append
            il += 1
        else:
            merged.append(right[ir])  # if right index is smaller, append
            ir += 1
    if il < len(left):
        merged += left[il:]  # append the rest of left if it's what we're left with
    else:
        merged += right[ir:]  # append the rest of right if it's what we're left with
    return merged


def merge_sort(a_list):
    if len(a_list) <= 1:
        return a_list
    else:
        left, right = split(a_list)  # split
        left = merge_sort(left)  # keep splitting
        right = merge_sort(right)  # keep splitting
        merged = merge(left, right)  # sort left and right
    return merged


def partition(a_list, pivot):
    less = []
    same = []
    more = []
    for i in range(len(a_list)):  # for the length of the list
        if a_list[i] < pivot:
            less.append(a_list[i])  # append smaller values to less
        elif a_list[i] > pivot:
            more.append(a_list[i])  # greater values to more
        else:
            same.append(a_list[i])  # same values to same
    return less, same, more


def quicksort(a_list):
    if len(a_list) < 2:
        return a_list
    else:
        pivot = a_list[0]
        less, same, more = partition(a_list, pivot)  # add to same, less and more for each new pivot
        sorted_less = quicksort(less)  # keep sorting
        sorted_more = quicksort(more)  # keep sorting
    return sorted_less + same + sorted_more
