<h2><a href="https://leetcode.com/problems/power-of-two">Power of Two</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given an integer <code>n</code>, return <em><code>true</code> if it is a power of two. Otherwise, return <code>false</code></em>.</p>

<p>An integer <code>n</code> is a power of two, if there exists an integer <code>x</code> such that <code>n == 2<sup>x</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> true
<strong>Explanation: </strong>2<sup>0</sup> = 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 16
<strong>Output:</strong> true
<strong>Explanation: </strong>2<sup>4</sup> = 16
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you solve it without loops/recursion?



# **Walkthrough: #231 - Power of Two**

## **The Goal**
Determine if a number is a power of two.

**Examples:**
- `1` (2⁰) → Yes
- `2` (2¹) → Yes  
- `3` → No
- `4` (2²) → Yes
- `5` → No
- `8` (2³) → Yes
- `0` → No (edge case!)
- Negative numbers → No

---

## **Key Insight: Binary Pattern of Powers of Two**

Let's look at the binary representation:

| Decimal | Binary | Observation |
|---------|--------|-------------|
| 1 | 0001 | One 1-bit |
| 2 | 0010 | One 1-bit |
| 3 | 0011 | Two 1-bits |
| 4 | 0100 | One 1-bit |
| 5 | 0101 | Two 1-bits |
| 8 | 1000 | One 1-bit |
| 16 | 10000 | One 1-bit |

**Pattern:** A power of two has **exactly one 1-bit** in its binary representation.

But wait... **0 also has one 1-bit?** No! 0 has **zero** 1-bits. So we need `n > 0`.

---

## **The Brilliant Trick: `n & (n-1)`**

From **#191 (Number of 1 Bits)**, we learned:
- `n & (n-1)` removes the lowest set bit
- If a number has exactly one 1-bit, then `n & (n-1)` should give `0`

Let's test:

### **Case 1: Power of Two (n = 8)**
```
n = 8     = 1000
n-1 = 7   = 0111
n & (n-1) = 1000 & 0111 = 0000 = 0 ✓
```

### **Case 2: Not Power of Two (n = 6)**
```
n = 6     = 0110
n-1 = 5   = 0101  
n & (n-1) = 0110 & 0101 = 0100 = 4 (≠ 0)
```

### **Case 3: n = 0 (Edge Case)**
```
n = 0
n-1 = -1 (in two's complement: 111...111)
0 & (-1) = 0
```
But 0 is NOT a power of two! So we need `n > 0` check.

### **Case 4: n = 1 (Smallest Power of Two)**
```
n = 1     = 0001
n-1 = 0   = 0000
n & (n-1) = 0001 & 0000 = 0000 = 0 ✓
```

---

## **The Complete Logic**

**Algorithm:** `n > 0 && (n & (n-1)) == 0`

Let's walk through examples:

**Example 1: n = 16**
```
n > 0? 16 > 0 → true
n & (n-1):
  16 = 10000
  15 = 01111
  10000 & 01111 = 00000 = 0
Both conditions true → YES
```

**Example 2: n = 18**
```
n > 0? 18 > 0 → true
n & (n-1):
  18 = 10010
  17 = 10001
  10010 & 10001 = 10000 = 16 (≠ 0)
Second condition false → NO
```

**Example 3: n = 0**
```
n > 0? 0 > 0 → false
Immediately NO (doesn't even check second condition)
```

**Example 4: n = -8**
```
n > 0? -8 > 0 → false
Immediately NO
```

---

## **Alternative Method: Bit Counting**

We could also use what we learned from #191:

```java
public boolean isPowerOfTwo(int n) {
    if (n <= 0) return false;
    
    // Count 1-bits
    int count = 0;
    while (n != 0) {
        n &= (n - 1);  // Remove lowest set bit
        count++;
    }
    
    return count == 1;  // Exactly one 1-bit
}
```

**Walkthrough with n = 8:**
```
n = 8 (1000)
Iteration 1: n = 8 & 7 = 0, count = 1
count == 1 → YES
```

**Walkthrough with n = 6:**
```
n = 6 (0110)
Iteration 1: n = 6 & 5 = 4, count = 1
Iteration 2: n = 4 & 3 = 0, count = 2  
count == 2 → NO
```

But the `n & (n-1) == 0` trick is more elegant and efficient!

---

## **Why This Works Mathematically**

### **For powers of two:**
```
Let n = 2^k = 100...00 (1 followed by k zeros)
Then n-1 = 2^k - 1 = 011...11 (0 followed by k ones)

n & (n-1) = 100...00 & 011...11 = 000...00 = 0
```

### **For non-powers of two:**
```
n has at least two 1-bits
After n-1, the lowest 1-bit becomes 0, all lower bits become 1
The AND operation will keep at least one 1-bit
Result ≠ 0
```

---

## **Edge Cases Deep Dive**

### **1. n = 0**
- 0 is **NOT** a power of two (2^k > 0 for all integer k)
- Our formula catches it with `n > 0` check

### **2. n = 1**
- 1 = 2⁰ → YES, it's a power of two
- `1 & 0 = 0` ✓

### **3. Negative numbers**
- Powers of two are positive
- Negative check fails immediately: `n > 0` false

### **4. Large numbers**
```
n = 2^30 = 1073741824
n-1 = 1073741823
n & (n-1) = 0 ✓

n = 2^31 - 1 = 2147483647 (max positive int)
n & (n-1) ≠ 0 (not a power of two)
```

---

## **Connection to Other Problems**

### **#191 - Number of 1 Bits**
- Power of two check uses the same `n & (n-1)` operation
- Just checks if result is 0 (meaning exactly one 1-bit)

### **#342 - Power of Four**
- First check if power of two
- Then additional check: `(n & 0xAAAAAAAA) == 0`
- Ensures the single 1-bit is at even position (counting from LSB)

### **Bit Manipulation Pattern:**
```java
// Common operations:
n & (n-1) == 0      // Exactly one 1-bit (power of two)
(n & (n-1)) != 0    // More than one 1-bit
(n & -n) == n       // Isolate lowest set bit
```

---

## **Practice Walkthrough Yourself**

Test these numbers manually:

**Test 1: n = 32**
```
32 > 0? ✓
32 = 100000
31 = 011111
100000 & 011111 = 000000 = 0 ✓ → YES
```

**Test 2: n = 12**
```
12 > 0? ✓  
12 = 1100
11 = 1011
1100 & 1011 = 1000 = 8 (≠ 0) → NO
```

**Test 3: n = 64**
```
64 > 0? ✓
64 = 1000000
63 = 0111111
1000000 & 0111111 = 0000000 = 0 ✓ → YES
```

**Test 4: n = 96**
```
96 > 0? ✓
96 = 1100000
95 = 1011111
1100000 & 1011111 = 1000000 = 64 (≠ 0) → NO
```

The beauty of this solution is its simplicity: one line of logic that leverages binary properties perfectly!
