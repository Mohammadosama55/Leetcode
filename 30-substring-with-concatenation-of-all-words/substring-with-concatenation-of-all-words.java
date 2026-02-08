class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), numWords = words.length, wordLen = words[0].length();
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words)
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);

        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> window = new HashMap<>();

            while (right + wordLen <= n) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCounts.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    while (window.get(word) > wordCounts.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == numWords)
                        res.add(left);
                } else {

                    window.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return res;
    }
}