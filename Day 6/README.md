
---

# Java Algorithm Solutions

This repository contains multiple Java-based solutions for classic algorithmic problems. Each solution is implemented with clarity and optimized logic, making them suitable for learning and interviews.

---

## Table of Contents

1. Check If Double Exists
2. Decode String
3. Text Justification

---

## Check If Double Exists

**Problem Statement:**
Given an array of integers, determine if there exists two distinct indices `i` and `j` such that `arr[i] == 2 * arr[j]`.

**Approach:**

* Utilizes a HashSet for efficient lookups.
* Iterates through the array and checks for two conditions:

  * If the current number’s double exists in the set.
  * If the current number is even and its half exists in the set.
* If either condition is true, returns `true`; otherwise, adds the current number to the set.
* Time complexity: **O(n)**
* Space complexity: **O(n)**

---

## Decode String

**Problem Statement:**
Decode a string that follows the encoding rule: `k[encoded_string]`, where `k` is a positive integer indicating the number of times the encoded string should be repeated.

**Approach:**

* Uses two stacks:

  * One to store the number of repetitions.
  * One to store the previous string context.
* Traverses the string character by character:

  * Builds the repeat count when encountering digits.
  * Pushes current state to stacks when `[` is found.
  * Pops from both stacks on `]` and constructs the repeated segment.
* Concatenates segments to build the final result.
* Handles nested patterns using stack-based logic.
* Time complexity: **O(n)**
* Space complexity: **O(n)**

---

## Text Justification

**Problem Statement:**
Given an array of words and a maximum width, format the text so that each line has exactly `maxWidth` characters, with full justification (both left and right alignment).

**Approach:**

* Greedy strategy to fit as many words as possible in each line.
* Calculates total characters and spaces required per line.
* For each line:

  * If it's the last line or contains only one word, left-justifies it.
  * Otherwise, distributes spaces evenly between words.
  * Extra spaces (if any) are added to the leftmost gaps.
* Constructs each justified line using `StringBuilder`.
* Time complexity: **O(n)**, where `n` is the total number of words.

---

## Notes

* Each solution is implemented in a clean and modular fashion.
* Code is well-commented and follows standard Java conventions.
* Ideal for understanding key algorithmic concepts such as greedy techniques, stack-based parsing, and set lookups.

---

