# Java Algorithm Solutions – Day 8

This repository includes optimized Java solutions for three algorithmic problems commonly asked in technical interviews. Each implementation is designed to be clear, efficient, and easy to understand.

---

## Table of Contents

1. Number of Recent Calls
2. Prime Palindrome
3. K-th Smallest in Lexicographical Order

---

## Number of Recent Calls

**Problem Statement:**
You have a RecentCounter class that counts the number of recent requests within the past 3000 milliseconds.

**Approach:**

* Uses a **Queue** to keep track of timestamps.
* When a new request comes in, it adds it to the queue.
* Continuously removes timestamps that are older than `t - 3000`.
* Returns the size of the queue, representing the count of recent requests.
* Time complexity: **O(n)** (amortized for `n` pings)
* Space complexity: **O(n)**

---

## Prime Palindrome

**Problem Statement:**
Find the smallest prime number that is also a palindrome and is greater than or equal to a given number `n`.

**Approach:**

* Increments `n` until it finds a number that is both a **palindrome** and **prime**.
* Skips the 8-digit non-palindrome gap between `10^7` and `10^8` to optimize search.
* Uses two helper methods:

  * `isPalindrome()` converts the number to a string and checks symmetry.
  * `isPrime()` checks if a number is divisible by any number up to its square root.
* Time complexity: **O(n√n)** in worst-case (for large gaps)
* Space complexity: **O(1)**

---

## K-th Smallest in Lexicographical Order

**Problem Statement:**
Given integers `n` and `k`, return the `k`-th smallest number in lexicographical order from `1` to `n`.

**Approach:**

* Builds a **prefix tree (trie)** logic by simulating digit-level traversal from `1`.
* Uses a custom `countSteps()` method to calculate how many numbers fall under a given prefix range.
* If the step count is less than `k`, the algorithm skips that prefix; otherwise, it goes deeper.
* Efficiently narrows down to the exact k-th number.
* Time complexity: **O(log n × log n)**
* Space complexity: **O(1)**

---

## Notes

* These solutions demonstrate key techniques such as **queue-based sliding windows**, **number theory**, and **prefix tree counting**.
* Each solution is modular, clearly structured, and aligned with best practices for technical interview preparation.
