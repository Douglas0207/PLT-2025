# 📘 Algorithm Solutions – Java

This repository contains Java implementations of three popular algorithmic problems commonly asked in coding interviews. Each solution is optimized for efficiency and demonstrates the use of key data structures and algorithmic techniques such as hashing, greedy methods, and binary search.

## 🔍 Problem 1: First Unique Character in a String

### 📝 Problem Statement

Given a string, find the index of the first non-repeating character. If it doesn't exist, return `-1`.

### 💡 Approach

* We use a frequency array of size 26 (for lowercase English letters) to count character occurrences.
* Then, we iterate through the string again to find the first character with a frequency of one.
* Time Complexity: `O(n)`
* Space Complexity: `O(1)` (constant size array)

### 🌟 Concepts Used

* Frequency counting
* String manipulation
* Character-to-index mapping

---

## 🎯 Problem 2: Minimum Number of Arrows to Burst Balloons

### 📝 Problem Statement

Given a list of intervals representing balloons in a 2D space, return the minimum number of arrows needed to burst all balloons.

### 💡 Approach

* Sort the intervals based on their end coordinates.
* Use a greedy approach: Always shoot the arrow at the end of the first balloon, and continue if the next balloon starts after the current arrow.
* Time Complexity: `O(n log n)`
* Space Complexity: `O(1)`

### 🌟 Concepts Used

* Interval sorting
* Greedy algorithms
* Custom comparator with `Arrays.sort()`

---

## 📦 Problem 3: Russian Doll Envelopes

### 📝 Problem Statement

Given envelopes with dimensions `(width, height)`, find the maximum number of envelopes you can nest (Russian Doll style), where each envelope must be strictly larger in both width and height.

### 💡 Approach

* Sort envelopes by width in ascending order, and by height in descending order for same widths.
* Extract the heights and apply the Longest Increasing Subsequence (LIS) algorithm.
* Binary search (`Arrays.binarySearch`) is used to optimize the LIS calculation.
* Time Complexity: `O(n log n)`
* Space Complexity: `O(n)`

### 🌟 Concepts Used

* Custom sorting for 2D arrays
* Binary search
* Longest Increasing Subsequence (LIS) pattern

---

## 🛠 Technologies Used

* Java 17
* Standard Java Libraries (`java.util.*`)
* No external dependencies

---

## 🧠 Author's Note

These problems were selected to demonstrate a variety of core algorithmic techniques used in technical interviews. Each solution focuses on both clarity and performance.




