class Solution {
    public String rearrangeString(String s, char x, char y) {
        // Reasoning: The problem only cares about *counts* and one ordering
        // rule — not original positions. So the first move is always to
        // strip away position and keep only quantity information.
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Reasoning: x and y are the ONLY constrained characters.
        // Every other character is free to go anywhere, so we handle
        // them completely separately from x and y.
        int countX = freq[x - 'a'];
        int countY = freq[y - 'a'];

        StringBuilder result = new StringBuilder();

        // Reasoning: Neutral characters (not x, not y) have zero ordering
        // constraints — dumping them first is always safe, since nothing
        // in the problem statement restricts their position relative to
        // x, y, or each other.
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (ch != x && ch != y) {
                // Reasoning: repeat() is the direct Java manifestation of
                // "place this whole solid block of identical characters
                // together" — matching our "block" mental model exactly.
                result.append(String.valueOf(ch).repeat(freq[i]));
            }
        }

        // Reasoning: placing the ENTIRE y-block before touching x at all
        // guarantees, by simple transitivity, that every y precedes every x.
        // This single line is what "unlocks" the constraint.
        result.append(String.valueOf(y).repeat(countY));

        // Reasoning: appending x only after all y's are fully committed
        // means no x can ever end up ahead of a y — the constraint is
        // automatically satisfied, not something we need to check for.
        result.append(String.valueOf(x).repeat(countX));

        return result.toString();
    }
}