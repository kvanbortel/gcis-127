"""
This program uses the Fibonacci sequence to compare methods of recursion and their time complexities
Author: Kayla Van Bortel
"""

import time
import plotter


def fibonacci_naive(n):
    "Moves backward to return the nth number in the Fibonacci sequence"
    if n <= 0:
        return None
    if n == 1:
        return 0
    if n == 2:
        return 1
    if n > 1:
        return fibonacci_naive(n - 1) + fibonacci_naive(n - 2)


def naive_timer(n):
    """
    Plots the time it takes for increasing values of the Fibonacci sequence
    """
    for each in range(n):
        start = time.perf_counter()
        fibonacci_naive(each)
        end = time.perf_counter()
        plotter.add_data_point(end - start)


def fibonacci_fast(n, fn_minus_1=1, fn_minus_2=0, count=2):
    """
    Moves forward to return the nth number in the backwards Fibonacci sequence
    """
    if n <= 0:
        return None
    if n == 1:
        return 0
    if n == 2:
        return 1
    if count < n:
        next = fn_minus_2 + fn_minus_1
        fn_minus_2 = fn_minus_1
        fn_minus_1 = next
        count = count + 1
        return fibonacci_fast(n, fn_minus_1, fn_minus_2, count)
    return fn_minus_1


def fast_timer(n):
    """
    Plots the time it takes for increasing values of the forwards Fibonacci sequence
    """
    for each in range(n):
        start = time.perf_counter()
        fibonacci_fast(each)
        end = time.perf_counter()
        plotter.add_data_point(end - start)


def main():
    print(fibonacci_naive(9))
    n = input("Enter a value for n: ")
    plotter.init("Naive Fibonacci", "N", "Time")
    plotter.new_series("Naive")
    naive_timer(int(n))
    plotter.plot()

    print(fibonacci_fast(9))
    n = input("Enter a value for n: ")
    plotter.init("Fast Fibonacci", "N", "Time")
    plotter.new_series("Fast")
    fast_timer(int(n))
    plotter.plot()

    n = input("Enter a value for n: ")
    plotter.init("Naive vs. Fast Fibonacci", "N", "Time")
    plotter.new_series("Fast")
    fast_timer(int(n))
    plotter.new_series("Naive")
    naive_timer(int(n))
    plotter.plot()


if __name__ == "__main__":
    main()
