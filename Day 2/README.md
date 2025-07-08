# Day2 Java Problem Solving

This Java program implements and demonstrates solutions for three classic algorithmic problems:

1. **Two Sum**
2. **Boats to Save People**
3. **Count Subarrays With Score Less Than K**

These problems are implemented as separate methods in a single class and are executed through a main method with sample test cases.

---

## 🔧 Requirements

- Java 8 or higher
- Any IDE or command line to compile and run

---

## 🚀 How to Run

1. Save the file as `Day2.java`.
2. Compile the program:

  
   javac Day2.java

3. Run the program:

   ```bash
   java Day2
   ```

You’ll see the output of all three algorithm solutions in the terminal.

---

## 🧠 Problem Descriptions

### 1. Two Sum

* **Goal:** Find two indices in the array such that their values sum up to a given target.
* **Approach:** Uses a HashMap to store complements and solve in O(n) time.

```java
int[] arr = {2, 7, 11, 15};
int target = 9;
Result: [0, 1]
```

---

### 2. Boats to Save People

* **Goal:** Given people's weights and a boat limit, return the minimum number of boats required to save everyone.
* **Approach:** Greedy two-pointer method after sorting the array.

```java
int[] people = {3, 2, 2, 1};
int limit = 3;
Result: 3 boats
```

---

### 3. Count Subarrays With Score Less Than K

* **Goal:** Count how many subarrays have `sum * length < k`.
* **Approach:** Sliding window with dynamic shrinking for O(n) performance.

```java
int[] nums = {2, 1, 4, 3, 5};
long k = 10;
Result: 10 subarrays
```

---

## 📁 File Structure

```
Day2.java         # Main Java file with 3 algorithms and test cases
README.md         # This file
```

---

## 👨‍💻 Author

Robinson Douglas

---

## 🏁 Output Sample

```
Two Sum Result: [0, 1]
Boats Needed: 3
Count of Subarrays with Score < 10: 10
```

---

## ✅ Notes

* This is a base template for building more advanced problem-solving sets.
* You can easily extend it with new methods and tests.

`
