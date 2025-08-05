# Java Algorithm Solutions – Day 11

This repository includes optimized Java solutions for three algorithmic problems commonly asked in technical interviews. Each implementation is designed to be clear, efficient, and easy to understand.

--

## Table of Contents

1. Balanced Binary Tree
2. Delete and Earn
3. Binary Tree Cameras

---

## Balanced Binary Tree

**Problem Statement:**
Determine if a binary tree is height-balanced. A binary tree is balanced if the left and right subtrees of every node differ in height by no more than one.

**Approach:**

* Uses a **bottom-up DFS approach** to compute the height of each subtree.
* If any subtree is unbalanced, propagates `-1` upward to indicate imbalance.
* Recursively compares the height difference of left and right subtrees.
* Time complexity: **O(n)**
* Space complexity: **O(h)** (recursive stack)

---

## Delete and Earn

**Problem Statement:**
Given an array `nums`, you can earn points by deleting elements. When you pick a number `x`, you earn `x` points but must delete every instance of `x-1` and `x+1`.

**Approach:**

* Maps each number to its total contribution (`num * frequency`).
* Sorts values implicitly using a DP array of size `max + 1`.
* Applies the **House Robber** technique: choose or skip a number based on adjacency constraint.
* Time complexity: **O(n + m)**, where `n` is input size and `m` is the max number
* Space complexity: **O(m)**

---

## Binary Tree Cameras

**Problem Statement:**
Place cameras in a binary tree such that every node is monitored. Each camera can monitor its parent, itself, and its immediate children. Return the minimum number of cameras needed.

**Approach:**

* Uses **post-order traversal** to decide camera placement based on child states.
* Returns:

  * `0`: node needs camera
  * `1`: node has a camera
  * `-1`: node is covered
* Adds a camera only when a child is in state `0`.
* Ensures the root is also covered at the end.
* Time complexity: **O(n)**
* Space complexity: **O(h)**

---

## Notes

* These solutions demonstrate a mix of **tree recursion**, **dynamic programming**, and **greedy decision-making**.
* The code is optimized, structured, and designed with interview readiness in mind.
