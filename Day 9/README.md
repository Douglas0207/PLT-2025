# Java Algorithm Solutions – Day 9

This repository includes optimized Java solutions for three algorithmic problems commonly asked in technical interviews. Each implementation is designed to be clear, efficient, and easy to understand.

---

## Table of Contents

1. Linked List Cycle
2. Non-overlapping Intervals
3. Reverse Nodes in k-Group

---

## Linked List Cycle

**Problem Statement:**
Determine if a given linked list contains a cycle.

**Approach:**

* Uses **Floyd’s Cycle Detection Algorithm** (Tortoise and Hare method).
* Two pointers (`slow` and `fast`) traverse the list at different speeds.
* If a cycle exists, the two pointers will eventually meet.
* If `fast` or `fast.next` becomes `null`, then the list does not have a cycle.
* Time complexity: **O(n)**
* Space complexity: **O(1)**

---

## Non-overlapping Intervals

**Problem Statement:**
Given a list of intervals, remove the minimum number of intervals to make the rest non-overlapping.

**Approach:**

* Sorts the intervals by their **end time** to maximize the number of non-overlapping intervals.
* Iterates through each interval and keeps track of the last valid end.
* Increments a counter whenever an overlap is found.
* Greedy strategy ensures optimal interval removal.
* Time complexity: **O(n log n)** (due to sorting)
* Space complexity: **O(1)**

---

## Reverse Nodes in k-Group

**Problem Statement:**
Given a linked list, reverse nodes in groups of size `k`.

**Approach:**

* First checks if at least `k` nodes are available to reverse.
* Reverses `k` nodes using three pointers: `prev`, `curr`, and `next`.
* Recursively processes the remaining list and connects it to the reversed part.
* Handles cases where nodes remaining are less than `k` by leaving them unchanged.
* Time complexity: **O(n)**
* Space complexity: **O(n/k)** (recursive stack)

---

## Notes

* These solutions highlight core techniques such as **fast-slow pointer traversal**, **greedy sorting**, and **in-place linked list manipulation**.
* Each solution is structured for readability and aligned with top interview practices.

