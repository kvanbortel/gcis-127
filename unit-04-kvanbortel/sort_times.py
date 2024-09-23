"""
Author: Kayla Van Bortel
"""

import sorts
import time
# import list_utils
import plotter
import random
import math
SIZES = list(range(200, 2001, 300))


def insertion_sort_function_timer(a_list):
    start = time.perf_counter()
    sorts.insertion_sort(a_list)
    end = time.perf_counter()
    return end - start


def sort_function_timer(sort_function, a_list):
    start = time.perf_counter()
    sort_function(a_list)
    end = time.perf_counter()
    return end - start


def plot_sort_time_using_random_lists(sort_function):
    print("timing", sort_function.__name__)
    plotter.new_series(sort_function.__name__)
    for i in range(len(SIZES)):
        a_list = list(range(0, SIZES[i]))
        for j in range(SIZES[i]):
            a_list[j] = random.randint(0, 99)
        try:
            time = sort_function_timer(sort_function, a_list)
        except RecursionError:
            print("max recursion depth exceeded for", sort_function.__name__, "list of length", SIZES[i])
        plotter.add_data_point(time)


def plot_sort_time_using_sorted_lists(sort_function):
    print("timing", sort_function.__name__)
    plotter.new_series(sort_function.__name__)
    for i in range(len(SIZES)):
        a_list = list(range(0, SIZES[i]))
        try:
            time = sort_function_timer(sort_function, a_list)
        except RecursionError:
            print("max recursion depth exceeded for", sort_function.__name__, "list of length", SIZES[i])
        plotter.add_data_point(time)


def quick_insertion_sort(a_list, depth=0, count=0):
    if len(a_list) < 2:
        return a_list
    elif depth > (0.25 * math.log2(len(a_list))):
        sorts.insertion_sort(a_list)
        return a_list
    else:
        pivot = a_list[0]
        less, same, more = sorts.partition(a_list, pivot)
        sorted_less = quick_insertion_sort(less, depth + 1)
        sorted_more = quick_insertion_sort(more, depth + 1)
    return sorted_less + same + sorted_more


def main():
    # print(insertion_sort_function_timer(list_utils.range_list(0, 3001)), "seconds")
    # print(insertion_sort_function_timer(list_utils.random_list(3000)), "seconds")
    # print(insertion_sort_function_timer(list_utils.range_list(2999, -1, -1)), "seconds")
    # every time we double the size, it takes 4 times as long to run because it's n^2
    # print(sort_function_timer(sorts.insertion_sort, [5, 4, 3, 2, 1]))

    # plotter.init("Insertion, merge, and quick sort", "SIZES Index", "Time")
    # plot_sort_time_using_random_lists(sorts.insertion_sort)
    # plot_sort_time_using_random_lists(sorts.merge_sort)
    # plot_sort_time_using_random_lists(sorts.quicksort)
    # plotter.plot()
    # plotter.init("Insertion, merge, and quick sort", "SIZES Index", "Time")
    # plot_sort_time_using_sorted_lists(sorts.insertion_sort)
    # plot_sort_time_using_sorted_lists(sorts.merge_sort)
    # plot_sort_time_using_sorted_lists(sorts.quicksort)  # max depth exceeded for 1100+
    # plotter.plot()

    # print(quick_insertion_sort([5, 4, 3, 2, 1]))
    plotter.init("Insertion, merge, and quick insertion sort", "SIZES Index", "Time")
    plot_sort_time_using_random_lists(sorts.insertion_sort)
    plot_sort_time_using_random_lists(sorts.merge_sort)  # merge sort works best
    plot_sort_time_using_random_lists(quick_insertion_sort)
    plotter.plot()
    plotter.init("Insertion, merge, and quick insertion sort", "SIZES Index", "Time")
    plot_sort_time_using_sorted_lists(sorts.insertion_sort)  # insertion sort works best
    plot_sort_time_using_sorted_lists(sorts.merge_sort)
    plot_sort_time_using_sorted_lists(quick_insertion_sort)
    plotter.plot()


if __name__ == "__main__":
    main()
