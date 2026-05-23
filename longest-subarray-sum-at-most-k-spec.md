# Longest Subarray With Sum ≤ K — Specification

## Overview

**Problem Name:** LongestSubarraySumAtMostK

**Category:** Algorithm — Sliding Window (Two Pointers)

**Difficulty:** Easy

**Target Audience:** FAANG / Altimetrik interview preparation

**Project Context:** Java 21, placed under `src/my/leet/pattern/sliding/` (matching the existing sliding window problems in the project).

---

## Problem Statement

Given an array of **non-negative integers** and an integer `K`, find the **length of the longest contiguous subarray** whose sum is **less than or equal to `K`**.

If no such subarray exists, return `0`.

### Example 1

```
Input:  arr = [3, 1, 2, 1, 1, 4, 2], K = 7
Output: 4
Explanation: The longest subarray with sum ≤ 7 is [3, 1, 2, 1] (sum = 7) → length 4
```

### Example 2

```
Input:  arr = [1, 2, 3, 4, 5], K = 11
Output: 4
Explanation: [1, 2, 3, 4] sum = 10 ≤ 11 → length 4. [2, 3, 4, 5] sum = 14 > 11.
```

### Example 3

```
Input:  arr = [5, 6, 7, 8], K = 4
Output: 0
Explanation: Every single element exceeds K, so no valid subarray exists.
```

---

## Constraints

- `1 ≤ arr.length ≤ 100`
- `0 ≤ arr[i] ≤ 100`
- `0 ≤ K ≤ 1000`
- Array contains **non-negative integers only** (ensures monotonic sliding window works)

---

## Edge Cases to Handle

| Edge Case | Expected Behavior |
|---|---|
| `arr = null` or empty | Return `0` |
| Single element ≤ K | Return `1` |
| Single element > K | Return `0` |
| All elements > K | Return `0` (no valid subarray) |
| All elements = 0 | Return entire array length |
| K = 0 | Return count of zeros in array |
| Entire array sum ≤ K | Return `arr.length` |

---

## Solution Approach

### Algorithm: Sliding Window (Expanding/Contracting)

Since all values are non-negative, the window sum increases monotonically as we expand the right pointer. If the sum exceeds K, we shrink from the left.

**Pseudocode:**

```
function longestSubarraySumAtMostK(arr, K):
    left = 0
    sum = 0
    maxLen = 0

    for right from 0 to arr.length - 1:
        sum += arr[right]

        // Shrink window while sum exceeds K
        while sum > K and left <= right:
            sum -= arr[left]
            left++

        // Update max length
        maxLen = max(maxLen, right - left + 1)

    return maxLen
```

**Time Complexity:** O(n) — each element is added once and removed at most once.

**Space Complexity:** O(1) — only a few integer variables.

---

## Implementation Requirements

### Class
- **Name:** `LongestSubarraySumAtMostK`
- **Package:** `my.leet.pattern.sliding`

### Methods

| Method | Visibility | Signature | Description |
|---|---|---|---|
| `longestSubarraySumAtMostK` | `public static` | `(int[] arr, int K) → int` | Core algorithm — returns max length |
| `main` | `public static` | `(String[] args) → void` | Demo — runs test cases and prints results |

### Style Guidelines

- Follow existing project conventions (see `MinSunWindow.java`, `MaxWindow.java`)
- Use descriptive variable names (`left`, `right`, `sum`, `maxLen`)
- Include Javadoc-style comments on the core method
- Include inline comments for non-trivial logic
- Keep the method clean and focused — no side effects

### Demo (`main` method)

The `main` method should include at least the following test cases:
1. Example 1 from above
2. Example 2 from above
3. Example 3 from above
4. Null/empty array → 0
5. Single element ≤ K → 1
6. Single element > K → 0
7. All zeros with K = 0 → full length
8. Entire array sum < K → full length
9. Generic case with multiple valid windows

---

## Differences from Existing Problems

| Existing File | How This Differs |
|---|---|
| `MinSunWindow.java` | Finds **minimum** length with sum **≥** target. This finds **maximum** length with sum **≤** target. |
| `MaxWindow.java` | Fixed window size K. This has a **variable** window size. |
| `BestSubArraySum.java` | Kadane's algorithm for max sum (can include negatives). This has a **sum constraint** with non-negatives. |

---

## File Path

`src/my/leet/pattern/sliding/LongestSubarraySumAtMostK.java`

---

## Future Enhancements (not for initial implementation)

- Handle arrays with negative numbers (requires prefix-sum + binary search or dequeue)
- Return the actual subarray (not just length)
- 2D variant (submatrix with sum ≤ K)
- Stream-based solution using `IntStream`
