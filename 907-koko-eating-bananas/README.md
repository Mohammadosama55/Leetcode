Find the minimum possible eating speed (left) as 1 and the maximum possible eating speed (right) as the maximum pile size.
While left is less than right:

Calculate mid as the average of left and right.
Calculate the total hours required to eat all piles at speed mid.
If the total hours is less than or equal to h, set right to mid.
If the total hours is greater than h, set left to mid + 1.

Return left.
