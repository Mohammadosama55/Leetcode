class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    int left = 1;
    int right = 0;
    for (int pile : piles) {
        right = Math.max(right, pile);
    }

    // WHY: Loop while the search range is valid (left < right).
    while (left < right) {
        // WHY: Calculate mid to test a speed in the middle of the current range.
        int mid = left + (right - left) / 2;

        // WHY: Calculate the total hours required to eat all piles at speed mid.
        int totalHours = 0;
        for (int pile : piles) {
            // WHY: For each pile, the time taken is the ceiling of pile / mid.
            totalHours += Math.ceil((double) pile / mid);
        }

        // WHY: If totalHours is less than or equal to h, try a slower speed (search left half).
        if (totalHours <= h) {
            right = mid;
        }
        // WHY: If totalHours is greater than h, try a faster speed (search right half).
        else {
            left = mid + 1;
        }
    }

    // WHY: When the loop ends, left points to the minimum eating speed.
    return left;    
    }
}