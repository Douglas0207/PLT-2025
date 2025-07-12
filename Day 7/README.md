
---

# Java Algorithm Solutions – Set 2

This repository includes optimized Java solutions for three algorithmic problems commonly asked in technical interviews. Each implementation is designed to be clear, efficient, and easy to understand.

---

## Table of Contents

1. [Power of Two Check](#power-of-two-check)
2. [Reverse Integer](#reverse-integer)
3. [Merge K Sorted Lists](#merge-k-sorted-lists)

---

## Power of Two Check

**Problem Statement:**
Determine whether a given integer is a power of two.

**Approach:**

* Uses bitwise operations to perform an efficient check.
* Any power of two has only one bit set in binary representation.
* The expression `(n & (n - 1)) == 0` verifies this property.
* Ensures the number is also greater than zero to rule out non-positive values.
* Time complexity: **O(1)**
* Space complexity: **O(1)**

---

## Reverse Integer

**Problem Statement:**
Given a signed 32-bit integer, reverse its digits. If the reversed integer overflows, return zero.

**Approach:**

* Extracts digits using modulo and division operations.
* Checks for overflow before performing any multiplication to ensure the result stays within bounds.
* Uses `Integer.MAX_VALUE` and `Integer.MIN_VALUE` to handle overflow conditions.
* Returns the reversed number if valid; otherwise returns zero.
* Time complexity: **O(log₁₀(n))**
* Space complexity: **O(1)**

---

## Merge K Sorted Lists

**Problem Statement:**
Merge `k` sorted linked lists into one sorted linked list and return it.

**Approach:**

* Uses a **Min Heap (PriorityQueue)** to efficiently fetch the smallest node among the `k` lists.
* Initializes the heap with the head of each non-null list.
* Repeatedly polls the minimum node and adds its next node to the heap.
* Constructs the result using a dummy head pointer to build the final merged list.
* Time complexity: **O(N log k)**, where `N` is the total number of nodes and `k` is the number of lists.
* Space complexity: **O(k)** for the priority queue.

---

## Notes

* These solutions demonstrate key algorithmic strategies such as bit manipulation, overflow handling, and heap-based merging.
* Each solution is modular, cleanly structured, and suitable for interview preparation or competitive programming.

---

Let me know if you’d like to combine both sets into one single `README` file or add more metadata like input/output examples or problem source links.
