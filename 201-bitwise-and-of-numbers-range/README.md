<h2><a href="https://leetcode.com/problems/bitwise-and-of-numbers-range">Bitwise AND of Numbers Range</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given two integers <code>left</code> and <code>right</code> that represent the range <code>[left, right]</code>, return <em>the bitwise AND of all numbers in this range, inclusive</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> left = 5, right = 7
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> left = 0, right = 0
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> left = 1, right = 2147483647
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= left &lt;= right &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
# **Walkthrough: #201 - Bitwise AND of Numbers Range**

## **The Problem**
Find the bitwise AND of all numbers in the range `[left, right]` inclusive.

**Example:** `left = 5, right = 7`
```
5 = 101
6 = 110  
7 = 111
AND: 101 & 110 & 111 = 100 = 4
```

---

## **Key Insight: The Common Prefix**

When AND-ing a range of consecutive numbers:
- **Only the common prefix of bits survives**
- Any bit position where numbers differ becomes 0 in the result

**Why?** Because consecutive numbers toggle bits from right to left.

---

## **Visual Pattern**

Let's look at ranges:

### **Range [5, 7]**
```
5: 101
6: 110
7: 111

Bit position 2 (MSB): All have 1 → stays 1
Bit position 1: Differs (0,1,1) → becomes 0
Bit position 0: Differs (1,0,1) → becomes 0

Result: 100 = 4
```

### **Range [12, 15]**
```
12: 1100
13: 1101
14: 1110
15: 1111

Common prefix: 11__ (first 2 bits same)
Remaining bits differ → become 0

Result: 1100 & 1101 & 1110 & 1111 = 1100 = 12
```

---

## **Method 1: Find Common Prefix (Bit Shifting)**

### **Algorithm:**
1. Right shift both `left` and `right` until they become equal
2. Count how many shifts were made
3. Left shift back by that amount

### **Walkthrough: left = 5, right = 7**
```
Step 1: Shift right until equal
left = 5 (101), right = 7 (111)
Shift 1: left=2 (10), right=3 (11)  → still different
Shift 2: left=1 (1), right=1 (1)    → equal!

Step 2: We shifted 2 times

Step 3: Shift left back 2 times
1 << 2 = 100 = 4
```

### **Walkthrough: left = 12, right = 15**
```
left = 12 (1100), right = 15 (1111)
Shift 1: left=6 (110), right=7 (111)  → different
Shift 2: left=3 (11), right=3 (11)    → equal!
Shift count = 2
Result: 3 << 2 = 1100 = 12
```

### **Why This Works:**
Each right shift removes the lowest bit. When `left == right`, we've found the common prefix. Shifting back adds zeros for the bits that differed.

---

## **Method 2: Remove Rightmost Bits**

### **Algorithm:**
While `left < right`:
- Remove rightmost 1-bit from `right`: `right = right & (right - 1)`

### **Walkthrough: left = 5, right = 7**
```
Iteration 1: left=5, right=7
right & (right-1) = 7 & 6 = 111 & 110 = 110 = 6

Iteration 2: left=5, right=6
right & (right-1) = 6 & 5 = 110 & 101 = 100 = 4

Iteration 3: left=5, right=4
Now left > right? No, 5 > 4? Yes → stop

Result: left & right = 5 & 4 = 101 & 100 = 100 = 4
```

### **Walkthrough: left = 12, right = 15**
```
Iteration 1: right=15, right&14=14 (1110)
Iteration 2: right=14, right&13=12 (1100)  
Iteration 3: right=12, left=12 → equal, stop
Result: 12 & 12 = 12
```

### **Why This Works:**
`right & (right-1)` removes the lowest set bit. We keep removing bits from `right` until it's ≤ `left`. The bits we remove are positions where numbers in the range differ.

---

## **The Mathematical Insight**

### **Bit Position Analysis:**
For a bit at position `k` (from right, 0-indexed):
- If `right - left ≥ 2^k`, then this bit will be 0 in the result
- Why? Because the range contains both numbers with 0 and 1 at that bit

**Example:** Range [5, 7], 2^0 = 1
```
right - left = 2 ≥ 1 → bit 0 becomes 0
In binary: 5=101, 6=110, 7=111 (bit 0: 1,0,1 → becomes 0)
```

### **Find First Differing Bit:**
The result is essentially: Keep bits where `left` and `right` have the same value, from MSB to the first differing bit.

---

## **Edge Cases & Special Patterns**

### **1. left == right**
```
Range [5, 5]: Result = 5
Trivial case: AND of single number is the number itself
```

### **2. Power of Two Boundaries**
```
Range [8, 15]: 1000 to 1111
Common prefix: 1___ (only first bit same)
Result: 1000 = 8

Range [16, 31]: Result = 16
Pattern: [2^k, 2^(k+1)-1] = 2^k
```

### **3. Large Ranges**
```
Range [1, 1000000]
Common prefix will be very short
Result will be 0 if range spans a power of two boundary
```

### **4. Range Contains a Power of Two**
If range contains a number like 8 (1000), AND result's lower bits become 0.

---

## **Step-by-Step Walkthrough: Complex Example**

**Example: left = 26, right = 30**
```
26: 11010
27: 11011  
28: 11100
29: 11101
30: 11110
```

### **Method 1 (Shifting):**
```
Shift until equal:
26 (11010), 30 (11110) → shift 1
13 (1101), 15 (1111)   → shift 2
6 (110), 7 (111)       → shift 3
3 (11), 3 (11)         → equal!

Shift count = 3
Result: 3 << 3 = 11000 = 24
```

### **Method 2 (Removing bits):**
```
left=26, right=30
right=30 & 29 = 11110 & 11101 = 11100 = 28
right=28 & 27 = 11100 & 11011 = 11000 = 24
right=24, left=26 → left > right? 26 > 24? Yes → stop
Result: 26 & 24 = 11010 & 11000 = 11000 = 24
```

### **Verify:**
```
26 & 27 & 28 & 29 & 30 = 11010 & 11011 & 11100 & 11101 & 11110
Stepwise:
26 & 27 = 11010 = 26
26 & 28 = 11000 = 24
24 & 29 = 11000 = 24
24 & 30 = 11000 = 24 ✓
```

---

## **Connection to Other Problems**

### **#191 - Number of 1 Bits**
- Uses `n & (n-1)` to remove lowest set bit
- Here we use it repeatedly on `right`

### **#231 - Power of Two**
- `n & (n-1) == 0` checks power of two
- Important for understanding boundaries

### **Pattern Recognition:**
```java
// Common bit range patterns:
1. [2^k, 2^(k+1)-1] → AND = 2^k
2. If (right - left) >= 2^m → bit m becomes 0
3. Common prefix determines result
```

---

## **Performance Comparison**

### **Method 1 (Shifting):**
- **O(1)** operations (at most 31 shifts for 32-bit int)
- Simple and elegant

### **Method 2 (Remove bits):**
- **O(number of 1-bits in right)** operations
- Can be faster if `right` has few 1-bits
- More intuitive for some

### **Method 3 (Naive):**
- AND all numbers in range: O(right - left)
- Too slow for large ranges like [1, 2^31-1]

---

## **The Big Picture: Why This Works**

**Intuition:** When AND-ing consecutive numbers:
1. The lowest bit toggles every number → becomes 0
2. The second bit toggles every 2 numbers → may become 0
3. The k-th bit toggles every 2^k numbers

If `right - left ≥ 2^k`, then bit k will have both 0 and 1 in the range → becomes 0.

The result keeps only bits where `left` and `right` agree, up to the highest differing bit.

---

## **Practice Walkthrough Yourself**

**Try: left = 10, right = 11**
```
10: 1010
11: 1011

Common prefix: 101_
Last bit differs → becomes 0
Result: 1010 = 10

Method 1: Shift until equal (10,11→5,5), shift=1, 5<<1=10
Method 2: right=11&10=10, left=10=right, result=10
```

**Try: left = 0, right = 1**
```
0: 0000
1: 0001

No common bits (first bit differs)
Result: 0

Method 1: Shift (0,1→0,0), shift=1, 0<<1=0
Method 2: right=1&0=0, left=0=right, result=0
```

**Try: left = 1, right = 2147483647 (max int)**
```
They only share the first bit? Actually no!
Left=1 (000...001), Right=max (011...111)
First bits differ (0 vs 0 at MSB? Wait...)
Actually: MSB of max int is 0 (positive), MSB of 1 is 0
But range is huge → many bits differ
Result will be 0
```

This problem beautifully demonstrates how **bitwise operations reveal mathematical structure** in seemingly complex problems!
