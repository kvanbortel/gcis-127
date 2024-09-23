"""
Author: Kayla Van Bortel
"""


def gcis_sort(a_list):
    for index_a in range(len(a_list)):
        for index_b in range(0, len(a_list) - 1 - index_a):
            if a_list[index_b] > a_list[index_b + 1]:
                temp = a_list[index_b]
                a_list[index_b] = a_list[index_b + 1]
                a_list[index_b + 1] = temp
    return a_list


def in_place_reverse(a_list):
    """
    Time complexity: O(n)
    """
    reverse = []
    for i in range(len(a_list)):
        value = a_list.pop(-1)
        reverse.insert(i, value)
    return reverse


def make_multplication_table():
    return [[j for j in range(1, 11) if j % k == 0] for k in range(1, 11)]

#    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
#    [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
#    [3, 6, 9, 12, 15, 18, 21, 24, 27, 30]
#    [4, 8, 12, 16, 20, 24, 28, 32, 36, 40]
#    [5, 10, 15, 20, 25, 30, 35, 40, 45, 50]
#    [6, 12, 18, 24, 30, 36, 42, 48, 54, 60]
#    [7, 14, 21, 28, 35, 42, 49, 56, 63, 70]
#    [8, 16, 24, 32, 40, 48, 56, 64, 72, 80]
#    [9, 18, 27, 36, 45, 54, 63, 72, 81, 90]
#    [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]


def main():
    # a_list = [5, 4, 3, 2, 1]
    # print(a_list)
    # print(gcis_sort(a_list))
    # print(gcis_sort([1, 2, 3, 4, 5]))
    # print(gcis_sort([1]))
    # print(gcis_sort([5, 3, 1, 2, 4]))

    # a_list = [1, 2, 3, 4, 5]
    # print(a_list)
    # print(in_place_reverse(a_list))

    table = make_multplication_table()
    # for i in range(9):
    #     row = table[i]
    #     print(row)
    print(table)


if __name__ == "__main__":
    main()
