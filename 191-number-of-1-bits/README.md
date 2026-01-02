<h2><a href="https://leetcode.com/problems/number-of-1-bits">Number of 1 Bits</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given a positive integer <code>n</code>, write a function that returns the number of <span data-keyword="set-bit">set bits</span> in its binary representation (also known as the <a href="http://en.wikipedia.org/wiki/Hamming_weight" target="_blank">Hamming weight</a>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 11</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The input binary string <strong>1011</strong> has a total of three set bits.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 128</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The input binary string <strong>10000000</strong> has a total of one set bit.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 2147483645</span></p>

<p><strong>Output:</strong> <span class="example-io">30</span></p>

<p><strong>Explanation:</strong></p>

<p>The input binary string <strong>1111111111111111111111111111101</strong> has a total of thirty set bits.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> If this function is called many times, how would you optimize it?

# **Walkthrough: #191 - Number of 1 Bits (Hamming Weight)**

## **The Goal**
Count how many `1` bits are in a binary number.

**Example**: `n = 11` (binary: `1011`)
- Should return `3` (three 1's: positions 0, 1, and 3)

---

## **Method 1: The `n & (n-1)` Trick (Most Elegant)**

### **Key Insight**
`n & (n-1)` removes the **lowest set bit** (rightmost 1) from `n`.

**Why?** Let's see with examples:

### **Walkthrough with n = 11 (1011)**

**Step 1: n = 11 (binary: 1011)**
```
n = 1011
n-1 = 1010
n & (n-1) = 1011 & 1010 = 1010
```
We removed the rightmost 1-bit (position 0). Count = 1

**Step 2: n = 10 (binary: 1010)**
```
n = 1010
n-1 = 1001
n & (n-1) = 1010 & 1001 = 1000
```
We removed the rightmost 1-bit (position 1). Count = 2

**Step 3: n = 8 (binary: 1000)**
```
n = 1000
n-1 = 0111
n & (n-1) = 1000 & 0111 = 0000
```
We removed the rightmost 1-bit (position 3). Count = 3

**Step 4: n = 0 → STOP**

**Total count = 3**

---

### **Why `n & (n-1)` works: Visual Pattern**
```
n    = 1 0 1 1 0 0  (example: 44)
n-1  = 1 0 1 0 1 1
AND  = 1 0 1 0 0 0  ← rightmost 1-bit gone!
```

**What happens at binary level:**
```
Rightmost 1-bit:   ... 1 0 0 0 ... (some 1 followed by zeros)
Minus 1:          ... 0 1 1 1 ... (that 1 becomes 0, all 0's become 1)
AND operation:    ... 0 0 0 0 ... (at that region)
```

---

## **Method 2: Bit Shifting (More Intuitive)**

### **Walkthrough with n = 11 (1011)**

Check each of 32 bits (but we'll show 4 bits for clarity):

**Bit 0 (LSB):** `n & 1`
```
n = 1011
mask = 0001
1011 & 0001 = 0001 ≠ 0 → count++ (count = 1)
n >>= 1 → n = 0101
```

**Bit 1:** `n & 1`
```
n = 0101
mask = 0001  
0101 & 0001 = 0001 ≠ 0 → count++ (count = 2)
n >>= 1 → n = 0010
```

**Bit 2:** `n & 1`
```
n = 0010
mask = 0001
0010 & 0001 = 0000 = 0 → no change
n >>= 1 → n = 0001
```

**Bit 3:** `n & 1`
```
n = 0001
mask = 0001
0001 & 0001 = 0001 ≠ 0 → count++ (count = 3)
n >>= 1 → n = 0000
```

**Stop when n = 0**

---

## **Method 3: Lookup Table (For Multiple Queries)**

If you need to count bits for many numbers, precompute small chunks:

**8-bit lookup table:**
```
popcount[0] = 0  (00000000)
popcount[1] = 1  (00000001)
popcount[2] = 1  (00000010)
...
popcount[255] = 8 (11111111)
```

For 32-bit number: Split into 4 bytes
```
n = 0x12345678
count = popcount[0x12] + popcount[0x34] + popcount[0x56] + popcount[0x78]
```

---

## **Edge Cases & Observations**

### **1. Negative Numbers in Java**
Java uses **two's complement** for negative numbers:
```
-1 in binary: 11111111111111111111111111111111 (32 ones)
hammingWeight(-1) = 32
```

### **2. Zero Case**
```
n = 0 (binary: 0000)
Count = 0
```

### **3. Powers of Two**
```
n = 16 (binary: 10000)
Only one 1-bit → returns 1
```

### **4. All Ones**
```
n = 7 (binary: 0111) → 3 ones
n = 15 (binary: 1111) → 4 ones
```

---

## **Performance Comparison**

**Method 1 (`n & (n-1)`):**
- Runs in **O(k)** where k = number of 1-bits
- Best for sparse numbers (few 1's)
- Example: n = 8 (1000) → 1 iteration

**Method 2 (Bit shifting):**
- Always **32 iterations** for 32-bit ints
- Consistent but slower for sparse numbers
- Simpler to understand

---

## **Connection to Other Problems**

### **#231 - Power of Two**
```java
// A power of two has exactly one 1-bit
return n > 0 && (n & (n-1)) == 0;
```

### **#338 - Counting Bits**
```java
// DP using the same trick
result[i] = result[i & (i-1)] + 1;
// "Number of 1's in i = Number of 1's in i without lowest set bit + 1"
```

### **Useful Properties:**
1. `n & (n-1) == 0` → n is power of two or zero
2. `n & (-n)` isolates lowest set bit
3. Clearing lowest set bit: `n = n & (n-1)`
4. Setting lowest 0-bit: `n = n | (n+1)`

---

## **Practice Walkthrough Yourself**

Try these examples manually:

**Example 1: n = 13 (1101)**
```
13 = 1101
Iteration 1: 1101 & 1100 = 1100 (count=1)
Iteration 2: 1100 & 1011 = 1000 (count=2)  
Iteration 3: 1000 & 0111 = 0000 (count=3)
Answer: 3
```

**Example 2: n = 6 (0110)**
```
6 = 0110
Iteration 1: 0110 & 0101 = 0100 (count=1)
Iteration 2: 0100 & 0011 = 0000 (count=2)
Answer: 2
```

**Example 3: n = 0**
```
0 = 0000
No iterations (while loop skips)
Answer: 0
```

This operation is fundamental to many bit manipulation problems. Mastering it helps with power-of-two checks, counting bits for DP, and understanding bitwise operations in general.
