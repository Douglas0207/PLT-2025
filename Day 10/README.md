# Java Algorithm Solutions – Day 10

This repository includes optimized Java solutions for three algorithmic problems commonly asked in technical interviews. Each implementation is designed to be clear, efficient, and easy to understand.

---

## Table of Contents

1. Average of Levels in Binary Tree
2. Remove Duplicates from Sorted List II
3. Binary Tree Maximum Path Sum

---

## Average of Levels in Binary Tree

**Problem Statement:**
Given the root of a binary tree, return the average value of the nodes on each level in the form of a list.

**Approach:**

* Performs a **level-order traversal** (BFS) using a queue.
* For each level, accumulates the sum of node values and calculates the average.
* Adds the average to the result list.
* Time complexity: **O(n)**, where `n` is the number of nodes.
* Space complexity: **O(m)**, where `m` is the maximum width of the tree.

---

## Remove Duplicates from Sorted List II

**Problem Statement:**
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers.

**Approach:**

* Uses a **dummy node** to handle edge cases cleanly.
* Traverses the list with two pointers: `prev` and `curr`.
* Skips over all duplicates by comparing `curr.val` with `curr.next.val`.
* Updates the `prev.next` pointer only if no duplicates are found.
* Time complexity: **O(n)**
* Space complexity: **O(1)**

---

## Binary Tree Maximum Path Sum

**Problem Statement:**
Given the root of a binary tree, return the maximum path sum. A path may start and end at any node in the tree.

**Approach:**

* Uses **DFS recursion** to explore all paths.
* At each node, calculates the maximum contribution from the left and right subtrees.
* Updates a global variable `maxSum` to keep track of the highest path sum seen so far.
* Returns the max gain from the current node to its parent.
* Time complexity: **O(n)**
* Space complexity: **O(h)**, where `h` is the height of the tree (recursive stack)

---

## Notes

* These solutions showcase concepts such as **BFS traversal**, **linked list pointer manipulation**, and **recursive tree path aggregation**.
* Each implementation is modular, readable, and ideal for interview preparation.
