<h2><a href="https://leetcode.com/problems/sum-of-two-integers">Sum of Two Integers</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given two integers <code>a</code> and <code>b</code>, return <em>the sum of the two integers without using the operators</em> <code>+</code> <em>and</em> <code>-</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> a = 1, b = 2
<strong>Output:</strong> 3
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> a = 2, b = 3
<strong>Output:</strong> 5
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-1000 &lt;= a, b &lt;= 1000</code></li>
</ul>
When you need to implement addition manually with bitwise operations, the typical pattern is:

XOR (^) – adds bits without carry.
AND (&) << 1 – computes the carry bits and shifts them left.
Repeat until the carry is zero, then the result of the XOR step is the sum.

## How the bit‑wise addition works  

1. **Initial values**  
   - `a` and `b` hold the two numbers you want to add.  
   - Example: `a = 13 (01101)`, `b = 9 (01001)`.

2. **Compute the carry**  
   ```c
   carry = (a & b) << 1;
   ```
   - `a & b` keeps only the bits that are **1 in both** numbers. Those are the positions where a carry will occur.  
   - Shifting left by one (`<< 1`) moves the carry to the next higher bit, exactly where it must be added in the next step.  
   - For the example:  
     `a & b = 01001` → `carry = 10010` (binary 18).

3. **Add without carry**  
   ```c
   a = a ^ b;
   ```
   - XOR (`^`) adds the bits **ignoring any carry**: 0+0 → 0, 1+0 → 1, 0+1 → 1, 1+1 → 0 (carry discarded).  
   - Example: `01101 ^ 01001 = 00100` (binary 4).

4. **Replace `b` with the carry**  
   ```c
   b = carry;
   ```
   - Now `b` holds the bits that still need to be added because of the previous carry.

5. **Repeat until no carry remains**  
   - The loop `while (b != 0)` repeats steps 2‑4. Each iteration moves carries further left until they either cancel out or reach a position where no further carry is generated.  
   - Continuing the example:  

   | Iteration | a (sum so far) | b (carry) |
   |-----------|----------------|-----------|
   | 1         | 00100 (4)      | 10010 (18)|
   | 2         | 10110 (22)     | 00000 (0) |

   - After the second iteration `b` becomes zero, so the loop ends.

6. **Result**  
   - `a` now holds the final sum. In the example, `a = 10110` which is **22**, the correct result of 13 + 9.

### Summary of the algorithm
```c
int add(int a, int b) {
    while (b != 0) {
        int carry = (a & b) << 1; // 1. compute carry
        a = a ^ b;                // 2. add without carry
        b = carry;                // 3. propagate carry
    }
    return a; // final sum
}
```
The loop iteratively resolves all carries using only bitwise AND, XOR, and left‑shift operations, producing the same result as the `+` operator but without using arithmetic addition.
