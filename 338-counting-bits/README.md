<h2><a href="https://leetcode.com/problems/counting-bits">Counting Bits</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given an integer <code>n</code>, return <em>an array </em><code>ans</code><em> of length </em><code>n + 1</code><em> such that for each </em><code>i</code><em> </em>(<code>0 &lt;= i &lt;= n</code>)<em>, </em><code>ans[i]</code><em> is the <strong>number of </strong></em><code>1</code><em><strong>&#39;s</strong> in the binary representation of </em><code>i</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 2
<strong>Output:</strong> [0,1,1]
<strong>Explanation:</strong>
0 --&gt; 0
1 --&gt; 1
2 --&gt; 10
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 5
<strong>Output:</strong> [0,1,1,2,1,2]
<strong>Explanation:</strong>
0 --&gt; 0
1 --&gt; 1
2 --&gt; 10
3 --&gt; 11
4 --&gt; 100
5 --&gt; 101
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong></p>

<ul>
	<li>It is very easy to come up with a solution with a runtime of <code>O(n log n)</code>. Can you do it in linear time <code>O(n)</code> and possibly in a single pass?</li>
	<li>Can you do it without using any built-in function (i.e., like <code>__builtin_popcount</code> in C++)?</li>
</ul>

# **Walkthrough: #338 - Counting Bits**

## **The Goal**
Given an integer `n`, return an array `ans` where:
- `ans[i]` = number of 1's in binary representation of `i`
- For all `i` from `0` to `n`

**Example:** `n = 5`
```
i    Binary    # of 1's
0    0000      0
1    0001      1  
2    0010      1
3    0011      2
4    0100      1
5    0101      2
Output: [0, 1, 1, 2, 1, 2]
```

---

## **Key Insight: Dynamic Programming with Bit Manipulation**

From **#191 (Number of 1 Bits)**, we know `n & (n-1)` removes the lowest set bit.

**Observation:** If we know the count for a smaller number, we can compute count for current number.

---

## **The Core Pattern**

For any number `i`:
```
count_ones(i) = count_ones(i & (i-1)) + 1
```
**Why?**
- `i & (i-1)` removes the lowest set bit from `i`
- This gives us a smaller number with one less 1-bit
- We add 1 (for the bit we just removed)

---

## **Step-by-Step Walkthrough for n = 5**

### **Base Case: i = 0**
```
ans[0] = 0  (binary: 0 has zero 1's)
```

### **i = 1**
```
i = 1 (0001)
i & (i-1) = 1 & 0 = 0
ans[1] = ans[0] + 1 = 0 + 1 = 1
```
Check: `1 = 0001` has one 1-bit ✓

### **i = 2**
```
i = 2 (0010)
i & (i-1) = 2 & 1 = 0000 = 0
ans[2] = ans[0] + 1 = 0 + 1 = 1
```
Check: `2 = 0010` has one 1-bit ✓

### **i = 3**
```
i = 3 (0011)
i & (i-1) = 3 & 2 = 0011 & 0010 = 0010 = 2
ans[3] = ans[2] + 1 = 1 + 1 = 2
```
Check: `3 = 0011` has two 1-bits ✓

### **i = 4**
```
i = 4 (0100)
i & (i-1) = 4 & 3 = 0100 & 0011 = 0000 = 0
ans[4] = ans[0] + 1 = 0 + 1 = 1
```
Check: `4 = 0100` has one 1-bit ✓

### **i = 5**
```
i = 5 (0101)
i & (i-1) = 5 & 4 = 0101 & 0100 = 0100 = 4
ans[5] = ans[4] + 1 = 1 + 1 = 2
```
Check: `5 = 0101` has two 1-bits ✓

**Final array:** `[0, 1, 1, 2, 1, 2]`

---

## **Visual Representation**

Let's visualize the DP transitions:

```
i    Binary    i&(i-1)  ← Source    ans[i] = ans[source] + 1
0    0000      -                   0
1    0001      0000 (0)            0 + 1 = 1
2    0010      0000 (0)            0 + 1 = 1  
3    0011      0010 (2)            1 + 1 = 2
4    0100      0000 (0)            0 + 1 = 1
5    0101      0100 (4)            1 + 1 = 2
6    0110      0100 (4)            1 + 1 = 2
7    0111      0110 (6)            2 + 1 = 3
8    1000      0000 (0)            0 + 1 = 1
```

**Pattern:** Each number builds upon a smaller number we've already computed.

---

## **Alternative Method: Right Shift Pattern**

Another DP approach:
```
ans[i] = ans[i >> 1] + (i & 1)
```
**Why?**
- `i >> 1` removes the last bit (shifts right)
- `i & 1` checks if last bit was 1

**Walkthrough with i = 5:**
```
i = 5 (0101)
i >> 1 = 2 (0010)  // Remove last bit
i & 1 = 1          // Last bit was 1
ans[5] = ans[2] + 1 = 1 + 1 = 2
```

**Walkthrough with i = 6:**
```
i = 6 (0110)
i >> 1 = 3 (0011)
i & 1 = 0          // Last bit was 0
ans[6] = ans[3] + 0 = 2 + 0 = 2
```

---

## **Comparison of Both Methods**

### **Method 1: `i & (i-1)`**
```
ans[i] = ans[i & (i-1)] + 1
```
- Removes lowest set bit
- Always adds 1 (because we removed a 1-bit)
- Source number is significantly smaller

### **Method 2: Right Shift**
```
ans[i] = ans[i >> 1] + (i & 1)
```
- Removes last bit (could be 0 or 1)
- Adds 0 or 1 depending on removed bit
- Source number is about half

Both are O(n) time, O(1) per computation.

---

## **Edge Cases & Observations**

### **1. n = 0**
```
ans = [0]  // Only one element
```

### **2. n = 1**
```
ans = [0, 1]
```

### **3. Powers of Two**
Notice the pattern for powers of two:
```
i=1: ans[1] = 1
i=2: ans[2] = 1  (2 = 10)
i=4: ans[4] = 1  (4 = 100)  
i=8: ans[8] = 1  (8 = 1000)
```
Always 1 because powers of two have exactly one 1-bit.

### **4. Consecutive Numbers**
```
7 (0111): ans[7] = 3
8 (1000): ans[8] = 1  // Resets to 1
```
Binary representation "resets" after all-ones pattern.

---

## **The Bigger Picture: DP Table Building**

Let's build the full table for n = 8 to see patterns:

| i | Binary | i&(i-1) | Formula | ans[i] |
|---|--------|---------|---------|--------|
| 0 | 0000   | -       | Base    | 0      |
| 1 | 0001   | 0       | ans[0]+1| 1      |
| 2 | 0010   | 0       | ans[0]+1| 1      |
| 3 | 0011   | 2       | ans[2]+1| 2      |
| 4 | 0100   | 0       | ans[0]+1| 1      |
| 5 | 0101   | 4       | ans[4]+1| 2      |
| 6 | 0110   | 4       | ans[4]+1| 2      |
| 7 | 0111   | 6       | ans[6]+1| 3      |
| 8 | 1000   | 0       | ans[0]+1| 1      |

**Observations:**
1. Powers of two always reference `ans[0]`
2. Numbers with same `i & (i-1)` value have related counts
3. This is essentially a **DAG (Directed Acyclic Graph)** of computations

---

## **Complexity Analysis**

**Time:** O(n) - Each computation is O(1)
**Space:** O(n) for the output array, O(1) extra space

---

## **Connection to Previous Problems**

### **#191 - Number of 1 Bits**
- This problem is essentially computing #191 for all numbers 0 to n
- The DP formula uses the same `n & (n-1)` trick

### **#231 - Power of Two**
- Powers of two are where `i & (i-1) = 0`
- In our DP, these always compute as `ans[0] + 1 = 1`

### **Pattern Recognition:**
```java
// Recurring bit manipulation patterns:
1. n & (n-1)  // Remove lowest set bit
2. n & -n     // Isolate lowest set bit  
3. n >> 1     // Divide by 2 (remove last bit)
4. n << 1     // Multiply by 2 (add 0 at end)
```

---

## **Practice Walkthrough Yourself**

**Compute for n = 3 using both methods:**

**Method 1 (i & (i-1)):**
```
ans[0] = 0
ans[1] = ans[1 & 0] + 1 = ans[0] + 1 = 1
ans[2] = ans[2 & 1] + 1 = ans[0] + 1 = 1
ans[3] = ans[3 & 2] + 1 = ans[2] + 1 = 2
Result: [0, 1, 1, 2]
```

**Method 2 (Right shift):**
```
ans[0] = 0
ans[1] = ans[0] + (1 & 1) = 0 + 1 = 1
ans[2] = ans[1] + (2 & 1) = 1 + 0 = 1
ans[3] = ans[1] + (3 & 1) = 1 + 1 = 2
Result: [0, 1, 1, 2]
```

The beauty of this problem is showing how **dynamic programming** and **bit manipulation** combine elegantly. Each computation reuses previous results, making it extremely efficient!


`int[] result = new int[n + 1];` creates an integer array whose **length** is `n + 1`.  
In Java every element of a newly‑created `int` array is automatically set to **0**.  
So before the loop starts the array looks like  

```
index: 0 1 2 3 … n
value: 0 0 0 0 … 0
```

The loop fills the array from left to right:

```java
for (int i = 1; i <= n; i++) {
    result[i] = result[i & (i - 1)] + 1;
}
```
