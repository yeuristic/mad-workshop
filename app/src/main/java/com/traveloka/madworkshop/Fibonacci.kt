package com.traveloka.madworkshop

fun badFibonacci(n: Int): Int = when (n) {
    in (Int.MIN_VALUE until 0) -> throw IllegalArgumentException("n must be positive")
    0 -> 0
    1 -> 1
    else -> badFibonacci(n - 2) + badFibonacci(n - 1)
}

fun badFibonacci(n: Int, callback: OnFibonacciCompleted) {
    callback.onFibonacciCompleted(badFibonacci(n))
}

fun interface OnFibonacciCompleted {
    fun onFibonacciCompleted(result: Int)
}